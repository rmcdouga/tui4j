package org.flatscrew.latte.message;

import org.flatscrew.latte.Message;

/**
 * Message that requests opening a URL with the system handler.
 * Latte extension; no Bubble Tea equivalent.
 *
 * @param url URL to open
 */
public record OpenUrlMessage(String url) implements Message {
}
