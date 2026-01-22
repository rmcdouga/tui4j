package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.color.ANSIColor;
import com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile;
import com.williamcallahan.tui4j.compat.lipgloss.color.HSL;
import com.williamcallahan.tui4j.compat.lipgloss.color.NoColor;
import com.williamcallahan.tui4j.compat.lipgloss.color.RGB;
import com.williamcallahan.tui4j.compat.lipgloss.color.RGBSupplier;
import com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor;
import com.williamcallahan.tui4j.term.TerminalInfo;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Port of Lip Gloss output.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 * <p>
 * Lipgloss: renderer.go.
 */
public class Output {

    private static Output defaultOutput = new Output();

    /**
     * Handles default output for this component.
     *
     * @return result
     */
    public static Output defaultOutput() {
        return defaultOutput;
    }

    /**
     * Creates an Output with a custom environment for SSH/remote session support.
     * Environment list should contain "KEY=VALUE" strings (same format as upstream Go).
     *
     * @param environment list of environment variables in "KEY=VALUE" format
     * @return Output configured with the custom environment
     */
    public static Output withEnvironment(List<String> environment) {
        return new Output(parseEnvironment(environment));
    }

    /**
     * Handles parse environment for this component.
     *
     * @param environment environment
     * @return result
     */
    private static Map<String, String> parseEnvironment(List<String> environment) {
        if (environment == null) {
            return null;
        }
        return environment.stream()
                .filter(s -> s != null && s.contains("="))
                .collect(Collectors.toMap(
                        s -> s.substring(0, s.indexOf('=')),
                        s -> s.substring(s.indexOf('=') + 1),
                        (v1, v2) -> v2 // later values override earlier ones
                ));
    }

    private final Function<String, String> envLookup;
    private final Writer writer;
    private TerminalColor backgroundColor = new NoColor();

    /**
     * Creates Output to keep this component ready for use.
     */
    public Output() {
        this.envLookup = System::getenv;
        this.writer = new OutputStreamWriter(System.out);
    }

    /**
     * Creates Output to keep this component ready for use.
     *
     * @param environment environment
     */
    private Output(Map<String, String> environment) {
        if (environment == null) {
            this.envLookup = System::getenv;
        } else {
            this.envLookup = environment::get;
        }
        this.writer = new OutputStreamWriter(System.out);
    }

    /**
     * Returns the writer for this output.
     *
     * @return writer
     */
    public Writer writer() {
        return writer;
    }

    /**
     * Handles env color profile for this component.
     *
     * @return result
     */
    public ColorProfile envColorProfile() {
        if (envNoColor()) {
            return ColorProfile.Ascii;
        }
        ColorProfile colorProfile = colorProfile();
        if (cliColorForced() && colorProfile == ColorProfile.Ascii) {
            return ColorProfile.ANSI;
        }
        return colorProfile;
    }

    /**
     * Returns the env.
     *
     * @param key key
     * @return result
     */
    private String getenv(String key) {
        return envLookup.apply(key);
    }

    /**
     * Handles color profile for this component.
     *
     * @return result
     */
    private ColorProfile colorProfile() {
        if (!TerminalInfo.get().tty()) {
            return ColorProfile.Ascii;
        }
        if ("true".equals(getenv("GOOGLE_CLOUD_SHELL"))) {
            return ColorProfile.TrueColor;
        }

        String term = Optional.ofNullable(getenv("TERM")).orElse("");
        String colorTerm = Optional.ofNullable(getenv("COLORTERM")).orElse("");

        switch (colorTerm.toLowerCase()) {
            case "24bit":
            case "truecolor":
                if (term.startsWith("screen")) {
                    if (!"tmux".equals(getenv("TERM_PROGRAM"))) {
                        return ColorProfile.ANSI256;
                    }
                }
                return ColorProfile.TrueColor;
            case "yes":
            case "true":
                return ColorProfile.ANSI256;
        }

        switch (term) {
            case "xterm-kity":
            case "wezterm":
                return ColorProfile.TrueColor;
            case "linux":
                return ColorProfile.ANSI;
        }

        if (term.contains("256color")) return ColorProfile.ANSI256;
        if (term.contains("color")) return ColorProfile.ANSI;
        if (term.contains("ansi")) return ColorProfile.ANSI;

        return ColorProfile.ANSI256;
    }

    /**
     * Handles env no color for this component.
     *
     * @return whether v no color
     */
    private boolean envNoColor() {
        String noColor = getenv("NO_COLOR");
        String clicolor = getenv("CLICOLOR");

        return (noColor != null && !noColor.isBlank()) || ((clicolor != null && clicolor.equals("0")) && !cliColorForced());
    }

    /**
     * Handles cli color forced for this component.
     *
     * @return whether i color forced
     */
    private boolean cliColorForced() {
        String force = getenv("CLICOLOR_FORCE");
        if (force == null || force.isBlank()) {
            return false;
        }
        return !"0".equals(force);
    }

    /**
     * Reports whether dark background is present.
     *
     * @return whether s dark background
     */
    public boolean hasDarkBackground() {
        TerminalColor terminalColor = backgroundColor();

        RGB rgb = RGB.black();
        if (terminalColor instanceof RGBSupplier rgbSupplier) {
            rgb = rgbSupplier.rgb();
        }

        HSL hsl = rgb.toHSL();
        return hsl.isDark();
    }

    /**
     * Handles background color for this component.
     *
     * @return result
     */
    public TerminalColor backgroundColor() {
        if (!TerminalInfo.get().tty()) {
            return backgroundColor;
        }

        TerminalColor terminalColor = TerminalInfo.get().backgroundColor();
        if (terminalColor == null) {
            String colorfgbg = Optional.ofNullable(getenv("COLORFGBG")).orElse("");
            if (colorfgbg.contains(";")) {
                String[] strings = colorfgbg.split(";");
                try {
                    int colorCode = Integer.parseInt(strings[strings.length-1]);
                    return new ANSIColor(colorCode);
                } catch (NumberFormatException e) {
                    // do nothing
                }
            }
        }
        return new NoColor();
    }
}
