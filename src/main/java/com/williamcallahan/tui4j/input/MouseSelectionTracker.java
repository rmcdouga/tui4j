package com.williamcallahan.tui4j.input;

import com.williamcallahan.tui4j.compat.bubbletea.input.MouseAction;
import com.williamcallahan.tui4j.compat.bubbletea.input.MouseButton;
import com.williamcallahan.tui4j.compat.bubbletea.input.MouseMessage;

/**
 * Tracks mouse selection state.
 * tui4j extension; no Bubble Tea equivalent.
 * tui4j: src/main/java/com/williamcallahan/tui4j/input/MouseSelectionTracker.java
 */
public final class MouseSelectionTracker {
    private boolean selecting;
    private int lastColumn;
    private int lastRow;

    /**
     * Creates a new mouse selection tracker.
     */
    public MouseSelectionTracker() {
    }

    /**
     * Update selection state from the latest mouse event.
     *
     * @param message mouse message
     * @return selection update
     */
    public MouseSelectionUpdate update(MouseMessage message) {
        boolean wasSelecting = selecting;

        if (message.getAction() == MouseAction.MouseActionPress
                && message.getButton() == MouseButton.MouseButtonLeft) {
            selecting = true;
        } else if (message.getAction() == MouseAction.MouseActionRelease) {
            selecting = false;
        } else if (selecting
                && message.getAction() == MouseAction.MouseActionMotion
                && message.getButton() == MouseButton.MouseButtonNone) {
            selecting = false;
        }

        lastColumn = message.column();
        lastRow = message.row();

        MouseMessage selectionScrollUpdate = null;
        if (message.isWheel() && selecting) {
            selectionScrollUpdate = new MouseMessage(
                    lastColumn,
                    lastRow,
                    message.isShift(),
                    message.isAlt(),
                    message.isCtrl(),
                    MouseAction.MouseActionMotion,
                    MouseButton.MouseButtonLeft
            );
        }

        return new MouseSelectionUpdate(
                !wasSelecting && selecting,
                wasSelecting && !selecting,
                selecting,
                selectionScrollUpdate
        );
    }

    /**
     * Handle mouse message and update selection state.
     *
     * @param message mouse message
     * @return selection update
     */
    public MouseSelectionUpdate onMouseMessage(MouseMessage message) {
        return update(message);
    }

    /**
     * Returns true if currently selecting.
     *
     * @return true if selecting
     */
    public boolean isSelecting() {
        return selecting;
    }

    /**
     * Returns the last mouse column position.
     *
     * @return last column
     */
    public int lastColumn() {
        return lastColumn;
    }

    /**
     * Returns the last mouse row position.
     *
     * @return last row
     */
    public int lastRow() {
        return lastRow;
    }
}
