package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.list.DefaultDelegate}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/list/DefaultDelegate.java}.
 * <p>
 * Bubbles: list/defaultitem.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.DefaultDelegate}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
@SuppressWarnings("removal")
public class DefaultDelegate extends com.williamcallahan.tui4j.compat.bubbles.list.DefaultDelegate
        implements ItemDelegate {

    /**
     * Creates a default delegate shim.
     */
    public DefaultDelegate() {
        super();
    }

    /**
     * Renders a list item row.
     *
     * @param output output buffer
     * @param list list model
     * @param index item index
     * @param filteredItem filtered item
     */
    @Override
    public void render(StringBuilder output, List list, int index, FilteredItem filteredItem) {
        super.render(output, list, index, filteredItem);
    }

    /**
     * Updates a list item.
     *
     * @param msg message
     * @param listModel list model
     * @return command
     */
    @Override
    public Command update(Message msg, List listModel) {
        return super.update(msg, listModel);
    }
}
