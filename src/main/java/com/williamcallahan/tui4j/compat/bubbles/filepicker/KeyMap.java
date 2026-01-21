package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Key bindings for the file picker component.
 * <p>
 * Port of charmbracelet/bubbles filepicker/filepicker.go KeyMap type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/filepicker/filepicker.go">bubbles/filepicker/filepicker.go</a>
 */
public class KeyMap {

    private Binding goToTop;
    private Binding goToLast;
    private Binding down;
    private Binding up;
    private Binding pageUp;
    private Binding pageDown;
    private Binding back;
    private Binding open;
    private Binding select;

    /** Creates a new key map with default bindings. */
    public KeyMap() {
        this.goToTop = new Binding(
                Binding.withKeys("g"),
                Binding.withHelp("g", "first")
        );
        this.goToLast = new Binding(
                Binding.withKeys("G"),
                Binding.withHelp("G", "last")
        );
        this.down = new Binding(
                Binding.withKeys("j", "down", "ctrl+n"),
                Binding.withHelp("j", "down")
        );
        this.up = new Binding(
                Binding.withKeys("k", "up", "ctrl+p"),
                Binding.withHelp("k", "up")
        );
        this.pageUp = new Binding(
                Binding.withKeys("K", "pgup"),
                Binding.withHelp("pgup", "page up")
        );
        this.pageDown = new Binding(
                Binding.withKeys("J", "pgdown"),
                Binding.withHelp("pgdown", "page down")
        );
        this.back = new Binding(
                Binding.withKeys("h", "backspace", "left", "esc"),
                Binding.withHelp("h", "back")
        );
        this.open = new Binding(
                Binding.withKeys("l", "right", "enter"),
                Binding.withHelp("l", "open")
        );
        this.select = new Binding(
                Binding.withKeys("enter"),
                Binding.withHelp("enter", "select")
        );
    }

    /**
     * Returns the go-to-top binding.
     *
     * @return the binding
     */
    public Binding goToTop() {
        return goToTop;
    }

    /**
     * Sets the go-to-top binding.
     *
     * @param goToTop the binding
     */
    public void setGoToTop(Binding goToTop) {
        this.goToTop = goToTop;
    }

    /**
     * Returns the go-to-last binding.
     *
     * @return the binding
     */
    public Binding goToLast() {
        return goToLast;
    }

    /**
     * Sets the go-to-last binding.
     *
     * @param goToLast the binding
     */
    public void setGoToLast(Binding goToLast) {
        this.goToLast = goToLast;
    }

    /**
     * Returns the down navigation binding.
     *
     * @return the binding
     */
    public Binding down() {
        return down;
    }

    /**
     * Sets the down navigation binding.
     *
     * @param down the binding
     */
    public void setDown(Binding down) {
        this.down = down;
    }

    /**
     * Returns the up navigation binding.
     *
     * @return the binding
     */
    public Binding up() {
        return up;
    }

    /**
     * Sets the up navigation binding.
     *
     * @param up the binding
     */
    public void setUp(Binding up) {
        this.up = up;
    }

    /**
     * Returns the page-up binding.
     *
     * @return the binding
     */
    public Binding pageUp() {
        return pageUp;
    }

    /**
     * Sets the page-up binding.
     *
     * @param pageUp the binding
     */
    public void setPageUp(Binding pageUp) {
        this.pageUp = pageUp;
    }

    /**
     * Returns the page-down binding.
     *
     * @return the binding
     */
    public Binding pageDown() {
        return pageDown;
    }

    /**
     * Sets the page-down binding.
     *
     * @param pageDown the binding
     */
    public void setPageDown(Binding pageDown) {
        this.pageDown = pageDown;
    }

    /**
     * Returns the back navigation binding.
     *
     * @return the binding
     */
    public Binding back() {
        return back;
    }

    /**
     * Sets the back navigation binding.
     *
     * @param back the binding
     */
    public void setBack(Binding back) {
        this.back = back;
    }

    /**
     * Returns the open/enter binding.
     *
     * @return the binding
     */
    public Binding open() {
        return open;
    }

    /**
     * Sets the open/enter binding.
     *
     * @param open the binding
     */
    public void setOpen(Binding open) {
        this.open = open;
    }

    /**
     * Returns the select binding.
     *
     * @return the binding
     */
    public Binding select() {
        return select;
    }

    /**
     * Sets the select binding.
     *
     * @param select the binding
     */
    public void setSelect(Binding select) {
        this.select = select;
    }
}
