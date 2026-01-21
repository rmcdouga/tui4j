package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Requests printing a line above the program output.
 * <p>
 * Bubble Tea: bubbletea/standard_renderer.go
 *
 * @deprecated Use {@link PrintLineMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/standard_renderer.go">bubbletea/standard_renderer.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class PrintLineMsg extends PrintLineMessage {

    /**
     * Creates a print line message.
     *
     * @param messageBody line content
     * @deprecated Use {@link PrintLineMessage#PrintLineMessage(String)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public PrintLineMsg(String messageBody) {
        super(messageBody);
    }
}
