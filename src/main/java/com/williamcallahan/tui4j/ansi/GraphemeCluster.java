package com.williamcallahan.tui4j.ansi;

import com.williamcallahan.tui4j.compat.x.ansi.Method;

import java.util.Arrays;

/**
 * Grapheme cluster parsing utilities for Unicode text segmentation.
 * <p>
 * Delegates to charmbracelet/x ansi/width.go grapheme cluster implementation.
 *
 * @see <a href="https://github.com/charmbracelet/x/blob/main/ansi/width.go">x/ansi/width.go</a>
 */
public class GraphemeCluster {

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
