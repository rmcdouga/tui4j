package com.williamcallahan.tui4j.compat.bubbletea.lipgloss;

import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.border.Border;

import java.util.function.Function;

/**
 * Style wrapper for Bubble Tea-compatible APIs.
 * <p>
 * Lipgloss: style.go.
 *
 * @deprecated Deprecated in tui4j as of 0.3.0 because this compatibility type moved; use {@link com.williamcallahan.tui4j.compat.lipgloss.Style}.
 * This transitional shim preserves the legacy Bubble Tea fluent API and will be removed
 * in a future release.
 */
@Deprecated(since = "0.3.0")
@SuppressWarnings("removal")
public class Style extends com.williamcallahan.tui4j.compat.lipgloss.Style {

    /**
     * Creates a new Style with the default renderer.
     *
     * @return new style
     */
    public static Style newStyle() {
        return new Style(Renderer.defaultRenderer());
    }

    /**
     * Wraps a canonical style with the legacy Bubble Tea shim.
     *
     * @param canonical canonical style
     * @return legacy style shim
     */
    public static Style fromCanonical(com.williamcallahan.tui4j.compat.lipgloss.Style canonical) {
        if (canonical instanceof Style legacy) {
            return legacy;
        }
        Style legacy = new Style(Renderer.defaultRenderer());
        if (canonical != null) {
            legacy.inherit(canonical);
        }
        return legacy;
    }

    /**
     * Creates a Style with the given renderer.
     *
     * @param renderer renderer
     */
    public Style(Renderer renderer) {
        super(renderer.toCanonical());
    }

    /**
     * Sets the string value for this style.
     *
     * @param strings strings to render
     * @return this style
     */
    @Override
    public Style setString(String... strings) {
        super.setString(strings);
        return this;
    }

    /**
     * Sets the foreground color using the canonical terminal color.
     *
     * @param color canonical terminal color
     * @return this style
     */
    @Override
    public Style foreground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.foreground(color);
        return this;
    }

    /**
     * Sets the foreground color using the Bubble Tea terminal color.
     *
     * @param color bubbletea terminal color
     * @return this style
     */
    public Style foreground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.foreground(adaptColor(color));
        return this;
    }

    /**
     * Sets the background color using the canonical terminal color.
     *
     * @param color canonical terminal color
     * @return this style
     */
    @Override
    public Style background(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.background(color);
        return this;
    }

    /**
     * Sets the background color using the Bubble Tea terminal color.
     *
     * @param color bubbletea terminal color
     * @return this style
     */
    public Style background(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.background(adaptColor(color));
        return this;
    }

    /**
     * Sets bold styling.
     *
     * @param bold bold flag
     * @return this style
     */
    @Override
    public Style bold(boolean bold) {
        super.bold(bold);
        return this;
    }

    /**
     * Sets italic styling.
     *
     * @param italic italic flag
     * @return this style
     */
    @Override
    public Style italic(boolean italic) {
        super.italic(italic);
        return this;
    }

    /**
     * Sets underline styling.
     *
     * @param underline underline flag
     * @return this style
     */
    @Override
    public Style underline(boolean underline) {
        super.underline(underline);
        return this;
    }

    /**
     * Sets reverse styling.
     *
     * @param reverse reverse flag
     * @return this style
     */
    @Override
    public Style reverse(boolean reverse) {
        super.reverse(reverse);
        return this;
    }

    /**
     * Sets blink styling.
     *
     * @param blink blink flag
     * @return this style
     */
    @Override
    public Style blink(boolean blink) {
        super.blink(blink);
        return this;
    }

    /**
     * Sets faint styling.
     *
     * @param faint faint flag
     * @return this style
     */
    @Override
    public Style faint(boolean faint) {
        super.faint(faint);
        return this;
    }

    /**
     * Sets inline rendering.
     *
     * @param inline inline flag
     * @return this style
     */
    @Override
    public Style inline(boolean inline) {
        super.inline(inline);
        return this;
    }

    /**
     * Sets the width.
     *
     * @param width width
     * @return this style
     */
    @Override
    public Style width(int width) {
        super.width(width);
        return this;
    }

    /**
     * Sets the height.
     *
     * @param height height
     * @return this style
     */
    @Override
    public Style height(int height) {
        super.height(height);
        return this;
    }

    /**
     * Sets the maximum width.
     *
     * @param maxWidth max width
     * @return this style
     */
    @Override
    public Style maxWidth(int maxWidth) {
        super.maxWidth(maxWidth);
        return this;
    }

    /**
     * Sets the maximum height.
     *
     * @param maxHeight max height
     * @return this style
     */
    @Override
    public Style maxHeight(int maxHeight) {
        super.maxHeight(maxHeight);
        return this;
    }

    /**
     * Sets the ellipsis string used for truncation.
     *
     * @param ellipsis ellipsis string
     * @return this style
     */
    @Override
    public Style ellipsis(String ellipsis) {
        super.ellipsis(ellipsis);
        return this;
    }

    /**
     * Sets alignment using canonical positions.
     *
     * @param positions positions
     * @return this style
     */
    @Override
    public Style align(com.williamcallahan.tui4j.compat.lipgloss.Position... positions) {
        super.align(positions);
        return this;
    }

    /**
     * Sets horizontal alignment using canonical position.
     *
     * @param position horizontal position
     * @return this style
     */
    @Override
    public Style alignHorizontal(com.williamcallahan.tui4j.compat.lipgloss.Position position) {
        super.alignHorizontal(position);
        return this;
    }

    /**
     * Sets vertical alignment using canonical position.
     *
     * @param position vertical position
     * @return this style
     */
    @Override
    public Style alignVertical(com.williamcallahan.tui4j.compat.lipgloss.Position position) {
        super.alignVertical(position);
        return this;
    }

    /**
     * Clears the max width.
     *
     * @return this style
     */
    @Override
    public Style unsetMaxWidth() {
        super.unsetMaxWidth();
        return this;
    }

    /**
     * Clears the max height.
     *
     * @return this style
     */
    @Override
    public Style unsetMaxHeight() {
        super.unsetMaxHeight();
        return this;
    }

    /**
     * Sets padding using the provided values.
     *
     * @param values padding values
     * @return this style
     */
    @Override
    public Style padding(int... values) {
        super.padding(values);
        return this;
    }

    /**
     * Sets top padding.
     *
     * @param topPadding top padding
     * @return this style
     */
    @Override
    public Style paddingTop(int topPadding) {
        super.paddingTop(topPadding);
        return this;
    }

    /**
     * Sets right padding.
     *
     * @param rightPadding right padding
     * @return this style
     */
    @Override
    public Style paddingRight(int rightPadding) {
        super.paddingRight(rightPadding);
        return this;
    }

    /**
     * Sets bottom padding.
     *
     * @param bottomPadding bottom padding
     * @return this style
     */
    @Override
    public Style paddingBottom(int bottomPadding) {
        super.paddingBottom(bottomPadding);
        return this;
    }

    /**
     * Sets left padding.
     *
     * @param leftPadding left padding
     * @return this style
     */
    @Override
    public Style paddingLeft(int leftPadding) {
        super.paddingLeft(leftPadding);
        return this;
    }

    /**
     * Sets margin using the provided values.
     *
     * @param values margin values
     * @return this style
     */
    @Override
    public Style margin(int... values) {
        super.margin(values);
        return this;
    }

    /**
     * Sets top margin.
     *
     * @param topMargin top margin
     * @return this style
     */
    @Override
    public Style marginTop(int topMargin) {
        super.marginTop(topMargin);
        return this;
    }

    /**
     * Sets right margin.
     *
     * @param rightMargin right margin
     * @return this style
     */
    @Override
    public Style marginRight(int rightMargin) {
        super.marginRight(rightMargin);
        return this;
    }

    /**
     * Sets bottom margin.
     *
     * @param bottomMargin bottom margin
     * @return this style
     */
    @Override
    public Style marginBottom(int bottomMargin) {
        super.marginBottom(bottomMargin);
        return this;
    }

    /**
     * Sets left margin.
     *
     * @param leftMargin left margin
     * @return this style
     */
    @Override
    public Style marginLeft(int leftMargin) {
        super.marginLeft(leftMargin);
        return this;
    }

    /**
     * Sets the margin background color using the canonical terminal color.
     *
     * @param marginBackgroundColor canonical terminal color
     * @return this style
     */
    @Override
    public Style marginBackgroundColor(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor marginBackgroundColor) {
        super.marginBackgroundColor(marginBackgroundColor);
        return this;
    }

    /**
     * Sets the margin background color using the Bubble Tea terminal color.
     *
     * @param marginBackgroundColor bubbletea terminal color
     * @return this style
     */
    public Style marginBackgroundColor(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor marginBackgroundColor) {
        super.marginBackgroundColor(adaptColor(marginBackgroundColor));
        return this;
    }

    /**
     * Sets the border using the canonical border type.
     *
     * @param border canonical border
     * @param sides sides to apply
     * @return this style
     */
    @Override
    public Style border(com.williamcallahan.tui4j.compat.lipgloss.border.Border border, boolean... sides) {
        super.border(border, sides);
        return this;
    }

    /**
     * Sets the border using the Bubble Tea border type.
     *
     * @param border bubbletea border
     * @param sides sides to apply
     * @return this style
     */
    public Style border(Border border, boolean... sides) {
        return border(border == null ? null : border.toNew(), sides);
    }

    /**
     * Sets the border decoration using the canonical border type.
     *
     * @param borderDecoration canonical border decoration
     * @return this style
     */
    @Override
    public Style borderDecoration(com.williamcallahan.tui4j.compat.lipgloss.border.Border borderDecoration) {
        super.borderDecoration(borderDecoration);
        return this;
    }

    /**
     * Sets the border decoration using the Bubble Tea border type.
     *
     * @param borderDecoration bubbletea border decoration
     * @return this style
     */
    public Style borderDecoration(Border borderDecoration) {
        super.borderDecoration(borderDecoration == null ? null : borderDecoration.toNew());
        return this;
    }

    /**
     * Enables or disables the top border.
     *
     * @param borderTop top border flag
     * @return this style
     */
    @Override
    public Style borderTop(boolean borderTop) {
        super.borderTop(borderTop);
        return this;
    }

    /**
     * Enables or disables the right border.
     *
     * @param borderRight right border flag
     * @return this style
     */
    @Override
    public Style borderRight(boolean borderRight) {
        super.borderRight(borderRight);
        return this;
    }

    /**
     * Enables or disables the bottom border.
     *
     * @param borderBottom bottom border flag
     * @return this style
     */
    @Override
    public Style borderBottom(boolean borderBottom) {
        super.borderBottom(borderBottom);
        return this;
    }

    /**
     * Enables or disables the left border.
     *
     * @param borderLeft left border flag
     * @return this style
     */
    @Override
    public Style borderLeft(boolean borderLeft) {
        super.borderLeft(borderLeft);
        return this;
    }

    /**
     * Sets border background colors using canonical terminal colors.
     *
     * @param colors canonical colors
     * @return this style
     */
    @Override
    public Style borderBackground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor... colors) {
        super.borderBackground(colors);
        return this;
    }

    /**
     * Sets border background colors using Bubble Tea terminal colors.
     *
     * @param colors bubbletea colors
     * @return this style
     */
    public Style borderBackground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor... colors) {
        super.borderBackground(adaptColors(colors));
        return this;
    }

    /**
     * Sets the top border background color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderTopBackground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderTopBackground(color);
        return this;
    }

    /**
     * Sets the top border background color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderTopBackground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderTopBackground(adaptColor(color));
        return this;
    }

    /**
     * Sets the right border background color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderRightBackground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderRightBackground(color);
        return this;
    }

    /**
     * Sets the right border background color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderRightBackground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderRightBackground(adaptColor(color));
        return this;
    }

    /**
     * Sets the bottom border background color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderBottomBackground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderBottomBackground(color);
        return this;
    }

    /**
     * Sets the bottom border background color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderBottomBackground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderBottomBackground(adaptColor(color));
        return this;
    }

    /**
     * Sets the left border background color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderLeftBackground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderLeftBackground(color);
        return this;
    }

    /**
     * Sets the left border background color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderLeftBackground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderLeftBackground(adaptColor(color));
        return this;
    }

    /**
     * Sets border foreground colors using canonical terminal colors.
     *
     * @param colors canonical colors
     * @return this style
     */
    @Override
    public Style borderForeground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor... colors) {
        super.borderForeground(colors);
        return this;
    }

    /**
     * Sets border foreground colors using Bubble Tea terminal colors.
     *
     * @param colors bubbletea colors
     * @return this style
     */
    public Style borderForeground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor... colors) {
        super.borderForeground(adaptColors(colors));
        return this;
    }

    /**
     * Sets the top border foreground color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderTopForeground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderTopForeground(color);
        return this;
    }

    /**
     * Sets the top border foreground color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderTopForeground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderTopForeground(adaptColor(color));
        return this;
    }

    /**
     * Sets the right border foreground color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderRightForeground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderRightForeground(color);
        return this;
    }

    /**
     * Sets the right border foreground color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderRightForeground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderRightForeground(adaptColor(color));
        return this;
    }

    /**
     * Sets the bottom border foreground color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderBottomForeground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderBottomForeground(color);
        return this;
    }

    /**
     * Sets the bottom border foreground color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderBottomForeground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderBottomForeground(adaptColor(color));
        return this;
    }

    /**
     * Sets the left border foreground color using canonical terminal colors.
     *
     * @param color canonical color
     * @return this style
     */
    @Override
    public Style borderLeftForeground(com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor color) {
        super.borderLeftForeground(color);
        return this;
    }

    /**
     * Sets the left border foreground color using Bubble Tea terminal colors.
     *
     * @param color bubbletea color
     * @return this style
     */
    public Style borderLeftForeground(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        super.borderLeftForeground(adaptColor(color));
        return this;
    }

    /**
     * Sets the transform function.
     *
     * @param transformFunction transform function
     * @return this style
     */
    @Override
    public Style transform(Function<String, String> transformFunction) {
        super.transform(transformFunction);
        return this;
    }

    /**
     * Returns a copy of this style.
     *
     * @return copied style
     */
    @Override
    public Style copy() {
        return (Style) super.copy();
    }

    /**
     * Inherits unset values from another style.
     *
     * @param style style to inherit from
     * @return this style
     */
    @Override
    public Style inherit(com.williamcallahan.tui4j.compat.lipgloss.Style style) {
        super.inherit(style);
        return this;
    }

    /**
     * Adapts a Bubble Tea terminal color to the canonical lipgloss terminal color interface.
     *
     * @param color bubbletea terminal color
     * @return canonical terminal color
     */
    private com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor adaptColor(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor color) {
        if (color == null) {
            return null;
        }
        return new com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor() {
            /** {@inheritDoc} */
            @Override
            public org.jline.utils.AttributedStyle applyAsBackground(
                org.jline.utils.AttributedStyle style,
                com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
            ) {
                return color.applyAsBackground(style, Renderer.fromCanonical(renderer));
            }

            /** {@inheritDoc} */
            @Override
            public org.jline.utils.AttributedStyle applyAsForeground(
                org.jline.utils.AttributedStyle style,
                com.williamcallahan.tui4j.compat.lipgloss.Renderer renderer
            ) {
                return color.applyAsForeground(style, Renderer.fromCanonical(renderer));
            }
        };
    }

    /**
     * Adapts Bubble Tea terminal colors to canonical terminal colors.
     *
     * @param colors bubbletea colors
     * @return canonical colors
     */
    private com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor[] adaptColors(com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.TerminalColor... colors) {
        if (colors == null) {
            return null;
        }
        com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor[] adapted =
            new com.williamcallahan.tui4j.compat.lipgloss.color.TerminalColor[colors.length];
        for (int i = 0; i < colors.length; i++) {
            adapted[i] = adaptColor(colors[i]);
        }
        return adapted;
    }
}
