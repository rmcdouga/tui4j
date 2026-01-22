package com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;
import java.time.LocalDateTime;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.spinner.Spinner} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Spinner extends com.williamcallahan.tui4j.compat.bubbles.spinner.Spinner {

    @Deprecated(since = "0.3.0")
    public Spinner(SpinnerType type) {
        super(type);
    }

}
