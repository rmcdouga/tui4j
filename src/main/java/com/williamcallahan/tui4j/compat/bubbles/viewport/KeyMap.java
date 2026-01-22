package com.williamcallahan.tui4j.compat.bubbles.viewport;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

public class KeyMap {

    private final Binding pageDown;
    private final Binding pageUp;
    private final Binding halfPageDown;
    private final Binding halfPageUp;
    private final Binding down;
    private final Binding up;
    private final Binding left;
    private final Binding right;

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

    public Binding pageDown() {
        return pageDown;
    }

    public Binding pageUp() {
        return pageUp;
    }

    public Binding halfPageDown() {
        return halfPageDown;
    }

    public Binding halfPageUp() {
        return halfPageUp;
    }

    public Binding down() {
        return down;
    }

    public Binding up() {
        return up;
    }

    public Binding left() {
        return left;
    }

    public Binding right() {
        return right;
    }
}
