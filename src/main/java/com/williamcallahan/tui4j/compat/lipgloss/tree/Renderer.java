package com.williamcallahan.tui4j.compat.lipgloss.tree;

import com.williamcallahan.tui4j.compat.lipgloss.Position;
import com.williamcallahan.tui4j.compat.lipgloss.Size;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.join.HorizontalJoinDecorator;
import com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator;

import java.util.LinkedList;
import java.util.List;

/**
 * Tree structure renderer.
 * <p>
 * Port of `lipgloss/tree`.
 * Handles the visual hierarchy, indentation, and joining of tree nodes.
 * <p>
 * Lipgloss: tree/renderer.go.
 */
public class Renderer {
    private TreeStyle style;
    private TreeEnumerator enumerator;
    private TreeIndenter indenter;

    /**
     * Creates Renderer to keep this component ready for use.
     */
    public Renderer() {
        this.style = new TreeStyle();
        this.enumerator = new TreeEnumerator.DefaultEnumerator();
        this.indenter = new TreeIndenter.DefaultIndenter();
    }

    /**
     * Handles render for this component.
     *
     * @param node node
     * @param root root
     * @param prefix prefix
     * @return result
     */
    public String render(Node node, boolean root, String prefix) {
        if (node.isHidden()) {
            return "";
        }

        List<String> strings = new LinkedList<>();
        int maxLength = 0;

        Children allChildren = node.children();
        Children children = new Filter(allChildren).filter(i -> !allChildren.at(i).isHidden());
        String name = node.value();

        // Print root node name if not empty
        if (name != null && !name.isEmpty() && root) {
            strings.add(style.rootStyle().render(name));
        }

        // First pass: calculate max prefix length
        for (int i = 0; i < children.length(); i++) {
            String currentPrefix = enumerator.enumerate(children, i);
            currentPrefix = style.enumeratorFunction().apply(children, i).render(currentPrefix);
            maxLength = Math.max(Size.width(currentPrefix), maxLength);
        }

        // Second pass: render nodes
        for (int i = 0; i < children.length(); i++) {
            Node child = children.at(i);

            String indent = indenter.indent(children, i);
            String nodePrefix = enumerator.enumerate(children, i);
            Style enumStyle = style.enumeratorFunction().apply(children, i);
            Style itemStyle = style.itemFunction().apply(children, i);

            nodePrefix = enumStyle.render(nodePrefix);
            int l = maxLength - Size.width(nodePrefix);
            if (l > 0) {
                nodePrefix = " ".repeat(l) + nodePrefix;
            }

            String item = itemStyle.render(child.value());
            String multiLinePrefix = prefix;

            // Handle multiline items
            while (Size.height(item) > Size.height(nodePrefix)) {
                nodePrefix = VerticalJoinDecorator.joinVertical(
                        Position.Left,
                        nodePrefix,
                        enumStyle.render(indent)
                );
            }

            // Ensure prefix heights match
            while (Size.height(nodePrefix) > Size.height(multiLinePrefix)) {
                multiLinePrefix = VerticalJoinDecorator.joinVertical(
                        Position.Left,
                        multiLinePrefix,
                        prefix
                );
            }

            // Join all parts horizontally
            strings.add(HorizontalJoinDecorator.joinHorizontal(
                    Position.Top,
                    multiLinePrefix,
                    nodePrefix,
                    item
            ));

            // Render children
            if (children.length() > 0) {
                Renderer newRenderer = this;
                if (child instanceof Tree tree && tree.renderer() != null) {
                    newRenderer = tree.renderer();
                }

                String rendered = newRenderer.render(
                        child,
                        false,
                        prefix + enumStyle.render(indent)
                );

                if (!rendered.isEmpty()) {
                    strings.add(rendered);
                }
            }
        }
        return String.join("\n", strings);
    }

    /**
     * Handles style for this component.
     *
     * @return result
     */
    public TreeStyle style() {
        return style;
    }

    /**
     * Updates the enumerator.
     *
     * @param enumerator enumerator
     */
    public void setEnumerator(TreeEnumerator enumerator) {
        this.enumerator = enumerator;
    }

    /**
     * Updates the indenter.
     *
     * @param indenter indenter
     */
    public void setIndenter(TreeIndenter indenter) {
        this.indenter = indenter;
    }
}
