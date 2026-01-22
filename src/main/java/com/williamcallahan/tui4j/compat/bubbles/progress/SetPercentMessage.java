package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent to set the progress bar percentage.
 * <p>
 * Bubbles: progress/progress.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 * <p>
 * Bubbles: filepicker/hidden_windows.go.
 */
public class SetPercentMessage implements Message {
    private final double percent;

    /**
     * Creates a set percent message.
     *
     * @param percent the new percentage (0.0 to 1.0)
     */
    public SetPercentMessage(double percent) {
        this.percent = percent;
    }

    /**
     * Returns the percentage value.
     *
     * @return the percentage (0.0 to 1.0)
     */
    public double percent() {
        return percent;
    }
}
