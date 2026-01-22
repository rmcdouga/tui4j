package com.williamcallahan.tui4j.compat.bubbletea.bubbles.key;

/**
 * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding}.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: key/key.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Binding
    extends com.williamcallahan.tui4j.compat.bubbles.key.Binding
{

    /**
     * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public interface BindingOption
        extends
            com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption {}

    /**
     * @deprecated Compatibility: Moved to {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding#Binding(com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption...)}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Binding(
        com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption... opts
    ) {
        super(opts);
    }
}
