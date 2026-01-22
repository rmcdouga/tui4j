package com.williamcallahan.tui4j.compat.bubbletea.bubbles.filepicker;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.filepicker.FilePicker} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: filepicker/filepicker.go.
 */
@Deprecated(since = "0.3.0")
public class FilePicker extends com.williamcallahan.tui4j.compat.bubbles.filepicker.FilePicker {
    
    /**
     * Creates FilePicker to keep this component ready for use.
     */
    public FilePicker() {
        super();
        this.setKeyMap(new KeyMap());
        this.setStyles(Styles.defaultStyles());
    }

    /**
     * Handles key map for this component.
     *
     * @return result
     */
    @Override
    public KeyMap keyMap() {
        return (KeyMap) super.keyMap();
    }

    /**
     * Handles styles for this component.
     *
     * @return result
     */
    @Override
    public Styles styles() {
        return (Styles) super.styles();
    }
}
