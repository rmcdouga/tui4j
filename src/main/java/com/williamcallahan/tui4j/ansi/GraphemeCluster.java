package com.williamcallahan.tui4j.ansi;

import com.williamcallahan.tui4j.compat.x.ansi.Method;

import java.util.Arrays;

/**
 * Grapheme cluster parsing utilities for Unicode text segmentation.
 * <p>
 * This class wraps the canonical grapheme cluster implementation with tui4j-specific
 * parsing logic that tracks parser state between clusters and returns remaining byte data.
 * <p>
 * <b>Difference from canonical port:</b>
 * <ul>
 *   <li>Returns {@code GraphemeResult} with {@code rest} (remaining bytes after cluster)</li>
 *   <li>Tracks parser state transitions (UTF8 ↔ GROUND) between grapheme clusters</li>
 *   <li>Uses legacy {@code ansi.State} enum for compatibility</li>
 * </ul>
 * <p>
 * <b>Canonical port:</b> {@link com.williamcallahan.tui4j.compat.x.ansi.GraphemeCluster}
 * Port of: <a href="https://github.com/charmbracelet/x/blob/main/ansi/width.go">x/ansi/width.go</a>
 */
public class GraphemeCluster {

    /**
     * Creates GraphemeCluster to keep this component ready for use.
     */
    private GraphemeCluster() {}

    /**
     * Extracts the first grapheme cluster starting at the given byte offset.
     *
     * @param bytes the input bytes
     * @param startIndex the starting byte index
     * @param state the current parser state
     * @return the grapheme result containing cluster bytes, remaining bytes, width, and new state
     */
    public static GraphemeResult getFirstGraphemeCluster(byte[] bytes, int startIndex, int state) {
        com.williamcallahan.tui4j.compat.x.ansi.GraphemeCluster.Result result =
                com.williamcallahan.tui4j.compat.x.ansi.GraphemeCluster.getFirstGraphemeCluster(
                        bytes, startIndex, Method.GRAPHEME_WIDTH);
        if (result == null) {
            return null;
        }

        byte[] clusterBytes = result.clusterBytes();
        byte[] restBytes = Arrays.copyOfRange(bytes, startIndex + clusterBytes.length, bytes.length);
        int newState = (state == State.UTF8.ordinal()) ? State.GROUND.ordinal() : State.UTF8.ordinal();
        return new GraphemeResult(clusterBytes, restBytes, result.width(), newState);
    }

    /**
     * Result of extracting a grapheme cluster.
     *
     * @param cluster the bytes of the grapheme cluster
     * @param rest the remaining bytes after the cluster
     * @param width the display width of the cluster in cells
     * @param newState the new parser state
     */
    public record GraphemeResult(byte[] cluster, byte[] rest, int width, int newState) {
    }
}
