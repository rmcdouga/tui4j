package com.williamcallahan.tui4j.compat.harmonica;

/**
 * Projectile motion simulator.
 * <p>
 * Port of github.com/charmbracelet/harmonica/projectile.go (Projectile).
 */
public final class Projectile {

    /**
     * Standard gravity vector used by the simulation.
     */
    public static final Vector GRAVITY = new Vector(0, -9.81, 0);

    /**
     * Terminal gravity vector used by the simulation.
     */
    public static final Vector TERMINAL_GRAVITY = new Vector(0, 9.81, 0);

    private Point position;
    private Vector velocity;
    private Vector acceleration;
    private final double deltaTime;

    /**
     * Creates Projectile to keep this component ready for use.
     *
     * @param deltaTime delta time
     * @param initialPosition initial position
     * @param initialVelocity initial velocity
     * @param initialAcceleration initial acceleration
     */
    public Projectile(double deltaTime, Point initialPosition, Vector initialVelocity, Vector initialAcceleration) {
        this.deltaTime = deltaTime;
        this.position = initialPosition;
        this.velocity = initialVelocity;
        this.acceleration = initialAcceleration;
    }

    /**
     * Handles new projectile for this component.
     *
     * @param deltaTime delta time
     * @param initialPosition initial position
     * @param initialVelocity initial velocity
     * @param initialAcceleration initial acceleration
     * @return result
     */
    public static Projectile newProjectile(double deltaTime, Point initialPosition, Vector initialVelocity,
                                           Vector initialAcceleration) {
        return new Projectile(deltaTime, initialPosition, initialVelocity, initialAcceleration);
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @return next model state and command
     */
    public Point update() {
        position = new Point(
                position.x() + (velocity.x() * deltaTime),
                position.y() + (velocity.y() * deltaTime),
                position.z() + (velocity.z() * deltaTime)
        );

        velocity = new Vector(
                velocity.x() + (acceleration.x() * deltaTime),
                velocity.y() + (acceleration.y() * deltaTime),
                velocity.z() + (acceleration.z() * deltaTime)
        );

        return position;
    }

    /**
     * Handles position for this component.
     *
     * @return result
     */
    public Point position() {
        return position;
    }

    /**
     * Handles velocity for this component.
     *
     * @return result
     */
    public Vector velocity() {
        return velocity;
    }

    /**
     * Handles acceleration for this component.
     *
     * @return result
     */
    public Vector acceleration() {
        return acceleration;
    }
}
