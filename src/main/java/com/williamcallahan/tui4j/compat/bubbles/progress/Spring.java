package com.williamcallahan.tui4j.compat.bubbles.progress;

/**
 * Port of the progress spring helper.
 * Upstream: github.com/charmbracelet/bubbles/progress (Spring)
 * <p>
 * Bubbles: progress/progress.go.
 */
public class Spring {

    /**
     * Port of the spring update strategy.
     * Upstream: github.com/charmbracelet/bubbles/progress (springUpdateFn)
     * <p>
     * Bubbles: progress/progress.go.
     */
    public interface SpringUpdate {
        /**
         * Applies an incoming message and returns the next model state.
         *
         * @param position position
         * @param velocity velocity
         * @param target target
         * @return next model state and command
         */
        SpringUpdateResult update(
            double position,
            double velocity,
            double target
        );
    }

    /**
     * Compatibility port of SpringUpdateResult to preserve upstream behavior.
     * <p>
     * Bubbles: progress/progress.go.
     */
    public record SpringUpdateResult(double position, double velocity) {}

    private static final double FPS = 60.0;

    private final double frequency;
    private final double damping;

    /**
     * Creates Spring to keep this component ready for use.
     *
     * @param frequency frequency
     * @param damping damping
     */
    public Spring(double frequency, double damping) {
        this.frequency = frequency;
        this.damping = damping;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param position position
     * @param velocity velocity
     * @param target target
     * @return next model state and command
     */
    public SpringUpdateResult update(
        double position,
        double velocity,
        double target
    ) {
        double dt = 1.0 / FPS;

        double displacement = position - target;
        double springForce = -frequency * frequency * displacement;
        double dampingForce = -2.0 * damping * frequency * velocity;

        double acceleration = springForce + dampingForce;

        velocity += acceleration * dt;
        position += velocity * dt;

        return new SpringUpdateResult(position, velocity);
    }

    /**
     * @deprecated Compatibility: Moved to {@link #Spring(double, double)}.
     * This transitional shim is temporary and will be removed in an upcoming release.
     */
    @Deprecated(since = "0.3.0", forRemoval = true)
    public static Spring withFPS(double fps, double frequency, double damping) {
        return new Spring(frequency, damping);
    }
}
