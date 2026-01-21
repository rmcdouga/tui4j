package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Reports an error from command execution.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.ErrorMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @param error error payload
 */
public record ErrorMessage(Throwable error) implements Message {
}
