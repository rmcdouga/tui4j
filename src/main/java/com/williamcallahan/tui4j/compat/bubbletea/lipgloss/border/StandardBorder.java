package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.border;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this is a compatibility shim for a relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: borders.go.
 */
@Deprecated(since = "0.3.0")
public class StandardBorder extends com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder {
    /** Border with no visible lines. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border NoBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.NoBorder;
    /** Single-line box border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border NormalBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.NormalBorder;
    /** Rounded corner border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border RoundedBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.RoundedBorder;
    /** Solid block border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border BlockBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.BlockBorder;
    /** Outer half-block border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border OuterHalfBlockBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.OuterHalfBlockBorder;
    /** Inner half-block border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border InnerHalfBlockBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.InnerHalfBlockBorder;
    /** Thick line border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border ThickBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.ThickBorder;
    /** Double line border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border DoubleBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.DoubleBorder;
    /** Hidden border (spaces). */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border HiddenBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.HiddenBorder;
    /** Markdown table border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border MarkdownBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.MarkdownBorder;
    /** ASCII line border. */
    public static com.williamcallahan.tui4j.compat.lipgloss.border.Border ASCIIBorder =
        com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.ASCIIBorder;

    /**
     * Creates a standard border shim.
     */
    public StandardBorder() {
        super();
    }
}
