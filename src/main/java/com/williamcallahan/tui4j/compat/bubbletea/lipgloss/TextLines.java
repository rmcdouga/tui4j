package com.williamcallahan.tui4j.compat.bubbletea.lipgloss;

/**
 */
public class TextLines {
    private final com.williamcallahan.tui4j.compat.lipgloss.TextLines delegate;

    /**
     * Wraps the canonical text lines helper.
     *
     * @param delegate canonical text lines helper
     */
    private TextLines(com.williamcallahan.tui4j.compat.lipgloss.TextLines delegate) {
        this.delegate = delegate;
    }

    /**
     * Creates a text-lines helper from raw text.
     *
     * @param text text to split
     * @return text-lines helper
     */
    public static TextLines fromText(String text) {
        return new TextLines(com.williamcallahan.tui4j.compat.lipgloss.TextLines.fromText(text));
    }

    /**
     * Returns the width of the widest line.
     *
     * @return widest line length
     */
    public int widestLineLength() {
        return delegate.widestLineLength();
    }

    /**
     * Returns the text split into lines.
     *
     * @return lines
     */
    public String[] lines() {
        return delegate.lines();
    }
}
