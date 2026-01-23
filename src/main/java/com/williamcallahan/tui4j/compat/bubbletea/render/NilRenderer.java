package com.williamcallahan.tui4j.compat.bubbletea.render;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * No-op renderer implementation.
 * Upstream: bubbletea/nil_renderer.go
 */
public class NilRenderer implements Renderer {

    /**
     * Creates a no-op renderer.
     */
    public NilRenderer() {
    }
    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void write(String view) {
    }

    @Override
    public void repaint() {
    }

    @Override
    public void clearScreen() {
    }

    @Override
    public boolean altScreen() {
        return false;
    }

    @Override
    public void enterAltScreen() {
    }

    @Override
    public void exitAltScreen() {
    }

    @Override
    public void showCursor() {
    }

    @Override
    public void hideCursor() {
    }

    @Override
    public void enableMouseAllMotion() {
    }

    @Override
    public void disableMouseAllMotion() {
    }

    @Override
    public void enableMouseSGRMode() {
    }

    @Override
    public void disableMouseSGRMode() {
    }

    @Override
    public boolean reportFocus() {
        return false;
    }

    @Override
    public void enableReportFocus() {
    }

    @Override
    public void disableReportFocus() {
    }

    @Override
    public void notifyModelChanged() {
    }

    @Override
    public void handleMessage(Message msg) {
    }

    @Override
    public void enableBracketedPaste() {
    }

    @Override
    public void disableBracketedPaste() {
    }

    @Override
    public boolean bracketedPaste() {
        return false;
    }
}
