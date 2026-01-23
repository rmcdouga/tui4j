package com.williamcallahan.tui4j.compat.bubbles.spinner;

import java.time.Duration;

/**
 * Port of Bubbles spinner type.
 * Bubble Tea: bubbletea/examples/spinner/main.go
 * <p>
 * Bubbles: spinner/spinner.go.
 */
public enum SpinnerType {

    /**
     * Simple line spinner.
     */
    LINE(new String[]{"|", "/", "-", "\\"}, Duration.ofSeconds(1).dividedBy(10)),
    /**
     * Braille dot spinner.
     */
    DOT(new String[]{"⣾ ", "⣽ ", "⣻ ", "⢿ ", "⡿ ", "⣟ ", "⣯ ", "⣷ "}, Duration.ofSeconds(1).dividedBy(10)),
    /**
     * Compact braille dot spinner.
     */
    MINI_DOT(new String[]{"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"}, Duration.ofSeconds(1).dividedBy(12)),
    /**
     * Jumping dot spinner.
     */
    JUMP(new String[]{"⢄", "⢂", "⢁", "⡁", "⡈", "⡐", "⡠"}, Duration.ofSeconds(1).dividedBy(10)),
    /**
     * Pulsing block spinner.
     */
    PULSE(new String[]{"█", "▓", "▒", "░"}, Duration.ofSeconds(1).dividedBy(8)),
    /**
     * Three-dot points spinner.
     */
    POINTS(new String[]{"∙∙∙", "●∙∙", "∙●∙", "∙∙●"}, Duration.ofSeconds(1).dividedBy(7)),
    /**
     * Rotating globe spinner.
     */
    GLOBE(new String[]{"🌍", "🌎", "🌏"}, Duration.ofSeconds(1).dividedBy(4)),
    /**
     * Lunar phase spinner.
     */
    MOON(new String[]{"🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘"}, Duration.ofSeconds(1).dividedBy(8)),
    /**
     * See-no/ hear-no/ speak-no monkey spinner.
     */
    MONKEY(new String[]{"🙈", "🙉", "🙊"}, Duration.ofSeconds(1).dividedBy(3)),
    /**
     * Meter bar spinner.
     */
    METER(new String[]{
            "▱▱▱",
            "▰▱▱",
            "▰▰▱",
            "▰▰▰",
            "▰▰▱",
            "▰▱▱",
            "▱▱▱"
    }, Duration.ofSeconds(1).dividedBy(7)),
    /**
     * Hamburger menu spinner.
     */
    HAMBURGER(new String[]{"☱", "☲", "☴", "☲"}, Duration.ofSeconds(1).dividedBy(3)),
    /**
     * Ellipsis dot spinner.
     */
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
