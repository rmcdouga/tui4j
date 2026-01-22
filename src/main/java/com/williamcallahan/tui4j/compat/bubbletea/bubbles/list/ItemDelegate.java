package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.key.Binding;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/ItemDelegate.java}.
 *
 * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: list/list.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public interface ItemDelegate extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate {

    /**
     * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.UpdateFunction}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    interface UpdateFunction extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.UpdateFunction {

        /**
         * Updates a list item for the legacy list type.
         *
         * @param msg message
         * @param listModel list model
         * @return command
         */
        Command update(Message msg, List listModel);

        /**
         * Updates a list item for the canonical list type.
         *
         * @param msg message
         * @param listModel list model
         * @return command
         */
        @Override
        default Command update(Message msg, com.williamcallahan.tui4j.compat.bubbles.list.List listModel) {
            return update(msg, (List) listModel);
        }
    }

    /**
     * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.ShortHelpFunc}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    interface ShortHelpFunc extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.ShortHelpFunc {

        /**
         * Returns the short help bindings.
         *
         * @return bindings
         */
        Binding[] get();
    }

    /**
     * @deprecated Moved to {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.FullHelpFunc}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    interface FullHelpFunc extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.FullHelpFunc {

        /**
         * Returns the full help bindings.
         *
         * @return bindings
         */
        Binding[][] get();
    }

    /**
     * Renders a row for the canonical list type.
     *
     * @param output output buffer
     * @param list list model
     * @param index item index
     * @param filteredItem filtered item
     */
    @Override
    default void render(StringBuilder output,
            com.williamcallahan.tui4j.compat.bubbles.list.List list,
            int index,
            com.williamcallahan.tui4j.compat.bubbles.list.FilteredItem filteredItem) {
        render(output, (List) list, index, (FilteredItem) filteredItem);
    }

    /**
     * Renders a row for the legacy list type.
     *
     * @param output output buffer
     * @param list list model
     * @param index item index
     * @param filteredItem filtered item
     */
    void render(StringBuilder output, List list, int index, FilteredItem filteredItem);

    /**
     * Returns the row height.
     *
     * @return row height
     */
    int height();

    /**
     * Returns the spacing between rows.
     *
     * @return row spacing
     */
    int spacing();

    /**
     * Updates a list item for the canonical list type.
     *
     * @param msg message
     * @param listModel list model
     * @return command
     */
    @Override
    default Command update(Message msg, com.williamcallahan.tui4j.compat.bubbles.list.List listModel) {
        return update(msg, (List) listModel);
    }

    /**
     * Updates a list item for the legacy list type.
     *
     * @param msg message
     * @param listModel list model
     * @return command
     */
    Command update(Message msg, List listModel);
}
