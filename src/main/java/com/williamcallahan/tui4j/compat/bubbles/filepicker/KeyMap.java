package com.williamcallahan.tui4j.compat.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles file picker key bindings.
 * Upstream: github.com/charmbracelet/bubbles/filepicker (KeyMap)
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

    /**
     * Creates default file picker key bindings.
     */
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
     * Returns the binding for jumping to the first entry.
     *
     * @return go-to-top binding
     */
    public Binding goToTop() {
        return goToTop;
    }

    /**
     * Sets the binding for jumping to the first entry.
     *
     * @param goToTop go-to-top binding
     */
    public void setGoToTop(Binding goToTop) {
        this.goToTop = goToTop;
    }

    /**
     * Returns the binding for jumping to the last entry.
     *
     * @return go-to-last binding
     */
    public Binding goToLast() {
        return goToLast;
    }

    /**
     * Sets the binding for jumping to the last entry.
     *
     * @param goToLast go-to-last binding
     */
    public void setGoToLast(Binding goToLast) {
        this.goToLast = goToLast;
    }

    /**
     * Returns the binding for moving down.
     *
     * @return down binding
     */
    public Binding down() {
        return down;
    }

    /**
     * Sets the binding for moving down.
     *
     * @param down down binding
     */
    public void setDown(Binding down) {
        this.down = down;
    }

    /**
     * Returns the binding for moving up.
     *
     * @return up binding
     */
    public Binding up() {
        return up;
    }

    /**
     * Sets the binding for moving up.
     *
     * @param up up binding
     */
    public void setUp(Binding up) {
        this.up = up;
    }

    /**
     * Returns the binding for paging up.
     *
     * @return page-up binding
     */
    public Binding pageUp() {
        return pageUp;
    }

    /**
     * Sets the binding for paging up.
     *
     * @param pageUp page-up binding
     */
    public void setPageUp(Binding pageUp) {
        this.pageUp = pageUp;
    }

    /**
     * Returns the binding for paging down.
     *
     * @return page-down binding
     */
    public Binding pageDown() {
        return pageDown;
    }

    /**
     * Sets the binding for paging down.
     *
     * @param pageDown page-down binding
     */
    public void setPageDown(Binding pageDown) {
        this.pageDown = pageDown;
    }

    /**
     * Returns the binding for navigating to the parent directory.
     *
     * @return back binding
     */
    public Binding back() {
        return back;
    }

    /**
     * Sets the binding for navigating to the parent directory.
     *
     * @param back back binding
     */
    public void setBack(Binding back) {
        this.back = back;
    }

    /**
     * Returns the binding for opening the selected entry.
     *
     * @return open binding
     */
    public Binding open() {
        return open;
    }

    /**
     * Sets the binding for opening the selected entry.
     *
     * @param open open binding
     */
    public void setOpen(Binding open) {
        this.open = open;
    }

    /**
     * Returns the binding for selecting the highlighted entry.
     *
     * @return select binding
     */
    public Binding select() {
        return select;
    }

    /**
     * Sets the binding for selecting the highlighted entry.
     *
     * @param select select binding
     */
    public void setSelect(Binding select) {
        this.select = select;
    }
}
