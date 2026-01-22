package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Runtime exception for program startup or execution failures.
 * tui4j: src/main/java/com/williamcallahan/tui4j/compat/bubbletea/ProgramException.java
 * <p>
 * Bubble Tea: tea.go.
 */
public class ProgramException extends RuntimeException {
    /**
     * Creates ProgramException to keep this component ready for use.
     *
     * @param error error
     */
    public ProgramException(Throwable error) {
        super(error);
    }

    /**
     * Creates ProgramException to keep this component ready for use.
     *
     * @param message message
     * @param error error
     */
    public ProgramException(String message, Throwable error) {
        super(message, error);
    }
}
