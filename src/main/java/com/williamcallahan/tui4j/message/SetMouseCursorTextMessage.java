package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;
import com.williamcallahan.tui4j.compat.bubbletea.SetMouseCursorTextMsg;

/**
 * Requests the text cursor.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/SetMouseCursorTextMessage.java
 */
public record SetMouseCursorTextMessage() implements MessageShim {

    @Override
    public Message toMessage() {
        return new SetMouseCursorTextMsg();
    }
}
