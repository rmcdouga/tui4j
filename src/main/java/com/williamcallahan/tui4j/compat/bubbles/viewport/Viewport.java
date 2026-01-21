package com.williamcallahan.tui4j.compat.bubbles.viewport;

import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.x.ansi.Cut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Scrollable viewport for viewing content larger than the screen.
 * <p>
 * Port of `bubbles/viewport`.
 * Handles vertical scrolling and panning of wrapped or raw text content.
 */
public class Viewport implements Model {

    private int width;
    private int height;
    private KeyMap keyMap;
    private boolean mouseWheelEnabled;
    private int mouseWheelDelta;
    private int yOffset;
    private int xOffset;
    private int horizontalStep;
    private int yPosition;
    private Style style;
    /**
     * @deprecated High performance rendering is deprecated in upstream Bubble Tea.
     *             This field is retained for API compatibility but has no effect.
     * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/viewport/viewport.go">bubbles/viewport/viewport.go</a>
     */
    @Deprecated(since = "0.3.0")
    private boolean highPerformanceRendering;
    private boolean initialized;
    private List<String> lines;
    private int longestLineWidth;

    public Viewport() {
        this.width = 0;
        this.height = 0;
        this.keyMap = new KeyMap();
        this.mouseWheelEnabled = true;
        this.mouseWheelDelta = 3;
        this.yOffset = 0;
        this.xOffset = 0;
        this.horizontalStep = 0;
        this.yPosition = 0;
        this.style = Style.newStyle();
        this.highPerformanceRendering = false;
        this.initialized = false;
        this.lines = new ArrayList<>();
        this.longestLineWidth = 0;
    }

    public static Viewport create(int width, int height) {
        Viewport viewport = new Viewport();
        viewport.setWidth(width);
        viewport.setHeight(height);
        return viewport;
    }

    private void setInitialValues() {
        this.keyMap = new KeyMap();
        this.mouseWheelEnabled = true;
        this.mouseWheelDelta = 3;
        this.initialized = true;
    }

    @Override
    public Command init() {
        return null;
    }

    public boolean atTop() {
        return yOffset <= 0;
    }

    public boolean atBottom() {
        return yOffset >= maxYOffset();
    }

    public boolean pastBottom() {
        return yOffset > maxYOffset();
    }

    public double scrollPercent() {
        if (lines.isEmpty() || height >= lines.size()) {
            return 1.0;
        }
        double y = (double) yOffset;
        double h = (double) height;
        double t = (double) lines.size();
        double v = y / (t - h);
        return max(0.0, min(1.0, v));
    }

    public double horizontalScrollPercent() {
        int effectiveWidth = max(0, width - style.getHorizontalFrameSize());
        if (lines.isEmpty() || effectiveWidth >= longestLineWidth) {
            return 1.0;
        }
        double x = (double) xOffset;
        double w = (double) effectiveWidth;
        double t = (double) longestLineWidth;
        double v = x / (t - w);
        return max(0.0, min(1.0, v));
    }

    /**
     * Replaces the viewport content and recalculates dimensions.
     * Resets position if content shrinks above current scroll.
     */
    public void setContent(String content) {
        if (content == null || content.isEmpty()) {
            this.lines = new ArrayList<>();
        } else {
            String normalized = content.replace("\r\n", "\n");
            this.lines = new ArrayList<>(Arrays.asList(normalized.split("\n")));
        }
        this.longestLineWidth = findLongestLineWidth(this.lines);
        setXOffset(this.xOffset);

        if (yOffset > lines.size() - 1) {
            gotoBottom();
        }
    }

    private int maxYOffset() {
        return max(0, lines.size() - height + style.getVerticalFrameSize());
    }

    private List<String> visibleLines() {
        int h = height - style.getVerticalFrameSize();
        int w = width - style.getHorizontalFrameSize();

        if (!lines.isEmpty()) {
            int top = max(0, yOffset);
            int bottom = clamp(yOffset + h, top, lines.size());
            List<String> result = lines.subList(top, bottom);
            if (xOffset == 0 || w <= 0) {
                return new ArrayList<>(result);
            }

            // Cut.cut() provides ANSI-aware horizontal scrolling, preserving all escape
            // sequences while extracting the visible portion [xOffset, xOffset+w).
            // Equivalent to the previous inline cutLine() implementation.
            List<String> cutLines = new ArrayList<>();
            for (String line : result) {
                cutLines.add(Cut.cut(line, xOffset, xOffset + w));
            }
            return cutLines;
        }

        return new ArrayList<>();
    }

    public void pageDown() {
        if (!atBottom()) {
            scrollDown(height);
        }
    }

    public void pageUp() {
        if (!atTop()) {
            scrollUp(height);
        }
    }

    public void halfPageDown() {
        if (!atBottom()) {
            scrollDown(height / 2);
        }
    }

    public void halfPageUp() {
        if (!atTop()) {
            scrollUp(height / 2);
        }
    }

    public void scrollDown(int n) {
        if (atBottom() || n == 0 || lines.isEmpty()) {
            return;
        }
        setYOffsetInternal(yOffset + n);
    }

    public void scrollUp(int n) {
        if (atTop() || n == 0 || lines.isEmpty()) {
            return;
        }
        setYOffsetInternal(yOffset - n);
    }

    public void setHorizontalStep(int n) {
        this.horizontalStep = max(n, 0);
    }

    public void setXOffset(int n) {
        int effectiveWidth = max(0, width - style.getHorizontalFrameSize());
        this.xOffset = clamp(n, 0, max(0, longestLineWidth - effectiveWidth));
    }

    public void scrollLeft(int n) {
        setXOffset(xOffset - n);
    }

    public void scrollRight(int n) {
        setXOffset(xOffset + n);
    }

    public int totalLineCount() {
        return lines.size();
    }

    public int visibleLineCount() {
        return visibleLines().size();
    }

    public void gotoTop() {
        if (!atTop()) {
            setYOffsetInternal(0);
        }
    }

    public void gotoBottom() {
        setYOffsetInternal(maxYOffset());
    }

    @Override
    public UpdateResult<Viewport> update(Message msg) {
        if (!initialized) {
            setInitialValues();
        }

        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (Binding.matches(keyPressMessage, keyMap.pageDown())) {
                pageDown();
            } else if (Binding.matches(keyPressMessage, keyMap.pageUp())) {
                pageUp();
            } else if (Binding.matches(keyPressMessage, keyMap.halfPageDown())) {
                halfPageDown();
            } else if (Binding.matches(keyPressMessage, keyMap.halfPageUp())) {
                halfPageUp();
            } else if (Binding.matches(keyPressMessage, keyMap.down())) {
                scrollDown(1);
            } else if (Binding.matches(keyPressMessage, keyMap.up())) {
                scrollUp(1);
            } else if (Binding.matches(keyPressMessage, keyMap.left())) {
                scrollLeft(horizontalStep);
            } else if (Binding.matches(keyPressMessage, keyMap.right())) {
                scrollRight(horizontalStep);
            }
        }

        return UpdateResult.from(this);
    }

    @Override
    public String view() {
        if (highPerformanceRendering) {
            return "\n".repeat(max(0, height - 1));
        }

        int effectiveWidth = max(1, width - style.getHorizontalFrameSize());
        int effectiveHeight = max(1, height - style.getVerticalFrameSize());

        StringBuilder content = new StringBuilder();
        List<String> visible = visibleLines();
        for (String line : visible) {
            content.append(line != null ? line : "").append("\n");
        }

        int linesNeeded = effectiveHeight - visible.size();
        for (int i = 0; i < linesNeeded; i++) {
            content.append("\n");
        }

        String rendered = style
                .width(effectiveWidth)
                .height(effectiveHeight)
                .render(content.toString());
        return rendered;
    }

    private int findLongestLineWidth(List<String> lines) {
        int w = 0;
        for (String line : lines) {
            int lineWidth = TextWidth.measureCellWidth(line != null ? line : "");
            if (lineWidth > w) {
                w = lineWidth;
            }
        }
        return w;
    }

    private int clamp(int v, int low, int high) {
        if (high < low) {
            int temp = low;
            low = high;
            high = temp;
        }
        return max(low, min(high, v));
    }

    private void setYOffsetInternal(int n) {
        this.yOffset = clamp(n, 0, maxYOffset());
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyMap getKeyMap() {
        return keyMap;
    }

    public boolean isMouseWheelEnabled() {
        return mouseWheelEnabled;
    }

    public void setMouseWheelEnabled(boolean mouseWheelEnabled) {
        this.mouseWheelEnabled = mouseWheelEnabled;
    }

    public int getMouseWheelDelta() {
        return mouseWheelDelta;
    }

    public void setMouseWheelDelta(int mouseWheelDelta) {
        this.mouseWheelDelta = mouseWheelDelta;
    }

    public int getYOffset() {
        return yOffset;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * @deprecated High performance rendering is deprecated in upstream Bubble Tea.
     *             This method is retained for API compatibility but has no effect.
     * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/viewport/viewport.go">bubbles/viewport/viewport.go</a>
     */
    @Deprecated(since = "0.3.0")
    public boolean isHighPerformanceRendering() {
        return highPerformanceRendering;
    }

    /**
     * @deprecated High performance rendering is deprecated in upstream Bubble Tea.
     *             This method is retained for API compatibility but has no effect.
     * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/viewport/viewport.go">bubbles/viewport/viewport.go</a>
     */
    @Deprecated(since = "0.3.0")
    public void setHighPerformanceRendering(boolean highPerformanceRendering) {
        this.highPerformanceRendering = highPerformanceRendering;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getXOffset() {
        return xOffset;
    }

    public int getMaxYOffset() {
        return maxYOffset();
    }
}
