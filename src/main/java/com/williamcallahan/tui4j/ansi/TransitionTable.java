package com.williamcallahan.tui4j.ansi;

/**
 * ANSI state transition table.
 * Delegates to the canonical x/ansi parser table for parity.
 */
public class TransitionTable {

    private static final TransitionTable instance = new TransitionTable();
    private static final com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable compatTable =
            com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable.get();
    /**
     * Returns the singleton transition table instance.
     *
     * @return transition table
     */
    public static TransitionTable get() {
        return instance;
    }

    private TransitionTable() {
    }

    /**
     * Generates the transition table (no-op, delegated to compat).
     */
    public void generateTable() {
        // Table is generated in the compat implementation.
    }

    /**
     * Returns the transition for the given state and input byte.
     *
     * @param state current state
     * @param code input byte
     * @return transition result
     */
    public Transition transition(State state, byte code) {
        com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable.Transition transition =
                compatTable.transition(toCompatState(state), code);
        State nextState = fromCompatState(transition.state());
        Action action = fromCompatAction(transition.action());
        return new Transition(nextState, action);
    }

    /**
     * Port of a transition tuple produced by the state table.
     * Upstream: github.com/charmbracelet/bubbletea (ansi/transition_table.go)
     *
     * @param state next state after transition
     * @param action action to perform
     */
    public record Transition(State state, Action action) {}

    private static com.williamcallahan.tui4j.compat.x.ansi.parser.State toCompatState(State state) {
        return com.williamcallahan.tui4j.compat.x.ansi.parser.State.values()[state.ordinal()];
    }

    private static State fromCompatState(com.williamcallahan.tui4j.compat.x.ansi.parser.State state) {
        return State.values()[state.ordinal()];
    }

    private static Action fromCompatAction(com.williamcallahan.tui4j.compat.x.ansi.parser.Action action) {
        return switch (action) {
            case NONE -> Action.NONE;
            case CLEAR -> Action.CLEAR;
            case COLLECT -> Action.COLLECT;
            case PREFIX -> Action.MARKER;
            case DISPATCH -> Action.DISPATCH;
            case EXECUTE -> Action.EXECUTE;
            case START -> Action.START;
            case PUT -> Action.PUT;
            case PARAM -> Action.PARAM;
            case PRINT -> Action.PRINT;
        };
    }
}
