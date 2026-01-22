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
    public static Border NoBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.NoBorder);
    /** Single-line box border. */
    public static Border NormalBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.NormalBorder);
    /** Rounded corner border. */
    public static Border RoundedBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.RoundedBorder);
    /** Solid block border. */
    public static Border BlockBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.BlockBorder);
    /** Outer half-block border. */
    public static Border OuterHalfBlockBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.OuterHalfBlockBorder);
    /** Inner half-block border. */
    public static Border InnerHalfBlockBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.InnerHalfBlockBorder);
    /** Thick line border. */
    public static Border ThickBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.ThickBorder);
    /** Double line border. */
    public static Border DoubleBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.DoubleBorder);
    /** Hidden border (spaces). */
    public static Border HiddenBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.HiddenBorder);
    /** Markdown table border. */
    public static Border MarkdownBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.MarkdownBorder);
    /** ASCII line border. */
    public static Border ASCIIBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.ASCIIBorder);

    /**
     * Creates a standard border shim.
     */
    public StandardBorder() {
        super();
    }
}
