package com.williamcallahan.tui4j.compat.bubbletea.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/mouse_test.go.
 */
class MouseTest {

    @Test
    void testMouseDescribe() {
        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonNone).describe())
                .isEqualTo("unknown");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("left press");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonRight).describe())
                .isEqualTo("right press");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonMiddle).describe())
                .isEqualTo("middle press");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionRelease, MouseButton.MouseButtonNone).describe())
                .isEqualTo("release");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonWheelUp).describe())
                .isEqualTo("wheel up");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonWheelDown).describe())
                .isEqualTo("wheel down");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonWheelLeft).describe())
                .isEqualTo("wheel left");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonWheelRight).describe())
                .isEqualTo("wheel right");

        assertThat(new MouseMessage(0, 0, false, false, false,
                MouseAction.MouseActionMotion, MouseButton.MouseButtonNone).describe())
                .isEqualTo("motion");

        assertThat(new MouseMessage(0, 0, true, false, false,
                MouseAction.MouseActionRelease, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("shift+left release");

        assertThat(new MouseMessage(0, 0, true, false, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("shift+left press");

        assertThat(new MouseMessage(0, 0, true, false, true,
                MouseAction.MouseActionPress, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("ctrl+shift+left press");

        assertThat(new MouseMessage(0, 0, false, true, false,
                MouseAction.MouseActionPress, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("alt+left press");

        assertThat(new MouseMessage(0, 0, false, false, true,
                MouseAction.MouseActionPress, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("ctrl+left press");

        assertThat(new MouseMessage(0, 0, false, true, true,
                MouseAction.MouseActionPress, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("ctrl+alt+left press");

        assertThat(new MouseMessage(0, 0, true, true, true,
                MouseAction.MouseActionPress, MouseButton.MouseButtonLeft).describe())
                .isEqualTo("ctrl+alt+shift+left press");
    }
}
