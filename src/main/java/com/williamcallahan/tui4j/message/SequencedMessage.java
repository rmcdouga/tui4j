package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.SequenceMessage;

/**
 * Wraps a message with a sequence ID for correlating asynchronous command results.
 * <p>
 * When multiple async commands are dispatched, their results can arrive out of order.
 * This wrapper tags a result message with a {@code sequenceId} so the application
 * can correlate "this result belongs to request #N."
 * <p>
 * <b>tui4j extension</b> — no upstream Bubble Tea equivalent. Upstream Go's concurrency
 * model (goroutines + channels) handles correlation differently; Java's async patterns
 * benefit from explicit correlation IDs.
 * <p>
 * <b>Not to be confused with {@link SequenceMessage}</b>, a Bubble Tea port that
 * executes commands sequentially. This class tracks <em>where</em> results came from;
 * {@code SequenceMessage} controls <em>when</em> commands run.
 *
 * @param message the actual result message
 * @param sequenceId the correlation ID matching the originating command
 * @see SequenceMessage
 */
public record SequencedMessage(Message message, long sequenceId) implements Message {
}
