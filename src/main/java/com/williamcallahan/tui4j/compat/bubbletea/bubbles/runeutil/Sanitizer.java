package com.williamcallahan.tui4j.compat.bubbletea.bubbles.runeutil;

import com.ibm.icu.lang.UCharacter;
import java.util.function.Consumer;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Sanitizer extends com.williamcallahan.tui4j.compat.bubbles.runeutil.Sanitizer {

    @Deprecated(since = "0.3.0")
    public Sanitizer(Consumer<Sanitizer>... options) {
        super(options);
    }

}
