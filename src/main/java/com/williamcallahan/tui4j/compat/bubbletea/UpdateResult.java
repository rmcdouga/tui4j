package com.williamcallahan.tui4j.compat.bubbletea;

/**
 * Pairs an updated model with an optional command.
 * tui4j: src/main/java/com/williamcallahan/tui4j/compat/bubbletea/UpdateResult.java
 *
 * @param <M> model type
 * @param model updated model
 * @param command optional command
 * <p>
 * Bubble Tea: tea.go.
 */
public record UpdateResult<M extends Model>(M model, Command command) {

    /**
     * Handles from for this component.
     *
     * @param <M> model type
     * @param model model
     * @param cmd cmd
     * @return result
     */
    public static <M extends Model> UpdateResult<M> from(M model, Command cmd) {
        return new UpdateResult<>(model, cmd);
    }

    /**
     * Handles from for this component.
     *
     * @param <M> model type
     * @param model model
     * @return result
     */
    public static <M extends Model> UpdateResult<M> from(M model) {
        return UpdateResult.from(model, null);
    }
}
