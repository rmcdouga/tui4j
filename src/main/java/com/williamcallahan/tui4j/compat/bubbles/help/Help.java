package com.williamcallahan.tui4j.compat.bubbles.help;

import com.williamcallahan.tui4j.compat.lipgloss.Position;
import com.williamcallahan.tui4j.compat.lipgloss.Size;
import com.williamcallahan.tui4j.compat.lipgloss.join.HorizontalJoinDecorator;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

import java.util.LinkedList;
import java.util.List;

/**
 * Component for rendering keyboard shortcut help text.
 * <p>
 * Port of charmbracelet/bubbles help/help.go.
 *
 * @see <a href="https://github.com/charmbracelet/bubbles/blob/main/help/help.go">bubbles/help/help.go</a>
 */
public class Help {

    private int width;
    private boolean showAll;

    private String shortSeparator;
    private String fullSeparator;
    private String ellipsis;
    private Styles styles;

    /** Creates a new help component with default settings. */
    public Help() {
        this.shortSeparator = " • ";
        this.fullSeparator = "    ";
        this.ellipsis = "…";

        this.styles = new Styles();
    }

    /**
     * Sets the maximum width for the help text.
     *
     * @param width the width in characters
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Renders the help text for the given key map.
     *
     * @param keyMap the key map to render
     * @return the rendered help string
     */
    public String render(KeyMap keyMap) {
        if (showAll) {
            return fullHelpView(keyMap.fullHelp());
        }
        return shortHelpView(keyMap.shortHelp());
    }

    private String fullHelpView(Binding[][] groups) {
        if (groups.length == 0) {
            return "";
        }

        List<String> out = new LinkedList<>();
        int totalWidth = 0;
        String separator = styles.getShortSeparator().copy().inline(true).render(fullSeparator);

        for (int i = 0; i < groups.length; i++) {
            Binding[] group = groups[i];
            if (group == null || !shouldRenderColumn(group)) {
                continue;
            }

            String sep = "";
            List<String> keys = new LinkedList<>();
            List<String> descriptions = new LinkedList<>();

            if (totalWidth > 0 && i < groups.length) {
                sep = separator;
            }

            for (Binding binding : group) {
                if (!binding.isEnabled()) {
                    continue;
                }

                keys.add(binding.help().key());
                descriptions.add(binding.help().desc());
            }

            // Column
            String col = HorizontalJoinDecorator.joinHorizontal(
                    Position.Top,
                    sep,
                    styles.getFullKey().render(String.join("\n", keys)),
                    " ",
                    styles.getFullDesc().render(String.join("\n", descriptions))
            );
            int w = Size.width(col);

            // Tail
            Result result = shouldAddItem(totalWidth, w);
            if (!result.ok()) {
                if (!"".equals(result.tail())) {
                    out.add(result.tail());
                }
                break;
            }
            totalWidth += w;
            out.add(col);
        }
        return HorizontalJoinDecorator.joinHorizontal(
                Position.Top,
                out.toArray(new String[0])
        );
    }

    private boolean shouldRenderColumn(Binding[] group) {
        for (Binding binding : group) {
            if (binding.isEnabled()) {
                return true;
            }
        }
        return false;
    }

    private String shortHelpView(Binding[] bindings) {
        if (bindings == null || bindings.length == 0) {
            return "";
        }

        StringBuilder b = new StringBuilder();
        int totalWidth = 0;
        String separator = styles.getShortSeparator().inline(true).render(shortSeparator);

        for (int i = 0; i < bindings.length; i++) {
            Binding kb = bindings[i];
            if (!kb.isEnabled()) {
                continue;
            }

            // Sep
            String sep = "";
            if (totalWidth > 0 && i < bindings.length) {
                sep = separator;
            }

            // Item
            String str = sep +
                    styles.getShortKey().inline(true).render(kb.help().key()) + " " +
                    styles.getShortDesc().inline(true).render(kb.help().desc());
            int w = Size.width(str);

            // Tail
            Result result = shouldAddItem(totalWidth, w);
            if (!result.ok()) {
                if (!"".equals(result.tail())) {
                    b.append(result.tail());
                }
                break;
            }

            totalWidth += w;
            b.append(str);
        }

        return b.toString();
    }

    private Result shouldAddItem(int totalWidth, int width) {
        String tail = "";
        if (this.width > 0 && totalWidth+width > this.width) {
            tail = " " + styles.getEllipsis().copy().inline(true).render(this.ellipsis);
            if (totalWidth + Size.width(tail) < this.width) {
                return new Result(false, tail);
            }
        }
        return new Result(true, "");
    }

    /**
     * Sets the separator used between items in full help view.
     *
     * @param fullSeparator the separator string
     */
    public void setFullSeparator(String fullSeparator) {
        this.fullSeparator = fullSeparator;
    }

    /**
     * Sets whether to show full or short help.
     *
     * @param showAll true for full help, false for short help
     */
    public void setShowAll(boolean showAll) {
        this.showAll = showAll;
    }

    /**
     * Returns whether full help is being shown.
     *
     * @return true if full help is shown
     */
    public boolean showAll() {
        return showAll;
    }
    record Result(boolean ok, String tail) {


    }
}
