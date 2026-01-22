package com.williamcallahan.tui4j.compat.bubbletea.render;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

/**
 * Compatibility helper for NilRenderer to keep API parity.
 * <p>
 * Bubble Tea: nil_renderer.go.
 */
public class NilRenderer implements Renderer {

    /**
     * Creates a renderer that performs no output.
     */
    public NilRenderer() {
    }

    /**
     * Handles start for this component.
     */
    @Override
    public void start() {
    }

    /**
     * Handles stop for this component.
     */
    @Override
    public void stop() {
    }

    /**
     * Handles write for this component.
     *
     * @param view view
     */
    @Override
    public void write(String view) {
    }

    /**
     * Handles repaint for this component.
     */
    @Override
    public void repaint() {
    }

    /**
     * Handles clear screen for this component.
     */
    @Override
    public void clearScreen() {
    }

    /**
     * Handles alt screen for this component.
     *
     * @return whether t screen
     */
    @Override
    public boolean altScreen() {
        return false;
    }

    /**
     * Handles enter alt screen for this component.
     */
    @Override
    public void enterAltScreen() {
    }

    /**
     * Handles exit alt screen for this component.
     */
    @Override
    public void exitAltScreen() {
    }

    /**
     * Handles show cursor for this component.
     */
    @Override
    public void showCursor() {
    }

    /**
     * Handles hide cursor for this component.
     */
    @Override
    public void hideCursor() {
    }

    /**
     * Handles enable mouse all motion for this component.
     */
    @Override
    public void enableMouseAllMotion() {
    }

    /**
     * Handles disable mouse all motion for this component.
     */
    @Override
    public void disableMouseAllMotion() {
    }

    /**
     * Handles enable mouse sgrmode for this component.
     */
    @Override
    public void enableMouseSGRMode() {
    }

    /**
     * Handles disable mouse sgrmode for this component.
     */
    @Override
    public void disableMouseSGRMode() {
    }

    /**
     * Handles report focus for this component.
     *
     * @return whether port focus
     */
    @Override
    public boolean reportFocus() {
        return false;
    }

    /**
     * Handles enable report focus for this component.
     */
    @Override
    public void enableReportFocus() {
    }

    /**
     * Handles disable report focus for this component.
     */
    @Override
    public void disableReportFocus() {
    }

    /**
     * Handles notify model changed for this component.
     */
    @Override
    public void notifyModelChanged() {
    }

    /**
     * Handles handle message for this component.
     *
     * @param msg msg
     */
    @Override
    public void handleMessage(Message msg) {
    }

    /**
     * Handles enable bracketed paste for this component.
     */
    @Override
    public void enableBracketedPaste() {
    }

    /**
     * Handles disable bracketed paste for this component.
     */
    @Override
    public void disableBracketedPaste() {
    }

    /**
     * Handles bracketed paste for this component.
     *
     * @return whether acketed paste
     */
    @Override
    public boolean bracketedPaste() {
        return false;
    }
}
