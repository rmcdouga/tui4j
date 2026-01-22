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
     * Returns the key binding for moving cursor up.
     *
     * @return key binding for moving cursor up
     */
    public Binding cursorUp() {
        return cursorUp;
    }

    /**
     * Returns the key binding for moving cursor down.
     *
     * @return key binding for moving cursor down
     */
    public Binding cursorDown() {
        return cursorDown;
    }

    /**
     * Returns the key binding for next page.
     *
     * @return key binding for next page
     */
    public Binding nextPage() {
        return nextPage;
    }

    /**
     * Returns the key binding for previous page.
     *
     * @return key binding for previous page
     */
    public Binding prevPage() {
        return prevPage;
    }

    /**
     * Returns the key binding for going to start.
     *
     * @return key binding for going to start
     */
    public Binding goToStart() {
        return goToStart;
    }

    /**
     * Returns the key binding for going to end.
     *
     * @return key binding for going to end
     */
    public Binding goToEnd() {
        return goToEnd;
    }

    /**
     * Returns the key binding for filtering.
     *
     * @return key binding for filtering
     */
    public Binding filter() {
        return filter;
    }

    /**
     * Returns the key binding for clearing filter.
     *
     * @return key binding for clearing filter
     */
    public Binding clearFilter() {
        return clearFilter;
    }

    /**
     * Returns the key binding for cancelling while filtering.
     *
     * @return key binding for cancelling while filtering
     */
    public Binding cancelWhileFiltering() {
        return cancelWhileFiltering;
    }

    /**
     * Returns the key binding for accepting while filtering.
     *
     * @return key binding for accepting while filtering
     */
    public Binding acceptWhileFiltering() {
        return acceptWhileFiltering;
    }

    /**
     * Returns the key binding for showing full help.
     *
     * @return key binding for showing full help
     */
    public Binding showFullHelp() {
        return showFullHelp;
    }

    /**
     * Returns the key binding for closing full help.
     *
     * @return key binding for closing full help
     */
    public Binding closeFullHelp() {
        return closeFullHelp;
    }

    /**
     * Returns the key binding for quitting.
     *
     * @return key binding for quitting
     */
    public Binding quit() {
        return quit;
    }

    /**
     * Returns the key binding for force quitting.
     *
     * @return key binding for force quitting
     */
    public Binding forceQuit() {
        return forceQuit;
    }

    /**
     * Handles short help for this component.
     *
     * @return result
     */
    @Override
    public Binding[] shortHelp() {
        return new Binding[] { cursorUp, cursorDown };
    }

    /**
     * Handles full help for this component.
     *
     * @return result
     */
    @Override
    public Binding[][] fullHelp() {
        return new Binding[][] {
                { cursorUp, cursorDown, prevPage, nextPage, goToStart, goToEnd },
                { filter, clearFilter, showFullHelp, closeFullHelp, quit, forceQuit }
        };
    }
}
