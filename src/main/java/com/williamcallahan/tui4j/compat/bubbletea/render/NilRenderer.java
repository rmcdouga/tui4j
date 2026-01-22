package com.williamcallahan.tui4j.compat.bubbletea.render;

import com.williamcallahan.tui4j.compat.bubbletea.Message;

public class NilRenderer implements Renderer {
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
