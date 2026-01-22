package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.term;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.ANSI256Color;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.ANSIColor;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.ColorProfile;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.NoColor;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.RGB;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.RGBColor;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.RGBSupplier;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor;
import java.io.Writer;


import java.util.List;

/**
 */
public class Output {
    private final com.williamcallahan.tui4j.compat.lipgloss.Output delegate;
    private final List<String> environment;

    /**
     * Creates Output to keep this component ready for use.
     *
     * @param delegate delegate
     * @param environment environment
     */
    public Output(com.williamcallahan.tui4j.compat.lipgloss.Output delegate, List<String> environment) {
        this.delegate = delegate;
        this.environment = environment;
    }
    
    /**
     * Handles writer for this component.
     *
     * @return result
     */
    public Writer writer() {
        return delegate.writer();
    }
    
    /**
     * Handles env color profile for this component.
     *
     * @return result
     */
    public ColorProfile envColorProfile() {
        return toBubbleteaProfile(delegate.envColorProfile());
    }
    
    /**
     * Handles default output for this component.
     *
     * @return result
     */
    public static Output defaultOutput() {
        return new Output(com.williamcallahan.tui4j.compat.lipgloss.Output.defaultOutput(), null);
    }

    /**
     * Returns whether the terminal background is dark.
     *
     * @return true if the background is dark
     */
    public boolean hasDarkBackground() {
        return delegate.hasDarkBackground();
    }

    /**
     * Returns the terminal background color.
     *
     * @return background color
     */
    public TerminalColor backgroundColor() {
        return toBubbleteaColor(delegate.backgroundColor());
    }

    /**
     * Returns the canonical output delegate.
     *
     * @return canonical output
     */
    public com.williamcallahan.tui4j.compat.lipgloss.Output toCanonical() {
        return delegate;
    }

    /**
     * Maps a canonical color profile to the Bubble Tea enum.
     *
     * @param profile canonical color profile
     * @return bubbletea color profile
     */
    private static ColorProfile toBubbleteaProfile(com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile profile) {
        if (profile == null) {
            return null;
        }
        return ColorProfile.valueOf(profile.name());
    }

    /**
     * Maps a canonical terminal color to the Bubble Tea API surface.
     *
     * @param color canonical terminal color
     * @return bubbletea terminal color
     */
    private static TerminalColor toBubbleteaColor(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        if (color == null) {
            return new NoColor();
        }
        if (color instanceof com.williamcallahan.tui4j.compat.lipgloss.color.ANSIColor ansiColor) {
            return new ANSIColor(ansiColor.value());
        }
        if (color instanceof com.williamcallahan.tui4j.compat.lipgloss.color.ANSI256Color ansi256Color) {
            return new ANSI256Color(ansi256Color.value());
        }
        if (color instanceof com.williamcallahan.tui4j.compat.lipgloss.color.RGBColor rgbColor) {
            com.williamcallahan.tui4j.compat.lipgloss.color.RGB rgb = rgbColor.rgb();
            return new RGBColor((int) (rgb.r() * 255.0f), (int) (rgb.g() * 255.0f), (int) (rgb.b() * 255.0f));
        }
        if (color instanceof com.williamcallahan.tui4j.compat.lipgloss.color.RGBSupplier rgbSupplier) {
            return new RGBColorAdapter(rgbSupplier);
        }
        return new NoColor();
    }

    /**
     * Adapter that exposes a canonical RGB supplier as a Bubble Tea terminal color.
     */
    private static final class RGBColorAdapter implements TerminalColor, RGBSupplier {
        private final com.williamcallahan.tui4j.compat.lipgloss.color.RGBSupplier delegate;

        /**
         * Creates an adapter for a canonical RGB supplier.
         *
         * @param delegate canonical RGB supplier
         */
        private RGBColorAdapter(com.williamcallahan.tui4j.compat.lipgloss.color.RGBSupplier delegate) {
            this.delegate = delegate;
        }

        /**
         * Applies the delegate as a background.
         *
         * @param style style to update
         * @param renderer renderer context
         * @return updated style
         */
        @Override
        public org.jline.utils.AttributedStyle applyAsBackground(
            org.jline.utils.AttributedStyle style,
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer renderer
        ) {
            return delegate
                .rgb()
                .asColorApplyStrategy()
                .applyForBackground(style);
        }

        /**
         * Applies the delegate as a background using the canonical renderer.
         *
         * @param style style to update
         * @param renderer renderer context
         * @return updated style
         */
        @Override
        public org.jline.utils.AttributedStyle applyAsBackground(
            org.jline.utils.AttributedStyle style,
            com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
        ) {
            return delegate
                .rgb()
                .asColorApplyStrategy()
                .applyForBackground(style);
        }

        /**
         * Applies the delegate as a foreground.
         *
         * @param style style to update
         * @param renderer renderer context
         * @return updated style
         */
        @Override
        public org.jline.utils.AttributedStyle applyAsForeground(
            org.jline.utils.AttributedStyle style,
            com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Renderer renderer
        ) {
            return delegate
                .rgb()
                .asColorApplyStrategy()
                .applyForForeground(style);
        }

        /**
         * Applies the delegate as a foreground using the canonical renderer.
         *
         * @param style style to update
         * @param renderer renderer context
         * @return updated style
         */
        @Override
        public org.jline.utils.AttributedStyle applyAsForeground(
            org.jline.utils.AttributedStyle style,
            com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
        ) {
            return delegate
                .rgb()
                .asColorApplyStrategy()
                .applyForForeground(style);
        }

        /**
         * Returns the RGB value for the delegate.
         *
         * @return RGB value
         */
        @Override
        public RGB rgb() {
            return RGB.fromCanonical(delegate.rgb());
        }
    }
}
