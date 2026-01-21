package com.williamcallahan.tui4j.compat.bubbles.viewport;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles viewport key map.
 * Bubble Tea: bubbles/viewport/viewport.go
 */
public class KeyMap {

    private final Binding pageDown;
    private final Binding pageUp;
    private final Binding halfPageDown;
    private final Binding halfPageUp;
    private final Binding down;
    private final Binding up;
    private final Binding left;
    private final Binding right;

    /**
     * Creates a new default key map.
     */
    public KeyMap() {
        this.pageDown = new Binding(Binding.withKeys("pgdown", "ctrl+d"), Binding.withHelp("pgdn/ctrl+d", "page down"));
        this.pageUp = new Binding(Binding.withKeys("pgup", "ctrl+u"), Binding.withHelp("pgup/ctrl+u", "page up"));
        this.halfPageDown = new Binding(Binding.withKeys("ctrl+f"), Binding.withHelp("ctrl+f", "half page down"));
        this.halfPageUp = new Binding(Binding.withKeys("ctrl+b"), Binding.withHelp("ctrl+b", "half page up"));
        this.down = new Binding(Binding.withKeys("down"), Binding.withHelp("↓", "line down"));
        this.up = new Binding(Binding.withKeys("up"), Binding.withHelp("↑", "line up"));
        this.left = new Binding(Binding.withKeys("left"), Binding.withHelp("←", "left"));
        this.right = new Binding(Binding.withKeys("right"), Binding.withHelp("→", "right"));
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
     * Returns the key binding for page up.
     *
     * @return key binding for page up
     */
    public Binding pageUp() {
        return pageUp;
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
     * Returns the key binding for half page up.
     *
     * @return key binding for half page up
     */
    public Binding halfPageUp() {
        return halfPageUp;
    }

    /**
     * Returns the key binding for line down.
     *
     * @return key binding for line down
     */
    public Binding down() {
        return down;
    }

    /**
     * Returns the key binding for line up.
     *
     * @return key binding for line up
     */
    public Binding up() {
        return up;
    }

    /**
     * Returns the key binding for scrolling left.
     *
     * @return key binding for scrolling left
     */
    public Binding left() {
        return left;
    }

    /**
     * Returns the key binding for scrolling right.
     *
     * @return key binding for scrolling right
     */
    public Binding right() {
        return right;
    }
}
