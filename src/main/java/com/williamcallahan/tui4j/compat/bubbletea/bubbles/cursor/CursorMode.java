package com.williamcallahan.tui4j.compat.bubbletea.bubbles.cursor;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: cursor/cursor.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public enum CursorMode {
    /** Blinking cursor. */
    Blink,
    /** Static cursor. */
    Static,
    /** Hidden cursor. */
    Hide;

    /**
     * Handles to new for this component.
     *
     * @return result
     */
    public com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode toNew() {
        return switch (this) {
            case Blink -> com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode.Blink;
            case Static -> com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode.Static;
            case Hide -> com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode.Hide;
        };
    }

    /**
     * Handles from new for this component.
     *
     * @param mode mode
     * @return result
     */
    public static CursorMode fromNew(com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode mode) {
        if (mode == null) return null;
        return switch (mode) {
            case Blink -> Blink;
            case Static -> Static;
            case Hide -> Hide;
        };
    }
}
