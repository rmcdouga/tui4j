package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.ansi.TextWrapper;
import com.williamcallahan.tui4j.ansi.Truncate;
import com.williamcallahan.tui4j.compat.lipgloss.align.AlignmentDecorator;
import com.williamcallahan.tui4j.compat.lipgloss.border.Border;
import com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile;
import com.williamcallahan.tui4j.compat.lipgloss.color.NoColor;
import com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor;
import org.jline.utils.AttributedCharSequence.ForceMode;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static com.williamcallahan.tui4j.compat.lipgloss.Renderer.defaultRenderer;

/**
 * Fluent styling and layout wrapper.
 * <p>
 * Port of `lipgloss/style.go`.
 * Provides a chainable API for coloring, sizing, padding, and aligning text content.
 * <p>
 * Lipgloss: style.go.
 */
public class Style implements Cloneable {

    /**
     * Handles new style for this component.
     *
     * @return result
     */
    public static Style newStyle() {
        return defaultRenderer.newStyle();
    }

    private final Renderer renderer;

    private String value;
    private Function<String, String> transformFunction;
    private TerminalColor background = new NoColor();
    private TerminalColor foreground = new NoColor();
    private boolean bold;
    private boolean italic;
    private boolean underline;
    private boolean blink;
    private boolean faint;
    private boolean reverse;
    private boolean inline;
    private int width;
    private int height;
    private int maxWidth;
    private int maxHeight;
    private String ellipsis = "";
    private Position horizontalAlign = Position.Left;
    private Position verticalAlign = Position.Top;

    private int topPadding;
    private int rightPadding;
    private int bottomPadding;
    private int leftPadding;

    private TerminalColor marginBackgroundColor = new NoColor();
    private int topMargin;
    private int rightMargin;
    private int bottomMargin;
    private int leftMargin;

    private Border borderDecoration;
    private boolean borderTop;
    private boolean borderRight;
    private boolean borderBottom;
    private boolean borderLeft;
    private boolean borderTopSet;
    private boolean borderRightSet;
    private boolean borderBottomSet;
    private boolean borderLeftSet;
    private TerminalColor borderTopForeground = new NoColor();
    private TerminalColor borderRightForeground = new NoColor();
    private TerminalColor borderBottomForeground = new NoColor();
    private TerminalColor borderLeftForeground = new NoColor();
    private TerminalColor borderTopBackground = new NoColor();
    private TerminalColor borderRightBackground = new NoColor();
    private TerminalColor borderBottomBackground = new NoColor();
    private TerminalColor borderLeftBackground = new NoColor();

    /**
     * Creates Style to keep this component ready for use.
     *
     * @param renderer renderer
     */
    public Style(Renderer renderer) {
        this.renderer = renderer;
    }

    /**
     * Updates the string.
     *
     * @param strings strings
     * @return result
     */
    public Style setString(String... strings) {
        this.value = String.join(" ", strings);
        return this;
    }

    /**
     * Handles foreground for this component.
     *
     * @param color color
     * @return result
     */
    public Style foreground(TerminalColor color) {
        this.foreground = color;
        return this;
    }

    /**
     * Handles background for this component.
     *
     * @param color color
     * @return result
     */
    public Style background(TerminalColor color) {
        this.background = color;
        return this;
    }

    /**
     * Handles bold for this component.
     *
     * @param bold bold
     * @return result
     */
    public Style bold(boolean bold) {
        this.bold = bold;
        return this;
    }

    /**
     * Handles italic for this component.
     *
     * @param italic italic
     * @return result
     */
    public Style italic(boolean italic) {
        this.italic = italic;
        return this;
    }

    /**
     * Handles underline for this component.
     *
     * @param underline underline
     * @return result
     */
    public Style underline(boolean underline) {
        this.underline = underline;
        return this;
    }

    /**
     * Handles reverse for this component.
     *
     * @param reverse reverse
     * @return result
     */
    public Style reverse(boolean reverse) {
        this.reverse = reverse;
        return this;
    }

    /**
     * Handles blink for this component.
     *
     * @param blink blink
     * @return result
     */
    public Style blink(boolean blink) {
        this.blink = blink;
        return this;
    }

    /**
     * Handles faint for this component.
     *
     * @param faint faint
     * @return result
     */
    public Style faint(boolean faint) {
        this.faint = faint;
        return this;
    }

    /**
     * Handles inline for this component.
     *
     * @param inline inline
     * @return result
     */
    public Style inline(boolean inline) {
        this.inline = inline;
        return this;
    }

    /**
     * Handles width for this component.
     *
     * @param width width
     * @return result
     */
    public Style width(int width) {
        this.width = width;
        return this;
    }

    /**
     * Handles height for this component.
     *
     * @param height height
     * @return result
     */
    public Style height(int height) {
        this.height = height;
        return this;
    }

    /**
     * Handles max width for this component.
     *
     * @param maxWidth max width
     * @return result
     */
    public Style maxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    /**
     * Handles max height for this component.
     *
     * @param maxHeight max height
     * @return result
     */
    public Style maxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    /**
     * Handles ellipsis for this component.
     *
     * @param ellipsis ellipsis
     * @return result
     */
    public Style ellipsis(String ellipsis) {
        this.ellipsis = ellipsis;
        return this;
    }

    /**
     * Handles align for this component.
     *
     * @param positions positions
     * @return result
     */
    public Style align(Position... positions) {
        if (positions.length > 0) {
            this.horizontalAlign = positions[0];
        }
        if (positions.length > 1) {
            this.verticalAlign = positions[1];
        }
        return this;
    }

    /**
     * Handles align horizontal for this component.
     *
     * @param position position
     * @return result
     */
    public Style alignHorizontal(Position position) {
        this.horizontalAlign = position;
        return this;
    }

    /**
     * Handles align vertical for this component.
     *
     * @param position position
     * @return result
     */
    public Style alignVertical(Position position) {
        this.verticalAlign = position;
        return this;
    }

    /**
     * Returns the width.
     *
     * @return result
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height.
     *
     * @return result
     */
    public int getHeight() {
        return height;
    }

    /**
     * Returns the max width.
     *
     * @return result
     */
    public int getMaxWidth() {
        return maxWidth;
    }

    /**
     * Returns the max height.
     *
     * @return result
     */
    public int getMaxHeight() {
        return maxHeight;
    }

    /**
     * Handles unset max width for this component.
     *
     * @return result
     */
    public Style unsetMaxWidth() {
        this.maxWidth = 0;
        return this;
    }

    /**
     * Handles unset max height for this component.
     *
     * @return result
     */
    public Style unsetMaxHeight() {
        this.maxHeight = 0;
        return this;
    }

    /**
     * Handles padding for this component.
     *
     * @param values values
     * @return result
     */
    public Style padding(int... values) {
        int[] boxValues = expandBoxValues(IntStream.range(0, values.length).toArray());
        this.topPadding = values[boxValues[0]];
        this.rightPadding = values[boxValues[1]];
        this.bottomPadding = values[boxValues[2]];
        this.leftPadding = values[boxValues[3]];
        return this;
    }

    /**
     * Handles padding top for this component.
     *
     * @param topPadding top padding
     * @return result
     */
    public Style paddingTop(int topPadding) {
        this.topPadding = topPadding;
        return this;
    }

    /**
     * Handles padding right for this component.
     *
     * @param rightPadding right padding
     * @return result
     */
    public Style paddingRight(int rightPadding) {
        this.rightPadding = rightPadding;
        return this;
    }

    /**
     * Handles right padding for this component.
     *
     * @return result
     */
    public int rightPadding() {
        return rightPadding;
    }

    /**
     * Handles padding bottom for this component.
     *
     * @param bottomPadding bottom padding
     * @return result
     */
    public Style paddingBottom(int bottomPadding) {
        this.bottomPadding = bottomPadding;
        return this;
    }

    /**
     * Handles padding left for this component.
     *
     * @param leftPadding left padding
     * @return result
     */
    public Style paddingLeft(int leftPadding) {
        this.leftPadding = leftPadding;
        return this;
    }

    /**
     * Handles left padding for this component.
     *
     * @return result
     */
    public int leftPadding() {
        return leftPadding;
    }

    /**
     * Handles margin for this component.
     *
     * @param values values
     * @return result
     */
    public Style margin(int... values) {
        int[] boxValues = expandBoxValues(IntStream.range(0, values.length).toArray());
        this.topMargin = values[boxValues[0]];
        this.rightMargin = values[boxValues[1]];
        this.bottomMargin = values[boxValues[2]];
        this.leftMargin = values[boxValues[3]];
        return this;
    }

    /**
     * Handles margin top for this component.
     *
     * @param topMargin top margin
     * @return result
     */
    public Style marginTop(int topMargin) {
        this.topMargin = topMargin;
        return this;
    }

    /**
     * Handles margin right for this component.
     *
     * @param rightMargin right margin
     * @return result
     */
    public Style marginRight(int rightMargin) {
        this.rightMargin = rightMargin;
        return this;
    }

    /**
     * Handles margin bottom for this component.
     *
     * @param bottomMargin bottom margin
     * @return result
     */
    public Style marginBottom(int bottomMargin) {
        this.bottomMargin = bottomMargin;
        return this;
    }

    /**
     * Handles margin left for this component.
     *
     * @param leftMargin left margin
     * @return result
     */
    public Style marginLeft(int leftMargin) {
        this.leftMargin = leftMargin;
        return this;
    }

    /**
     * Handles margin background color for this component.
     *
     * @param marginBackgroundColor margin background color
     * @return result
     */
    public Style marginBackgroundColor(TerminalColor marginBackgroundColor) {
        this.marginBackgroundColor = marginBackgroundColor;
        return this;
    }

    /**
     * Handles top margin for this component.
     *
     * @return result
     */
    public int topMargin() {
        return topMargin;
    }

    /**
     * Handles border for this component.
     *
     * @param border border
     * @param sides sides
     * @return result
     */
    public Style border(Border border, boolean... sides) {
        if (sides.length == 0) {
            return border(border, true);
        }

        borderDecoration(border);

        int[] boxValues = expandBoxValues(
                IntStream.range(0, sides.length)
                        .map(i -> Boolean.compare(sides[i], true))
                        .toArray()
        );

        return borderTop(sides[boxValues[0]])
                .borderRight(sides[boxValues[1]])
                .borderBottom(sides[boxValues[2]])
                .borderLeft(sides[boxValues[3]]);
    }

    /**
     * Handles border decoration for this component.
     *
     * @param borderDecoration border decoration
     * @return result
     */
    public Style borderDecoration(Border borderDecoration) {
        this.borderDecoration = borderDecoration;
        return this;
    }

    /**
     * Handles border top for this component.
     *
     * @param borderTop border top
     * @return result
     */
    public Style borderTop(boolean borderTop) {
        this.borderTop = borderTop;
        this.borderTopSet = true;
        return this;
    }

    /**
     * Handles border right for this component.
     *
     * @param borderRight border right
     * @return result
     */
    public Style borderRight(boolean borderRight) {
        this.borderRight = borderRight;
        this.borderRightSet = true;
        return this;
    }

    /**
     * Handles border bottom for this component.
     *
     * @param borderBottom border bottom
     * @return result
     */
    public Style borderBottom(boolean borderBottom) {
        this.borderBottom = borderBottom;
        this.borderBottomSet = true;
        return this;
    }

    /**
     * Handles border left for this component.
     *
     * @param borderLeft border left
     * @return result
     */
    public Style borderLeft(boolean borderLeft) {
        this.borderLeft = borderLeft;
        this.borderLeftSet = true;
        return this;
    }

    /**
     * Handles border background for this component.
     *
     * @param colors colors
     * @return result
     */
    public Style borderBackground(TerminalColor... colors) {
        int[] boxValues = expandBoxValues(
                IntStream.range(0, colors.length).toArray()
        );
        this.borderTopBackground = colors[boxValues[0]];
        this.borderRightBackground = colors[boxValues[1]];
        this.borderBottomBackground = colors[boxValues[2]];
        this.borderLeftBackground = colors[boxValues[3]];

        return this;
    }

    /**
     * Handles border top background for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderTopBackground(TerminalColor color) {
        this.borderTopBackground = color;
        return this;
    }

    /**
     * Handles border right background for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderRightBackground(TerminalColor color) {
        this.borderRightBackground = color;
        return this;
    }

    /**
     * Handles border bottom background for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderBottomBackground(TerminalColor color) {
        this.borderBottomBackground = color;
        return this;
    }

    /**
     * Handles border left background for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderLeftBackground(TerminalColor color) {
        this.borderLeftBackground = color;
        return this;
    }

    /**
     * Handles border foreground for this component.
     *
     * @param colors colors
     * @return result
     */
    public Style borderForeground(TerminalColor... colors) {
        int[] boxValues = expandBoxValues(
                IntStream.range(0, colors.length).toArray()
        );
        this.borderTopForeground = colors[boxValues[0]];
        this.borderRightForeground = colors[boxValues[1]];
        this.borderBottomForeground = colors[boxValues[2]];
        this.borderLeftForeground = colors[boxValues[3]];

        return this;
    }

    /**
     * Handles border top foreground for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderTopForeground(TerminalColor color) {
        this.borderTopForeground = color;
        return this;
    }

    /**
     * Handles border right foreground for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderRightForeground(TerminalColor color) {
        this.borderRightForeground = color;
        return this;
    }

    /**
     * Handles border bottom foreground for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderBottomForeground(TerminalColor color) {
        this.borderBottomForeground = color;
        return this;
    }

    /**
     * Handles border left foreground for this component.
     *
     * @param color color
     * @return result
     */
    public Style borderLeftForeground(TerminalColor color) {
        this.borderLeftForeground = color;
        return this;
    }

    /**
     * Handles transform for this component.
     *
     * @param transformFunction transform function
     * @return result
     */
    public Style transform(Function<String, String> transformFunction) {
        this.transformFunction = transformFunction;
        return this;
    }

    /**
     * Applies all style rules (colors, margins, padding, borders) to the input strings.
     * Renders the final ANSI sequence.
     */
    public String render(String... strings) {
        AttributedStyle style = new AttributedStyle();
        if (foreground != null) {
            style = foreground.applyAsForeground(style, renderer);
        }
        if (background != null) {
            style = background.applyAsBackground(style, renderer);
        }
        if (bold) {
            style = style.bold();
        }
        if (italic) {
            style = style.italic();
        }
        if (underline) {
            style = style.underline();
        }
        if (faint) {
            style = style.faint();
        }
        if (blink) {
            style = style.blink();
        }
        if (reverse) {
            style = style.inverse();
        }

        List<String> strs = new ArrayList<>(List.of(strings));
        if (value != null && !value.isEmpty()) {
            strs.addFirst(value);
        }
        String string = String.join(" ", strs);

        if (this.transformFunction != null) {
            string = transformFunction.apply(string);
        }

        string = string.replaceAll("\r\n", "\n");

        if (inline) {
            string = string.replaceAll("\n", "");
        }

        if (!inline && width > 0) {
            int wrapAt = width - leftPadding - rightPadding;
            string = new TextWrapper().wrap(string, wrapAt);
        }

        // core rendering
        ColorProfile colorProfile = renderer.colorProfile();
        renderer.newStyle();
        String[] lines = string.split("\n");

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            if (colorProfile != ColorProfile.Ascii) {
                buffer.append(new AttributedString(line, style).toAnsi(colorProfile.colorsCount(), ForceMode.None));
            } else {
                buffer.append(line);
            }
            if (i < lines.length - 1) {
                buffer.append('\n');
            }
        }
        string = buffer.toString();

        if (!inline) {
            AttributedStyle st = new AttributedStyle();
            if (background != null) {
                st = background.applyAsBackground(st, renderer);
            }
            string = PaddingDecorator.applyPadding(string, topPadding, rightPadding, bottomPadding, leftPadding, st, renderer);
        }
        if (height > 0) {
            string = AlignmentDecorator.alignTextVertical(string, verticalAlign, height);
        }

        int numLines = string.split("\n", 0).length;
        if (!(numLines == 0 && width == 0)) {
            AttributedStyle st = new AttributedStyle();
            if (background != null) {
                st = background.applyAsBackground(st, renderer);
            }
            string = AlignmentDecorator.alignTextHorizontal(string, horizontalAlign, width, st);
        }
        if (!inline) {
            string = applyBorders(string);

            AttributedStyle st = new AttributedStyle();
            st = marginBackgroundColor.applyAsBackground(st, renderer);

            string = MarginDecorator.applyMargins(string, topMargin, rightMargin, bottomMargin, leftMargin, st, renderer);
        }

        if (maxWidth > 0) {
            String[] maxWidthLines = string.split("\n");
            for (int i = 0; i < maxWidthLines.length; i++) {
                maxWidthLines[i] = Truncate.truncate(maxWidthLines[i], maxWidth, ellipsis);
            }
            string = String.join("\n", maxWidthLines);
        }

        if (maxHeight > 0) {
            String[] maxHeightLines = string.split("\n");
            int displayHeight = Math.min(maxHeight, maxHeightLines.length);
            if (maxHeightLines.length > 0) {
                String[] truncatedLines = new String[displayHeight];
                System.arraycopy(maxHeightLines, 0, truncatedLines, 0, displayHeight);
                string = String.join("\n", truncatedLines);
            }
        }

        return string;
    }

    /**
     * Handles apply borders for this component.
     *
     * @param string string
     * @return result
     */
    private String applyBorders(String string) {
        boolean hasTop = this.borderTop;
        boolean hasRight = this.borderRight;
        boolean hasBottom = this.borderBottom;
        boolean hasLeft = this.borderLeft;

        if (implicitBorders()) {
            hasTop = true;
            hasRight = true;
            hasBottom = true;
            hasLeft = true;
        }

        if (borderDecoration == null || (!hasTop && !hasRight && !hasBottom && !hasLeft)) {
            return string;
        }

        return borderDecoration.applyBorders(string,
                hasTop,
                hasRight,
                hasBottom,
                hasLeft,
                borderTopForeground,
                borderRightForeground,
                borderBottomForeground,
                borderLeftForeground,
                borderTopBackground,
                borderRightBackground,
                borderBottomBackground,
                borderLeftBackground,
                renderer);
    }

    /**
     * Handles implicit borders for this component.
     *
     * @return whether plicit borders
     */
    private boolean implicitBorders() {
        return borderDecoration != null && !(borderTopSet || borderRightSet || borderBottomSet || borderLeftSet);
    }

    /**
     * Handles expand box values for this component.
     *
     * @param values values
     * @return result
     */
    public static int[] expandBoxValues(int... values) {
        int[] result = new int[4];  // top, right, bottom, left

        switch (values.length) {
            case 1:
                Arrays.fill(result, values[0]);
                break;
            case 2:
                result[0] = 0;  // top
                result[1] = 1;  // right
                result[2] = 0;  // bottom
                result[3] = 1;  // left
                break;
            case 3:
                result[0] = 0;  // top
                result[1] = 1;  // right
                result[2] = 2;  // bottom
                result[3] = 1;  // left
                break;
            case 4:
                result[0] = 0;  // top
                result[1] = 1;  // right
                result[2] = 2;  // bottom
                result[3] = 3;
                break;
            default:
                throw new IllegalArgumentException("Expected 1-4 values, got " + values.length);
        }
        return result;
    }

    /**
     * Handles frame size for this component.
     *
     * @return result
     */
    public Dimensions frameSize() {
        return new Dimensions(getHorizontalFrameSize(), getVerticalFrameSize());
    }

    /**
     * Returns the vertical frame size.
     *
     * @return result
     */
    public int getVerticalFrameSize() {
        return getVerticalMargins() + getVerticalPadding() + getVerticalBorderSize();
    }

    /**
     * Returns the vertical margins.
     *
     * @return result
     */
    public int getVerticalMargins() {
        return topMargin + bottomMargin;
    }

    /**
     * Returns the vertical padding.
     *
     * @return result
     */
    public int getVerticalPadding() {
        return topPadding + bottomPadding;
    }

    /**
     * Returns the vertical border size.
     *
     * @return result
     */
    public int getVerticalBorderSize() {
        return getBorderTopSize() + getBorderBottomSize();
    }

    /**
     * Returns the border top size.
     *
     * @return result
     */
    public int getBorderTopSize() {
        if (!borderTop && !implicitBorders()) {
            return 0;
        }
        return borderDecoration.getTopSize();
    }

    /**
     * Returns the border bottom size.
     *
     * @return result
     */
    public int getBorderBottomSize() {
        if (!borderBottom && !implicitBorders()) {
            return 0;
        }
        return borderDecoration.getBottomSize();
    }

    /**
     * Returns the horizontal frame size.
     *
     * @return result
     */
    public int getHorizontalFrameSize() {
        return getHorizontalMargins() + getHorizontalPadding() + getHorizontalBorderSize();
    }

    /**
     * Returns the horizontal margins.
     *
     * @return result
     */
    public int getHorizontalMargins() {
        return rightMargin + leftMargin;
    }

    /**
     * Returns the horizontal padding.
     *
     * @return result
     */
    public int getHorizontalPadding() {
        return rightPadding + leftPadding;
    }

    /**
     * Returns the horizontal border size.
     *
     * @return result
     */
    public int getHorizontalBorderSize() {
        return getBorderLeftSize() + getBorderRightSize();
    }

    /**
     * Returns the border left size.
     *
     * @return result
     */
    public int getBorderLeftSize() {
        if (!borderLeft && !implicitBorders()) {
            return 0;
        }
        return borderDecoration.getLeftSize();
    }

    /**
     * Returns the border right size.
     *
     * @return result
     */
    public int getBorderRightSize() {
        if (!borderRight && !implicitBorders()) {
            return 0;
        }
        return borderDecoration.getRightSize();
    }

    /**
     * Handles clone for this component.
     *
     * @return result
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Returns a copy of this style.
     *
     * <p>Note: This method was deprecated in upstream Lip Gloss because Go's value-type semantics
     * make simple assignment sufficient for copying. In Java, this method remains necessary for
     * obtaining an independent mutable copy since objects are reference types.
     *
     * @return a shallow copy of this style
     * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/style.go">lipgloss/style.go</a>
     */
    public Style copy() {
        try {
            return (Style) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles inherit for this component.
     *
     * @param style style
     * @return result
     */
    public Style inherit(Style style) {
        if (this.value == null) this.value = style.value;
        if (this.transformFunction == null) this.transformFunction = style.transformFunction;
        if (this.background instanceof NoColor) this.background = style.background;
        if (this.foreground instanceof NoColor) this.foreground = style.foreground;
        if (!this.bold) this.bold = style.bold;
        if (!this.italic) this.italic = style.italic;
        if (!this.underline) this.underline = style.underline;
        if (!this.blink) this.blink = style.blink;
        if (!this.faint) this.faint = style.faint;
        if (!this.reverse) this.reverse = style.reverse;
        if (!this.inline) this.inline = style.inline;
        if (this.width == 0) this.width = style.width;
        if (this.height == 0) this.height = style.height;
        if (this.maxWidth == 0) this.maxWidth = style.maxWidth;
        if (this.maxHeight == 0) this.maxHeight = style.maxHeight;
        if (this.ellipsis.isEmpty()) this.ellipsis = style.ellipsis;
        if (this.horizontalAlign == Position.Left) this.horizontalAlign = style.horizontalAlign;
        if (this.verticalAlign == Position.Top) this.verticalAlign = style.verticalAlign;

        if (this.borderDecoration == null) this.borderDecoration = style.borderDecoration;

        if (!this.borderTopSet) {
            this.borderTop = style.borderTop;
            this.borderTopSet = style.borderTopSet;
            this.borderTopForeground = style.borderTopForeground;
            this.borderTopBackground = style.borderTopBackground;
        }
        if (!this.borderRightSet) {
            this.borderRight = style.borderRight;
            this.borderRightSet = style.borderRightSet;
            this.borderRightForeground = style.borderRightForeground;
            this.borderRightBackground = style.borderRightBackground;
        }
        if (!this.borderBottomSet) {
            this.borderBottom = style.borderBottom;
            this.borderBottomSet = style.borderBottomSet;
            this.borderBottomForeground = style.borderBottomForeground;
            this.borderBottomBackground = style.borderBottomBackground;
        }
        if (!this.borderLeftSet) {
            this.borderLeft = style.borderLeft;
            this.borderLeftSet = style.borderLeftSet;
            this.borderLeftForeground = style.borderLeftForeground;
            this.borderLeftBackground = style.borderLeftBackground;
        }
        return this;
    }
}
