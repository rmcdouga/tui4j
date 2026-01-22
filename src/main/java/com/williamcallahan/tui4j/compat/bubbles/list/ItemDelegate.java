package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles item delegate contract.
 * Bubbles: list/list.go.
 * <p>
 * Bubbles: filepicker/hidden_windows.go.
 */
public interface ItemDelegate {

    /**
     * Hook for item-level updates.
     * <p>
     * Bubbles: list/list.go.
     */
    interface UpdateFunction {
        /**
         * Updates an item with the given message.
         *
         * @param msg message to handle
         * @param listModel list model
         * @return command to run
         */
        Command update(Message msg, List listModel);
    }

    /**
     * Supplies short help bindings.
     * <p>
     * Bubbles: list/list.go.
     */
    interface ShortHelpFunc {
        /**
         * Returns short help bindings.
         *
         * @return bindings
         */
        Binding[] get();
    }

    /**
     * Supplies full help bindings.
     * <p>
     * Bubbles: list/list.go.
     */
    interface FullHelpFunc {
        /**
         * Returns full help bindings.
         *
         * @return bindings
         */
        Binding[][] get();
    }

    /**
     * Renders a list item into the provided output builder.
     *
     * @param output output builder
     * @param list list model
     * @param index item index
     * @param filteredItem filtered item data
     */
    void render(StringBuilder output, List list, int index, FilteredItem filteredItem);

    /**
     * Returns the item height in rows.
     *
     * @return row height
     */
    int height();

    /**
     * Returns the spacing between items in rows.
     *
     * @return row spacing
     */
    int spacing();

    /**
     * Updates the delegate with a message.
     *
     * @param msg message to handle
     * @param listModel list model
     * @return command to run
     */
    Command update(Message msg, List listModel);
}
