package com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.key.Binding;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.paginator.Paginator} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Paginator extends com.williamcallahan.tui4j.compat.bubbles.paginator.Paginator {

    @Deprecated(since = "0.3.0")
    public Paginator(Option... options) {
        super(options);
    }

}
