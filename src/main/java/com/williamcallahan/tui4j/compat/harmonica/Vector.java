package com.williamcallahan.tui4j.compat.harmonica;

/**
 * Velocity vector in 3D space for projectile motion.
 * <p>
 * Port of charmbracelet/harmonica projectile.go Vector type.
 *
 * @param x the x velocity component
 * @param y the y velocity component
 * @param z the z velocity component
 * @see <a href="https://github.com/charmbracelet/harmonica/blob/main/projectile.go">harmonica/projectile.go</a>
 */
public record Vector(double x, double y, double z) {
}
