package com.williamcallahan.tui4j.compat.bubbletea.bubbles.filepicker;

/**
 * Compatibility shim for {@link com.williamcallahan.tui4j.compat.bubbles.filepicker.FilePicker}.
 * Canonical source: {@code src/main/java/com/williamcallahan/tui4j/compat/bubbles/filepicker/FilePicker.java}.
 * <p>
 * Bubbles: filepicker/filepicker.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.filepicker.FilePicker}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class FilePicker extends com.williamcallahan.tui4j.compat.bubbles.filepicker.FilePicker {

    /**
     * Creates a file picker shim.
     */
    public FilePicker() {
        super();
        this.setKeyMap(new KeyMap());
        this.setStyles(Styles.defaultStyles());
    }

    @Override
    public KeyMap keyMap() {
        return (KeyMap) super.keyMap();
    }

    @Override
    public Styles styles() {
        return (Styles) super.styles();
    }

}
