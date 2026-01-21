package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

/**
 * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate} instead.
 *             This interface has been moved as part of the Bubbles package restructuring.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public interface ItemDelegate extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate {

    /**
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.UpdateFunction} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    interface UpdateFunction extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.UpdateFunction {
    }

    /**
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.ShortHelpFunc} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    interface ShortHelpFunc extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.ShortHelpFunc {
    }

    /**
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.FullHelpFunc} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    interface FullHelpFunc extends com.williamcallahan.tui4j.compat.bubbles.list.ItemDelegate.FullHelpFunc {
    }
}
