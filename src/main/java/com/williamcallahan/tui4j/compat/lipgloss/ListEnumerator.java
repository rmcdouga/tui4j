package com.williamcallahan.tui4j.compat.lipgloss;

import com.williamcallahan.tui4j.compat.lipgloss.tree.TreeEnumerator;

/**
 * Port of Lip Gloss list enumerator.
 * Lip Gloss: lipgloss/list/enumerator.go
 */
public interface ListEnumerator {

    /** Length of the alphabet for enumeration calculations. */
    int abcLen = 26;

    /**
     * Returns an enumerator using alphabetic labels (A., B., ..., AA., AB., ...).
     *
     * @return alphabetic enumerator
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
     * Returns an enumerator using Arabic numerals (1., 2., 3., ...).
     *
     * @return arabic numeral enumerator
     */
    static TreeEnumerator arabic() {
        return (children, index) -> String.format("%d.", index + 1);
    }

    /**
     * Returns an enumerator using Roman numerals (I., II., III., IV., ...).
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
     * Returns an enumerator using bullet points (•).
     *
     * @return bullet enumerator
     */
    static TreeEnumerator bullet() {
        return (children, index) -> "•";
    }

    /**
     * Returns an enumerator using asterisks (*).
     *
     * @return asterisk enumerator
     */
    static TreeEnumerator asterisk() {
        return (children, index) -> "*";
    }

    /**
     * Returns an enumerator using dashes (-).
     *
     * @return dash enumerator
     */
    static TreeEnumerator dash() {
        return (children, index) -> "-";
    }
}
