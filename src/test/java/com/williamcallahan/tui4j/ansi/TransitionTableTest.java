package com.williamcallahan.tui4j.ansi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests transition table legacy shim.
 * Tests that the deprecated tui4j.ansi.TransitionTable correctly delegates to the new implementation
 * and maps states/actions correctly.
 */
class TransitionTableTest {

    @Test
    void testLegacyShimDelegation() {
        TransitionTable table = TransitionTable.get();
        State initialState = State.GROUND;
        byte code = 0x1B; // ESC character

        // This call tests the SHIM method: transition(com.williamcallahan.tui4j.ansi.State, byte)
        TransitionTable.Transition transition = table.transition(initialState, code);

        // Verify the result is mapped back to legacy types
        assertEquals(State.ESCAPE, transition.state());
        assertEquals(Action.CLEAR, transition.action());
    }

    @Test
    void testLegacyShimMapping() {
        TransitionTable table = TransitionTable.get();
        State initialState = State.CSI_ENTRY;
        byte code = (byte) 0x40; // '@' -> dispatch

        TransitionTable.Transition transition = table.transition(initialState, code);

        assertEquals(State.GROUND, transition.state());
        assertEquals(Action.DISPATCH, transition.action());
    }
}
