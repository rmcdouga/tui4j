package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests copying text to the clipboard.
 * <p>
 * Re-export of {@link com.williamcallahan.tui4j.compat.bubbletea.CopyToClipboardMessage}.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 *
 * @param text text to copy
 */
public record CopyToClipboardMessage(String text) implements Message {
}
