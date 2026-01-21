package com.williamcallahan.tui4j.compat.harmonica;

/**
 * Projectile motion simulator.
 * <p>
 * Port of github.com/charmbracelet/harmonica/projectile.go (Projectile).
 */
public final class Projectile {

    public static final Vector GRAVITY = new Vector(0, -9.81, 0);
    public static final Vector TERMINAL_GRAVITY = new Vector(0, 9.81, 0);

    private Point position;
    private Vector velocity;
    private Vector acceleration;
    private final double deltaTime;

    public Projectile(double deltaTime, Point initialPosition, Vector initialVelocity, Vector initialAcceleration) {
        this.deltaTime = deltaTime;
        this.position = initialPosition;
        this.velocity = initialVelocity;
        this.acceleration = initialAcceleration;
    }

    public static Projectile newProjectile(double deltaTime, Point initialPosition, Vector initialVelocity,
                                           Vector initialAcceleration) {
        return new Projectile(deltaTime, initialPosition, initialVelocity, initialAcceleration);
    }

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

    public Point position() {
        return position;
    }

    public Vector velocity() {
        return velocity;
    }

    public Vector acceleration() {
        return acceleration;
    }
}
