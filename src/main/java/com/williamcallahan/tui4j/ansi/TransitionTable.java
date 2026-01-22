package com.williamcallahan.tui4j.ansi;

/**
 * ANSI state transition table compatibility shim.
 * <p>
 * Maps between legacy {@code com.williamcallahan.tui4j.ansi} types and canonical
 * port at {@code com.williamcallahan.tui4j.compat.x.ansi.parser}. This allows
 * existing code using {@code ansi.State} and {@code ansi.Action} to continue working
 * while codebase migrates to canonical compat package.
 * <p>
 * <b>Difference from canonical port:</b>
 * <ul>
 *   <li>Accepts {@code ansi.State} and {@code ansi.Action} (legacy types)</li>
 *   <li>Internally maps to and from {@code compat.x.ansi.parser} types</li>
 *   <li>Returns {@code ansi.Transition} record with legacy types</li>
 * </ul>
 * <p>
 * <b>Canonical port:</b> {@link com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable}
 * Port of: <a href="https://github.com/charmbracelet/x/blob/main/ansi/parser/transition_table.go">x/ansi/parser/transition_table.go</a>
 */
public class TransitionTable {

    private static final TransitionTable instance = new TransitionTable();

    /**
     * Handles get for this component.
     *
     * @return result
     */
    public static TransitionTable get() {
        return instance;
    }

    /**
     * Creates TransitionTable to keep this component ready for use.
     */
    private TransitionTable() {
    }

    /**
     * Returns a transition for the given state and input byte.
     *
     * @param state the current parser state
     * @param code the input byte
     * @return the transition containing next state and action
     */
    public Transition transition(State state, byte code) {
        // Map legacy State to compat State
        com.williamcallahan.tui4j.compat.x.ansi.parser.State compatState = toCompatState(state);

        // Delegate to compat TransitionTable
        com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable.Transition compatTransition =
            com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable.get().transition(compatState, code);

        // Map result back to legacy Transition
        return new Transition(
            toLegacyState(compatTransition.state()),
            toLegacyAction(compatTransition.action())
        );
    }

    /**
     * Transition result containing the next state and action to perform.
     *
     * @param state next parser state
     * @param action action to perform
     */
    public record Transition(State state, Action action) {}

    // ─────────────────────────────────────────────────────────────────────────────
    // Mapping Helpers
    // ─────────────────────────────────────────────────────────────────────────────

    /**
     * Handles to compat state for this component.
     *
     * @param state state
     * @return result
     */
    private com.williamcallahan.tui4j.compat.x.ansi.parser.State toCompatState(State state) {
        return switch (state) {
            case GROUND -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.GROUND;
            case CSI_ENTRY -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.CSI_ENTRY;
            case CSI_INTERMEDIATE -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.CSI_INTERMEDIATE;
            case CSI_PARAM -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.CSI_PARAM;
            case DCS_ENTRY -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.DCS_ENTRY;
            case DCS_INTERMEDIATE -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.DCS_INTERMEDIATE;
            case DCS_PARAM -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.DCS_PARAM;
            case DCS_STRING -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.DCS_STRING;
            case ESCAPE -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.ESCAPE;
            case ESCAPE_INTERMEDIATE -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.ESCAPE_INTERMEDIATE;
            case OSC_STRING -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.OSC_STRING;
            case SOS_STRING -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.SOS_STRING;
            case PM_STRING -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.PM_STRING;
            case APC_STRING -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.APC_STRING;
            case UTF8 -> com.williamcallahan.tui4j.compat.x.ansi.parser.State.UTF8;
        };
    }

    /**
     * Handles to legacy state for this component.
     *
     * @param state state
     * @return result
     */
    private State toLegacyState(com.williamcallahan.tui4j.compat.x.ansi.parser.State state) {
        return switch (state) {
            case GROUND -> State.GROUND;
            case CSI_ENTRY -> State.CSI_ENTRY;
            case CSI_INTERMEDIATE -> State.CSI_INTERMEDIATE;
            case CSI_PARAM -> State.CSI_PARAM;
            case DCS_ENTRY -> State.DCS_ENTRY;
            case DCS_INTERMEDIATE -> State.DCS_INTERMEDIATE;
            case DCS_PARAM -> State.DCS_PARAM;
            case DCS_STRING -> State.DCS_STRING;
            case ESCAPE -> State.ESCAPE;
            case ESCAPE_INTERMEDIATE -> State.ESCAPE_INTERMEDIATE;
            case OSC_STRING -> State.OSC_STRING;
            case SOS_STRING -> State.SOS_STRING;
            case PM_STRING -> State.PM_STRING;
            case APC_STRING -> State.APC_STRING;
            case UTF8 -> State.UTF8;
        };
    }

    /**
     * Handles to legacy action for this component.
     *
     * @param action action
     * @return result
     */
    private Action toLegacyAction(com.williamcallahan.tui4j.compat.x.ansi.parser.Action action) {
        return switch (action) {
            case NONE -> Action.NONE;
            case CLEAR -> Action.CLEAR;
            case COLLECT -> Action.COLLECT;
            case PREFIX -> Action.MARKER; // Mapping PREFIX to legacy MARKER
            case DISPATCH -> Action.DISPATCH;
            case EXECUTE -> Action.EXECUTE;
            case START -> Action.START;
            case PUT -> Action.PUT;
            case PARAM -> Action.PARAM;
            case PRINT -> Action.PRINT;
        };
    }
}
