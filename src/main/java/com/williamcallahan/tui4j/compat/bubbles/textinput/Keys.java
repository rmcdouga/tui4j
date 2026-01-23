package com.williamcallahan.tui4j.compat.bubbles.textinput;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles keys.
 * Bubble Tea: bubbletea/examples/textinput/main.go
 */
public class Keys {

    private final Binding characterForward;
    private final Binding characterBackward;
    private final Binding wordForward;
    private final Binding wordBackward;
    private final Binding deleteWordBackward;
    private final Binding deleteWordForward;
    private final Binding deleteAfterCursor;
    private final Binding deleteBeforeCursor;
    private final Binding deleteCharacterBackward;
    private final Binding deleteCharacterForward;
    private final Binding lineStart;
    private final Binding lineEnd;
    private final Binding paste;
    private final Binding acceptSuggestion;
    private final Binding nextSuggestion;
    private final Binding prevSuggestion;

    /**
     * Creates the default text input key bindings.
     */
    public Keys() {
        this.characterForward = new Binding(Binding.withKeys("right", "ctrl+f"));
        this.characterBackward = new Binding(Binding.withKeys("left", "ctrl+b"));
        this.wordForward = new Binding(Binding.withKeys("alt+right", "ctrl+right", "alt+f"));
        this.wordBackward = new Binding(Binding.withKeys("alt+left", "ctrl+left", "alt+b"));
        this.deleteWordBackward = new Binding(Binding.withKeys("alt+backspace", "ctrl+w"));
        this.deleteWordForward = new Binding(Binding.withKeys("alt+delete", "alt+d"));
        this.deleteAfterCursor = new Binding(Binding.withKeys("ctrl+k"));
        this.deleteBeforeCursor = new Binding(Binding.withKeys("ctrl+u"));
        this.deleteCharacterBackward = new Binding(Binding.withKeys("backspace", "ctrl+h"));
        this.deleteCharacterForward = new Binding(Binding.withKeys("delete", "ctrl+d"));
        this.lineStart = new Binding(Binding.withKeys("home", "ctrl+a"));
        this.lineEnd = new Binding(Binding.withKeys("end", "ctrl+e"));
        this.paste = new Binding(Binding.withKeys("ctrl+v"));
        this.acceptSuggestion = new Binding(Binding.withKeys("tab"));
        this.nextSuggestion = new Binding(Binding.withKeys("down", "ctrl+n"));
        this.prevSuggestion = new Binding(Binding.withKeys("up", "ctrl+p"));
    }

    /**
     * Returns the binding for moving forward one character.
     *
     * @return binding for character forward
     */
    public Binding characterForward() {
        return characterForward;
    }

    /**
     * Returns the binding for moving backward one character.
     *
     * @return binding for character backward
     */
    public Binding characterBackward() {
        return characterBackward;
    }

    /**
     * Returns the binding for moving forward by one word.
     *
     * @return binding for word forward
     */
    public Binding wordForward() {
        return wordForward;
    }

    /**
     * Returns the binding for moving backward by one word.
     *
     * @return binding for word backward
     */
    public Binding wordBackward() {
        return wordBackward;
    }

    /**
     * Returns the binding for deleting the word before the cursor.
     *
     * @return binding for delete word backward
     */
    public Binding deleteWordBackward() {
        return deleteWordBackward;
    }

    /**
     * Returns the binding for deleting the word after the cursor.
     *
     * @return binding for delete word forward
     */
    public Binding deleteWordForward() {
        return deleteWordForward;
    }

    /**
     * Returns the binding for deleting everything after the cursor.
     *
     * @return binding for delete after cursor
     */
    public Binding deleteAfterCursor() {
        return deleteAfterCursor;
    }

    /**
     * Returns the binding for deleting everything before the cursor.
     *
     * @return binding for delete before cursor
     */
    public Binding deleteBeforeCursor() {
        return deleteBeforeCursor;
    }

    /**
     * Returns the binding for deleting the previous character.
     *
     * @return binding for delete character backward
     */
    public Binding deleteCharacterBackward() {
        return deleteCharacterBackward;
    }

    /**
     * Returns the binding for deleting the next character.
     *
     * @return binding for delete character forward
     */
    public Binding deleteCharacterForward() {
        return deleteCharacterForward;
    }

    /**
     * Returns the binding for moving to the start of the line.
     *
     * @return binding for line start
     */
    public Binding lineStart() {
        return lineStart;
    }

    /**
     * Returns the binding for moving to the end of the line.
     *
     * @return binding for line end
     */
    public Binding lineEnd() {
        return lineEnd;
    }

    /**
     * Returns the binding for pasting content.
     *
     * @return binding for paste
     */
    public Binding paste() {
        return paste;
    }

    /**
     * Returns the binding for accepting a suggestion.
     *
     * @return binding for accepting a suggestion
     */
    public Binding acceptSuggestion() {
        return acceptSuggestion;
    }

    /**
     * Returns the binding for moving to the next suggestion.
     *
     * @return binding for next suggestion
     */
    public Binding nextSuggestion() {
        return nextSuggestion;
    }

    /**
     * Returns the binding for moving to the previous suggestion.
     *
     * @return binding for previous suggestion
     */
    public Binding prevSuggestion() {
        return prevSuggestion;
    }
}
