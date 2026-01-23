package com.williamcallahan.tui4j.examples.compat.lipgloss.layout;

import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;

/**
 * Example program demonstrating lipgloss status bar with components.
 * <p>
 * Shows a status bar with status label, encoding info, and an emoji.
 *
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/examples/layout/main.go">lipgloss/examples/layout</a>
 * <p>
 * Lipgloss: examples/layout/main.go.
 */
public class StatusBarExample {

    private static final String HIGHLIGHT = "#874BFD";
    private static final String SUBTLE_LIGHT = "#D9DCCF";
    private static final String SUBTLE_DARK = "#383838";
    private static final String SPECIAL = "#43BF6D";

    private static final Style STATUS_NUGGET = Style.newStyle()
            .foreground(Color.color("#FFFDF5"))
            .padding(0, 1);

    private static final Style STATUS_BAR_STYLE = Style.newStyle()
            .foreground(Color.adaptiveColor("#343433", "#C1C6B2"))
            .background(Color.adaptiveColor("#D9DCCF", "#353533"));

    private static final Style STATUS_STYLE = STATUS_BAR_STYLE.copy()
            .foreground(Color.color("#FFFDF5"))
            .background(Color.color("#FF5F87"))
            .padding(0, 1);

    private static final Style ENCODING_STYLE = STATUS_NUGGET
            .background(Color.color("#A550DF"))
            .alignHorizontal(Style.Align.RIGHT);

    private static final Style FISH_CAKE_STYLE = STATUS_NUGGET
            .background(Color.color("#6124DF"));

    private static final Style STATUS_TEXT = STATUS_BAR_STYLE.copy();

    /**
     * Runs the example to render a styled status bar layout.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        String statusKey = STATUS_STYLE.render("STATUS");
        String encoding = ENCODING_STYLE.render("UTF-8");
        String fishCake = FISH_CAKE_STYLE.render("🍥 Fish Cake");

        String statusVal = STATUS_TEXT.copy()
                .width(96 - Style.newStyle().stringWidth(statusKey) - Style.newStyle().stringWidth(encoding) - Style.newStyle().stringWidth(fishCake))
                .render("Ravishing");

        Style bar = Style.newStyle()
                .joinHorizontal(
                        Style.Align.TOP,
                        statusKey,
                        statusVal,
                        encoding,
                        fishCake
                );

        System.out.println(STATUS_BAR_STYLE.width(96).render(bar));
    }
}
