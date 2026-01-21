package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles keys.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 */
public class KeyMap implements com.williamcallahan.tui4j.compat.bubbles.help.KeyMap {

    private final Binding cursorUp;
    private final Binding cursorDown;
    private final Binding nextPage;
    private final Binding prevPage;
    private final Binding goToStart;
    private final Binding goToEnd;
    private final Binding filter;
    private final Binding clearFilter;
    private final Binding cancelWhileFiltering;
    private final Binding acceptWhileFiltering;
    private final Binding showFullHelp;
    private final Binding closeFullHelp;
    private final Binding quit;
    private final Binding forceQuit;

    /**
     * Creates a new default key map.
     */
    public KeyMap() {
        // Browsing
        this.cursorUp = new Binding(Binding.withKeys("up", "k"), Binding.withHelp("↑/k", "up"));
        this.cursorDown = new Binding(Binding.withKeys("down", "j"), Binding.withHelp("↓/j", "down"));
        this.prevPage = new Binding(Binding.withKeys("left", "h", "pgup", "b", "u"),
                Binding.withHelp("←/h/pgup", "prev page"));
        this.nextPage = new Binding(Binding.withKeys("right", "l", "pgdown", "f", "d"),
                Binding.withHelp("→/l/pgdn", "next page"));
        this.goToStart = new Binding(Binding.withKeys("home", "g"), Binding.withHelp("g/home", "go to start"));
        this.goToEnd = new Binding(Binding.withKeys("end", "G"), Binding.withHelp("G/end", "go to end"));

        // Filtering
        this.filter = new Binding(Binding.withKeys("/"), Binding.withHelp("/", "filter"));
        this.clearFilter = new Binding(Binding.withKeys("esc"), Binding.withHelp("esc", "clear filter"));
        this.cancelWhileFiltering = new Binding(Binding.withKeys("esc"), Binding.withHelp("esc", "cancel"));
        this.acceptWhileFiltering = new Binding(
                Binding.withKeys("enter", "tab", "shift+tab", "ctrl+k", "up", "ctrl+j", "down"),
                Binding.withHelp("enter", "apply filter"));

        // Help
        this.showFullHelp = new Binding(Binding.withKeys("?"), Binding.withHelp("?", "more"));
        this.closeFullHelp = new Binding(Binding.withKeys("?"), Binding.withHelp("?", "close help"));

        // Quitting
        this.quit = new Binding(Binding.withKeys("q", "esc"), Binding.withHelp("q", "quit"));
        this.forceQuit = new Binding(Binding.withKeys("ctrl+c"));
    }

    /**
     * @return key binding for moving cursor up
     */
    public Binding cursorUp() {
        return cursorUp;
    }

    /**
     * @return key binding for moving cursor down
     */
    public Binding cursorDown() {
        return cursorDown;
    }

    /**
     * @return key binding for next page
     */
    public Binding nextPage() {
        return nextPage;
    }

    /**
     * @return key binding for previous page
     */
    public Binding prevPage() {
        return prevPage;
    }

    /**
     * @return key binding for going to start
     */
    public Binding goToStart() {
        return goToStart;
    }

    /**
     * @return key binding for going to end
     */
    public Binding goToEnd() {
        return goToEnd;
    }

    /**
     * @return key binding for filtering
     */
    public Binding filter() {
        return filter;
    }

    /**
     * @return key binding for clearing filter
     */
    public Binding clearFilter() {
        return clearFilter;
    }

    /**
     * @return key binding for cancelling while filtering
     */
    public Binding cancelWhileFiltering() {
        return cancelWhileFiltering;
    }

    /**
     * @return key binding for accepting while filtering
     */
    public Binding acceptWhileFiltering() {
        return acceptWhileFiltering;
    }

    /**
     * @return key binding for showing full help
     */
    public Binding showFullHelp() {
        return showFullHelp;
    }

    /**
     * @return key binding for closing full help
     */
    public Binding closeFullHelp() {
        return closeFullHelp;
    }

    /**
     * @return key binding for quitting
     */
    public Binding quit() {
        return quit;
    }

    /**
     * @return key binding for force quitting
     */
    public Binding forceQuit() {
        return forceQuit;
    }

    @Override
    public Binding[] shortHelp() {
        return new Binding[] { cursorUp, cursorDown };
    }

    @Override
    public Binding[][] fullHelp() {
        return new Binding[][] {
                { cursorUp, cursorDown, prevPage, nextPage, goToStart, goToEnd },
                { filter, clearFilter, showFullHelp, closeFullHelp, quit, forceQuit }
        };
    }
}
