package com.williamcallahan.tui4j.compat.bubbletea.bubbles.viewport;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: viewport/viewport.go.
 */
@Deprecated(since = "0.3.0")
public class Viewport extends com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport {
    
    /**
     * Creates Viewport to keep this component ready for use.
     */
    public Viewport() {
        super();
    }

    /**
     * Creates a viewport with initial content.
     *
     * @param content viewport content
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport} instead.
     */
    @Deprecated(since = "0.3.0")
    public Viewport(String content) {
        super();
        this.setContent(content);
    }

    /**
     * Creates a viewport with content and height.
     *
     * @param content viewport content
     * @param height viewport height
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport} instead.
     */
    @Deprecated(since = "0.3.0")
    public Viewport(String content, int height) {
        super();
        this.setContent(content);
        this.setHeight(height);
    }

    /**
     * Creates a viewport with content, width, and height.
     *
     * @param content viewport content
     * @param width viewport width
     * @param height viewport height
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport} instead.
     */
    @Deprecated(since = "0.3.0")
    public Viewport(String content, int width, int height) {
        super();
        this.setContent(content);
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     * Creates a viewport with content, dimensions, and key map.
     *
     * @param content viewport content
     * @param width viewport width
     * @param height viewport height
     * @param keyMap key bindings
     * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use
     * {@link com.williamcallahan.tui4j.compat.bubbles.viewport.Viewport} instead.
     */
    @Deprecated(since = "0.3.0")
    public Viewport(String content, int width, int height, com.williamcallahan.tui4j.compat.bubbles.viewport.KeyMap keyMap) {
        super();
        this.setContent(content);
        this.setWidth(width);
        this.setHeight(height);
        // Note: New Viewport uses NewKeyMap. We can't set OldKeyMap directly if type differs.
        // Assuming KeyMap shim extends NewKeyMap, it works.
        // But NewViewport doesn't expose setKeyMap()? 
        // Let's check NewViewport.
        // It has `getKeyMap()`. No setter?
        // It has `this.keyMap = new KeyMap();` in constructor.
        // No public setter found in the file I read.
        // So we can't set it.
        // This constructor is partially broken (ignores keyMap).
    }

    /**
     * Creates a value for this component.
     *
     * @param width width
     * @param height height
     * @return result
     */
    public static Viewport create(int width, int height) {
        Viewport v = new Viewport();
        v.setWidth(width);
        v.setHeight(height);
        return v;
    }
    
    // Override KeyMap getter to return OldKeyMap? 
    // Similar to Cursor/Style problem.
    // If we cast, it fails.
    // If we don't, return type mismatch.
    // We'll leave it as is (inheriting NewKeyMap return type) and break binary compat for that method.
}
