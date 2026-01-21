package com.williamcallahan.tui4j.compat.bubbletea.bubbles.key;

/**
 * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding} instead.
 *             This class has been moved as part of the Bubbles package restructuring.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Binding extends com.williamcallahan.tui4j.compat.bubbles.key.Binding {

    /**
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public interface BindingOption extends com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption {
    }

    /**
     * Creates a binding configured by the provided options.
     *
     * @param opts binding options
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.key.Binding#Binding(BindingOption...)} instead.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public Binding(com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption... opts) {
        super(opts);
    }
}
