package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests resetting the mouse cursor.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @deprecated Use {@link ResetMouseCursorMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class ResetMouseCursorMsg implements Message {
}
