package org.flatscrew.latte.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MouseMessageTest {

    @Test
    void testSgrReleasePreservesMotion() {
        MouseMessage message = MouseMessage.parseSGRMouseEvent(32, 10, 20, true);

        assertThat(message.getAction()).isEqualTo(MouseAction.MouseActionMotion);
        assertThat(message.getButton()).isEqualTo(MouseButton.MouseButtonLeft);
    }

    @Test
    void testSgrReleaseSetsReleaseForNonMotion() {
        MouseMessage message = MouseMessage.parseSGRMouseEvent(0, 10, 20, true);

        assertThat(message.getAction()).isEqualTo(MouseAction.MouseActionRelease);
        assertThat(message.getButton()).isEqualTo(MouseButton.MouseButtonNone);
    }
}
