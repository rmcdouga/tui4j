package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator;

/**
 * Port of Lip Gloss list enumerators.
 * Upstream: lipgloss/list/enumerator.go
 */
public interface ListEnumerator {

    /**
     * Length of the Latin alphabet for enumerator calculations.
     */
    int abcLen = 26;

    /**
     * Returns an A, B, C style enumerator.
     *
     * @return alphabet enumerator
     */
    static TreeEnumerator alphabet() {
        return (children, index) -> {
            if (index >= abcLen * abcLen + abcLen) {
                return String.format("%c%c%c.", 'A' + index / abcLen / abcLen - 1, 'A' + (index / abcLen) % abcLen - 1, 'A' + index % abcLen);
            }
            if (index >= abcLen) {
                return String.format("%c%c.", 'A' + index / abcLen - 1, 'A' + (index) % abcLen);
            }
            return String.format("%c.", 'A' + index % abcLen);
        };
    }

    /**
     * Returns a numeric enumerator.
     *
     * @return arabic numeral enumerator
     */
    static TreeEnumerator arabic() {
        return (children, index) -> String.format("%d.", index + 1);
    }

    /**
     * Returns a Roman numeral enumerator.
     *
     * @return roman numeral enumerator
     */
    static TreeEnumerator roman() {
        return (children, index) -> {
            String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] arabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

            StringBuilder result = new StringBuilder();
            int i = index;
            for (int v = 0; v < arabic.length; v++) {
                int value = arabic[v];

                while (i >= value - 1) {
                    i -= value;
                    result.append(roman[v]);
                }
            }
            return result.append('.').toString();
        };
    }

    /**
     * Returns a bullet enumerator.
     *
     * @return bullet enumerator
     */
    static TreeEnumerator bullet() {
        return (children, index) -> "•";
    }

    /**
     * Returns an asterisk enumerator.
     *
     * @return asterisk enumerator
     */
    static TreeEnumerator asterisk() {
        return (children, index) -> "*";
    }

    /**
     * Returns a dash enumerator.
     *
     * @return dash enumerator
     */
    static TreeEnumerator dash() {
        return (children, index) -> "-";
    }
}
