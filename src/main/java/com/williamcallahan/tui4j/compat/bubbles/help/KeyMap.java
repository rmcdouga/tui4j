package com.williamcallahan.tui4j.compat.bubbles.help;

import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of Bubbles help key map contract.
 * Bubbles: bubbles/help/help.go
 */
public interface KeyMap {

    /**
     * Returns bindings to show in the short help view.
     *
     * @return short help bindings
     */
    Binding[] shortHelp();

    /**
     * Returns bindings to show in the full help view.
     *
     * @return full help bindings
     */
    Binding[][] fullHelp();
}
