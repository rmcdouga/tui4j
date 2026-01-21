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
     * Creates a new default table key map.
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
     * Returns the default key map.
     *
     * @return the default key map
     */
    public static Keys defaultKeys() {
        return new Keys();
    }

    /**
     * Returns the key binding for line up.
     *
     * @return key binding for line up
     */
    public Binding lineUp() {
        return lineUp;
    }

    /**
     * Sets the line up key binding.
     *
     * @param lineUp new key binding
     * @return this for chaining
     */
    public Keys lineUp(Binding lineUp) {
        this.lineUp = lineUp;
        return this;
    }

    /**
     * Returns the key binding for line down.
     *
     * @return key binding for line down
     */
    public Binding lineDown() {
        return lineDown;
    }

    /**
     * Sets the line down key binding.
     *
     * @param lineDown new key binding
     * @return this for chaining
     */
    public Keys lineDown(Binding lineDown) {
        this.lineDown = lineDown;
        return this;
    }

    /**
     * Returns the key binding for page up.
     *
     * @return key binding for page up
     */
    public Binding pageUp() {
        return pageUp;
    }

    /**
     * Sets the page up key binding.
     *
     * @param pageUp new key binding
     * @return this for chaining
     */
    public Keys pageUp(Binding pageUp) {
        this.pageUp = pageUp;
        return this;
    }

    /**
     * Returns the key binding for page down.
     *
     * @return key binding for page down
     */
    public Binding pageDown() {
        return pageDown;
    }

    /**
     * Sets the page down key binding.
     *
     * @param pageDown new key binding
     * @return this for chaining
     */
    public Keys pageDown(Binding pageDown) {
        this.pageDown = pageDown;
        return this;
    }

    /**
     * Returns the key binding for half page up.
     *
     * @return key binding for half page up
     */
    public Binding halfPageUp() {
        return halfPageUp;
    }

    /**
     * Sets the half page up key binding.
     *
     * @param halfPageUp new key binding
     * @return this for chaining
     */
    public Keys halfPageUp(Binding halfPageUp) {
        this.halfPageUp = halfPageUp;
        return this;
    }

    /**
     * Returns the key binding for half page down.
     *
     * @return key binding for half page down
     */
    public Binding halfPageDown() {
        return halfPageDown;
    }

    /**
     * Sets the half page down key binding.
     *
     * @param halfPageDown new key binding
     * @return this for chaining
     */
    public Keys halfPageDown(Binding halfPageDown) {
        this.halfPageDown = halfPageDown;
        return this;
    }

    /**
     * Returns the key binding for go to top.
     *
     * @return key binding for go to top
     */
    public Binding gotoTop() {
        return gotoTop;
    }

    /**
     * Sets the go to top key binding.
     *
     * @param gotoTop new key binding
     * @return this for chaining
     */
    public Keys gotoTop(Binding gotoTop) {
        this.gotoTop = gotoTop;
        return this;
    }

    /**
     * Returns the key binding for go to bottom.
     *
     * @return key binding for go to bottom
     */
    public Binding gotoBottom() {
        return gotoBottom;
    }

    /**
     * Sets the go to bottom key binding.
     *
     * @param gotoBottom new key binding
     * @return this for chaining
     */
    public Keys gotoBottom(Binding gotoBottom) {
        this.gotoBottom = gotoBottom;
        return this;
    }

    /**
     * Returns array of key bindings for short help.
     *
     * @return array of key bindings for short help
     */
    public Binding[] shortHelp() {
        return new Binding[]{lineUp, lineDown};
    }

    /**
     * Returns array of key bindings for full help.
     *
     * @return array of key bindings for full help
     */
    public Binding[][] fullHelp() {
        return new Binding[][]{
                {lineUp, lineDown, gotoTop, gotoBottom},
                {pageUp, pageDown, halfPageUp, halfPageDown}
        };
    }
}
