package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Enables bracketed paste mode in the terminal.
 * When enabled, pasted text is wrapped in escape sequences allowing
 * the application to distinguish paste from typed input.
 * <p>
 * Bubble Tea: bubbletea/screen.go enableBracketedPasteMsg
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
public class EnableBracketedPasteMessage implements Message {

    /**
     * Creates an enable bracketed paste message.
     */
    public EnableBracketedPasteMessage() {
    }
}
