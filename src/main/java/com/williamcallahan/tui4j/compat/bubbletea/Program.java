package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.input.InputHandler;
import com.williamcallahan.tui4j.compat.bubbletea.input.MouseAction;

import com.williamcallahan.tui4j.input.MouseClickMessage;
import com.williamcallahan.tui4j.input.MouseClickTracker;
import com.williamcallahan.tui4j.input.MouseHoverTextDetector;
import com.williamcallahan.tui4j.compat.bubbletea.input.MouseMessage;
import com.williamcallahan.tui4j.input.MouseSelectionAutoScroller;
import com.williamcallahan.tui4j.input.MouseSelectionTracker;
import com.williamcallahan.tui4j.input.MouseSelectionUpdate;
import com.williamcallahan.tui4j.input.MouseTarget;
import com.williamcallahan.tui4j.input.MouseTargetProvider;
import com.williamcallahan.tui4j.input.MouseTargets;
import com.williamcallahan.tui4j.compat.bubbletea.input.NoopInputHandler;
import com.williamcallahan.tui4j.compat.bubbletea.input.NewInputHandler;
import com.williamcallahan.tui4j.compat.bubbletea.render.Renderer;
import com.williamcallahan.tui4j.compat.bubbletea.render.NilRenderer;
import com.williamcallahan.tui4j.compat.bubbletea.render.StandardRenderer;
import com.williamcallahan.tui4j.runtime.CommandExecutor;
import com.williamcallahan.tui4j.runtime.UrlOpener;
import com.williamcallahan.tui4j.term.TerminalInfo;
import com.williamcallahan.tui4j.term.jline.JLineTerminalInfoProvider;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;
import org.jline.utils.Signals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Runs the TUI event loop and manages terminal IO.
 * <p>
 * Port of Bubble Tea's `Program` (tea.go).
 * Manages the lifecycle of a TUI application, including terminal
 * initialization,
 * event polling, and rendering loops.
 */
public class Program {

    private static final int DEFAULT_FPS = 60;
    private static final int MAX_FPS = 120;
    private static final Logger logger = Logger.getLogger(Program.class.getName());

    static {
        try {
            com.williamcallahan.tui4j.compat.lipgloss.Renderer.defaultRenderer().hasDarkBackground();
        } catch (Throwable ignored) {
            // Best-effort parity with bubbletea/tea_init.go.
        }
    }

    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final CountDownLatch initLatch = new CountDownLatch(1);
    private final BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>();
    private final CommandExecutor commandExecutor;
    private InputHandler inputHandler;

    private Throwable lastError;
    private volatile Model currentModel;
    private Renderer renderer;
    private Terminal terminal;
    private final MouseSelectionTracker mouseSelectionTracker = new MouseSelectionTracker();
    private final MouseHoverTextDetector mouseHoverTextDetector = new MouseHoverTextDetector();
    private final MouseClickTracker mouseClickTracker = new MouseClickTracker();
    private boolean extendSelectionOnScroll;
    private boolean manageMouseSelectionCursor;
    private boolean mouseSelectionCursorActive;
    private boolean hoverTextCursorEnabled;
    private boolean hoverTextCursorActive;
    private boolean mouseClicksEnabled;
    private volatile boolean isSuspended = false;

    private MouseSelectionAutoScroller mouseSelectionAutoScroller;

    private int fps = DEFAULT_FPS;
    private boolean withoutSignalHandler;
    private boolean withoutCatchPanics;
    private final AtomicBoolean ignoreSignals = new AtomicBoolean(false);
    private boolean withoutBracketedPaste;
    private boolean withoutRenderer;
    /**
     * Whether ANSI sequence compression is enabled (currently ignored).
     *
     * <p>This mirrors Go Bubble Tea's {@code WithANSICompressor()} option, deprecated in
     * bubbletea v0.19.0 due to performance overhead. Accepted for API compatibility only.
     *
     * @deprecated Go Bubble Tea deprecated this in v0.19.0. Has no effect and will be removed.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @SuppressWarnings("unused")
    private boolean ansiCompressor;
    private boolean enableAltScreen;
    private boolean enableMouseAllMotion;
    private boolean enableMouseCellMotion;
    private boolean enableReportFocus;
    private BiFunction<Model, Message, Message> filter;
    private CompletableFuture<?> cancelSignal;
    private InputStream input = System.in;
    private OutputStream output = System.out;
    private boolean inputDisabled;
    private boolean useInputTTY;
    private InputStream openedInput;
    // SSH/remote session support - passes environment to lipgloss for terminal capability detection
    private List<String> environment;
    private boolean selectionAutoScrollEnabled;
    private int selectionAutoScrollEdgeRows = 1;
    private int selectionAutoScrollIntervalMs = 50;

    public Program(Model initialModel) {
        this(initialModel, (ProgramOption[]) null);
    }

    public Program(Model initialModel, ProgramOption... options) {
        this.currentModel = initialModel;
        this.commandExecutor = new CommandExecutor();
        if (options != null) {
            for (ProgramOption option : options) {
                if (option != null) {
                    option.apply(this);
                }
            }
        }
        initializeTerminal();
    }

    private void initializeTerminal() {
        try {
            InputStream resolvedInput = resolveInputStream();
            OutputStream resolvedOutput = output == null ? System.out : output;
            boolean systemTerminal = isSystemTerminal(resolvedInput, resolvedOutput);

            TerminalBuilder builder = TerminalBuilder.builder()
                    .jni(true)
                    .system(systemTerminal);

            if (!systemTerminal) {
                builder.streams(resolvedInput, resolvedOutput);
            }

            this.terminal = builder.build();
            terminal.enterRawMode();

            TerminalInfo.provide(new JLineTerminalInfoProvider(terminal));

            // Wire environment to lipgloss for SSH/remote session support
            if (environment != null && !environment.isEmpty()) {
                com.williamcallahan.tui4j.compat.lipgloss.Renderer.defaultRenderer().setEnvironment(environment);
            }

            if (withoutRenderer) {
                this.renderer = new NilRenderer();
            } else {
                this.renderer = new StandardRenderer(terminal, normalizeFps(fps));
            }
            this.inputHandler = inputDisabled ? new NoopInputHandler() : new NewInputHandler(terminal, this::send);
            this.mouseSelectionAutoScroller = new MouseSelectionAutoScroller(terminal::getHeight, mouseSelectionTracker,
                    this::send);
            applySelectionAutoScrollConfig();
        } catch (IOException e) {
            throw new ProgramException("Failed to initialize terminal", e);
        }
    }

    public Program withAltScreen() {
        enableAltScreen = true;
        if (renderer != null) {
            renderer.enterAltScreen();
        }
        return this;
    }

    public Program withReportFocus() {
        enableReportFocus = true;
        if (renderer != null) {
            renderer.enableReportFocus();
        }
        return this;
    }

    public Program withMouseAllMotion() {
        enableMouseAllMotion = true;
        enableMouseCellMotion = false;
        if (renderer != null) {
            renderer.enableMouseAllMotion();
            renderer.enableMouseSGRMode();
        }
        return this;
    }

    public Program withMouseCellMotion() {
        enableMouseCellMotion = true;
        enableMouseAllMotion = false;
        if (renderer != null) {
            renderer.enableMouseCellMotion();
            renderer.enableMouseSGRMode();
        }
        return this;
    }

    /**
     * While selecting, translate wheel events into selection motion updates.
     */
    public Program withMouseSelectionExtendOnScroll() {
        this.extendSelectionOnScroll = true;
        return this;
    }

    /**
     * While selecting, automatically scroll when the mouse is at the top/bottom
     * edge.
     * <p>
     * tui4j extension; no Bubble Tea equivalent.
     */
    public Program withMouseSelectionAutoScroll() {
        // Auto-scroll is implemented by emitting wheel events while selecting, so we
        // must also
        // preserve selection during scroll to avoid breaking the user's selection
        // state.
        this.extendSelectionOnScroll = true;
        selectionAutoScrollEnabled = true;
        if (mouseSelectionAutoScroller != null) {
            mouseSelectionAutoScroller.enable();
        }
        return this;
    }

    /**
     * Configure selection auto-scroll behavior.
     * <p>
     * tui4j extension; no Bubble Tea equivalent.
     */
    public Program withMouseSelectionAutoScroll(int edgeRows, int intervalMs) {
        this.extendSelectionOnScroll = true;
        selectionAutoScrollEnabled = true;
        selectionAutoScrollEdgeRows = edgeRows;
        selectionAutoScrollIntervalMs = intervalMs;
        if (mouseSelectionAutoScroller != null) {
            mouseSelectionAutoScroller.configure(edgeRows, intervalMs);
        }
        return this;
    }

    /**
     * Manage the mouse cursor during selection (OSC 22).
     */
    public Program withMouseSelectionCursor() {
        this.manageMouseSelectionCursor = true;
        return this;
    }

    /**
     * Manage the mouse cursor when hovering non-whitespace text (OSC 22).
     * Requires mouse motion events (e.g. {@link #withMouseAllMotion()}).
     */
    public Program withMouseHoverTextCursor() {
        this.hoverTextCursorEnabled = true;
        return this;
    }

    /**
     * When enabled, emits {@link MouseClickMessage} on press/release clicks.
     * tui4j extension; no Bubble Tea equivalent.
     */
    public Program withMouseClicks() {
        this.mouseClicksEnabled = true;
        return this;
    }

    /**
     * Blocks the calling thread, enters raw mode, and starts the event loop.
     * Takes control of the terminal until the model returns a {@link QuitMsg}.
     */
    public void run() {
        if (!isRunning.compareAndSet(false, true)) {
            throw new IllegalStateException("Program is already running!");
        }

        handleTerminationSignals();
        handleSuspendSignals();
        handleTerminalResize();
        if (mouseSelectionAutoScroller != null) {
            mouseSelectionAutoScroller.start();
        }

        // start reading keyboard input
        inputHandler.start();

        applyStartupOptions();

        // starting renderer
        renderer.hideCursor();
        renderer.start();
        installCancelSignal();

        Model finalModel = currentModel;
        boolean renderFinalView = false;

        try {
            // execute init command
            Command initCommand = currentModel.init();
            commandExecutor
                    .executeIfPresent(initCommand, this::send, this::sendError)
                    .thenRun(initLatch::countDown);

            // render the initial view
            renderer.write(currentModel.view());

            // run event loop
            finalModel = eventLoop();
            renderFinalView = true;
        } catch (Throwable t) {
            if (withoutCatchPanics) {
                throw t;
            }
            lastError = t;
        } finally {
            cleanup(renderFinalView, finalModel);
        }

        if (lastError != null) {
            throw new ProgramException(lastError);
        }
    }

    private void cleanup(boolean renderFinalView, Model finalModel) {
        // stop reading keyboard input
        inputHandler.stop();

        if (renderFinalView) {
            // render final model view before closing
            renderer.write(finalModel.view());
        }
        renderer.showCursor();
        renderer.stop();

        if (mouseSelectionAutoScroller != null) {
            mouseSelectionAutoScroller.stop();
        }

        if (renderer.bracketedPaste()) {
            renderer.disableBracketedPaste();
        }

        if (manageMouseSelectionCursor && mouseSelectionCursorActive) {
            renderer.resetMouseCursor();
        }
        if (hoverTextCursorEnabled && hoverTextCursorActive) {
            renderer.resetMouseCursor();
        }

        // disabling mouse support
        disableMouse();

        if (renderer.reportFocus()) {
            renderer.disableReportFocus();
        }

        if (renderer.altScreen()) {
            renderer.exitAltScreen();
        }

        terminal.puts(InfoCmp.Capability.carriage_return);
        terminal.puts(InfoCmp.Capability.cursor_down);
        terminal.flush();

        // Finally clean up
        isRunning.set(false);
        commandExecutor.shutdown();
        try {
            terminal.close();
        } catch (IOException e) {
            // Chain with any existing error to preserve context
            if (lastError != null) {
                e.addSuppressed(lastError);
            }
            throw new ProgramException(e);
        } finally {
            closeOpenedInput();
        }
    }

    private void handleTerminationSignals() {
        if (withoutSignalHandler) {
            return;
        }
        Signals.register("INT", () -> {
            if (ignoreSignals.get()) {
                return;
            }
            commandExecutor.executeIfPresent(QuitMsg::new, this::send, this::sendError);
        });
        Signals.register("TERM", () -> {
            if (ignoreSignals.get()) {
                return;
            }
            commandExecutor.executeIfPresent(QuitMsg::new, this::send, this::sendError);
        });
    }

    private void handleSuspendSignals() {
        if (withoutSignalHandler) {
            return;
        }
        Signals.register("TSTP", () -> {
            if (ignoreSignals.get()) {
                return;
            }
            commandExecutor.executeIfPresent(SuspendMessage::new, this::send, this::sendError);
        });
        Signals.register("CONT", () -> {
            if (ignoreSignals.get()) {
                return;
            }
            commandExecutor.executeIfPresent(ResumeMessage::new, this::send, this::sendError);
        });
    }

    private void handleTerminalResize() {
        Signals.register("WINCH",
                () -> commandExecutor.executeIfPresent(CheckWindowSizeMessage::new, this::send, this::sendError));
        commandExecutor.executeIfPresent(CheckWindowSizeMessage::new, this::send, this::sendError);
    }

    private Model eventLoop() {
        while (isRunning.get()) {
            Message msg;
            try {
                msg = messageQueue.poll(10, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            if (msg != null) {
                if (filter != null) {
                    msg = filter.apply(currentModel, msg);
                }
                if (msg == null) {
                    continue;
                }
                Message internalMsg = normalizeMessage(msg);
                if (handleSystemMessage(internalMsg)) {
                    continue;
                }

                if (internalMsg instanceof QuitMessage) {
                    return currentModel;
                } else if (internalMsg instanceof ErrorMessage errorMessage) {
                    this.lastError = errorMessage.error();
                    return currentModel;
                }

                if (internalMsg instanceof MouseMessage mouseMessage) {
                    if (mouseSelectionAutoScroller != null) {
                        mouseSelectionAutoScroller.onMouse(mouseMessage);
                    }
                    handleMouseClickTracking(mouseMessage);
                    handleMouseSelectionTracking(mouseMessage);
                    handleMouseHoverCursor(mouseMessage);
                }

                // process internal messages for the renderer
                renderer.handleMessage(internalMsg);

                UpdateResult<? extends Model> updateResult = currentModel.update(msg);

                currentModel = updateResult.model();
                renderer.notifyModelChanged();
                commandExecutor.executeIfPresent(updateResult.command(), this::send, this::sendError);

                renderer.write(currentModel.view());
            }

        }
        return currentModel;
    }

    private boolean handleSystemMessage(Message msg) {
        return switch (msg) {
            case ClearScreenMessage ignored -> {
                renderer.clearScreen();
                yield true;
            }
            case EnterAltScreenMessage ignored -> {
                renderer.enterAltScreen();
                yield true;
            }
            case ExitAltScreenMessage ignored -> {
                renderer.exitAltScreen();
                yield true;
            }
            case BatchMessage batchMessage -> {
                handleBatch(batchMessage.commands());
                yield true;
            }
            case SequenceMessage sequenceMessage -> {
                handleSequence(sequenceMessage.commands());
                yield true;
            }
            case CheckWindowSizeMessage ignored -> {
                commandExecutor.executeIfPresent(this::checkSize, this::send, this::sendError);
                yield true;
            }
            case OpenUrlMessage openUrlMessage -> {
                handleOpenUrl(openUrlMessage.url());
                yield true;
            }
            case ExecProcessMessage execProcessMessage -> {
                executeProcess(execProcessMessage);
                yield true;
            }
            case SuspendMessage ignored -> {
                suspend();
                yield true;
            }
            case ResumeMessage ignored -> {
                resume();
                yield true;
            }
            default -> false;
        };
    }

    private Message normalizeMessage(Message msg) {
        if (msg instanceof MessageShim shim) {
            return shim.toMessage();
        }
        return msg;
    }

    private void handleBatch(Command... commands) {
        Arrays.stream(commands)
                .forEach(command -> commandExecutor.executeIfPresent(command, this::send, this::sendError));
    }

    private void handleSequence(Command... commands) {
        Arrays.stream(commands)
                .reduce(
                        CompletableFuture.completedFuture(null),
                        (CompletableFuture<Void> future, Command command) -> future.thenCompose(
                                __ -> commandExecutor.executeIfPresent(command, this::send, this::sendError)),
                        (f1, f2) -> f2)
                .join();
    }

    private void handleOpenUrl(String url) {
        boolean success = UrlOpener.open(url);
        if (!success) {
            logger.log(Level.WARNING, "Failed to open URL: " + url);
        }
    }

    private void handleMouseSelectionTracking(MouseMessage mouseMessage) {
        MouseSelectionUpdate selectionUpdate = mouseSelectionTracker.update(mouseMessage);

        if (extendSelectionOnScroll && selectionUpdate.selectionScrollUpdate() != null) {
            send(selectionUpdate.selectionScrollUpdate());
        }

        if (!manageMouseSelectionCursor) {
            return;
        }

        if (selectionUpdate.selectionStarted()) {
            setMouseSelectionCursorText();
            return;
        }

        if (selectionUpdate.selectionEnded()) {
            resetMouseSelectionCursor();
            return;
        }

        if (selectionUpdate.selectionActive()) {
            if (mouseMessage.isWheel()) {
                resetMouseSelectionCursor();
                return;
            }

            if (mouseMessage.getAction() == MouseAction.MouseActionMotion
                    || mouseMessage.getAction() == MouseAction.MouseActionPress) {
                setMouseSelectionCursorText();
            }
        }
    }

    private void handleMouseHoverCursor(MouseMessage mouseMessage) {
        if (!hoverTextCursorEnabled) {
            return;
        }
        if (mouseSelectionTracker.isSelecting() || mouseSelectionCursorActive) {
            return;
        }
        if (mouseMessage.isWheel()) {
            return;
        }
        if (mouseMessage.getAction() != MouseAction.MouseActionMotion
                && mouseMessage.getAction() != MouseAction.MouseActionPress
                && mouseMessage.getAction() != MouseAction.MouseActionRelease) {
            return;
        }

        boolean overText = mouseHoverTextDetector.isHoveringText(
                currentModel.view(),
                mouseMessage.column(),
                mouseMessage.row());

        if (overText && !hoverTextCursorActive) {
            renderer.setMouseCursorText();
            hoverTextCursorActive = true;
        } else if (!overText && hoverTextCursorActive) {
            renderer.resetMouseCursor();
            hoverTextCursorActive = false;
        }
    }

    private void setMouseSelectionCursorText() {
        if (mouseSelectionCursorActive) {
            return;
        }
        renderer.setMouseCursorText();
        mouseSelectionCursorActive = true;
    }

    private void resetMouseSelectionCursor() {
        if (!mouseSelectionCursorActive) {
            return;
        }
        renderer.resetMouseCursor();
        mouseSelectionCursorActive = false;
    }

    private void handleMouseClickTracking(MouseMessage mouseMessage) {
        if (!mouseClicksEnabled) {
            return;
        }
        MouseTarget target = resolveMouseTarget(mouseMessage);
        MouseClickMessage clickMessage = mouseClickTracker.handle(mouseMessage, target);
        if (clickMessage != null) {
            send(clickMessage);
        }
    }

    private MouseTarget resolveMouseTarget(MouseMessage mouseMessage) {
        if (!(currentModel instanceof MouseTargetProvider provider)) {
            return null;
        }
        return MouseTargets.hitTest(provider.mouseTargets(), mouseMessage.column(), mouseMessage.row());
    }

    private Message checkSize() {
        Size size = terminal.getSize();
        return new WindowSizeMessage(size.getColumns(), size.getRows());
    }

    private void sendError(Throwable error) {
        send(new ErrorMessage(error));
    }

    public void send(Message msg) {
        if (isRunning.get() && msg != null) {
            messageQueue.offer(msg);
        }
    }

    public boolean isRunning() {
        return isRunning.get();
    }

    public void waitForInit() {
        try {
            initLatch.await();
        } catch (InterruptedException e) {
            throw new ProgramException(e);
        }
    }

    private void disableMouse() {
        renderer.disableMouseSGRMode();
        renderer.disableMouseNormalTracking();
        renderer.disableMouseCellMotion();
        renderer.disableMouseAllMotion();
    }

    private void executeProcess(ExecProcessMessage execProcessMessage) {
        // Run synchronously to block the event loop, matching Bubble Tea's behavior
        Process process = execProcessMessage.process();
        BiConsumer<Integer, byte[]> outputHandler = execProcessMessage.outputHandler();
        BiConsumer<Integer, byte[]> errorHandler = execProcessMessage.errorHandler();

        suspend();

        try {
            // Drain stdout/stderr concurrently to prevent deadlock from filled buffers
            CompletableFuture<byte[]> stdoutFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return process.getInputStream().readAllBytes();
                } catch (IOException e) {
                    throw new UncheckedIOException("Failed to read stdout", e);
                }
            });
            CompletableFuture<byte[]> stderrFuture = CompletableFuture.supplyAsync(() -> {
                try {
                    return process.getErrorStream().readAllBytes();
                } catch (IOException e) {
                    throw new UncheckedIOException("Failed to read stderr", e);
                }
            });

            int exitCode = process.waitFor();

            if (outputHandler != null) {
                byte[] output = stdoutFuture.get();
                outputHandler.accept(exitCode, output);
            }
            if (errorHandler != null) {
                byte[] error = stderrFuture.get();
                errorHandler.accept(exitCode, error);
            }

            send(new ExecCompletedMsg(exitCode, null));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            send(new ExecCompletedMsg(-1, e));
        } catch (java.util.concurrent.ExecutionException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            logger.log(Level.WARNING, "Error reading process streams", cause);
            send(new ExecCompletedMsg(-1, cause));
        } finally {
            resume(); // Restore terminal and renderer
        }
    }

    private void suspend() {
        if (isSuspended) {
            return;
        }
        isSuspended = true;
        renderer.showCursor();
        renderer.pause();
        terminal.pause();
    }

    private void resume() {
        if (!isSuspended) {
            return;
        }
        terminal.resume();
        renderer.resume();
        renderer.hideCursor();
        renderer.write(currentModel.view());
        isSuspended = false;
    }

    private void applyStartupOptions() {
        if (enableAltScreen && !renderer.altScreen()) {
            renderer.enterAltScreen();
        }
        if (!withoutBracketedPaste) {
            renderer.enableBracketedPaste();
        }
        if (enableMouseCellMotion) {
            renderer.enableMouseCellMotion();
            renderer.enableMouseSGRMode();
        } else if (enableMouseAllMotion) {
            renderer.enableMouseAllMotion();
            renderer.enableMouseSGRMode();
        }
        if (enableReportFocus && !renderer.reportFocus()) {
            renderer.enableReportFocus();
        }
    }

    private void installCancelSignal() {
        if (cancelSignal == null) {
            return;
        }
        cancelSignal.whenComplete((result, error) -> send(new QuitMessage()));
    }

    private void applySelectionAutoScrollConfig() {
        if (!selectionAutoScrollEnabled || mouseSelectionAutoScroller == null) {
            return;
        }
        mouseSelectionAutoScroller.configure(selectionAutoScrollEdgeRows, selectionAutoScrollIntervalMs);
    }

    private int normalizeFps(int value) {
        if (value < 1) {
            return DEFAULT_FPS;
        }
        return Math.min(value, MAX_FPS);
    }

    private InputStream resolveInputStream() throws IOException {
        InputStream resolved = input;
        if (useInputTTY) {
            resolved = openInputTTY();
        }
        if (resolved == null) {
            inputDisabled = true;
            return System.in;
        }
        return resolved;
    }

    private boolean isSystemTerminal(InputStream resolvedInput, OutputStream resolvedOutput) {
        if (useInputTTY) {
            return false;
        }
        boolean inputIsSystem = resolvedInput == System.in;
        boolean outputIsSystem = resolvedOutput == System.out || resolvedOutput == System.err;
        return inputIsSystem && outputIsSystem;
    }

    private InputStream openInputTTY() throws IOException {
        InputStream tty = null;
        String osName = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        if (osName.contains("win")) {
            tty = new FileInputStream("CONIN$");
        } else {
            tty = new FileInputStream("/dev/tty");
        }
        openedInput = tty;
        return tty;
    }

    private void closeOpenedInput() {
        if (openedInput == null || openedInput == System.in) {
            return;
        }
        try {
            openedInput.close();
        } catch (IOException ignored) {
        }
    }

    void setOutput(OutputStream output) {
        this.output = output;
    }

    void setInput(InputStream input) {
        this.input = input;
        this.inputDisabled = input == null;
    }

    void setInputTTY(boolean useInputTTY) {
        this.useInputTTY = useInputTTY;
    }

    void setEnvironment(List<String> environment) {
        this.environment = environment;
    }

    void setWithoutSignalHandler(boolean withoutSignalHandler) {
        this.withoutSignalHandler = withoutSignalHandler;
    }

    void setWithoutCatchPanics(boolean withoutCatchPanics) {
        this.withoutCatchPanics = withoutCatchPanics;
    }

    void setIgnoreSignals(boolean ignoreSignals) {
        this.ignoreSignals.set(ignoreSignals);
    }

    void setWithoutBracketedPaste(boolean withoutBracketedPaste) {
        this.withoutBracketedPaste = withoutBracketedPaste;
    }

    void setWithoutRenderer(boolean withoutRenderer) {
        this.withoutRenderer = withoutRenderer;
    }

    /**
     * Enables ANSI sequence compression to reduce output size.
     *
     * <p>This mirrors Go Bubble Tea's {@code WithANSICompressor()} program option, which was
     * deprecated in bubbletea v0.19.0 due to noticeable performance overhead. The Go team plans
     * to optimize ANSI output automatically in a future release without requiring this option.
     *
     * <p>This setter is accepted for API compatibility but has no effect in tui4j.
     *
     * @param ansiCompressor whether to enable ANSI compression (ignored)
     * @deprecated Go Bubble Tea deprecated {@code WithANSICompressor()} in v0.19.0 due to
     *             performance issues. This option has no effect and will be removed.
     * @see <a href="https://pkg.go.dev/github.com/charmbracelet/bubbletea#WithANSICompressor">
     *      bubbletea.WithANSICompressor (Go docs)</a>
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    @SuppressWarnings("DeprecationWarning")
    void setAnsiCompressor(boolean ansiCompressor) {
        this.ansiCompressor = ansiCompressor;
    }

    void setFilter(BiFunction<Model, Message, Message> filter) {
        this.filter = filter;
    }

    void setFps(int fps) {
        this.fps = fps;
    }

    void setCancelSignal(CompletableFuture<?> cancelSignal) {
        this.cancelSignal = cancelSignal;
    }
}
