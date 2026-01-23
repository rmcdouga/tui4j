package com.williamcallahan.tui4j.compat.harmonica;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/harmonica/projectile_test.go.
 */
class ProjectileTest {

    private static final int FPS = 60;
    private static final double EQUALITY_THRESHOLD = 1e-2;

    @Test
    void testNew() {
        int x = 8;
        int y = 20;
        int z = 0;

        Projectile projectile = Projectile.newProjectile(
                fpsToDelta(FPS),
                new Point(x, y, z),
                new Vector(1, 1, 0),
                new Vector(0, 9.81, 0)
        );

        Point pos = projectile.update();

        assertThat((int) pos.x()).isEqualTo(x);
        assertThat((int) pos.y()).isEqualTo(y);
    }

    @Test
    void testUpdate() {
        Projectile projectile = Projectile.newProjectile(
                fpsToDelta(FPS),
                new Point(0, 0, 0),
                new Vector(5, 5, 0),
                new Vector(0, 0, 0)
        );

        Point[] coordinates = new Point[]{
                new Point(5.0, 5.0, 0),
                new Point(10.0, 10.0, 0),
                new Point(15.0, 15.0, 0),
                new Point(20.0, 20.0, 0),
                new Point(25.0, 25.0, 0),
                new Point(30.0, 30.0, 0),
                new Point(35.0, 35.0, 0)
        };

        for (Point expected : coordinates) {
            Point pos = projectile.position(); // Get initial position
            for (int i = 0; i < FPS; i++) {
                pos = projectile.update();
            }

            Vector velocity = projectile.velocity();
            assertThat(equal(velocity.x(), 5)).isTrue();
            assertThat(equal(velocity.y(), 5)).isTrue();
            assertThat(equal(velocity.z(), 0)).isTrue();

            assertThat(equal(pos.x(), expected.x())).isTrue();
            assertThat(equal(pos.y(), expected.y())).isTrue();
        }
    }

    @Test
    void testUpdateGravity() {
        Projectile projectile = Projectile.newProjectile(
                fpsToDelta(FPS),
                new Point(0, 0, 0),
                new Vector(5, 5, 0),
                Projectile.TERMINAL_GRAVITY
        );

        Point[] coordinates = new Point[]{
                new Point(5.0, 9.82, 0),
                new Point(10.0, 29.46, 0),
                new Point(15.0, 58.90, 0),
                new Point(20.0, 98.15, 0),
                new Point(25.0, 147.22, 0),
                new Point(30.0, 206.09, 0),
                new Point(35.0, 274.77, 0)
        };

        for (Point expected : coordinates) {
            Point pos = projectile.position(); // Get initial position
            for (int i = 0; i < FPS; i++) {
                pos = projectile.update();
            }

            double yacc = projectile.acceleration().y();
            assertThat(equal(yacc, Projectile.TERMINAL_GRAVITY.y())).isTrue();

            assertThat(equal(pos.x(), expected.x())).isTrue();
            assertThat(equal(pos.y(), expected.y())).isTrue();
        }
    }

    private static double fpsToDelta(int fps) {
        return 1.0 / fps;
    }

    private static boolean equal(double a, double b) {
        return Math.abs(a - b) <= EQUALITY_THRESHOLD;
    }
}
