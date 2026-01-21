package com.williamcallahan.tui4j.compat.bubbletea;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Requests resetting the mouse cursor.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/ResetMouseCursorMsg.java
 */
public record ResetMouseCursorMsg() implements Message {
}
