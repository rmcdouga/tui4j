package com.williamcallahan.tui4j.term;

/**
 * Supplies terminal capability information.
 * <p>
 * Native tui4j interface for terminal introspection.
 */
public interface TerminalInfoProvider {

    /**
     * Returns information about the terminal.
     *
     * @return the terminal info
     */
    TerminalInfo provide();
}
