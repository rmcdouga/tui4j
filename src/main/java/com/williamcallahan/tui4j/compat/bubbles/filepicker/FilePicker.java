package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.ErrorMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * File selection bubble for navigating the filesystem and selecting files or directories.
 * <p>
 * Port of charmbracelet/bubbles filepicker/filepicker.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/filepicker/filepicker.go">bubbles/filepicker/filepicker.go</a>
 * <p>
 * Bubbles: filepicker/filepicker.go.
 */
public class FilePicker implements Model {

    private static final int MARGIN_BOTTOM = 5;
    private static final String DEFAULT_CURSOR = ">";
    private static final String EMPTY_MSG = "Bummer. No Files Found.";
    private static final Logger logger = Logger.getLogger(FilePicker.class.getName());

    private final int id;
    private String path;
    private String currentDirectory;
    private List<String> allowedTypes;
    private KeyMap keyMap;
    private List<DirEntry> files;
    private boolean showPermissions;
    private boolean showSize;
    private boolean showHidden;
    private boolean dirAllowed;
    private boolean fileAllowed;
    private boolean autoHeight;
    private int height;
    private int selected;
    private int min;
    private int max;
    private Stack selectedStack;
    private Stack minStack;
    private Stack maxStack;
    private Styles styles;
    private String cursorChar;
    private static final AtomicInteger nextId = new AtomicInteger(1);
    private List<String> readErrors;

    /** Creates a new file picker with default settings. */
    public FilePicker() {
        this.id = generateId();
        this.currentDirectory = ".";
        this.cursorChar = DEFAULT_CURSOR;
        this.allowedTypes = new ArrayList<>();
        this.selected = 0;
        this.showPermissions = true;
        this.showSize = true;
        this.showHidden = false;
        this.dirAllowed = false;
        this.fileAllowed = true;
        this.autoHeight = true;
        this.height = 0;
        this.max = 0;
        this.min = 0;
        this.selectedStack = new Stack();
        this.minStack = new Stack();
        this.maxStack = new Stack();
        this.keyMap = new KeyMap();
        this.styles = Styles.defaultStyles();
        this.files = new ArrayList<>();
        this.readErrors = new ArrayList<>();
    }

    /**
     * Handles generate id for this component.
     *
     * @return result
     */
    private int generateId() {
        return nextId.getAndIncrement();
    }

    /**
     * Returns a command to populate the file list from the current directory.
     * Respects showHidden rules.
     */
    @Override
    public Command init() {
        return readDir(this.currentDirectory, this.showHidden);
    }

    /**
     * Handles read dir for this component.
     *
     * @param directory directory
     * @param showHidden show hidden
     * @return result
     */
    private Command readDir(String directory, boolean showHidden) {
        return () -> {
            try {
                Path dirPath = Paths.get(directory);
                List<DirEntry> entries = new ArrayList<>();
                List<String> errors = new ArrayList<>();
                try (var stream = Files.list(dirPath)) {
                    stream.sorted(Comparator.comparing(FilePicker::isNotDir)
                            .thenComparing(Path::getFileName)).forEach(p -> {
                        try {
                            boolean isDir = Files.isDirectory(p);
                            boolean isSymlink = Files.isSymbolicLink(p);
                            boolean isHidden = p.getFileName().toString().startsWith(".");
                            String name = p.getFileName().toString();

                            if (!showHidden && isHidden && !name.equals(".") && !name.equals("..")) {
                                return;
                            }

                            long size = Files.size(p);
                            String permissions = getPermissions(p);
                            entries.add(new DirEntry(name, isDir, isSymlink, size, permissions));
                        } catch (IOException e) {
                             String errorMsg = "Failed to read: " + p.getFileName() + " (" + e.getMessage() + ")";
                             errors.add(errorMsg);
                             logger.log(Level.WARNING, "Failed to read entry " + p, e);
                        }
                    });
                }
                return new ReadDirMessage(this.id, entries, errors);
            } catch (IOException e) {
                return new ErrorMessage(e);
            }
        };
    }

    /**
     * Reports whether not dir.
     *
     * @param p p
     * @return whether not dir
     */
    private static boolean isNotDir(Path p) {
        try {
            return !Files.isDirectory(p);
        } catch (SecurityException e) {
            // Can't propagate inside stream comparator; fallback to treating as file
            logger.log(Level.WARNING, "Security exception checking directory status for " + p, e);
            return false;
        }
    }

    /**
     * Returns the permissions.
     *
     * @param p p
     * @return result
     */
    private static String getPermissions(Path p) throws IOException {
        try {
            return Files.getPosixFilePermissions(p).toString();
        } catch (UnsupportedOperationException e) {
            // Non-POSIX filesystem (Windows)
            return (Files.isReadable(p) ? "r" : "-")
                    + (Files.isWritable(p) ? "w" : "-")
                    + (Files.isExecutable(p) ? "x" : "-");
        }
    }

    /**
     * Builds the path for a directory entry in the current directory.
     *
     * @param entry entry
     * @return entry path
     */
    private Path entryPath(DirEntry entry) {
        return Paths.get(this.currentDirectory, entry.name());
    }

    /**
     * Resolves symlink targets relative to the current directory.
     *
     * @param entry entry
     * @return resolved target path
     * @throws IOException when the symlink cannot be read
     */
    private Path resolveSymlink(DirEntry entry) throws IOException {
        Path linkPath = entryPath(entry);
        Path symlinkTarget = Files.readSymbolicLink(linkPath);
        return linkPath.getParent().resolve(symlinkTarget).normalize();
    }

    /**
     * Reports whether an entry is a directory, resolving symlinks.
     *
     * @param entry entry
     * @return whether the entry is a directory
     * @throws IOException when symlink resolution fails
     */
    private boolean isDirectoryEntry(DirEntry entry) throws IOException {
        if (!entry.isSymlink()) {
            return entry.isDir();
        }
        return Files.isDirectory(resolveSymlink(entry));
    }

    /**
     * Builds the display suffix for symlink targets.
     *
     * @param entry entry
     * @return suffix for symlink targets or empty string
     */
    private String symlinkSuffix(DirEntry entry) {
        if (!entry.isSymlink()) {
            return "";
        }
        try {
            Path symlinkTarget = Files.readSymbolicLink(entryPath(entry));
            return " \u2192 " + symlinkTarget;
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to resolve symlink for " + entry.name(), e);
            return "";
        }
    }

    /**
     * Sets the visible height in rows.
     *
     * @param height the height in rows
     */
    public void setHeight(int height) {
        this.height = height;
        if (this.max > this.height - 1) {
            this.max = this.min + this.height - 1;
        }
    }

    /**
     * Updates the picker dimensions based on terminal size.
     *
     * @param width the terminal width
     * @param height the terminal height
     */
    public void setTerminalSize(int width, int height) {
        if (this.autoHeight) {
            this.height = height - MARGIN_BOTTOM;
        }
        this.max = this.height - 1;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
    @Override
    public UpdateResult<FilePicker> update(Message msg) {
        if (msg instanceof KeyPressMessage keyPressMessage) {
            return handleKeyPress(keyPressMessage);
        } else if (msg instanceof ReadDirMessage readDirMsg) {
            if (readDirMsg.id() != this.id) {
                return UpdateResult.from(this);
            }
            this.files = readDirMsg.entries();
            this.readErrors = readDirMsg.errors();
            // Clamp selection indices to prevent out-of-bounds access when directory shrinks
            int lastIndex = Math.max(0, this.files.size() - 1);
            this.selected = Math.min(this.selected, lastIndex);
            this.min = Math.min(this.min, this.selected);
            this.max = Math.min(lastIndex, Math.max(0, this.min + this.height - 1));
            return UpdateResult.from(this);
        } else if (msg instanceof ErrorMessage errorMsg) {
            logger.log(Level.WARNING, "File picker failed to read directory", errorMsg.error());
            return UpdateResult.from(this);
        }

        return UpdateResult.from(this);
    }

    /**
     * Handles handle key press for this component.
     *
     * @param keyPressMessage key press message
     * @return result
     */
    private UpdateResult<FilePicker> handleKeyPress(KeyPressMessage keyPressMessage) {
        if (handleNavigation(keyPressMessage)) {
            return UpdateResult.from(this);
        } else if (Binding.matches(keyPressMessage, keyMap.back())) {
            this.currentDirectory = Path.of(this.currentDirectory).getParent() != null
                    ? Path.of(this.currentDirectory).getParent().toString()
                    : ".";
            if (this.selectedStack.length() > 0) {
                this.selected = this.selectedStack.pop();
                this.min = this.minStack.pop();
                this.max = this.maxStack.pop();
            } else {
                this.selected = 0;
                this.min = 0;
                this.max = this.height - 1;
            }
            return UpdateResult.from(this, readDir(this.currentDirectory, this.showHidden));
        } else if (Binding.matches(keyPressMessage, keyMap.open())) {
            return handleOpen(keyPressMessage);
        }
        return UpdateResult.from(this);
    }

    /**
     * Handles handle navigation for this component.
     *
     * @param keyPressMessage key press message
     * @return whether ndle navigation
     */
    private boolean handleNavigation(KeyPressMessage keyPressMessage) {
        if (Binding.matches(keyPressMessage, keyMap.goToTop())) {
            this.selected = 0;
            this.min = 0;
            this.max = this.height - 1;
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.goToLast())) {
            this.selected = Math.max(0, this.files.size() - 1);
            this.min = Math.max(0, this.files.size() - this.height);
            this.max = Math.max(0, this.files.size() - 1);
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.down())) {
            if (this.files.isEmpty()) {
                return true;
            }
            this.selected++;
            if (this.selected >= this.files.size()) {
                this.selected = this.files.size() - 1;
            }
            if (this.selected > this.max) {
                this.min++;
                this.max++;
            }
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.up())) {
            this.selected--;
            if (this.selected < 0) {
                this.selected = 0;
            }
            if (this.selected < this.min) {
                this.min--;
                this.max--;
            }
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.pageDown())) {
            if (this.files.isEmpty()) {
                return true;
            }
            this.selected += this.height;
            if (this.selected >= this.files.size()) {
                this.selected = Math.max(0, this.files.size() - 1);
            }
            this.min += this.height;
            this.max += this.height;

            if (this.max >= this.files.size()) {
                this.max = Math.max(0, this.files.size() - 1);
                this.min = Math.max(0, this.max - this.height + 1);
            }
            return true;
        } else if (Binding.matches(keyPressMessage, keyMap.pageUp())) {
            if (this.files.isEmpty()) {
                return true;
            }
            this.selected -= this.height;
            if (this.selected < 0) {
                this.selected = 0;
            }
            this.min -= this.height;
            this.max -= this.height;

            if (this.min < 0) {
                this.min = 0;
                this.max = Math.min(this.files.size() - 1, this.min + this.height - 1);
            }
            return true;
        }
        return false;
    }

    /**
     * Handles handle open for this component.
     *
     * @param keyPressMessage key press message
     * @return result
     */
    private UpdateResult<FilePicker> handleOpen(KeyPressMessage keyPressMessage) {
        if (this.files.isEmpty()) {
            return UpdateResult.from(this);
        }

        DirEntry f = this.files.get(this.selected);
        boolean isDir;
        try {
            isDir = isDirectoryEntry(f);
        } catch (IOException e) {
            return UpdateResult.from(this, () -> new ErrorMessage(e));
        }

        if ((!isDir && this.fileAllowed) || (isDir && this.dirAllowed)) {
            if (Binding.matches(keyPressMessage, keyMap.select())) {
                this.path = entryPath(f).toString();
            }
        }

        if (!isDir) {
            return UpdateResult.from(this);
        }

        this.currentDirectory = entryPath(f).toString();
        this.selectedStack.push(this.selected);
        this.minStack.push(this.min);
        this.maxStack.push(this.max);
        this.selected = 0;
        this.min = 0;
        this.max = this.height - 1;
        return UpdateResult.from(this, readDir(this.currentDirectory, this.showHidden));
    }

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    @Override
    public String view() {
        StringBuilder sb = new StringBuilder();

        if (this.files.isEmpty()) {
            sb.append(this.styles.emptyDirectory()
                    .height(this.height)
                    .render(EMPTY_MSG));
            return sb.toString();
        }

        for (int i = 0; i < this.files.size(); i++) {
            if (i < this.min || i > this.max) {
                continue;
            }

            DirEntry f = this.files.get(i);
            boolean disabled = !canSelect(f.name()) && !f.isDir();

            sb.append(renderRow(i, f, disabled));
        }

        int currentHeight = sb.toString().split("\n", -1).length;
        for (int i = currentHeight; i <= this.height; i++) {
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Handles render row for this component.
     *
     * @param i i
     * @param f f
     * @param disabled disabled
     * @return result
     */
    private String renderRow(int i, DirEntry f, boolean disabled) {
        StringBuilder sb = new StringBuilder();
        if (this.selected == i) {
            StringBuilder selectedBuilder = new StringBuilder();
            if (this.showPermissions) {
                selectedBuilder.append(" ").append(f.permissions());
            }
            if (this.showSize) {
                selectedBuilder.append(formatSize(f.size()));
            }
            selectedBuilder.append(" ").append(f.name()).append(symlinkSuffix(f));

            if (disabled) {
                sb.append(this.styles.disabledCursor().render(this.cursorChar));
                sb.append(this.styles.disabledSelected().render(selectedBuilder.toString()));
            } else {
                sb.append(this.styles.cursor().render(this.cursorChar));
                sb.append(this.styles.selected().render(selectedBuilder.toString()));
            }
            sb.append("\n");
            return sb.toString();
        }

        Style style = this.styles.file();
        if (f.isDir()) {
            style = this.styles.directory();
        } else if (f.isSymlink()) {
            style = this.styles.symlink();
        } else if (disabled) {
            style = this.styles.disabledFile();
        }

        sb.append(this.styles.cursor().render(" "));

        String fileName = style.render(f.name()) + symlinkSuffix(f);

        if (this.showPermissions) {
            sb.append(" ").append(this.styles.permission().render(f.permissions()));
        }
        if (this.showSize) {
            sb.append(this.styles.fileSize().render(formatSize(f.size())));
        }
        sb.append(" ").append(fileName);
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Handles format size for this component.
     *
     * @param bytes bytes
     * @return result
     */
    private String formatSize(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.1f KB", bytes / 1024.0);
        } else if (bytes < 1024 * 1024 * 1024) {
            return String.format("%.1f MB", bytes / (1024.0 * 1024));
        } else {
            return String.format("%.1f GB", bytes / (1024.0 * 1024 * 1024));
        }
    }

    /**
     * Handles can select for this component.
     *
     * @param file file
     * @return whether n select
     */
    private boolean canSelect(String file) {
        if (this.allowedTypes.isEmpty()) {
            return true;
        }

        for (String ext : this.allowedTypes) {
            if (file.endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the path of the selected file or directory.
     *
     * @return the selected path, or null if nothing selected
     */
    public String selectedPath() {
        return this.path;
    }

    /**
     * Checks if the given message represents a file selection.
     *
     * @param msg the message to check
     * @return true if a file was selected
     */
    public boolean didSelectFile(Message msg) {
        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (!Binding.matches(keyPressMessage, keyMap.select())) {
                return false;
            }

            if (this.files.isEmpty()) {
                return false;
            }

            DirEntry f = this.files.get(this.selected);
            boolean isDir;
            try {
                isDir = isDirectoryEntry(f);
            } catch (IOException e) {
                logger.log(Level.WARNING, "Failed to resolve symlink for " + f.name(), e);
                return false;
            }

            if ((!isDir && this.fileAllowed) || (isDir && this.dirAllowed)) {
                this.path = entryPath(f).toString();
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the given message represents entering a directory.
     *
     * @param msg the message to check
     * @return true if a directory was opened
     */
    public boolean didSelectDirectory(Message msg) {
        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (!Binding.matches(keyPressMessage, keyMap.open())) {
                return false;
            }

            if (this.files.isEmpty()) {
                return false;
            }

            DirEntry f = this.files.get(this.selected);
            try {
                return isDirectoryEntry(f);
            } catch (IOException e) {
                logger.log(Level.WARNING, "Failed to resolve symlink for " + f.name(), e);
                return false;
            }
        }
        return false;
    }

    /**
     * Returns the current directory path.
     *
     * @return the current directory
     */
    public String currentDirectory() {
        return this.currentDirectory;
    }

    /**
     * Returns any errors encountered while reading the current directory.
     * Errors are cleared when a new directory is read.
     *
     * @return list of error messages
     */
    public List<String> readErrors() {
        return List.copyOf(this.readErrors);
    }

    /**
     * Returns true if there were errors reading the current directory.
     *
     * @return true if there are read errors
     */
    public boolean hasReadErrors() {
        return !this.readErrors.isEmpty();
    }

    /**
     * Sets the current directory.
     *
     * @param directory the directory path
     */
    public void setCurrentDirectory(String directory) {
        this.currentDirectory = directory;
    }

    /**
     * Returns the list of allowed file extensions.
     *
     * @return list of allowed extensions
     */
    public List<String> allowedTypes() {
        return new ArrayList<>(this.allowedTypes);
    }

    /**
     * Sets the allowed file extensions for selection.
     *
     * @param types the allowed extensions (e.g., ".txt", ".java")
     */
    public void setAllowedTypes(String... types) {
        this.allowedTypes = new ArrayList<>(Arrays.asList(types));
    }

    /**
     * Returns whether hidden files are shown.
     *
     * @return true if hidden files are shown
     */
    public boolean showHidden() {
        return this.showHidden;
    }

    /**
     * Sets whether to show hidden files.
     *
     * @param showHidden true to show hidden files
     */
    public void setShowHidden(boolean showHidden) {
        this.showHidden = showHidden;
    }

    /**
     * Returns whether directories can be selected.
     *
     * @return true if directories can be selected
     */
    public boolean dirAllowed() {
        return this.dirAllowed;
    }

    /**
     * Sets whether directories can be selected.
     *
     * @param dirAllowed true to allow directory selection
     */
    public void setDirAllowed(boolean dirAllowed) {
        this.dirAllowed = dirAllowed;
    }

    /**
     * Returns whether files can be selected.
     *
     * @return true if files can be selected
     */
    public boolean fileAllowed() {
        return this.fileAllowed;
    }

    /**
     * Sets whether files can be selected.
     *
     * @param fileAllowed true to allow file selection
     */
    public void setFileAllowed(boolean fileAllowed) {
        this.fileAllowed = fileAllowed;
    }

    /**
     * Returns whether file permissions are displayed.
     *
     * @return true if permissions are shown
     */
    public boolean showPermissions() {
        return this.showPermissions;
    }

    /**
     * Sets whether to show file permissions.
     *
     * @param showPermissions true to show permissions
     */
    public void setShowPermissions(boolean showPermissions) {
        this.showPermissions = showPermissions;
    }

    /**
     * Returns whether file sizes are displayed.
     *
     * @return true if sizes are shown
     */
    public boolean showSize() {
        return this.showSize;
    }

    /**
     * Sets whether to show file sizes.
     *
     * @param showSize true to show sizes
     */
    public void setShowSize(boolean showSize) {
        this.showSize = showSize;
    }

    /**
     * Returns the visible height in rows.
     *
     * @return the height
     */
    public int height() {
        return this.height;
    }

    /**
     * Returns the current styles.
     *
     * @return the styles
     */
    public Styles styles() {
        return this.styles;
    }

    /**
     * Sets the styles for rendering.
     *
     * @param styles the styles to use
     */
    public void setStyles(Styles styles) {
        this.styles = styles;
    }

    /**
     * Returns the current key bindings.
     *
     * @return the key map
     */
    public KeyMap keyMap() {
        return this.keyMap;
    }

    /**
     * Sets the key bindings.
     *
     * @param keyMap the key map to use
     */
    public void setKeyMap(KeyMap keyMap) {
        this.keyMap = keyMap;
    }

    /**
     * Returns the cursor character.
     *
     * @return the cursor character
     */
    public String cursorChar() {
        return this.cursorChar;
    }

    /**
     * Sets the cursor character.
     *
     * @param cursorChar the cursor character to use
     */
    public void setCursorChar(String cursorChar) {
        this.cursorChar = cursorChar;
    }

    /**
     * Port of the file picker directory entry model.
     * Upstream: github.com/charmbracelet/bubbles/filepicker (dirEntry)
     *
     * @param name entry name
     * @param isDir whether the entry is a directory
     * @param isSymlink whether the entry is a symlink
     * @param size entry size in bytes
     * @param permissions entry permissions string
     * <p>
     * Bubbles: filepicker/filepicker.go.
     */
    public record DirEntry(String name, boolean isDir, boolean isSymlink, long size, String permissions) {
    }

    /**
     * Compatibility port of ReadDirMessage to preserve upstream behavior.
     * <p>
     * Bubbles: filepicker/filepicker.go.
     */
    private record ReadDirMessage(int id, List<DirEntry> entries, List<String> errors) implements Message {
    }

    /**
     * Compatibility port of Stack to preserve upstream behavior.
     * <p>
     * Bubbles: filepicker/filepicker.go.
     */
    private static class Stack {
        private final List<Integer> items = new ArrayList<>();

        /**
         * Handles push for this component.
         *
         * @param item item
         */
        public void push(int item) {
            this.items.add(item);
        }

        /**
         * Handles pop for this component.
         *
         * @return result
         */
        public int pop() {
            if (this.items.isEmpty()) {
                return 0;
            }
            int result = this.items.get(this.items.size() - 1);
            this.items.remove(this.items.size() - 1);
            return result;
        }

        /**
         * Handles length for this component.
         *
         * @return result
         */
        public int length() {
            return this.items.size();
        }
    }
}
