package com.williamcallahan.tui4j.compat.bubbletea.render;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbletea/nil_renderer_test.go.
 */
class NilRendererTest {

    @Test
    void testNilRendererNoops() {
        NilRenderer renderer = new NilRenderer();

        renderer.start();
        renderer.stop();
        renderer.write("a");
        renderer.repaint();
        renderer.enterAltScreen();
        renderer.exitAltScreen();
        renderer.clearScreen();
        renderer.showCursor();
        renderer.hideCursor();
        renderer.enableMouseCellMotion();
        renderer.disableMouseCellMotion();
        renderer.enableMouseAllMotion();
        renderer.disableMouseAllMotion();
        renderer.enableMouseNormalTracking();
        renderer.disableMouseNormalTracking();
        renderer.enableMouseSGRMode();
        renderer.disableMouseSGRMode();
        renderer.enableBracketedPaste();
        renderer.disableBracketedPaste();

        assertThat(renderer.altScreen()).isFalse();
        assertThat(renderer.bracketedPaste()).isFalse();
        assertThat(renderer.reportFocus()).isFalse();
    }
}
