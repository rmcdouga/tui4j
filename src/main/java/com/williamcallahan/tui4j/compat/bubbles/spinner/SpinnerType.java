package com.williamcallahan.tui4j.compat.bubbles.spinner;

import java.time.Duration;

/**
 * Port of Bubbles spinner type.
 * Bubble Tea: bubbletea/examples/spinner/main.go
 * <p>
 * Bubbles: spinner/spinner.go.
 */
public enum SpinnerType {

    LINE(new String[]{"|", "/", "-", "\\"}, Duration.ofSeconds(1).dividedBy(10)),
    DOT(new String[]{"⣾ ", "⣽ ", "⣻ ", "⢿ ", "⡿ ", "⣟ ", "⣯ ", "⣷ "}, Duration.ofSeconds(1).dividedBy(10)),
    MINI_DOT(new String[]{"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"}, Duration.ofSeconds(1).dividedBy(12)),
    JUMP(new String[]{"⢄", "⢂", "⢁", "⡁", "⡈", "⡐", "⡠"}, Duration.ofSeconds(1).dividedBy(10)),
    PULSE(new String[]{"█", "▓", "▒", "░"}, Duration.ofSeconds(1).dividedBy(8)),
    POINTS(new String[]{"∙∙∙", "●∙∙", "∙●∙", "∙∙●"}, Duration.ofSeconds(1).dividedBy(7)),
    GLOBE(new String[]{"🌍", "🌎", "🌏"}, Duration.ofSeconds(1).dividedBy(4)),
    MOON(new String[]{"🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘"}, Duration.ofSeconds(1).dividedBy(8)),
    MONKEY(new String[]{"🙈", "🙉", "🙊"}, Duration.ofSeconds(1).dividedBy(3)),
    METER(new String[]{
            "▱▱▱",
            "▰▱▱",
            "▰▰▱",
            "▰▰▰",
            "▰▰▱",
            "▰▱▱",
            "▱▱▱"
    }, Duration.ofSeconds(1).dividedBy(7)),
    HAMBURGER(new String[]{"☱", "☲", "☴", "☲"}, Duration.ofSeconds(1).dividedBy(3)),
    ELLIPSIS(new String[]{"", ".", "..", "..."}, Duration.ofSeconds(1).dividedBy(3));

    private final String[] frames;
    private final Duration duration;

    /**
     * Creates a spinner type with frames and timing that match the Go reference.
     *
     * @param frames frames rendered for this spinner type
     * @param duration delay between frames
     */
    SpinnerType(String[] frames, Duration duration) {
        this.frames = frames;
        this.duration = duration;
    }

    /**
     * Returns the frames for this spinner type.
     *
     * @return spinner frames
     */
    String[] frames() {
        return frames.clone();
    }
    /**
     * Returns the frame interval for this spinner type.
     *
     * @return frame duration
     */
    Duration duration() {
        return duration;
    }
}
