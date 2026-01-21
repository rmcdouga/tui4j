package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message to request the current window size.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @deprecated Use {@link CheckWindowSizeMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class CheckWindowSizeMsg extends CheckWindowSizeMessage {

    /**
     * Creates a window size check message.
     *
     * @deprecated Use {@link CheckWindowSizeMessage#CheckWindowSizeMessage()} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public CheckWindowSizeMsg() {
    }
}
