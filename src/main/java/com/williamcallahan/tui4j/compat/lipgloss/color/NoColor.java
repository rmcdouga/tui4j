package com.williamcallahan.tui4j.compat.lipgloss.color;

import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import org.jline.utils.AttributedStyle;

/**
 * Port of Lip Gloss no color.
 * Upstream: lipgloss/color.go
 */
public final class NoColor implements TerminalColor{

    /**
     * Creates a no-color instance.
     */
    public NoColor() {
    }

    @Override
    public AttributedStyle applyAsBackground(AttributedStyle style, Renderer renderer) {
        return style;
    }

    @Override
    public AttributedStyle applyAsForeground(AttributedStyle style, Renderer renderer) {
        return style;
    }
}
