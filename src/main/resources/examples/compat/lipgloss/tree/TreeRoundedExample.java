package com.williamcallahan.tui4j.examples.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.lipgloss.Tree;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;
import com.williamcallahan.tui4j.compat.lipgloss.tree.Enumerator;

/**
 * Example program demonstrating lipgloss tree component.
 * <p>
 * Shows a nested tree structure with rounded enumerator for tree nodes.
 *
 * @see <a href="https://github.com/charmbracelet/lipgloss/blob/main/examples/tree/rounded/main.go">lipgloss/examples/tree</a>
 */
public class TreeRoundedExample {

    /**
     * Runs the example to render a tree with rounded enumerators.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Style itemStyle = Style.newStyle().marginRight(1);
        Style enumeratorStyle = Style.newStyle().foreground(Color.color("8")).marginRight(1);

        Tree t = Tree.root("Groceries")
                .child(
                        Tree.root("Fruits")
                                .child("Blood Orange", "Papaya", "Dragonfruit", "Yuzu"),
                        Tree.root("Items")
                                .child("Cat Food", "Nutella", "Powdered Sugar"),
                        Tree.root("Veggies")
                                .child("Leek", "Artichoke")
                )
                .itemStyle(itemStyle)
                .enumeratorStyle(enumeratorStyle)
                .enumerator(Enumerator.ROUNDED);

        System.out.println(t);
    }
}
