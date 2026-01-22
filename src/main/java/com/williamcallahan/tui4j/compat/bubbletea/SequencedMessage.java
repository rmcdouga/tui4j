package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Wraps a message with a sequence ID to ensure correct ordering of asynchronous command results.
 * <p>
 * tui4j extension; no upstream Bubble Tea equivalent.
 *
 * @param message the actual message
 * @param sequenceId the sequence ID
 */
public record SequencedMessage(Message message, long sequenceId) implements Message {
}
