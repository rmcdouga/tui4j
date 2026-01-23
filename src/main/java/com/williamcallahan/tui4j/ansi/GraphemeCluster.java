package com.williamcallahan.tui4j.ansi;

import com.williamcallahan.tui4j.compat.x.ansi.Method;

import java.util.Arrays;

/**
 * Grapheme cluster parsing utilities.
 * Delegates to the x/ansi grapheme implementation for parity.
 */
public class GraphemeCluster {

    /**
     * Returns the first grapheme cluster starting at the given byte offset.
     *
     * @param bytes UTF-8 bytes to scan
     * @param startIndex start offset into {@code bytes}
     * @param state parser state
     * @return grapheme result or {@code null} when no cluster is found
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
     * Creates a grapheme cluster helper.
     */
    public GraphemeCluster() {
    }

    /**
     * Holds the parsed grapheme cluster and remaining bytes.
     *
     * @param cluster grapheme cluster bytes
     * @param rest remaining bytes after the cluster
     * @param width display width for the cluster
     * @param newState next parser state
     */
    public record GraphemeResult(byte[] cluster, byte[] rest, int width, int newState) {
    }
}
