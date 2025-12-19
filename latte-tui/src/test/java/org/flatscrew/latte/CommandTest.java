package org.flatscrew.latte;

import org.flatscrew.latte.message.CopyToClipboardMessage;
import org.flatscrew.latte.message.OpenUrlMessage;
import org.flatscrew.latte.message.ResetMouseCursorMessage;
import org.flatscrew.latte.message.SetMouseCursorPointerMessage;
import org.flatscrew.latte.message.SetMouseCursorTextMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CommandTest {

    @Test
    @DisplayName("Command.setMouseCursorText should return a SetMouseCursorTextMessage")
    void test_SetMouseCursorText() {
        Command cmd = Command.setMouseCursorText();
        Message msg = cmd.execute();
        assertThat(msg).isInstanceOf(SetMouseCursorTextMessage.class);
    }

    @Test
    @DisplayName("Command.setMouseCursorPointer should return a SetMouseCursorPointerMessage")
    void test_SetMouseCursorPointer() {
        Command cmd = Command.setMouseCursorPointer();
        Message msg = cmd.execute();
        assertThat(msg).isInstanceOf(SetMouseCursorPointerMessage.class);
    }

    @Test
    @DisplayName("Command.resetMouseCursor should return a ResetMouseCursorMessage")
    void test_ResetMouseCursor() {
        Command cmd = Command.resetMouseCursor();
        Message msg = cmd.execute();
        assertThat(msg).isInstanceOf(ResetMouseCursorMessage.class);
    }

    @Test
    @DisplayName("Command.copyToClipboard should return a CopyToClipboardMessage with correct text")
    void test_CopyToClipboard() {
        String text = "hello";
        Command cmd = Command.copyToClipboard(text);
        Message msg = cmd.execute();
        assertThat(msg).isInstanceOf(CopyToClipboardMessage.class);
        assertThat(((CopyToClipboardMessage) msg).text()).isEqualTo(text);
    }

    @Test
    @DisplayName("Command.openUrl should return an OpenUrlMessage with correct url")
    void test_OpenUrl() {
        String url = "https://example.com";
        Command cmd = Command.openUrl(url);
        Message msg = cmd.execute();
        assertThat(msg).isInstanceOf(OpenUrlMessage.class);
        assertThat(((OpenUrlMessage) msg).url()).isEqualTo(url);
    }
}

