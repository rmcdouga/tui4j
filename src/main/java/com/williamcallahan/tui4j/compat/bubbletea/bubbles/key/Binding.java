package com.williamcallahan.tui4j.compat.bubbletea.bubbles.key;

/**
 * Bubble Tea-compatible alias for {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding}.
 * <p>
 * Bubbles: key/key.go.
 */
public class Binding
    extends com.williamcallahan.tui4j.compat.bubbles.key.Binding
{

    /**
     * Compatibility alias for {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption}.
     */
    public interface BindingOption
        extends
            com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption {}

    /**
     * Creates a binding with the provided options.
     *
     * @param opts binding options
     */
    public Binding(
        com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption... opts
    ) {
        super(opts);
    }

    /**
     * Returns whether the given key press matches this binding.
     *
     * @param keyPressMessage key press message
     * @return true when a key matches
     * @deprecated Deprecated in tui4j as of 0.3.0 because you should use {@link #matches(com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage)} instead.
     */
    @Deprecated(since = "0.3.0")
    @SuppressWarnings("removal")
    public boolean matches(com.williamcallahan.tui4j.compat.bubbletea.KeyMsg keyPressMessage) {
        return matches((com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage) keyPressMessage);
    }
}
