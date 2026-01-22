package com.williamcallahan.tui4j.compat.harmonica;

/**
 * Physics-based spring animation primitive.
 * <p>
 * Port of {@code harmonica/spring.go}.
 *
 * @see <a href="https://github.com/charmbracelet/harmonica/blob/main/spring.go">harmonica/spring.go</a>
 */
public class Spring {
    private final com.williamcallahan.tui4j.compat.bubbletea.harmonica.Spring delegate;

    /**
     * Creates Spring to keep this component ready for use.
     *
     * @param delegate delegate
     */
    private Spring(com.williamcallahan.tui4j.compat.bubbletea.harmonica.Spring delegate) {
        this.delegate = delegate;
    }

    /**
     * Handles fps for this component.
     *
     * @param n n
     * @return result
     */
    public static double fps(int n) {
        return com.williamcallahan.tui4j.compat.bubbletea.harmonica.Spring.fps(n);
    }

    /**
     * Handles new spring for this component.
     *
     * @param deltaTime delta time
     * @param angularFrequency angular frequency
     * @param dampingRatio damping ratio
     * @return result
     */
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
