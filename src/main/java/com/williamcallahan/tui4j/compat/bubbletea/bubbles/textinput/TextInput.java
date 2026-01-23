package com.williamcallahan.tui4j.compat.bubbletea.bubbles.textinput;

import com.ibm.icu.lang.UCharacter;
import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Size;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.color.Color;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbles.cursor.Cursor;
import com.williamcallahan.tui4j.compat.bubbles.cursor.CursorMode;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.runeutil.Sanitizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static java.lang.Math.clamp;
import static com.williamcallahan.tui4j.compat.bubbletea.Command.batch;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class TextInput extends com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput {

    /**
     * Creates a text input with default settings.
     *
     * @deprecated Use {@link com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput#TextInput()} instead.
     */
    @Deprecated(since = "0.3.0")
    public TextInput() {
        super();
    }

}
