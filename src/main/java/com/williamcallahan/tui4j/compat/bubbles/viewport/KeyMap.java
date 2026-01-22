package com.williamcallahan.tui4j.compat.bubbles.viewport;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles viewport key bindings.
 * Upstream: github.com/charmbracelet/bubbles/viewport (KeyMap)
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
     * Creates default viewport key bindings.
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
     * Returns the binding for paging down.
     *
     * @return page-down binding
     */
    public Binding pageDown() {
        return pageDown;
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
     * Returns the binding for half-page down.
     *
     * @return half-page-down binding
     */
    public Binding halfPageDown() {
        return halfPageDown;
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
     * Returns the binding for line-down movement.
     *
     * @return down binding
     */
    public Binding down() {
        return down;
    }

    /**
     * Returns the binding for line-up movement.
     *
     * @return up binding
     */
    public Binding up() {
        return up;
    }

    /**
     * Returns the binding for left movement.
     *
     * @return left binding
     */
    public Binding left() {
        return left;
    }

    /**
     * Returns the binding for right movement.
     *
     * @return right binding
     */
    public Binding right() {
        return right;
    }
}
