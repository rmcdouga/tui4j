package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message to set progress percentage.
 * <p>
 * Bubbles: progress/progress.go SetPercentMessage type.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 */
public class SetPercentMessage implements Message {

    private final double percent;

    /**
     * Creates a set percent message.
     *
     * @param percent target percentage (0.0 to 1.0)
     */
    public SetPercentMessage(double percent) {
        this.percent = percent;
    }

    /**
     * Returns the target percentage.
     *
     * @return percentage value
     */
    public double percent() {
        return percent;
    }
}
