package com.williamcallahan.tui4j.message;

import com.williamcallahan.tui4j.compat.bubbletea.ErrorMsg;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.MessageShim;

/**
 * Reports an error from command execution.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/message/ErrorMessage.java
 *
 * @param error error payload
 */
@SuppressWarnings("deprecation")
public record ErrorMessage(Throwable error) implements MessageShim {

    @Override
    public Message toMessage() {
        return new ErrorMsg(error);
    }
}
