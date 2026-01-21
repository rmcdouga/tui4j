package com.williamcallahan.tui4j.compat.harmonica;

/**
 * Physics-based spring animation primitive.
 * <p>
 * Port of {@code charmbracelet/harmonica}.
 */
public class Spring {
    private final com.williamcallahan.tui4j.compat.bubbletea.harmonica.Spring delegate;

    private Spring(com.williamcallahan.tui4j.compat.bubbletea.harmonica.Spring delegate) {
        this.delegate = delegate;
    }

    public static double fps(int n) {
        return com.williamcallahan.tui4j.compat.bubbletea.harmonica.Spring.fps(n);
    }

    public static Spring newSpring(double deltaTime, double angularFrequency, double dampingRatio) {
        return new Spring(
                com.williamcallahan.tui4j.compat.bubbletea.harmonica.Spring.newSpring(
                        deltaTime,
                        angularFrequency,
                        dampingRatio
                )
        );
    }

    /**
     * Advances the spring simulation by one step.
     * Calculates the new position and velocity based on the pre-computed coefficients.
     */
    public double[] update(double pos, double vel, double equilibriumPos) {
        return delegate.update(pos, vel, equilibriumPos);
    }
}
