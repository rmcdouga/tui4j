package com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner;

import java.time.Duration;

/**
 * Port of Bubbles spinner type.
 * Bubble Tea: bubbletea/examples/spinner/main.go
 */
@Deprecated(since = "0.3.0")
public enum SpinnerType {

    /** Rotating line spinner (|, /, -, \). */
    LINE {
        @Override
        String[] frames() {
            return new String[]{"|", "/", "-", "\\"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(10);
        }
    },

    /** Braille dot spinner. */
    DOT {
        @Override
        String[] frames() {
            return new String[]{"⣾ ", "⣽ ", "⣻ ", "⢿ ", "⡿ ", "⣟ ", "⣯ ", "⣷ "};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(10);
        }
    },

    /** Minimal braille dot spinner. */
    MINI_DOT {
        @Override
        String[] frames() {
            return new String[]{"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(12);
        }
    },

    /** Jumping braille dot spinner. */
    JUMP {
        @Override
        String[] frames() {
            return new String[]{"⢄", "⢂", "⢁", "⡁", "⡈", "⡐", "⡠"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(10);
        }
    },

    /** Pulsing block shade spinner. */
    PULSE {
        @Override
        String[] frames() {
            return new String[]{"█", "▓", "▒", "░"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(8);
        }
    },

    /** Moving dot points spinner. */
    POINTS {
        @Override
        String[] frames() {
            return new String[]{"∙∙∙", "●∙∙", "∙●∙", "∙∙●"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(7);
        }
    },

    /** Globe emoji spinner. */
    GLOBE {
        @Override
        String[] frames() {
            return new String[]{"🌍", "🌎", "🌏"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(4);
        }
    },

    /** Moon phase emoji spinner. */
    MOON {
        @Override
        String[] frames() {
            return new String[]{"🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(8);
        }
    },

    /** Monkey emoji spinner (see-hear-speak no evil). */
    MONKEY {
        @Override
        String[] frames() {
            return new String[]{"🙈", "🙉", "🙊"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(3);
        }
    },

    /** Meter bar spinner. */
    METER {
        @Override
        String[] frames() {
            return new String[]{
                    "▱▱▱",
                    "▰▱▱",
                    "▰▰▱",
                    "▰▰▰",
                    "▰▰▱",
                    "▰▱▱",
                    "▱▱▱"
            };
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(7);
        }
    },

    /** Hamburger trigram spinner. */
    HAMBURGER {
        @Override
        String[] frames() {
            return new String[]{"☱", "☲", "☴", "☲"};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(3);
        }
    },

    /** Ellipsis dots spinner. */
    ELLIPSIS {
        @Override
        String[] frames() {
            return new String[]{"", ".", "..", "..."};
        }

        @Override
        Duration duration() {
            return Duration.ofSeconds(1).dividedBy(3);
        }
    };

    abstract String[] frames();
    abstract Duration duration();
}
