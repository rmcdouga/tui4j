package com.williamcallahan.tui4j.compat.bubbletea.lipgloss.border;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Lip Gloss: borders.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class StandardBorder extends com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder {
    public static Border NoBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.NoBorder);
    public static Border NormalBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.NormalBorder);
    public static Border RoundedBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.RoundedBorder);
    public static Border BlockBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.BlockBorder);
    public static Border OuterHalfBlockBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.OuterHalfBlockBorder);
    public static Border InnerHalfBlockBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.InnerHalfBlockBorder);
    public static Border ThickBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.ThickBorder);
    public static Border DoubleBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.DoubleBorder);
    public static Border HiddenBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.HiddenBorder);
    public static Border MarkdownBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.MarkdownBorder);
    public static Border ASCIIBorder = Border.fromNew(com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder.ASCIIBorder);
}
