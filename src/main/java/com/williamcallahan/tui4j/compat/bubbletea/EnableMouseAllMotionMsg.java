package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Enables "all motion" mouse tracking (report motion without a pressed button).
 * <p>
 * Bubble Tea: bubbletea/screen.go
 *
 * @deprecated Use {@link EnableMouseAllMotionMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class EnableMouseAllMotionMsg implements Message {

    /**
     * Creates a new enable mouse all motion message.
     */
    public EnableMouseAllMotionMsg() {
    }
}
