package com.williamcallahan.tui4j.examples.compat.x.ansi;

import com.williamcallahan.tui4j.compat.x.ansi.StringWidth;
import com.williamcallahan.tui4j.compat.x.ansi.Method;

/**
 * Example program demonstrating Unicode string width measurement.
 * <p>
 * Demonstrates StringWidth.stringWidth() with various character types including
 * wide characters, emojis, and ANSI escape codes.
 *
 * @see <a href="https://github.com/charmbracelet/x/blob/main/ansi/width.go">x/ansi/width.go</a>
 */
public class WidthExample {

    /**
     * Runs the example program.
     *
     * @param args args
     */
    public static void main(String[] args) {
        System.out.println("=== Basic ASCII Characters ===");
        System.out.println("Width of 'Hello': " + StringWidth.stringWidth("Hello"));

        System.out.println("\n=== Wide Characters (CJK) ===");
        System.out.println("Width of '你好': " + StringWidth.stringWidth("你好"));
        System.out.println("Width of '日本語': " + StringWidth.stringWidth("日本語"));
        System.out.println("Width of '한글': " + StringWidth.stringWidth("한글"));

        System.out.println("\n=== Emojis ===");
        System.out.println("Width of '😀': " + StringWidth.stringWidth("😀"));
        System.out.println("Width of '🎉': " + StringWidth.stringWidth("🎉"));
        System.out.println("Width of '👍': " + StringWidth.stringWidth("👍"));

        System.out.println("\n=== Emoji Sequences ===");
        System.out.println("Width of '👨‍👩‍👧': " + StringWidth.stringWidth("👨‍👩‍👧"));
        System.out.println("Width of '🏴': " + StringWidth.stringWidth("🏴"));

        System.out.println("\n=== Zero-Width Characters ===");
        System.out.println("Width of 'e\u0301': " + StringWidth.stringWidth("é"));
        System.out.println("Width of 'café': " + StringWidth.stringWidth("café"));

        System.out.println("\n=== ANSI Escape Codes ===");
        String ansiText = "\u001B[31mRed\u001B[0m \u001B[1mBold\u001B[0m text";
        System.out.println("ANSI text: " + ansiText);
        System.out.println("Width (ANSI ignored): " + StringWidth.stringWidth(ansiText));

        System.out.println("\n=== Method Comparison ===");
        String emojiText = "Hello 🌍 World";
        System.out.println("Text: " + emojiText);
        System.out.println("GRAPHEME_WIDTH: " + StringWidth.stringWidth(Method.GRAPHEME_WIDTH, emojiText));
        System.out.println("WC_WIDTH: " + StringWidth.stringWidth(Method.WC_WIDTH, emojiText));

        System.out.println("\n=== Mixed Content ===");
        String mixed = "A 你好 😀 B";
        System.out.println("Mixed: " + mixed);
        System.out.println("Total width: " + StringWidth.stringWidth(mixed));
    }
}
