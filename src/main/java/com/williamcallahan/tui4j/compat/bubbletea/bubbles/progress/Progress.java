package com.williamcallahan.tui4j.compat.bubbletea.bubbles.progress;

import com.williamcallahan.tui4j.compat.lipgloss.Style;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.progress.Progress}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/progress/Progress.java}.
 * <p>
 * Bubbles: progress/progress.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.progress.Progress}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Progress extends com.williamcallahan.tui4j.compat.bubbles.progress.Progress {

    /**
     * Creates a progress bar shim.
     */
    public Progress() {
        super();
    }

    @Override
    public Progress withWidth(int width) {
        super.withWidth(width);
        return this;
    }

    @Override
    public Progress withFull(char full) {
        super.withFull(full);
        return this;
    }

    @Override
    public Progress withEmpty(char empty) {
        super.withEmpty(empty);
        return this;
    }

    @Override
    public Progress withFullColor(String fullColor) {
        super.withFullColor(fullColor);
        return this;
    }

    @Override
    public Progress withEmptyColor(String emptyColor) {
        super.withEmptyColor(emptyColor);
        return this;
    }

    @Override
    public Progress withoutPercentage() {
        super.withoutPercentage();
        return this;
    }

    @Override
    public Progress withShowPercentage(boolean showPercentage) {
        super.withShowPercentage(showPercentage);
        return this;
    }

    @Override
    public Progress withPercentFormat(String percentFormat) {
        super.withPercentFormat(percentFormat);
        return this;
    }

    @Override
    public Progress withPercentageStyle(Style percentageStyle) {
        super.withPercentageStyle(percentageStyle);
        return this;
    }

    @Override
    public Progress withDefaultGradient() {
        super.withDefaultGradient();
        return this;
    }

    @Override
    public Progress withGradient(String colorA, String colorB) {
        super.withGradient(colorA, colorB);
        return this;
    }

    @Override
    public Progress withDefaultScaledGradient() {
        super.withDefaultScaledGradient();
        return this;
    }

    @Override
    public Progress withScaledGradient(String colorA, String colorB) {
        super.withScaledGradient(colorA, colorB);
        return this;
    }

}
