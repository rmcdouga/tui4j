package com.williamcallahan.tui4j.compat.bubbles.cursor;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbles/cursor/cursor_test.go.
 */
class CursorTest {

    @Test
    void testBlinkCommandCapturesTag() {
        Cursor cursor = new Cursor();
        cursor.setBlinkSpeed(Duration.ofMillis(2));

        Command first = cursor.blinkCommand();
        Command second = cursor.blinkCommand();

        Message firstMsg = first.execute();
        Message secondMsg = second.execute();

        assertThat(firstMsg).isInstanceOf(BlinkMessage.class);
        assertThat(secondMsg).isInstanceOf(BlinkMessage.class);

        BlinkMessage firstBlink = (BlinkMessage) firstMsg;
        BlinkMessage secondBlink = (BlinkMessage) secondMsg;

        assertThat(firstBlink.tag()).isEqualTo(1);
        assertThat(secondBlink.tag()).isEqualTo(2);
    }
}
