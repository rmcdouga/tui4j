package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Message sent to set the progress bar percentage.
 * <p>
 * Bubbles: bubbles/progress/progress.go
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 */
public class SetPercentMessage implements MessageShim {
    private final double percent;

    public SetPercentMessage(double percent) {
        this.percent = percent;
    }

    public double percent() {
        return percent;
    }

    @Override
    public Message toMessage() {
        return new SetPercentMsg(percent);
    }
}
