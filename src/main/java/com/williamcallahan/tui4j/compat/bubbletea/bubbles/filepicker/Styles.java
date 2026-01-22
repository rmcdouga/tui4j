package com.williamcallahan.tui4j.compat.bubbletea.bubbles.filepicker;

import com.williamcallahan.tui4j.compat.lipgloss.Position;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;

/**
 * @deprecated Compatibility shim for relocated type; use {@link com.williamcallahan.tui4j.compat.bubbles.filepicker.Styles} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 * <p>
 * Bubbles: filepicker/filepicker.go.
 */
@Deprecated(since = "0.3.0", forRemoval = true)
public class Styles extends com.williamcallahan.tui4j.compat.bubbles.filepicker.Styles {
    
    private static final int FILE_SIZE_WIDTH = 7;
    private static final int PADDING_LEFT = 2;

    /**
     * Handles default styles for this component.
     *
     * @return result
     */
    public static Styles defaultStyles() {
        Styles styles = new Styles();
        styles.setDisabledCursor(Style.newStyle().foreground(Color.color("247")));
        styles.setCursor(Style.newStyle().foreground(Color.color("212")));
        styles.setSymlink(Style.newStyle().foreground(Color.color("36")));
        styles.setDirectory(Style.newStyle().foreground(Color.color("99")));
        styles.setFile(Style.newStyle());
        styles.setDisabledFile(Style.newStyle().foreground(Color.color("243")));
        styles.setPermission(Style.newStyle().foreground(Color.color("244")));
        styles.setSelected(Style.newStyle().foreground(Color.color("212")).bold(true));
        styles.setDisabledSelected(Style.newStyle().foreground(Color.color("247")));
        styles.setFileSize(Style.newStyle().foreground(Color.color("240")).width(FILE_SIZE_WIDTH));
        styles.fileSize().align(Position.Right);
        styles.setEmptyDirectory(Style.newStyle()
                .foreground(Color.color("240"))
                .paddingLeft(PADDING_LEFT)
                .setString("Bummer. No Files Found."));
        return styles;
    }
}
