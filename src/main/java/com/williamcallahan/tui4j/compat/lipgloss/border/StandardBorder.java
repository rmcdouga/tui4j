package com.williamcallahan.tui4j.compat.lipgloss.border;

/**
 * Port of Lip Gloss standard border.
 * Bubble Tea: bubbletea/examples/list-fancy/main.go
 */
public class StandardBorder {

    /** Border with no visible lines. */
    public static Border NoBorder = new Border("", "", "", "", "", "", "", "", "", "", "", "", "");
    /** Single-line box border. */
    public static Border NormalBorder = new Border("─", "─", "│", "│", "┌", "┐", "└", "┘", "├", "┤", "┼", "┬", "┴");
    /** Rounded corner border. */
    public static Border RoundedBorder = new Border("─", "─", "│", "│", "╭", "╮", "╰", "╯", "├", "┤", "┼", "┬", "┴");
    /** Solid block border. */
    public static Border BlockBorder = new Border("█", "█", "█", "█", "█", "█", "█", "█", "", "", "", "", "");
    /** Outer half-block border. */
    public static Border OuterHalfBlockBorder = new Border("▀", "▄", "▌", "▐", "▛", "▜", "▙", "▟", "", "", "", "", "");
    /** Inner half-block border. */
    public static Border InnerHalfBlockBorder = new Border("▄", "▀", "▐", "▌", "▗", "▖", "▝", "▘", "", "", "", "", "");
    /** Thick line border. */
    public static Border ThickBorder = new Border("━", "━", "┃", "┃", "┏", "┓", "┗", "┛", "┣", "┫", "╋", "┳", "┻");
    /** Double line border. */
    public static Border DoubleBorder = new Border("═", "═", "║", "║", "╔", "╗", "╚", "╝", "╠", "╣", "╬", "╦", "╩");
    /** Hidden border (spaces). */
    public static Border HiddenBorder = new Border(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ");
    /** Markdown table border. */
    public static Border MarkdownBorder = new Border("-", "-", "|", "|", "|", "|", "|", "|", "|", "|", "|", "|", "|");
    /** ASCII line border. */
    public static Border ASCIIBorder = new Border("-", "-", "|", "|", "+", "+", "+", "+", "+", "+", "+", "+", "+");

    /**
     * Creates a standard border container.
     */
    public StandardBorder() {
    }
}
