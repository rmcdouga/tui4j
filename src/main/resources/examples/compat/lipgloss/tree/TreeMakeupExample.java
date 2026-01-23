package com.williamcallahan.tui4j.examples.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.lipgloss.Tree;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;
import com.williamcallahan.tui4j.compat.lipgloss.tree.Enumerator;

/**
 * Example program demonstrating lipgloss tree with makeup products.
 * <p>
 * Shows a nested tree of makeup products and subcategories.
 *
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/examples/tree/makeup/main.go">lipgloss/examples/tree</a>
 */
public class TreeMakeupExample {

    private static final Style ENUMERATOR_STYLE = Style.newStyle().foreground(Color.color("63")).marginRight(1);
    private static final Style ROOT_STYLE = Style.newStyle().foreground(Color.color("35"));
    private static final Style ITEM_STYLE = Style.newStyle().foreground(Color.color("212"));

    /**
     * Runs the example to render a themed tree of makeup items.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Tree t = Tree.root("✜ Makeup")
                .enumerator(Enumerator.ROUNDED)
                .enumeratorStyle(ENUMERATOR_STYLE)
                .rootStyle(ROOT_STYLE)
                .itemStyle(ITEM_STYLE)
                .child(
                        "Glossier",
                        "Fenty Beauty",
                        Tree.root()
                                        .enumerator(Enumerator.ROUNDED)
                                        .child("Gloss Bomb Universal Lip Luminizer", "Hot Cheeks Velour Blushlighter"),
                        "Nyx",
                        "Mac",
                        "Milk"
                );

        System.out.println(t);
    }
}
