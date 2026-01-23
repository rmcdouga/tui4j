package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.lipgloss.Position;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;

/**
 * Port of Bubbles file picker styles.
 * Upstream: github.com/charmbracelet/bubbles/filepicker (Styles)
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
     * Creates an empty styles instance.
     */
    public Styles() {
    }

    /**
     * Creates default file picker styles.
     *
     * @return default styles
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
     * Returns the disabled cursor style.
     *
     * @return disabled cursor style
     */
    public Style disabledCursor() {
        return disabledCursor;
    }

    /**
     * Sets the disabled cursor style.
     *
     * @param disabledCursor style to set
     */
    public void setDisabledCursor(Style disabledCursor) {
        this.disabledCursor = disabledCursor;
    }

    /**
     * Returns the cursor style.
     *
     * @return cursor style
     */
    public Style cursor() {
        return cursor;
    }

    /**
     * Sets the cursor style.
     *
     * @param cursor style to set
     */
    public void setCursor(Style cursor) {
        this.cursor = cursor;
    }

    /**
     * Returns the symlink style.
     *
     * @return symlink style
     */
    public Style symlink() {
        return symlink;
    }

    /**
     * Sets the symlink style.
     *
     * @param symlink style to set
     */
    public void setSymlink(Style symlink) {
        this.symlink = symlink;
    }

    /**
     * Returns the directory style.
     *
     * @return directory style
     */
    public Style directory() {
        return directory;
    }

    /**
     * Sets the directory style.
     *
     * @param directory style to set
     */
    public void setDirectory(Style directory) {
        this.directory = directory;
    }

    /**
     * Returns the file style.
     *
     * @return file style
     */
    public Style file() {
        return file;
    }

    /**
     * Sets the file style.
     *
     * @param file style to set
     */
    public void setFile(Style file) {
        this.file = file;
    }

    /**
     * Returns the disabled file style.
     *
     * @return disabled file style
     */
    public Style disabledFile() {
        return disabledFile;
    }

    /**
     * Sets the disabled file style.
     *
     * @param disabledFile style to set
     */
    public void setDisabledFile(Style disabledFile) {
        this.disabledFile = disabledFile;
    }

    /**
     * Returns the permission style.
     *
     * @return permission style
     */
    public Style permission() {
        return permission;
    }

    /**
     * Sets the permission style.
     *
     * @param permission style to set
     */
    public void setPermission(Style permission) {
        this.permission = permission;
    }

    /**
     * Returns the selected style.
     *
     * @return selected style
     */
    public Style selected() {
        return selected;
    }

    /**
     * Sets the selected style.
     *
     * @param selected style to set
     */
    public void setSelected(Style selected) {
        this.selected = selected;
    }

    /**
     * Returns the disabled selected style.
     *
     * @return disabled selected style
     */
    public Style disabledSelected() {
        return disabledSelected;
    }

    /**
     * Sets the disabled selected style.
     *
     * @param disabledSelected style to set
     */
    public void setDisabledSelected(Style disabledSelected) {
        this.disabledSelected = disabledSelected;
    }

    /**
     * Returns the file size style.
     *
     * @return file size style
     */
    public Style fileSize() {
        return fileSize;
    }

    /**
     * Sets the file size style.
     *
     * @param fileSize style to set
     */
    public void setFileSize(Style fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Returns the empty directory style.
     *
     * @return empty directory style
     */
    public Style emptyDirectory() {
        return emptyDirectory;
    }

    /**
     * Sets the empty directory style.
     *
     * @param emptyDirectory style to set
     */
    public void setEmptyDirectory(Style emptyDirectory) {
        this.emptyDirectory = emptyDirectory;
    }

    private static final int FILE_SIZE_WIDTH = 7;
    private static final int PADDING_LEFT = 2;
}
