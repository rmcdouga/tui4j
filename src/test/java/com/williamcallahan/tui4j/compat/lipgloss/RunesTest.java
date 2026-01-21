package com.williamcallahan.tui4j.compat.lipgloss;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests rune styling helpers.
 * <p>
 * Port of github.com/charmbracelet/lipgloss/runes_test.go.
 */
class RunesTest {

    @Test
    void testStyleRunes() {
        Style matchedStyle = Style.newStyle().reverse(true);
        Style unmatchedStyle = Style.newStyle();

        record TestCase(String name, String input, int[] indices, String expected) {
        }

        List<TestCase> cases = List.of(
                new TestCase(
                        "hello 0",
                        "hello",
                        new int[]{0},
                        "\u001b[7mh\u001b[0mello"
                ),
                new TestCase(
                        "你好 1",
                        "你好",
                        new int[]{1},
                        "你\u001b[7m好\u001b[0m"
                ),
                new TestCase(
                        "hello 你好 6,7",
                        "hello 你好",
                        new int[]{6, 7},
                        "hello \u001b[7m你好\u001b[0m"
                ),
                new TestCase(
                        "hello 1,3",
                        "hello",
                        new int[]{1, 3},
                        "h\u001b[7me\u001b[0ml\u001b[7ml\u001b[0mo"
                ),
                new TestCase(
                        "你好 0,1",
                        "你好",
                        new int[]{0, 1},
                        "\u001b[7m你好\u001b[0m"
                )
        );

        for (TestCase testCase : cases) {
            String result = Runes.styleRunes(testCase.input(), testCase.indices(), matchedStyle, unmatchedStyle);
            assertThat(result)
                    .withFailMessage(
                            "Expected:\n`%s`\n`%s`\nActual:\n`%s`\n`%s`",
                            testCase.expected(),
                            formatEscapes(testCase.expected()),
                            result,
                            formatEscapes(result)
                    )
                    .isEqualTo(testCase.expected());
        }
    }

    private static String formatEscapes(String value) {
        return value.replace("\u001b", "\\x1b");
    }
}
