package org.flatscrew.latte.spice.timer;

import org.flatscrew.latte.Message;

/**
 * Emitted once when a timer reaches (or passes) its timeout.
 */
public record TimeoutMessage(int id) implements Message {
}
