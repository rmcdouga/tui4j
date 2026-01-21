package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Reports an unrecognized input sequence.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.UnknownSequenceMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @param sequence the unrecognized escape sequence
 */
public record UnknownSequenceMessage(String sequence) implements Message {
}
