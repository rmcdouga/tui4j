package com.williamcallahan.tui4j.compat.bubbletea.bubbles.key;

/**
 * Port of Bubbles help.
 * Bubble Tea: bubbletea/examples/help/main.go
 */
@Deprecated(since = "0.3.0")
public record Help(String key, String desc) {

    public Help() {
        this("", "");
    }
}
