package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Message sent on each animation frame of a progress bar.
 * <p>
 * Bubbles: bubbles/progress/progress.go
 *
 * @deprecated Use {@link FrameMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/progress/progress.go">bubbles/progress/progress.go</a>
 * @param id animation id
 * @param tag animation tag
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public record FrameMsg(int id, int tag) implements Message {
}
