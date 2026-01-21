package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;
import com.williamcallahan.tui4j.compat.bubbletea.ResetMouseCursorMsg;

/**
 * Requests resetting the mouse cursor.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/ResetMouseCursorMessage.java
 */
@SuppressWarnings("deprecation")
public record ResetMouseCursorMessage() implements MessageShim {

    @Override
    public Message toMessage() {
        return new ResetMouseCursorMsg();
    }
}
