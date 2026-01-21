package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Enables bracketed paste mode in the terminal.
 * When enabled, pasted text is wrapped in escape sequences allowing
 * the application to distinguish paste from typed input.
 * <p>
 * Bubble Tea: bubbletea/screen.go enableBracketedPasteMsg
 *
 * @deprecated Use {@link EnableBracketedPasteMessage} instead.
 *             The {@code *Msg} suffix classes are being phased out in favor of
 *             {@code *Message} suffix classes to use idiomatic Java naming conventions.
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/screen.go">bubbletea/screen.go</a>
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class EnableBracketedPasteMsg implements Message {
}
