package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Message requesting clipboard contents via OSC 52.
 * Bubble Tea: bubbletea/commands.go (Paste command)
 * 
 * @deprecated Use {@link ReadClipboardMsg} directly instead.
 */
@Deprecated
public class ReadClipboardMessage implements MessageShim {

    private static final ReadClipboardMsg INSTANCE = new ReadClipboardMsg();

    @Override
    public Message toMessage() {
        return INSTANCE;
    }
}
