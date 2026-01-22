package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Abstraction for rendering and terminal mode control.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: renderer.go.
 */
public class Renderer {

    static Renderer defaultRenderer = new Renderer(Output.defaultOutput());

    /**
     * Handles default renderer for this component.
     *
     * @return result
     */
    public static Renderer defaultRenderer() {
        return defaultRenderer;
    }

    private final Lock renderLock = new ReentrantLock();
    private Output output;
    private ColorProfile colorProfile;
    private boolean explicitColorProfile;

    private boolean hasDarkBackground;
    private boolean hasDarkBackgroundSet;
    private boolean explicitBackgroundColor;

    /**
     * Creates Renderer to keep this component ready for use.
     *
     * @param output output
     */
    public Renderer(Output output) {
        this.output = output;
    }

    /**
     * Sets a custom environment for terminal capability detection.
     * Used for SSH/remote session support where System.getenv() doesn't reflect
     * the remote session's environment variables.
     *
     * @param environment list of environment variables in "KEY=VALUE" format
     */
    public void setEnvironment(java.util.List<String> environment) {
        renderLock.lock();
        try {
            this.output = Output.withEnvironment(environment);
            // Reset cached values so they're re-detected with new environment
            if (!this.explicitColorProfile) { this.colorProfile = null; }
            this.hasDarkBackgroundSet = false;
        } finally {
            renderLock.unlock();
        }
    }

    /**
     * Handles new style for this component.
     *
     * @return result
     */
    public Style newStyle() {
        return new Style(this);
    }

    /**
     * Reports whether dark background is present.
     *
     * @return whether s dark background
     */
    public boolean hasDarkBackground() {
        if (hasDarkBackgroundSet || explicitBackgroundColor) {
            return hasDarkBackground;
        }

        renderLock.lock();
        try {
            hasDarkBackground = output.hasDarkBackground();
            hasDarkBackgroundSet = true;
            return hasDarkBackground;
        } finally {
            renderLock.unlock();
        }
    }

    /**
     * Handles color profile for this component.
     *
     * @return result
     */
    public ColorProfile colorProfile() {
        if (!explicitColorProfile && colorProfile == null) {
            renderLock.lock();
            try {
                colorProfile = output.envColorProfile();
            } finally {
                renderLock.unlock();
            }
        }
        return colorProfile;
    }

    /**
     * Updates the color profile.
     *
     * @param colorProfile color profile
     */
    public void setColorProfile(ColorProfile colorProfile) {
        renderLock.lock();
        try {
            this.colorProfile = colorProfile;
            this.explicitColorProfile = true;
        } finally {
            renderLock.unlock();
        }
    }

    /**
     * Updates the has dark background.
     *
     * @param hasDarkBackground has dark background
     */
    public void setHasDarkBackground(boolean hasDarkBackground) {
        renderLock.lock();
        try {
            this.hasDarkBackground = hasDarkBackground;
            hasDarkBackgroundSet = true;
            explicitBackgroundColor = true;
        } finally {
            renderLock.unlock();
        }
    }

    /**
     * Handles place for this component.
     *
     * @param width width
     * @param height height
     * @param hPos h pos
     * @param vPos v pos
     * @param input input
     * @param options options
     * @return result
     */
    public String place(int width, int height, Position hPos, Position vPos, String input, Whitespace.WhitespaceOption... options) {
        return placeVertical(height, vPos, placeHorizontal(width, hPos, input, options), options);
    }

    /**
     * Handles place vertical for this component.
     *
     * @param height height
     * @param position position
     * @param input input
     * @param options options
     * @return result
     */
    public String placeVertical(int height, Position position, String input, Whitespace.WhitespaceOption... options) {
        int contentHeight = (int) (input.chars().filter(ch -> ch == '\n').count() + 1);
        int gap = height - contentHeight;

        if (gap <= 0) {
            return input;
        }

        Whitespace whitespace = Whitespace.newWhiteSpace(this, options);
        TextLines textLines = TextLines.fromText(input);
        String emptyLine = whitespace.render(textLines.widestLineLength());

        StringBuilder builder = new StringBuilder();
        if (position.equals(Position.Top)) {
            builder.append(input).append('\n');

            for (int i = 0; i < gap; i++) {
                builder.append(emptyLine);
                if (i < gap - 1) {
                    builder.append('\n');
                }
            }

        } else if (position.equals(Position.Bottom)) {
            builder.append((emptyLine + "\n").repeat(gap)).append(input);
        } else {
            int split = (int) Math.round(gap * position.value());
            int top = gap - split;
            int bottom = gap - top;

            builder.append((emptyLine + "\n").repeat(gap)).append(input);

            for (int i = 0; i < bottom; i++) {
                builder.append('\n').append(emptyLine);
            }
        }
        return builder.toString();
    }

    /**
     * Handles place horizontal for this component.
     *
     * @param width width
     * @param position position
     * @param input input
     * @param options options
     * @return result
     */
    public String placeHorizontal(int width, Position position, String input, Whitespace.WhitespaceOption... options) {
        TextLines textLines = TextLines.fromText(input);
        int contentWidth = textLines.widestLineLength();
        int gap = width - contentWidth;

        if (gap <= 0) {
            return input;
        }

        Whitespace whitespace = Whitespace.newWhiteSpace(this, options);
        StringBuilder builder = new StringBuilder();

        String[] lines = textLines.lines();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            int shorty = Math.max(0, contentWidth - TextWidth.measureCellWidth(line));

            if (position.equals(Position.Left)) {
                builder.append(line).append(whitespace.render(gap + shorty));
            } else if (position.equals(Position.Right)) {
                builder.append(whitespace.render(gap + shorty)).append(line);
            } else {
                int totalGap = gap + shorty;

                int split = (int) Math.round(totalGap * position.value());
                int left = totalGap - split;
                int right = totalGap - left;

                builder
                        .append(whitespace.render(left))
                        .append(line)
                        .append(whitespace.render(right));
            }

            if (i < lines.length - 1) {
                builder.append('\n');
            }
        }

        return builder.toString();
    }
}
