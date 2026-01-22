package com.williamcallahan.tui4j.compat.bubbletea.bubbles.textarea;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.cursor.Cursor;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class Textarea extends com.williamcallahan.tui4j.compat.bubbles.textarea.Textarea {

    @Deprecated(since = "0.3.0")
    public Textarea() {
        super();
    }

    @Deprecated(since = "0.3.0")
    public Textarea(String placeholder) {
        super(placeholder);
    }

    @Deprecated(since = "0.3.0")
    public Textarea(String placeholder, int width, int height) {
        super(placeholder, width, height);
    }

    @Deprecated(since = "0.3.0")
    public Textarea(String placeholder, int width, int height, int charLimit) {
        super(placeholder, width, height, charLimit);
    }

}
