package com.williamcallahan.tui4j.compat.bubbletea.render;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.ProgramException;
import com.williamcallahan.tui4j.ansi.Code;
import com.williamcallahan.tui4j.ansi.Truncate;
import com.williamcallahan.tui4j.compat.bubbletea.*;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Default renderer backed by JLine.
 * tui4j:
 * src/main/java/com/williamcallahan/tui4j/compat/bubbletea/render/StandardRenderer.java
 * <p>
 * Bubble Tea: standard_renderer.go.
 */
public class StandardRenderer implements Renderer {

    private static final int DEFAULT_FPS = 60;

    private volatile boolean needsRender = true;
    private final Lock renderLock = new ReentrantLock();
    private final Terminal terminal;
    private volatile boolean isRunning = false;
    private final StringBuilder buffer = new StringBuilder();
    private volatile String lastRender = "";
    private final ScheduledExecutorService ticker;
    private final long frameTime;
    private String[] lastRenderedLines = new String[0];
    private final List<String> queuedMessageLines = new ArrayList<>();

    private int linesRendered = 0;
    private int width;
    private int height;
    private boolean isInAltScreen;
    private boolean isReportFocus;
    private boolean bracketedPasteEnabled;

    /**
     * Creates StandardRenderer to keep this component ready for use.
     *
     * @param terminal terminal
     */
    public StandardRenderer(Terminal terminal) {
        this(terminal, DEFAULT_FPS);
    }

    /**
     * Creates StandardRenderer to keep this component ready for use.
     *
     * @param terminal terminal
     * @param fps fps
     */
    public StandardRenderer(Terminal terminal, int fps) {
        this.terminal = terminal;
        this.frameTime = 1000 / Math.min(Math.max(fps, 1), 120);
        this.ticker = Executors.newSingleThreadScheduledExecutor(r -> {
            Thread t = new Thread(r, "tui4j-Renderer-Thread");
            t.setDaemon(true);
            return t;
        });

        try {
            this.width = terminal.getWidth();
            this.height = terminal.getHeight();
        } catch (Throwable t) {
            // Log the error but fallback to safe defaults to prevent crash
            // The renderer can recover when a window size message is received later
            // Use system err/out sparingly or logger if available
            System.err.println("Failed to get initial terminal size, defaulting to 80x24: " + t.getMessage());
            this.width = 80;
            this.height = 24;
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go start behavior.
    /**
     * Handles start for this component.
     */
    public void start() {
        if (!isRunning) {
            isRunning = true;
            ticker.scheduleAtFixedRate(this::flush, 0, frameTime, TimeUnit.MILLISECONDS);
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go stop behavior.
    /**
     * Handles stop for this component.
     */
    public void stop() {
        isRunning = false;
        try {
            ticker.shutdownNow();
            ticker.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new ProgramException(e);
        }
    }

    /**
     * Handles pause for this component.
     */
    @Override
    public void pause() {
        isRunning = false;
    }

    /**
     * Handles resume for this component.
     */
    @Override
    public void resume() {
        isRunning = true;
    }

    /**
     * Handles flush for this component.
     */
    private void flush() {
        if (!needsRender) {
            return;
        }

        renderLock.lock();
        try {
            if (buffer.isEmpty() || buffer.toString().equals(lastRender)) {
                return;
            }

            StringBuilder outputBuffer = new StringBuilder();
            String[] newLines = buffer.toString().split("\n");

            if (height > 0 && newLines.length > height) {
                newLines = Arrays.copyOfRange(newLines, newLines.length - height, newLines.length);
            }

            if (linesRendered > 1) {
                outputBuffer.append("\033[").append(linesRendered - 1).append("A");
            }

            boolean flushQueuedMessages = !queuedMessageLines.isEmpty() && !isInAltScreen;
            if (flushQueuedMessages) {
                for (String line : queuedMessageLines) {
                    if (width > 0 && line.length() < width) {
                        outputBuffer.append(line).append("\033[K");
                    } else {
                        outputBuffer.append(line);
                    }
                    outputBuffer.append("\r\n");
                }
                queuedMessageLines.clear();
            }

            for (int i = 0; i < newLines.length; i++) {
                boolean canSkip = !flushQueuedMessages &&
                        lastRenderedLines.length > i &&
                        newLines[i].equals(lastRenderedLines[i]);

                if (canSkip) {
                    if (i < newLines.length - 1) {
                        outputBuffer.append("\033[B");
                    }
                    continue;
                }

                String line = newLines[i];

                if (this.width > 0) {
                    line = Truncate.truncate(line, this.width, "");
                }

                if (width > 0 && line.length() < width) {
                    outputBuffer.append("\r").append(line).append("\033[K");
                } else {
                    outputBuffer.append("\r").append(line);
                }

                if (i < newLines.length - 1) {
                    outputBuffer.append("\n");
                }
            }

            if (linesRendered > newLines.length) {
                outputBuffer.append("\033[J");
            }

            outputBuffer.append("\r");

            terminal.writer().print(outputBuffer);
            terminal.writer().flush();

            lastRender = buffer.toString();
            lastRenderedLines = newLines;
            linesRendered = newLines.length;
            needsRender = false;
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go write behavior.
    /**
     * Handles write for this component.
     *
     * @param view view
     */
    @Override
    public void write(String view) {
        if (!isRunning)
            return;

        String string = view.isEmpty() ? " " : view;

        renderLock.lock();
        try {
            buffer.setLength(0);
            buffer.append(string);
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go showCursor
    // behavior.
    /**
     * Handles show cursor for this component.
     */
    @Override
    public void showCursor() {
        renderLock.lock();
        try {
            terminal.puts(InfoCmp.Capability.cursor_visible);
            terminal.flush();
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go hideCursor
    // behavior.
    /**
     * Handles hide cursor for this component.
     */
    @Override
    public void hideCursor() {
        renderLock.lock();
        try {
            terminal.puts(InfoCmp.Capability.cursor_invisible);
            terminal.flush();
        } finally {
            renderLock.unlock();
        }
    }

    /**
     * Handles write to terminal unlocked for this component.
     *
     * @param value value
     */
    private void writeToTerminalUnlocked(String value) {
        terminal.writer().print(value);
        terminal.writer().flush();
    }

    /**
     * Handles write to terminal for this component.
     *
     * @param value value
     */
    private void writeToTerminal(String value) {
        renderLock.lock();
        try {
            writeToTerminalUnlocked(value);
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // enableMouseCellMotion behavior.
    /**
     * Handles enable mouse cell motion for this component.
     */
    @Override
    public void enableMouseCellMotion() {
        writeToTerminal(Code.EnableMouseCellMotion.value());
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // disableMouseCellMotion behavior.
    /**
     * Handles disable mouse cell motion for this component.
     */
    @Override
    public void disableMouseCellMotion() {
        writeToTerminal(Code.DisableMouseCellMotion.value());
    }

    /**
     * Handles enable mouse normal tracking for this component.
     */
    @Override
    public void enableMouseNormalTracking() {
        writeToTerminal(Code.EnableMouseNormalTracking.value());
    }

    /**
     * Handles disable mouse normal tracking for this component.
     */
    @Override
    public void disableMouseNormalTracking() {
        writeToTerminal(Code.DisableMouseNormalTracking.value());
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // enableMouseAllMotion behavior.
    /**
     * Handles enable mouse all motion for this component.
     */
    @Override
    public void enableMouseAllMotion() {
        writeToTerminal(Code.EnableMouseAllMotion.value());
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // disableMouseAllMotion behavior.
    /**
     * Handles disable mouse all motion for this component.
     */
    @Override
    public void disableMouseAllMotion() {
        writeToTerminal(Code.DisableMouseAllMotion.value());
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // enableMouseSGRMode behavior.
    /**
     * Handles enable mouse sgrmode for this component.
     */
    @Override
    public void enableMouseSGRMode() {
        writeToTerminal(Code.EnableMouseSgrExt.value());
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // disableMouseSGRMode behavior.
    /**
     * Handles disable mouse sgrmode for this component.
     */
    @Override
    public void disableMouseSGRMode() {
        writeToTerminal(Code.DisableMouseSgrExt.value());
    }

    // tui4j extension; no Bubble Tea equivalent.
    /**
     * Updates the mouse cursor text.
     */
    @Override
    public void setMouseCursorText() {
        writeToTerminal(Code.SetMouseTextCursor.value());
    }

    // tui4j extension; no Bubble Tea equivalent.
    /**
     * Updates the mouse cursor pointer.
     */
    @Override
    public void setMouseCursorPointer() {
        writeToTerminal(Code.SetMousePointerCursor.value());
    }

    // tui4j extension; no Bubble Tea equivalent.
    /**
     * Handles reset mouse cursor for this component.
     */
    @Override
    public void resetMouseCursor() {
        writeToTerminal(Code.ResetMouseCursor.value());
    }

    // tui4j extension; no Bubble Tea equivalent.
    /**
     * Handles copy to clipboard for this component.
     *
     * @param text text
     */
    @Override
    public void copyToClipboard(String text) {
        writeToTerminal(Code.copyToClipboard(text));
    }

    // Bubble Tea: bubbletea/commands.go Paste command
    /**
     * Handles request clipboard for this component.
     */
    @Override
    public void requestClipboard() {
        writeToTerminal(Code.requestClipboard());
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go clearScreen
    // behavior.
    /**
     * Handles clear screen for this component.
     */
    @Override
    public void clearScreen() {
        renderLock.lock();
        try {
            terminal.puts(InfoCmp.Capability.clear_screen);
            terminal.flush();
            repaint();
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go altScreen
    // behavior.
    /**
     * Handles alt screen for this component.
     *
     * @return whether the alternate screen is active
     */
    @Override
    public boolean altScreen() {
        return isInAltScreen;
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go enterAltScreen
    // behavior.
    /**
     * Handles enter alt screen for this component.
     */
    @Override
    public void enterAltScreen() {
        if (isInAltScreen)
            return;

        renderLock.lock();
        try {
            if (terminal.getType().equals("dumb"))
                return;

            terminal.puts(InfoCmp.Capability.enter_ca_mode);
            terminal.puts(InfoCmp.Capability.clear_screen);
            terminal.puts(InfoCmp.Capability.cursor_home);

            repaint();
            needsRender = true;
            isInAltScreen = true;

            terminal.flush();
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go exitAltScreen
    // behavior.
    /**
     * Handles exit alt screen for this component.
     */
    @Override
    public void exitAltScreen() {
        if (!altScreen())
            return;

        renderLock.lock();
        try {
            terminal.puts(InfoCmp.Capability.exit_ca_mode);

            repaint();
            needsRender = true;
            isInAltScreen = false;

            terminal.flush();
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go reportFocus
    // behavior.
    /**
     * Handles report focus for this component.
     *
     * @return whether focus reporting is enabled
     */
    @Override
    public boolean reportFocus() {
        renderLock.lock();
        try {
            return isReportFocus;
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // enableReportFocus behavior.
    /**
     * Handles enable report focus for this component.
     */
    @Override
    public void enableReportFocus() {
        renderLock.lock();
        try {
            isReportFocus = true;
            writeToTerminalUnlocked(Code.EnableFocusReporting.value());
        } finally {
            renderLock.unlock();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go
    // disableReportFocus behavior.
    /**
     * Handles disable report focus for this component.
     */
    @Override
    public void disableReportFocus() {
        renderLock.lock();
        try {
            isReportFocus = false;
            writeToTerminalUnlocked(Code.DisableFocusReporting.value());
        } finally {
            renderLock.unlock();
        }
    }

    /**
     * Handles enable bracketed paste for this component.
     */
    @Override
    public void enableBracketedPaste() {
        writeToTerminal(Code.EnableBracketedPaste.value());
        bracketedPasteEnabled = true;
    }

    /**
     * Handles disable bracketed paste for this component.
     */
    @Override
    public void disableBracketedPaste() {
        writeToTerminal(Code.DisableBracketedPaste.value());
        bracketedPasteEnabled = false;
    }

    /**
     * Handles bracketed paste for this component.
     *
     * @return whether acketed paste
     */
    @Override
    public boolean bracketedPaste() {
        return bracketedPasteEnabled;
    }

    // tui4j extension; no Bubble Tea equivalent.
    /**
     * Handles notify model changed for this component.
     */
    @Override
    public void notifyModelChanged() {
        this.needsRender = true;
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go repaint
    // behavior.
    /**
     * Handles repaint for this component.
     */
    @Override
    public void repaint() {
        lastRender = "";
        lastRenderedLines = new String[] {};
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go handleMessages
    // behavior.
    /**
     * Handles handle message for this component.
     *
     * @param msg msg
     */
    @Override
    public void handleMessage(Message msg) {
        // Deprecated *Msg classes extend *Message, so these checks handle both.
        if (msg instanceof PrintLineMessage printLineMessage) {
            queuePrintLine(printLineMessage.messageBody());
        } else if (msg instanceof SetWindowTitleMessage windowTitleMessage) {
            setWindowTitle(windowTitleMessage.title());
        } else if (msg instanceof EnableMouseCellMotionMessage) {
            enableMouseCellMotion();
            enableMouseSGRMode();
        } else if (msg instanceof EnableMouseAllMotionMessage) {
            enableMouseAllMotion();
            enableMouseSGRMode();
        } else if (msg instanceof DisableMouseMessage) {
            disableMouseSGRMode();
            disableMouseNormalTracking();
            disableMouseCellMotion();
            disableMouseAllMotion();
        } else if (msg instanceof SetMouseCursorTextMessage) {
            setMouseCursorText();
        } else if (msg instanceof SetMouseCursorPointerMessage) {
            setMouseCursorPointer();
        } else if (msg instanceof ResetMouseCursorMessage) {
            resetMouseCursor();
        } else if (msg instanceof com.williamcallahan.tui4j.message.CopyToClipboardMessage copyToClipboardMessage) {
            copyToClipboard(copyToClipboardMessage.text());
        } else if (msg instanceof ReadClipboardMessage) {
            requestClipboard();
        } else if (msg instanceof EnableBracketedPasteMessage) {
            enableBracketedPaste();
        } else if (msg instanceof DisableBracketedPasteMessage) {
            disableBracketedPaste();
        } else if (msg instanceof WindowSizeMessage windowSizeMessage) {
            this.width = windowSizeMessage.width();
            this.height = windowSizeMessage.height();
        }
    }

    // Bubble Tea: seeks to replicate bubbletea/standard_renderer.go setWindowTitle
    // behavior.
    /**
     * Updates the window title.
     *
     * @param title title
     */
    private void setWindowTitle(String title) {
        terminal.writer().print("\u001b]2;" + title + "\u0007");
    }

    /**
     * Handles queue print line for this component.
     *
     * @param messageBody message body
     */
    private void queuePrintLine(String messageBody) {
        if (isInAltScreen) {
            return;
        }
        renderLock.lock();
        try {
            String[] lines = messageBody.split("\n");
            queuedMessageLines.addAll(Arrays.asList(lines));
            needsRender = true;
            repaint();
        } finally {
            renderLock.unlock();
        }
    }
}
