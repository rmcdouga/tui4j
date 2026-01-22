package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.border.Border;
import com.williamcallahan.tui4j.compat.lipgloss.border.StandardBorder;

/**
 * Port of Lip Gloss border helpers.
 * Lip Gloss: lipgloss/borders.go
 */
public final class Borders {

    private Borders() {
    }

    /**
     * Returns the no-border style.
     *
     * @return no border
     */
    public static Border noBorder() {
        return StandardBorder.NoBorder;
    }

    /**
     * Returns the normal border style.
     *
     * @return normal border
     */
    public static Border normalBorder() {
        return StandardBorder.NormalBorder;
    }

    /**
     * Returns the rounded border style.
     *
     * @return rounded border
     */
    public static Border roundedBorder() {
        return StandardBorder.RoundedBorder;
    }

    /**
     * Returns the block border style.
     *
     * @return block border
     */
    public static Border blockBorder() {
        return StandardBorder.BlockBorder;
    }

    /**
     * Returns the outer half-block border style.
     *
     * @return outer half-block border
     */
    public static Border outerHalfBlockBorder() {
        return StandardBorder.OuterHalfBlockBorder;
    }

    /**
     * Returns the inner half-block border style.
     *
     * @return inner half-block border
     */
    public static Border innerHalfBlockBorder() {
        return StandardBorder.InnerHalfBlockBorder;
    }

    /**
     * Returns the thick border style.
     *
     * @return thick border
     */
    public static Border thickBorder() {
        return StandardBorder.ThickBorder;
    }

    /**
     * Returns the double border style.
     *
     * @return double border
     */
    public static Border doubleBorder() {
        return StandardBorder.DoubleBorder;
    }

    /**
     * Returns the hidden border style.
     *
     * @return hidden border
     */
    public static Border hiddenBorder() {
        return StandardBorder.HiddenBorder;
    }

    /**
     * Returns the Markdown border style.
     *
     * @return markdown border
     */
    public static Border markdownBorder() {
        return StandardBorder.MarkdownBorder;
    }

    /**
     * Returns the ASCII border style.
     *
     * @return ASCII border
     */
    public static Border asciiBorder() {
        return StandardBorder.ASCIIBorder;
    }
}
