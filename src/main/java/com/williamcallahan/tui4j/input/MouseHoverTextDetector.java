package com.williamcallahan.tui4j.input;

import com.williamcallahan.tui4j.ansi.GraphemeCluster;
import com.williamcallahan.tui4j.ansi.TextWidth;
import com.williamcallahan.tui4j.compat.x.ansi.parser.Action;
import com.williamcallahan.tui4j.compat.x.ansi.parser.State;
import com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable;
import com.williamcallahan.tui4j.compat.x.ansi.parser.TransitionTable.Transition;

import java.nio.charset.StandardCharsets;

/**
 * Detects whether the mouse cursor is hovering over text (non-whitespace) in a terminal view.
 * <p>
 * Uses an ANSI state machine to parse each line, tracking which display cells contain
 * visible text vs whitespace. Results are cached per-line for efficient repeated queries.
 * <p>
 * tui4j extension; no Bubble Tea equivalent.
 */
public final class MouseHoverTextDetector {

    private String cachedView = "";
    private String[] cachedLines = new String[0];
    private LineCache[] lineCaches = new LineCache[0];

    /**
     * Creates MouseHoverTextDetector to keep this component ready for use.
     */
    public MouseHoverTextDetector() {
    }

    /**
     * Returns true if the given (column, row) is over a non-whitespace cell.
     *
     * @param view   the rendered view string
     * @param column column coordinate (0-based)
     * @param row    row coordinate (0-based)
     * @return true if hovering over text, false otherwise
     */
    public boolean isHoveringText(String view, int column, int row) {
        if (view == null || view.isEmpty()) {
            return false;
        }
        if (!view.equals(cachedView)) {
            cachedView = view;
            cachedLines = view.split("\n", -1);
            lineCaches = new LineCache[cachedLines.length];
        }

        if (row < 0 || row >= cachedLines.length) {
            return false;
        }

        String line = cachedLines[row];
        LineCache cache = lineCaches[row];
        if (cache == null || !cache.line.equals(line)) {
            cache = new LineCache(line, buildTextCells(line));
            lineCaches[row] = cache;
        }

        return cache.isTextAt(column);
    }

    /**
     * Builds a boolean array indicating which display cells contain text (non-whitespace).
     */
    private boolean[] buildTextCells(String line) {
        int width = TextWidth.measureCellWidth(line);
        if (width <= 0) {
            return new boolean[0];
        }

        CellBuilder builder = new CellBuilder(width, line.getBytes(StandardCharsets.UTF_8));
        return builder.build();
    }

    /**
     * Checks if a grapheme cluster consists entirely of whitespace.
     */
    private static boolean isWhitespaceCluster(byte[] cluster) {
        if (cluster.length == 0) {
            return false;
        }
        String text = new String(cluster, StandardCharsets.UTF_8);
        int index = 0;
        while (index < text.length()) {
            int codePoint = text.codePointAt(index);
            if (!Character.isWhitespace(codePoint)) {
                return false;
            }
            index += Character.charCount(codePoint);
        }
        return true;
    }

    /**
     * Encapsulates the state machine logic for building text cell flags.
     */
    private static final class CellBuilder {
        private final boolean[] cells;
        private final byte[] bytes;
        private final int width;

        private State state = State.GROUND;
        private int cellIndex = 0;
        private int byteIndex = 0;

        /**
         * Creates CellBuilder to keep this component ready for use.
         *
         * @param width width
         * @param bytes bytes
         */
        CellBuilder(int width, byte[] bytes) {
            this.width = width;
            this.cells = new boolean[width];
            this.bytes = bytes;
        }

        /**
         * Builds the result for this component.
         *
         * @return result
         */
        boolean[] build() {
            TransitionTable table = TransitionTable.get();

            while (byteIndex < bytes.length && cellIndex < width) {
                Transition transition = table.transition(state, bytes[byteIndex]);
                State nextState = transition.state();
                Action action = transition.action();

                if (nextState == State.UTF8) {
                    processUtf8Grapheme();
                    state = State.GROUND;
                } else if (action == Action.PRINT) {
                    processPrintableChar();
                    state = nextState;
                    byteIndex++;
                } else {
                    state = nextState;
                    byteIndex++;
                }
            }

            return cells;
        }

        /**
         * Handles process utf8 grapheme for this component.
         */
        private void processUtf8Grapheme() {
            GraphemeCluster.GraphemeResult result =
                GraphemeCluster.getFirstGraphemeCluster(bytes, byteIndex, -1);

            if (result == null) {
                byteIndex++;
                return;
            }

            byte[] cluster = result.cluster();
            int cellWidth = result.width();
            boolean isText = !isWhitespaceCluster(cluster);

            for (int j = 0; j < cellWidth && cellIndex + j < width; j++) {
                cells[cellIndex + j] = isText;
            }

            cellIndex += cellWidth;
            byteIndex += cluster.length;
        }

        /**
         * Handles process printable char for this component.
         */
        private void processPrintableChar() {
            char ch = (char) (bytes[byteIndex] & 0xFF);
            cells[cellIndex] = !Character.isWhitespace(ch);
            cellIndex++;
        }
    }

    /**
     * Caches the text-cell analysis for a single line.
     */
    private static final class LineCache {
        private final String line;
        private final boolean[] textCells;

        /**
         * Creates LineCache to keep this component ready for use.
         *
         * @param line line
         * @param textCells text cells
         */
        LineCache(String line, boolean[] textCells) {
            this.line = line;
            this.textCells = textCells;
        }

        /**
         * Reports whether text at.
         *
         * @param column column
         * @return whether text at
         */
        boolean isTextAt(int column) {
            return column >= 0 && column < textCells.length && textCells[column];
        }
    }
}
