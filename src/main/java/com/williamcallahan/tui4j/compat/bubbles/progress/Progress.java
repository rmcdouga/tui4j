package com.williamcallahan.tui4j.compat.bubbles.progress;

import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile;
import com.williamcallahan.tui4j.compat.lipgloss.color.RGB;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Progress bar bubble with gradient support.
 * <p>
 * Port of `bubbles/progress`.
 * Visualizes a percentage value, optionally using a spring animation for smooth transitions.
 * <p>
 * Bubbles: progress/progress.go.
 */
public class Progress implements Model {

    private static final double FPS = 60.0;
    private static final int DEFAULT_WIDTH = 40;
    private static final double DEFAULT_FREQUENCY = 18.0;
    private static final double DEFAULT_DAMPING = 1.0;
    private static final AtomicInteger LAST_ID = new AtomicInteger(0);

    private final int id;
    private int tag;

    private int width;
    private char full;
    private char empty;
    private String fullColor;
    private String emptyColor;
    private boolean showPercentage;
    private String percentFormat;
    private Style percentageStyle;

    private Spring spring;
    private double percentShown;
    private double targetPercent;
    private double velocity;

    private boolean useRamp;
    private RGB rampColorA;
    private RGB rampColorB;
    private boolean scaleRamp;

    private ColorProfile colorProfile;
    private ColorProfile cachedColorProfile;

    /**
     * Creates Progress to keep this component ready for use.
     */
    public Progress() {
        this.id = nextId();
        this.width = DEFAULT_WIDTH;
        this.full = '█';
        this.fullColor = "#7571F9";
        this.empty = '░';
        this.emptyColor = "#606060";
        this.showPercentage = true;
        this.percentFormat = " %3.0f%%";
        this.percentageStyle = Style.newStyle();

        setSpringOptions(DEFAULT_FREQUENCY, DEFAULT_DAMPING);
    }

    /**
     * Handles next id for this component.
     *
     * @return result
     */
    private static int nextId() {
        return LAST_ID.incrementAndGet();
    }

    /**
     * Handles with width for this component.
     *
     * @param width width
     * @return result
     */
    public Progress withWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * Handles with full for this component.
     *
     * @param full full
     * @return result
     */
    public Progress withFull(char full) {
        this.full = full;
        return this;
    }

    /**
     * Handles with empty for this component.
     *
     * @param empty empty
     * @return result
     */
    public Progress withEmpty(char empty) {
        this.empty = empty;
        return this;
    }

    /**
     * Handles with full color for this component.
     *
     * @param fullColor full color
     * @return result
     */
    public Progress withFullColor(String fullColor) {
        this.fullColor = fullColor;
        this.useRamp = false;
        return this;
    }

    /**
     * Handles with empty color for this component.
     *
     * @param emptyColor empty color
     * @return result
     */
    public Progress withEmptyColor(String emptyColor) {
        this.emptyColor = emptyColor;
        return this;
    }

    /**
     * Handles without percentage for this component.
     *
     * @return result
     */
    public Progress withoutPercentage() {
        this.showPercentage = false;
        return this;
    }

    /**
     * Handles with show percentage for this component.
     *
     * @param showPercentage show percentage
     * @return result
     */
    public Progress withShowPercentage(boolean showPercentage) {
        this.showPercentage = showPercentage;
        return this;
    }

    /**
     * Handles with percent format for this component.
     *
     * @param percentFormat percent format
     * @return result
     */
    public Progress withPercentFormat(String percentFormat) {
        this.percentFormat = percentFormat;
        return this;
    }

    /**
     * Handles with percentage style for this component.
     *
     * @param percentageStyle percentage style
     * @return result
     */
    public Progress withPercentageStyle(Style percentageStyle) {
        this.percentageStyle = percentageStyle;
        return this;
    }

    /**
     * Handles with default gradient for this component.
     *
     * @return result
     */
    public Progress withDefaultGradient() {
        return withGradient("#5A56E0", "#EE6FF8");
    }

    /**
     * Configures a color gradient for the filled portion of the bar.
     *
     * @param colorA starting color
     * @param colorB ending color
     * @return updated progress instance
     */
    public Progress withGradient(String colorA, String colorB) {
        return setRamp(colorA, colorB, false);
    }

    /**
     * Handles with default scaled gradient for this component.
     *
     * @return result
     */
    public Progress withDefaultScaledGradient() {
        return withScaledGradient("#5A56E0", "#EE6FF8");
    }

    /**
     * Handles with scaled gradient for this component.
     *
     * @param colorA color a
     * @param colorB color b
     * @return result
     */
    public Progress withScaledGradient(String colorA, String colorB) {
        return setRamp(colorA, colorB, true);
    }

    /**
     * Updates the ramp.
     *
     * @param colorA color a
     * @param colorB color b
     * @param scaled scaled
     * @return result
     */
    private Progress setRamp(String colorA, String colorB, boolean scaled) {
        RGB a = parseColor(colorA);
        RGB b = parseColor(colorB);

        this.useRamp = true;
        this.scaleRamp = scaled;
        this.rampColorA = a;
        this.rampColorB = b;
        return this;
    }

    /**
     * Handles parse color for this component.
     *
     * @param color color
     * @return result
     */
    private static RGB parseColor(String color) {
        return RGB.fromHexString(color);
    }

    /**
     * Updates the spring options.
     *
     * @param frequency frequency
     * @param damping damping
     */
    public void setSpringOptions(double frequency, double damping) {
        this.spring = new Spring(frequency, damping);
    }

    /**
     * Updates the color profile.
     *
     * @param colorProfile color profile
     */
    public void setColorProfile(ColorProfile colorProfile) {
        this.colorProfile = colorProfile;
    }

    /**
     * Returns the color profile.
     *
     * @return result
     */
    private ColorProfile getColorProfile() {
        if (colorProfile != null) {
            return colorProfile;
        }
        if (cachedColorProfile == null) {
            cachedColorProfile = Renderer.defaultRenderer().colorProfile();
        }
        return cachedColorProfile;
    }

    /**
     * Handles id for this component.
     *
     * @return result
     */
    public int id() {
        return id;
    }

    /**
     * Handles width for this component.
     *
     * @return result
     */
    public int width() {
        return width;
    }

    /**
     * Updates the width.
     *
     * @param width width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Handles full for this component.
     *
     * @return result
     */
    public char full() {
        return full;
    }

    /**
     * Handles empty for this component.
     *
     * @return result
     */
    public char empty() {
        return empty;
    }

    /**
     * Handles full color for this component.
     *
     * @return result
     */
    public String fullColor() {
        return fullColor;
    }

    /**
     * Handles empty color for this component.
     *
     * @return result
     */
    public String emptyColor() {
        return emptyColor;
    }

    /**
     * Handles show percentage for this component.
     *
     * @return whether ow percentage
     */
    public boolean showPercentage() {
        return showPercentage;
    }

    /**
     * Handles percent format for this component.
     *
     * @return result
     */
    public String percentFormat() {
        return percentFormat;
    }

    /**
     * Handles percent for this component.
     *
     * @return result
     */
    public double percent() {
        return targetPercent;
    }

    /**
     * Handles target percent for this component.
     *
     * @return result
     */
    public double targetPercent() {
        return targetPercent;
    }

    /**
     * Handles tag for this component.
     *
     * @return result
     */
    public int tag() {
        return tag;
    }

    /**
     * Handles percent shown for this component.
     *
     * @return result
     */
    public double percentShown() {
        return percentShown;
    }

    /**
     * Reports whether animating.
     *
     * @return whether animating
     */
    public boolean isAnimating() {
        double dist = Math.abs(percentShown - targetPercent);
        return !(dist < 0.001 && Math.abs(velocity) < 0.01);
    }

    /**
     * Supplies the initial command for the model.
     *
     * @return initial command
     */
    @Override
    public Command init() {
        return null;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
    @Override
    public UpdateResult<Progress> update(Message msg) {
        if (msg instanceof SetPercentMessage setMessage) {
            return UpdateResult.from(this, setPercent(setMessage.percent()));
        }
        if (msg instanceof FrameMessage frameMessage) {
            return handleFrame(frameMessage.id(), frameMessage.tag());
        }

        return UpdateResult.from(this);
    }

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    @Override
    public String view() {
        return viewAs(percentShown);
    }

    /**
     * Handles view as for this component.
     *
     * @param percent percent
     * @return result
     */
    public String viewAs(double percent) {
        StringBuilder b = new StringBuilder();
        String percentView = percentageView(percent);
        int textWidth = textWidth(percentView);
        barView(b, percent, textWidth);
        b.append(percentView);
        return b.toString();
    }

    /**
     * Returns the display width of a string in terminal cells.
     * <p>
     * Delegates to {@link TextWidth#measureCellWidth(String)} which uses
     * grapheme clustering for accurate width calculation of:
     * <ul>
     *   <li>ANSI escape codes (ignored, not counted)</li>
     *   <li>CJK characters (counted as 2 cells based on Unicode blocks)</li>
     *   <li>Emojis and ZWJ sequences (counted as 2 cells)</li>
     *   <li>Combining marks (counted as 0 cells)</li>
     * </ul>
     * This replaces the previous simple heuristic (chars &gt;= 0x1100 = 2 cells)
     * with proper Unicode-aware width calculation.
     */
    private static int textWidth(String s) {
        return TextWidth.measureCellWidth(s);
    }

    /**
     * Handles bar view for this component.
     *
     * @param b b
     * @param percent percent
     * @param textWidth text width
     */
    private void barView(StringBuilder b, double percent, int textWidth) {
        int tw = Math.max(0, width - textWidth);
        int fw = (int) Math.round((double) tw * percent);

        fw = Math.max(0, Math.min(tw, fw));

        if (useRamp) {
            for (int i = 0; i < fw; i++) {
                double p;
                if (fw == 1) {
                    p = 0.5;
                } else if (scaleRamp) {
                    p = (double) i / (fw - 1);
                } else {
                    p = (double) i / (tw - 1);
                }
                RGB blended = blend(rampColorA, rampColorB, p);
                String color = rgbToHex(blended);
                b.append(colorize(String.valueOf(full), color));
            }
        } else {
            String colored = colorize(String.valueOf(full), fullColor);
            b.append(colored.repeat(fw));
        }

        String emptyColored = colorize(String.valueOf(empty), emptyColor);
        int n = Math.max(0, tw - fw);
        b.append(emptyColored.repeat(n));
    }

    /**
     * Handles blend for this component.
     *
     * @param a a
     * @param b b
     * @param t t
     * @return result
     */
    private static RGB blend(RGB a, RGB b, double t) {
        return new RGB(
                (float) (a.r() + (b.r() - a.r()) * t),
                (float) (a.g() + (b.g() - a.g()) * t),
                (float) (a.b() + (b.b() - a.b()) * t)
        );
    }

    /**
     * Handles rgb to hex for this component.
     *
     * @param rgb rgb
     * @return result
     */
    private static String rgbToHex(RGB rgb) {
        int r = Math.round(rgb.r() * 255.0f);
        int g = Math.round(rgb.g() * 255.0f);
        int b = Math.round(rgb.b() * 255.0f);
        return String.format("#%02x%02x%02x", r, g, b);
    }

    /**
     * Handles colorize for this component.
     *
     * @param text text
     * @param color color
     * @return result
     */
    private String colorize(String text, String color) {
        ColorProfile profile = getColorProfile();
        if (profile == null || profile == ColorProfile.Ascii) {
            return text;
        }
        return "\033[" + getANSIColorCode(color, profile) + "m" + text + "\033[0m";
    }

    /**
     * Returns the ansicolor code.
     *
     * @param color color
     * @param profile profile
     * @return result
     */
    private String getANSIColorCode(String color, ColorProfile profile) {
        RGB rgb = parseColor(color);
        int r = Math.round(rgb.r() * 255.0f);
        int g = Math.round(rgb.g() * 255.0f);
        int b = Math.round(rgb.b() * 255.0f);

        if (profile == ColorProfile.TrueColor) {
            return "38;2;" + r + ";" + g + ";" + b;
        } else {
            int ansi256 = rgbToANSI256(r, g, b);
            return "38;5;" + ansi256;
        }
    }

    /**
     * Handles rgb to ansi256 for this component.
     *
     * @param r r
     * @param g g
     * @param b b
     * @return result
     */
    private static int rgbToANSI256(int r, int g, int b) {
        if (r == g && g == b) {
            if (r < 8) {
                return 16;
            }
            if (r > 248) {
                return 231;
            }
            return (int) Math.round(((double) r - 8) / 247 * 24) + 232;
        }

        int rIdx = Math.round((float) r / 255 * 5);
        int gIdx = Math.round((float) g / 255 * 5);
        int bIdx = Math.round((float) b / 255 * 5);

        rIdx = Math.min(5, Math.max(0, rIdx));
        gIdx = Math.min(5, Math.max(0, gIdx));
        bIdx = Math.min(5, Math.max(0, bIdx));

        return 16 + 36 * rIdx + 6 * gIdx + bIdx;
    }

    /**
     * Handles percentage view for this component.
     *
     * @param percent percent
     * @return result
     */
    private String percentageView(double percent) {
        if (!showPercentage) {
            return "";
        }
        percent = Math.max(0, Math.min(1, percent));
        String percentage = String.format(percentFormat, percent * 100);
        if (percentageStyle != null) {
            percentage = percentageStyle.copy().inline(true).render(percentage);
        }
        return percentage;
    }

    /**
     * Handles next frame for this component.
     *
     * @return result
     */
    private Command nextFrame() {
        return Command.tick(Duration.ofNanos((long) (1_000_000_000.0 / FPS)), time -> new FrameMessage(id, tag));
    }

    /**
     * Handles handle frame for this component.
     *
     * @param frameId frame id
     * @param frameTag frame tag
     * @return result
     */
    private UpdateResult<Progress> handleFrame(int frameId, int frameTag) {
        if (frameId != id || frameTag != tag) {
            return UpdateResult.from(this);
        }

        if (!isAnimating()) {
            return UpdateResult.from(this);
        }

        Spring.SpringUpdateResult result = spring.update(percentShown, velocity, targetPercent);
        this.percentShown = result.position();
        this.velocity = result.velocity();
        return UpdateResult.from(this, nextFrame());
    }

    /**
     * Updates the percent.
     *
     * @param p p
     * @return result
     */
    public Command setPercent(double p) {
        this.targetPercent = Math.max(0, Math.min(1, p));
        this.tag++;
        return nextFrame();
    }

    /**
     * Handles incr percent for this component.
     *
     * @param v v
     * @return result
     */
    public Command incrPercent(double v) {
        return setPercent(targetPercent + v);
    }

    /**
     * Handles decr percent for this component.
     *
     * @param v v
     * @return result
     */
    public Command decrPercent(double v) {
        return setPercent(targetPercent - v);
    }
}
