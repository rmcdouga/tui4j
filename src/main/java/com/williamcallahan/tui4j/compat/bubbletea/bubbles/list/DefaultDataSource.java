package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.fuzzy.FuzzyFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.DefaultDataSource} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class DefaultDataSource extends com.williamcallahan.tui4j.compat.bubbles.list.DefaultDataSource {

    @Deprecated(since = "0.3.0")
    public DefaultDataSource(List list, Item... items) {
        super(list, items);
    }

}
