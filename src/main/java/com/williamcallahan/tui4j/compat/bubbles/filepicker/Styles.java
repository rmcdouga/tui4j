package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.lipgloss.Position;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;

/**
 * Port of Bubbles file picker styles.
 * Upstream: github.com/charmbracelet/bubbles/filepicker (Styles)
 * <p>
 * Bubbles: filepicker/filepicker.go.
 */
public class Styles {

    private Style disabledCursor;
    private Style cursor;
    private Style symlink;
    private Style directory;
    private Style file;
    private Style disabledFile;
    private Style permission;
    private Style selected;
    private Style disabledSelected;
    private Style fileSize;
    private Style emptyDirectory;

    /**
     * Creates Styles to keep this component ready for use.
     */
    public Styles() {
    }

    /**
     * Handles default styles for this component.
     *
     * @return result
     */
    public static Styles defaultStyles() {
        Styles styles = new Styles();
        styles.disabledCursor = Style.newStyle().foreground(Color.color("247"));
        styles.cursor = Style.newStyle().foreground(Color.color("212"));
        styles.symlink = Style.newStyle().foreground(Color.color("36"));
        styles.directory = Style.newStyle().foreground(Color.color("99"));
        styles.file = Style.newStyle();
        styles.disabledFile = Style.newStyle().foreground(Color.color("243"));
        styles.permission = Style.newStyle().foreground(Color.color("244"));
        styles.selected = Style.newStyle().foreground(Color.color("212")).bold(true);
        styles.disabledSelected = Style.newStyle().foreground(Color.color("247"));
        styles.fileSize = Style.newStyle().foreground(Color.color("240")).width(FILE_SIZE_WIDTH);
        styles.fileSize.align(Position.Right);
        styles.emptyDirectory = Style.newStyle()
                .foreground(Color.color("240"))
                .paddingLeft(PADDING_LEFT)
                .setString("Bummer. No Files Found.");
        return styles;
    }

    /**
     * Handles disabled cursor for this component.
     *
     * @return result
     */
    public Style disabledCursor() {
        return disabledCursor;
    }

    /**
     * Updates the disabled cursor.
     *
     * @param disabledCursor disabled cursor
     */
    public void setDisabledCursor(Style disabledCursor) {
        this.disabledCursor = disabledCursor;
    }

    /**
     * Handles cursor for this component.
     *
     * @return result
     */
    public Style cursor() {
        return cursor;
    }

    /**
     * Updates the cursor.
     *
     * @param cursor cursor
     */
    public void setCursor(Style cursor) {
        this.cursor = cursor;
    }

    /**
     * Handles symlink for this component.
     *
     * @return result
     */
    public Style symlink() {
        return symlink;
    }

    /**
     * Updates the symlink.
     *
     * @param symlink symlink
     */
    public void setSymlink(Style symlink) {
        this.symlink = symlink;
    }

    /**
     * Handles directory for this component.
     *
     * @return result
     */
    public Style directory() {
        return directory;
    }

    /**
     * Updates the directory.
     *
     * @param directory directory
     */
    public void setDirectory(Style directory) {
        this.directory = directory;
    }

    /**
     * Handles file for this component.
     *
     * @return result
     */
    public Style file() {
        return file;
    }

    /**
     * Updates the file.
     *
     * @param file file
     */
    public void setFile(Style file) {
        this.file = file;
    }

    /**
     * Handles disabled file for this component.
     *
     * @return result
     */
    public Style disabledFile() {
        return disabledFile;
    }

    /**
     * Updates the disabled file.
     *
     * @param disabledFile disabled file
     */
    public void setDisabledFile(Style disabledFile) {
        this.disabledFile = disabledFile;
    }

    /**
     * Handles permission for this component.
     *
     * @return result
     */
    public Style permission() {
        return permission;
    }

    /**
     * Updates the permission.
     *
     * @param permission permission
     */
    public void setPermission(Style permission) {
        this.permission = permission;
    }

    /**
     * Handles selected for this component.
     *
     * @return result
     */
    public Style selected() {
        return selected;
    }

    /**
     * Updates the selected.
     *
     * @param selected selected
     */
    public void setSelected(Style selected) {
        this.selected = selected;
    }

    /**
     * Handles disabled selected for this component.
     *
     * @return result
     */
    public Style disabledSelected() {
        return disabledSelected;
    }

    /**
     * Updates the disabled selected.
     *
     * @param disabledSelected disabled selected
     */
    public void setDisabledSelected(Style disabledSelected) {
        this.disabledSelected = disabledSelected;
    }

    /**
     * Handles file size for this component.
     *
     * @return result
     */
    public Style fileSize() {
        return fileSize;
    }

    /**
     * Updates the file size.
     *
     * @param fileSize file size
     */
    public void setFileSize(Style fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Handles empty directory for this component.
     *
     * @return result
     */
    public Style emptyDirectory() {
        return emptyDirectory;
    }

    /**
     * Updates the empty directory.
     *
     * @param emptyDirectory empty directory
     */
    public void setEmptyDirectory(Style emptyDirectory) {
        this.emptyDirectory = emptyDirectory;
    }

    private static final int FILE_SIZE_WIDTH = 7;
    private static final int PADDING_LEFT = 2;
}
