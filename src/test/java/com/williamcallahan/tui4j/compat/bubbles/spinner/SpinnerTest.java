package com.williamcallahan.tui4j.compat.bubbles.spinner;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbles/spinner/spinner_test.go.
 */
class SpinnerTest {

    @Test
    void testSpinnerTypes() {
        assertSpinnerType(SpinnerType.LINE, new String[]{"|", "/", "-", "\\"}, Duration.ofSeconds(1).dividedBy(10));
        assertSpinnerType(SpinnerType.DOT, new String[]{"⣾ ", "⣽ ", "⣻ ", "⢿ ", "⡿ ", "⣟ ", "⣯ ", "⣷ "}, Duration.ofSeconds(1).dividedBy(10));
        assertSpinnerType(SpinnerType.MINI_DOT, new String[]{"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"}, Duration.ofSeconds(1).dividedBy(12));
        assertSpinnerType(SpinnerType.JUMP, new String[]{"⢄", "⢂", "⢁", "⡁", "⡈", "⡐", "⡠"}, Duration.ofSeconds(1).dividedBy(10));
        assertSpinnerType(SpinnerType.PULSE, new String[]{"█", "▓", "▒", "░"}, Duration.ofSeconds(1).dividedBy(8));
        assertSpinnerType(SpinnerType.POINTS, new String[]{"∙∙∙", "●∙∙", "∙●∙", "∙∙●"}, Duration.ofSeconds(1).dividedBy(7));
        assertSpinnerType(SpinnerType.GLOBE, new String[]{"🌍", "🌎", "🌏"}, Duration.ofSeconds(1).dividedBy(4));
        assertSpinnerType(SpinnerType.MOON, new String[]{"🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘"}, Duration.ofSeconds(1).dividedBy(8));
        assertSpinnerType(SpinnerType.MONKEY, new String[]{"🙈", "🙉", "🙊"}, Duration.ofSeconds(1).dividedBy(3));
    }

    @Test
    void testSpinnerUsesProvidedType() {
        Spinner spinner = new Spinner(SpinnerType.LINE);
        assertThat(spinner.view()).isEqualTo("|");
    }

    private static void assertSpinnerType(SpinnerType type, String[] expectedFrames, Duration expectedDuration) {
        assertThat(type.frames()).containsExactly(expectedFrames);
        assertThat(type.duration()).isEqualTo(expectedDuration);
    }
}
