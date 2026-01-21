package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Enables bracketed paste mode in the terminal.
 * When enabled, pasted text is wrapped in escape sequences allowing
 * the application to distinguish paste from typed input.
 * <p>
 * Bubble Tea: bubbletea/screen.go enableBracketedPasteMsg
 */
public record EnableBracketedPasteMsg() implements Message {
}
