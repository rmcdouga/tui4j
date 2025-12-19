package org.flatscrew.latte.input;

import java.util.List;

/**
 * Optional interface for models that expose clickable targets.
 * Latte extension; no Bubble Tea equivalent.
 */
public interface MouseTargetProvider {
    List<MouseTarget> mouseTargets();
}
