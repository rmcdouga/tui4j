package com.williamcallahan.tui4j.compat.bubbles.table;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles table KeyMap.
 * Bubble Tea: bubbles/table/keys.go
 */
public class Keys {

    private Binding lineUp;
    private Binding lineDown;
    private Binding pageUp;
    private Binding pageDown;
    private Binding halfPageUp;
    private Binding halfPageDown;
    private Binding gotoTop;
    private Binding gotoBottom;

    /**
     * Creates default table key bindings.
     */
    public Keys() {
        this.lineUp = new Binding(Binding.withKeys("up", "k"), Binding.withHelp("↑/k", "up"));
        this.lineDown = new Binding(Binding.withKeys("down", "j"), Binding.withHelp("↓/j", "down"));
        this.pageUp = new Binding(Binding.withKeys("b", "pgup"), Binding.withHelp("b/pgup", "page up"));
        this.pageDown = new Binding(Binding.withKeys("f", "pgdown", " "), Binding.withHelp("f/pgdn", "page down"));
        this.halfPageUp = new Binding(Binding.withKeys("u", "ctrl+u"), Binding.withHelp("u", "½ page up"));
        this.halfPageDown = new Binding(Binding.withKeys("d", "ctrl+d"), Binding.withHelp("d", "½ page down"));
        this.gotoTop = new Binding(Binding.withKeys("home", "g"), Binding.withHelp("g/home", "go to start"));
        this.gotoBottom = new Binding(Binding.withKeys("end", "G"), Binding.withHelp("G/end", "go to end"));
    }

    /**
     * Returns the default key set.
     *
     * @return default keys
     */
    public static Keys defaultKeys() {
        return new Keys();
    }

    /**
     * Returns the binding for moving one line up.
     *
     * @return line-up binding
     */
    public Binding lineUp() {
        return lineUp;
    }

    /**
     * Sets the binding for moving one line up.
     *
     * @param lineUp line-up binding
     * @return this keys instance
     */
    public Keys lineUp(Binding lineUp) {
        this.lineUp = lineUp;
        return this;
    }

    /**
     * Returns the binding for moving one line down.
     *
     * @return line-down binding
     */
    public Binding lineDown() {
        return lineDown;
    }

    /**
     * Sets the binding for moving one line down.
     *
     * @param lineDown line-down binding
     * @return this keys instance
     */
    public Keys lineDown(Binding lineDown) {
        this.lineDown = lineDown;
        return this;
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
     * @return this keys instance
     */
    public Keys pageUp(Binding pageUp) {
        this.pageUp = pageUp;
        return this;
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
     * @return this keys instance
     */
    public Keys pageDown(Binding pageDown) {
        this.pageDown = pageDown;
        return this;
    }

    /**
     * Returns the binding for half-page up.
     *
     * @return half-page-up binding
     */
    public Binding halfPageUp() {
        return halfPageUp;
    }

    /**
     * Sets the binding for half-page up.
     *
     * @param halfPageUp half-page-up binding
     * @return this keys instance
     */
    public Keys halfPageUp(Binding halfPageUp) {
        this.halfPageUp = halfPageUp;
        return this;
    }

    /**
     * Returns the binding for half-page down.
     *
     * @return half-page-down binding
     */
    public Binding halfPageDown() {
        return halfPageDown;
    }

    /**
     * Sets the binding for half-page down.
     *
     * @param halfPageDown half-page-down binding
     * @return this keys instance
     */
    public Keys halfPageDown(Binding halfPageDown) {
        this.halfPageDown = halfPageDown;
        return this;
    }

    /**
     * Returns the binding for jumping to the top.
     *
     * @return go-to-top binding
     */
    public Binding gotoTop() {
        return gotoTop;
    }

    /**
     * Sets the binding for jumping to the top.
     *
     * @param gotoTop go-to-top binding
     * @return this keys instance
     */
    public Keys gotoTop(Binding gotoTop) {
        this.gotoTop = gotoTop;
        return this;
    }

    /**
     * Returns the binding for jumping to the bottom.
     *
     * @return go-to-bottom binding
     */
    public Binding gotoBottom() {
        return gotoBottom;
    }

    /**
     * Sets the binding for jumping to the bottom.
     *
     * @param gotoBottom go-to-bottom binding
     * @return this keys instance
     */
    public Keys gotoBottom(Binding gotoBottom) {
        this.gotoBottom = gotoBottom;
        return this;
    }

    /**
     * Returns the short help bindings.
     *
     * @return short help bindings
     */
    public Binding[] shortHelp() {
        return new Binding[]{lineUp, lineDown};
    }

    /**
     * Returns the full help bindings.
     *
     * @return full help bindings
     */
    public Binding[][] fullHelp() {
        return new Binding[][]{
                {lineUp, lineDown, gotoTop, gotoBottom},
                {pageUp, pageDown, halfPageUp, halfPageDown}
        };
    }
}
