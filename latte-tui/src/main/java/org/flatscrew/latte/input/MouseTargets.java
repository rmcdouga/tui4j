package org.flatscrew.latte.input;

import java.util.Comparator;
import java.util.List;

/**
 * Utility functions for resolving mouse targets.
 * Latte extension; no Bubble Tea equivalent.
 */
public final class MouseTargets {
    private MouseTargets() {
    }

    public static MouseTarget hitTest(List<MouseTarget> targets, int column, int row) {
        if (targets == null || targets.isEmpty()) {
            return null;
        }
        return targets.stream()
                .filter(target -> target != null && target.contains(column, row))
                .max(Comparator.comparingInt(MouseTarget::zIndex))
                .orElse(null);
    }
}
