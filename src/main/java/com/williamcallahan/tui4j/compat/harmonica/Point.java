package com.williamcallahan.tui4j.compat.harmonica;

/**
 * Point in 3D space for projectile motion.
 * <p>
 * Port of charmbracelet/harmonica projectile.go Point type.
 *
 * @param x the x coordinate
 * @param y the y coordinate
 * @param z the z coordinate
 * @see <a href="https://github.com/charmbracelet/harmonica/blob/main/projectile.go">harmonica/projectile.go</a>
 */
public record Point(double x, double y, double z) {
}
