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
     * Creates a new default text input key map.
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
     * @return key binding for moving character forward
     */
    public Binding characterForward() {
        return characterForward;
    }

    /**
     * @return key binding for moving character backward
     */
    public Binding characterBackward() {
        return characterBackward;
    }

    /**
     * @return key binding for moving word forward
     */
    public Binding wordForward() {
        return wordForward;
    }

    /**
     * @return key binding for moving word backward
     */
    public Binding wordBackward() {
        return wordBackward;
    }

    /**
     * @return key binding for deleting word backward
     */
    public Binding deleteWordBackward() {
        return deleteWordBackward;
    }

    /**
     * @return key binding for deleting word forward
     */
    public Binding deleteWordForward() {
        return deleteWordForward;
    }

    /**
     * @return key binding for deleting after cursor
     */
    public Binding deleteAfterCursor() {
        return deleteAfterCursor;
    }

    /**
     * @return key binding for deleting before cursor
     */
    public Binding deleteBeforeCursor() {
        return deleteBeforeCursor;
    }

    /**
     * @return key binding for deleting character backward
     */
    public Binding deleteCharacterBackward() {
        return deleteCharacterBackward;
    }

    /**
     * @return key binding for deleting character forward
     */
    public Binding deleteCharacterForward() {
        return deleteCharacterForward;
    }

    /**
     * @return key binding for moving to line start
     */
    public Binding lineStart() {
        return lineStart;
    }

    /**
     * @return key binding for moving to line end
     */
    public Binding lineEnd() {
        return lineEnd;
    }

    /**
     * @return key binding for paste
     */
    public Binding paste() {
        return paste;
    }

    /**
     * @return key binding for accepting suggestion
     */
    public Binding acceptSuggestion() {
        return acceptSuggestion;
    }

    /**
     * @return key binding for next suggestion
     */
    public Binding nextSuggestion() {
        return nextSuggestion;
    }

    /**
     * @return key binding for previous suggestion
     */
    public Binding prevSuggestion() {
        return prevSuggestion;
    }
}
