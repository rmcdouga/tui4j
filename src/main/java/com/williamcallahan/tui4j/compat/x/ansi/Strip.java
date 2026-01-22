package com.williamcallahan.tui4j.compat.x.ansi;

import com.williamcallahan.tui4j.compat.x.ansi.parser.Action;
import com.williamcallahan.tui4j.compat.x.ansi.parser.State;
import com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * ANSI escape code stripping.
 * Port of github.com/charmbracelet/x/ansi (width.go Strip function)
 */
public final class Strip {
    /**
     * Creates Strip to keep this component ready for use.
     */
    private Strip() {}

    /**
     * Removes all ANSI escape codes from a string.
     *
     * @param s the input string (must not be null)
     * @return the string with ANSI codes removed
     * @throws NullPointerException if s is null
     */
    public static String strip(String s) {
        Objects.requireNonNull(s, "s");
        if (s.isEmpty()) {
            return s;
        }

        TransitionTable table = TransitionTable.get();
        State pstate = State.GROUND;
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);

        ByteArrayOutputStream out = new ByteArrayOutputStream(bytes.length);
        int ri = 0; // rune index within UTF-8 sequence
        int rw = 0; // rune width (bytes remaining)

        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];

            if (pstate == State.UTF8) {
                // Collecting UTF-8 bytes
                out.write(b);
                ri++;
                if (ri < rw) {
                    continue;
                }
                pstate = State.GROUND;
                ri = 0;
                rw = 0;
                continue;
            }

            TransitionTable.Transition transition = table.transition(pstate, b);
            State state = transition.state();
            Action action = transition.action();

            switch (action) {
                case COLLECT:
                    if (state == State.UTF8) {
                        // Starting UTF-8 sequence
                        rw = Ansi.utf8ByteLength(b);
                        out.write(b);
                        ri++;
                    }
                    break;
                case PRINT:
                case EXECUTE:
                    // Include printable and execute characters
                    out.write(b);
                    break;
                default:
                    // Skip ANSI sequences
                    break;
            }

            if (pstate != State.UTF8) {
                pstate = state;
            }
        }

        return out.toString(StandardCharsets.UTF_8);
    }
}
