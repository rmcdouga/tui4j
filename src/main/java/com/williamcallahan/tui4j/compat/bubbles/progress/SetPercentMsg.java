package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent to set the progress bar percentage.
 * <p>
 * Bubbles: bubbles/progress/progress.go
 *
 * @deprecated Use {@link SetPercentMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 * @param percent new progress percentage
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record SetPercentMsg(double percent) implements Message {
}
