package com.williamcallahan.tui4j.examples.counter;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Example program message for the counter demo.
 * tui4j: examples/generic/src/main/java/com/williamcallahan/tui4j/examples/counter/CounterMessage.java
 */
public enum CounterMessage implements Message {
    INCREMENT,
    DECREMENT,
    INCREMENT_LATER,
}
