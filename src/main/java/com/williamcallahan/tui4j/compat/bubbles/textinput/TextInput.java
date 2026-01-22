package com.williamcallahan.tui4j.compat.bubbles.textinput;

import com.ibm.icu.lang.UCharacter;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.lipgloss.Size;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.PasteMessage;
import com.williamcallahan.tui4j.compat.bubbletea.ReadClipboardMessage;
import com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor;
import com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.clamp;
import static com.williamcallahan.tui4j.compat.bubbletea.Command.batch;

/**
 * Text input component.
 * Bubbles: bubbles/textinput/textinput.go
 */
public class TextInput implements Model {

    /**
     * Validates candidate input before it is applied.
     * Bubbles: bubbles/textinput/textinput.go
     */
    @FunctionalInterface
    interface ValidateFunction {

        /**
         * Reports whether valid.
         *
         * @param runes runes
         * @return whether valid
         */
        boolean isValid(char[] runes);
    }
    private String prompt;

    private String placeholder;
    private EchoMode echoMode;
    private char echoCharacter;
    private Cursor cursor;

    private Style promptStyle;
    private Style textStyle;
    private Style placeholderStyle;
    private Style completionStyle;
    private int charLimit;

    private int width;
    private Keys keys;
    private char[] value;
    private boolean focus;
    private int pos;
    private int offset;
    private int offsetRight;
    private ValidateFunction validateFunction;

    private Sanitizer sanitizer;
    private boolean showSuggestions;

    private char[][] suggestions;
    private char[][] matchedSuggestions;
    private int currentSuggestionIndex;
    /**
     * Creates TextInput to keep this component ready for use.
     */
    public TextInput() {
        this.prompt = "> ";
        this.echoCharacter = '*';
        this.echoMode = EchoMode.EchoNormal;
        this.charLimit = 0;
        this.placeholderStyle = Style.newStyle().foreground(Color.color("240"));
        this.showSuggestions = false;
        this.completionStyle = Style.newStyle().foreground(Color.color("240"));
        this.promptStyle = Style.newStyle();
        this.textStyle = Style.newStyle();
        this.cursor = new Cursor();
        this.keys = new Keys();
        this.sanitizer = new Sanitizer(
                Sanitizer.replaceTabs(" "),
                Sanitizer.replaceNewlines(" ")
        );

        this.suggestions = new char[][]{};
        this.matchedSuggestions = new char[][]{};
        this.value = new char[0];
        this.focus = false;
        this.pos = 0;
    }

    /**
     * Updates the prompt.
     *
     * @param prompt prompt
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    /**
     * Handles prompt for this component.
     *
     * @return result
     */
    public String prompt() {
        return prompt;
    }

    /**
     * Updates the prompt style.
     *
     * @param promptStyle prompt style
     */
    public void setPromptStyle(Style promptStyle) {
        this.promptStyle = promptStyle;
    }

    /**
     * Updates the text style.
     *
     * @param textStyle text style
     */
    public void setTextStyle(Style textStyle) {
        this.textStyle = textStyle;
    }

    /**
     * Updates the value.
     *
     * @param value value
     */
    public void setValue(String value) {
        char[] sanitized = sanitizer.sanitize(value.toCharArray());
        if (validateFunction != null) {
            validateFunction.isValid(sanitized);
        }
        setValueInternal(sanitized);
    }

    /**
     * Updates the value internal.
     *
     * @param runes runes
     */
    private void setValueInternal(char[] runes) {
        boolean empty = value.length == 0;

        if (charLimit > 0 && runes.length > charLimit) {
            this.value = Arrays.copyOfRange(runes, 0, charLimit);
        } else {
            this.value = runes;
        }

        if ((pos == 0 && empty) | pos > value.length) {
            setCursor(value.length);
        }
        handleOverflow();
    }

    /**
     * Handles value for this component.
     *
     * @return result
     */
    public String value() {
        return String.valueOf(value);
    }

    /**
     * Reports whether empty.
     *
     * @return whether empty
     */
    public boolean isEmpty() {
        return value.length == 0;
    }

    /**
     * Handles position for this component.
     *
     * @return result
     */
    public int position() {
        return pos;
    }

    /**
     * Updates the cursor.
     *
     * @param position position
     */
    public void setCursor(int position) {
        this.pos = clamp(position, 0, value.length);
        handleOverflow();
    }

    /**
     * Handles cursor start for this component.
     */
    public void cursorStart() {
        setCursor(0);
    }

    /**
     * Handles cursor end for this component.
     */
    public void cursorEnd() {
        setCursor(value.length);
    }

    /**
     * Reports whether focused.
     *
     * @return whether focused
     */
    public boolean isFocused() {
        return focus;
    }

    /**
     * Handles focus for this component.
     *
     * @return result
     */
    public Command focus() {
        this.focus = true;
        return cursor.focus();
    }

    /**
     * Handles blur for this component.
     */
    public void blur() {
        this.focus = false;
        cursor.blur();
    }

    /**
     * Handles reset for this component.
     */
    public void reset() {
        this.value = new char[0];
        setCursor(0);
    }

    /**
     * Updates the suggestions.
     *
     * @param suggestions suggestions
     */
    public void setSuggestions(String[] suggestions) {
        this.suggestions = new char[suggestions.length][];
        for (int i = 0; i < suggestions.length; i++) {
            this.suggestions[i] = suggestions[i].toCharArray();
        }

        updateSuggestions();
    }

    /**
     * Handles insert runes from user input for this component.
     *
     * @param runes runes
     */
    private void insertRunesFromUserInput(char[] runes) {
        char[] paste = sanitizer.sanitize(runes);

        int availSpace = 0;
        if (charLimit > 0) {
            availSpace = charLimit - value.length;

            if (availSpace <= 0) {
                return;
            }

            if (availSpace < paste.length) {
                paste = Arrays.copyOfRange(paste, 0, availSpace);
            }
        }

        char[] head = Arrays.copyOfRange(value, 0, pos);
        char[] tailSrc = Arrays.copyOfRange(value, pos, value.length);

        char[] tail = Arrays.copyOf(tailSrc, tailSrc.length);

        for (char r : paste) {
            head = appendChar(head, r);
            pos++;
            if (charLimit > 0) {
                availSpace--;
                if (availSpace <= 0) {
                    break;
                }
            }
        }

        char[] newValue = combineArrays(head, tail);

        if (validateFunction != null) {
            validateFunction.isValid(newValue);
        }
        setValueInternal(newValue);
    }

    /**
     * Handles append char for this component.
     *
     * @param array array
     * @param c c
     * @return result
     */
    private char[] appendChar(char[] array, char c) {
        char[] newArray = Arrays.copyOf(array, array.length + 1);
        newArray[array.length] = c;
        return newArray;
    }

    /**
     * Handles combine arrays for this component.
     *
     * @param head head
     * @param tail tail
     * @return result
     */
    private char[] combineArrays(char[] head, char[] tail) {
        char[] combined = new char[head.length + tail.length];
        System.arraycopy(head, 0, combined, 0, head.length);
        System.arraycopy(tail, 0, combined, head.length, tail.length);
        return combined;
    }

    /**
     * Handles handle overflow for this component.
     */
    private void handleOverflow() {
        if (width <= 0 || Size.width(new String(value)) <= width) {
            this.offset = 0;
            this.offsetRight = value.length;
            return;
        }

        this.offsetRight = Math.min(offsetRight, value.length);
        if (pos < offset) {
            this.offset = pos;

            int w = 0;
            int i = 0;
            char[] runes = Arrays.copyOfRange(value, offset, value.length);

            while (i < runes.length && w <= width) {
                w += TextWidth.measureCellWidth(String.valueOf(runes[i]));
                if (w <= width + 1) {
                    i++;
                }
            }

            this.offsetRight = offset + i;
        } else if (pos >= offsetRight) {
            this.offsetRight = pos;

            int w = 0;
            char[] runes = Arrays.copyOfRange(value, 0, offsetRight);
            int i = runes.length - 1;

            while (i > 0 && w < this.width) {
                w += TextWidth.measureCellWidth(String.valueOf(runes[i]));
                if (w <= this.width) {
                    i--;
                }
            }
            this.offset = offsetRight - (runes.length - 1 - i);
        }
    }

    /**
     * Handles delete before cursor for this component.
     */
    private void deleteBeforeCursor() {
        this.value = Arrays.copyOfRange(value, pos, value.length);
        this.offset = 0;
        setCursor(0);
    }

    /**
     * Handles delete after cursor for this component.
     */
    private void deleteAfterCursor() {
        this.value = Arrays.copyOfRange(value, 0, pos);
        setCursor(value.length);
    }

    /**
     * Handles delete character backward for this component.
     */
    private void deleteCharacterBackward() {
        if (value.length > 0) {
            value = combineArrays(
                    Arrays.copyOfRange(value, 0, Math.max(0, pos - 1)),
                    Arrays.copyOfRange(value, pos, value.length)
            );
            if (pos > 0) {
                setCursor(pos - 1);
            }
        }
    }

    /**
     * Handles delete word backward for this component.
     */
    private void deleteWordBackward() {
        if (pos == 0 || value.length == 0) {
            return;
        }

        if (echoMode != EchoMode.EchoNormal) {
            deleteBeforeCursor();
            return;
        }

        int oldPos = pos;
        setCursor(pos - 1);
        while (UCharacter.isSpaceChar(value[pos])) {
            if (pos <= 0) {
                break;
            }
            setCursor(pos - 1);
        }

        while (pos > 0) {
            if (!UCharacter.isSpaceChar(value[pos])) {
                setCursor(pos - 1);
            } else {
                if (pos > 0) {
                    setCursor(pos + 1);
                }
                break;
            }
        }

        if (oldPos > value.length) {
            this.value = Arrays.copyOfRange(value, 0, pos);
        } else {
            this.value = combineArrays(
                    Arrays.copyOfRange(value, 0, pos),
                    Arrays.copyOfRange(value, oldPos, value.length)
            );
        }
    }

    /**
     * Handles delete character forward for this component.
     */
    private void deleteCharacterForward() {
        if (value.length > 0 && pos < value.length) {
            value = combineArrays(
                    Arrays.copyOfRange(value, 0, pos),
                    Arrays.copyOfRange(value, pos + 1, value.length)
            );
        }
    }

    /**
     * Handles delete word forward for this component.
     */
    private void deleteWordForward() {
        if (pos >= value.length || value.length == 0) {
            return;
        }

        if (echoMode != EchoMode.EchoNormal) {
            deleteAfterCursor();
            return;
        }

        int oldPos = pos;
        setCursor(pos + 1);

        while (pos < value.length && UCharacter.isSpaceChar(value[pos])) {
            setCursor(pos + 1);
            if (pos >= value.length) {
                break;
            }
        }

        while (pos < value.length) {
            if (!UCharacter.isSpaceChar(value[pos])) {
                setCursor(pos + 1);
            } else {
                break;
            }
        }

        if (pos > value.length) {
            this.value = Arrays.copyOfRange(value, 0, oldPos);
        } else {
            this.value = combineArrays(
                    Arrays.copyOfRange(value, 0, oldPos),
                    Arrays.copyOfRange(value, pos, value.length)
            );
        }
        setCursor(oldPos);
    }

    /**
     * Handles word backward for this component.
     */
    private void wordBackward() {
        if (pos == 0 || value.length == 0) {
            return;
        }

        if (echoMode != EchoMode.EchoNormal) {
            cursorStart();
            return;
        }

        int i = pos - 1;

        while (i >= 0) {
            if (UCharacter.isSpaceChar(value[i])) {
                setCursor(pos - 1);
                i--;
            } else {
                break;
            }
        }

        while (i >= 0) {
            if (!UCharacter.isSpaceChar(value[i])) {
                setCursor(pos - 1);
                i--;
            } else {
                break;
            }
        }
    }

    /**
     * Handles word forward for this component.
     */
    private void wordForward() {
        if (pos >= value.length || value.length == 0) {
            return;
        }

        if (echoMode != EchoMode.EchoNormal) {
            cursorEnd();
            return;
        }

        int i = pos;

        while (i < value.length) {
            if (UCharacter.isSpaceChar(value[i])) {
                setCursor(pos + 1);
                i++;
            } else {
                break;
            }
        }

        while (i < value.length) {
            if (!UCharacter.isSpaceChar(value[i])) {
                setCursor(pos + 1);
                i++;
            } else {
                break;
            }
        }
    }

    /**
     * Handles echo transform for this component.
     *
     * @param input input
     * @return result
     */
    private String echoTransform(String input) {
        return switch (echoMode) {
            case EchoNormal -> input;
            case EchoPassword -> String.valueOf(echoCharacter).repeat(TextWidth.measureCellWidth(input));
            case EchoNone -> "";
        };
    }

    /**
     * Supplies the initial command for the model.
     *
     * @return initial command
     */
    @Override
    public Command init() {
        return null;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
    @Override
    public UpdateResult<TextInput> update(Message msg) {
        if (!focus) {
            return UpdateResult.from(this);
        }

        if (msg instanceof KeyPressMessage keyPressMsg && canAcceptSuggestion()) {
            if (Binding.matches(keyPressMsg, keys.acceptSuggestion())) {
                acceptSuggestion();
            }
        }

        int oldPos = pos;

        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (Binding.matches(keyPressMessage, keys.deleteWordBackward())) {
                deleteWordBackward();
            } else if (Binding.matches(keyPressMessage, keys.deleteCharacterBackward())) {
                deleteCharacterBackward();
            } else if (Binding.matches(keyPressMessage, keys.wordBackward())) {
                wordBackward();
            } else if (Binding.matches(keyPressMessage, keys.characterBackward())) {
                if (pos > 0) {
                    setCursor(pos - 1);
                }
            } else if (Binding.matches(keyPressMessage, keys.wordForward())) {
                wordForward();
            } else if (Binding.matches(keyPressMessage, keys.characterForward())) {
                if (pos < value.length) {
                    setCursor(pos + 1);
                }
            } else if (Binding.matches(keyPressMessage, keys.lineStart())) {
                cursorStart();
            } else if (Binding.matches(keyPressMessage, keys.deleteCharacterForward())) {
                deleteCharacterForward();
            } else if (Binding.matches(keyPressMessage, keys.lineEnd())) {
                cursorEnd();
            } else if (Binding.matches(keyPressMessage, keys.deleteAfterCursor())) {
                deleteAfterCursor();
            } else if (Binding.matches(keyPressMessage, keys.deleteBeforeCursor())) {
                deleteBeforeCursor();
            } else if (Binding.matches(keyPressMessage, keys.paste())) {
                return UpdateResult.from(this, this::paste);
            } else if (Binding.matches(keyPressMessage, keys.deleteWordForward())) {
                deleteWordForward();
            } else if (Binding.matches(keyPressMessage, keys.nextSuggestion())) {
                nextSuggestion();
            } else if (Binding.matches(keyPressMessage, keys.prevSuggestion())) {
                previousSuggestion();
            } else if (!Binding.matches(keyPressMessage, keys.acceptSuggestion())) {
                insertRunesFromUserInput(keyPressMessage.runes());
            }

            updateSuggestions();
        } else if (msg instanceof PasteMessage pasteMessage) {
            insertRunesFromUserInput(pasteMessage.content().toCharArray());
            updateSuggestions();
        }

        List<Command> commands = new LinkedList<>();

        UpdateResult<Cursor> cursorUpdateResult = cursor.update(msg);
        this.cursor = cursorUpdateResult.model();
        commands.add(cursorUpdateResult.command());

        if (oldPos != pos && cursor.mode() == CursorMode.Blink) {
            cursor.setBlink(false);
            commands.add(cursor.blinkCommand());
        }

        handleOverflow();
        return UpdateResult.from(this, batch(commands.toArray(new Command[0])));
    }

    /**
     * Requests clipboard contents from the terminal.
     * The clipboard contents are delivered as a {@link PasteMessage} in a subsequent update.
     * <p>
     * Bubble Tea: bubbles/textinput/textinput.go Paste
     *
     * @return message to request clipboard contents
     */
    public Message paste() {
        return new ReadClipboardMessage();
    }

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    @Override
    public String view() {
        if (value.length == 0 && placeholder != null && !placeholder.isEmpty()) {
            return placeholderView();
        }
        cursor.resetTextStyle();

        Style styleText = textStyle.copy().inline(true);

        char[] value = Arrays.copyOfRange(this.value, offset, offsetRight);
        int pos = Math.max(0, this.pos - offset);
        String v = styleText.render(
                echoTransform(
                        String.valueOf(Arrays.copyOfRange(value, 0, pos))
                )
        );

        if (pos < value.length) {
            String character = echoTransform(String.valueOf(value[pos]));
            cursor.setChar(character);

            v += cursor.view();
            v += styleText.render(echoTransform(String.valueOf(Arrays.copyOfRange(value, pos + 1, value.length))));
            v += completionView(0);
        } else {
            if (canAcceptSuggestion()) {
                char[] suggestion = matchedSuggestions[currentSuggestionIndex];

                if (value.length < suggestion.length) {
                    cursor.setTextStyle(this.completionStyle.copy());
                    cursor.setChar(echoTransform(String.valueOf(suggestion[pos])));
                    v += cursor.view();
                    v += completionView(1);
                } else {
                    cursor.setChar(" ");
                    v += cursor.view();
                }
            } else {
                cursor.setChar(" ");
                v += cursor.view();
            }
        }

        int valWidth = Size.width(String.valueOf(value));
        if (width > 0 && valWidth < width) {
            int padding = Math.max(0, this.width - valWidth);
            if (valWidth + padding <= this.width && pos < value.length) {
                padding++;
            }
            v += styleText.render(" ".repeat(padding));
        }

        return promptStyle.render(prompt) + v;
    }

    /**
     * Handles placeholder view for this component.
     *
     * @return result
     */
    public String placeholderView() {
        String v = "";
        Style style = placeholderStyle.copy().inline(true);

        char[] p = new char[width + 1];
        char[] placeholder = this.placeholder.toCharArray();
        if (placeholder.length > width + 1) {
            p = new char[placeholder.length];
        }
        System.arraycopy(placeholder, 0, p, 0, placeholder.length);

        cursor.setTextStyle(placeholderStyle.copy());
        cursor.setChar(String.valueOf(p[0]));
        v += cursor.view();

        if (width < 1 && p.length <= 1) {
            return promptStyle.render(prompt) + v;
        }

        if (width > 0) {
            int minWidth = Size.width(this.placeholder);
            int availWidth = width - minWidth + 1;

            if (availWidth < 0) {
                minWidth += availWidth;
                availWidth = 0;
            }

            v += style.render(String.valueOf(Arrays.copyOfRange(p, 1, minWidth)));
            v += style.render(" ".repeat(availWidth));
        } else {
            v += style.render(String.valueOf(Arrays.copyOfRange(p, 1, p.length)));
        }

        return promptStyle.render(prompt) + v;
    }

    /**
     * Handles blink for this component.
     *
     * @return result
     */
    public static Message blink() {
        return Cursor.blink();
    }

    /**
     * Handles completion view for this component.
     *
     * @param offset offset
     * @return result
     */
    public String completionView(int offset) {
        char[] value = this.value;
        Style style = placeholderStyle.copy().inline(true);

        if (canAcceptSuggestion()) {
            char[] suggestion = matchedSuggestions[currentSuggestionIndex];
            if (value.length < suggestion.length) {
                return style.render(
                        String.valueOf(
                                Arrays.copyOfRange(suggestion, value.length + offset, suggestion.length)
                        )
                );
            }
        }
        return "";
    }

    /**
     * Handles can accept suggestion for this component.
     *
     * @return whether n accept suggestion
     */
    private boolean canAcceptSuggestion() {
        return matchedSuggestions.length > 0;
    }

    /**
     * Accepts the current suggestion, replacing the input value with it.
     * Does nothing if there are no matched suggestions.
     */
    public void acceptSuggestion() {
        if (!canAcceptSuggestion()) {
            return;
        }
        if (currentSuggestionIndex >= matchedSuggestions.length) {
            return;
        }
        char[] suggestion = matchedSuggestions[currentSuggestionIndex];
        setValueInternal(suggestion);
        setCursor(suggestion.length);
    }

    /**
     * Handles next suggestion for this component.
     */
    public void nextSuggestion() {
        this.currentSuggestionIndex = currentSuggestionIndex + 1;
        if (currentSuggestionIndex > matchedSuggestions.length) {
            this.currentSuggestionIndex = 0;
        }
    }

    /**
     * Handles previous suggestion for this component.
     */
    public void previousSuggestion() {
        this.currentSuggestionIndex = currentSuggestionIndex - 1;
        if (currentSuggestionIndex < 0) {
            this.currentSuggestionIndex = matchedSuggestions.length;
        }
    }

    /**
     * Handles update suggestions for this component.
     */
    public void updateSuggestions() {
        if (!showSuggestions) {
            return;
        }

        if (value.length == 0 || suggestions.length == 0) {
            matchedSuggestions = new char[0][];
            return;
        }

        List<char[]> matches = new ArrayList<>();
        String currentValue = new String(value).toLowerCase();

        for (char[] suggestion : suggestions) {
            String suggestionStr = new String(suggestion);
            if (suggestionStr.toLowerCase().startsWith(currentValue)) {
                matches.add(suggestion);
            }
        }

        char[][] matchesArray = matches.toArray(new char[0][]);
        if (!Arrays.deepEquals(matchesArray, matchedSuggestions)) {
            currentSuggestionIndex = 0;
        }

        matchedSuggestions = matchesArray;
    }

    /**
     * Returns the suggestions.
     *
     * @param sugs sugs
     * @return result
     */
    private String[] getSuggestions(char[][] sugs) {
        String[] suggestions = new String[sugs.length];
        for (int i = 0; i < sugs.length; i++) {
            suggestions[i] = new String(sugs[i]);
        }
        return suggestions;
    }

    /**
     * Handles available suggestions for this component.
     *
     * @return result
     */
    public String[] availableSuggestions() {
        return getSuggestions(suggestions);
    }

    /**
     * Handles matched suggestions for this component.
     *
     * @return result
     */
    public String[] matchedSuggestions() {
        return getSuggestions(matchedSuggestions);
    }

    /**
     * Handles current suggestion index for this component.
     *
     * @return result
     */
    public int currentSuggestionIndex() {
        return currentSuggestionIndex;
    }

    /**
     * Handles current suggestion for this component.
     *
     * @return result
     */
    public String currentSuggestion() {
        if (currentSuggestionIndex >= matchedSuggestions.length) {
            return "";
        }
        return new String(matchedSuggestions[currentSuggestionIndex]);
    }

    /**
     * Updates the show suggestions.
     *
     * @param showSuggestions show suggestions
     */
    public void setShowSuggestions(boolean showSuggestions) {
        this.showSuggestions = showSuggestions;
    }

    /**
     * Updates the placeholder.
     *
     * @param placeholder placeholder
     */
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    /**
     * Updates the width.
     *
     * @param width width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Updates the char limit.
     *
     * @param charLimit char limit
     */
    public void setCharLimit(int charLimit) {
        this.charLimit = charLimit;
    }

    /**
     * Updates the echo mode.
     *
     * @param echoMode echo mode
     */
    public void setEchoMode(EchoMode echoMode) {
        this.echoMode = echoMode;
    }

    /**
     * Updates the echo character.
     *
     * @param echoCharacter echo character
     */
    public void setEchoCharacter(char echoCharacter) {
        this.echoCharacter = echoCharacter;
    }

    /**
     * Handles cursor for this component.
     *
     * @return result
     */
    public Cursor cursor() {
        return cursor;
    }
}
