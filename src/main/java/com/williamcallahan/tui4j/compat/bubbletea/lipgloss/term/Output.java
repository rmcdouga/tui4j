package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.term;

import java.io.Writer;
import java.util.List;

/**
 * Terminal output wrapper for Bubble Tea-compatible lipgloss rendering.
 * <p>
 * Lipgloss: term/output.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved to the canonical TUI4J path; use {@link com.williamcallahan.tui4j.compat.lipgloss.Output} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
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
     * Returns the writer for this output.
     * <p>
     * Note: This method returns null as the canonical Output does not expose a writer.
     *
     * @return null
     */
    public Writer writer() {
        return null;
    }
    
    /**
     * Handles env color profile for this component.
     *
     * @return result
     */
    public com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile envColorProfile() {
        return delegate.envColorProfile();
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
    public com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor backgroundColor() {
        return delegate.backgroundColor();
    }

    /**
     * Returns the canonical output delegate.
     *
     * @return canonical output
     */
    public com.williamcallahan.tui4j.compat.lipgloss.Output toCanonical() {
        return delegate;
    }

}
