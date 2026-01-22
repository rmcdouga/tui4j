package com.williamcallahan.tui4j.examples.compat.bubbles.help;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.Program;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.QuitMessage;
import com.williamcallahan.tui4j.compat.bubbletea.WindowSizeMessage;
import com.williamcallahan.tui4j.compat.bubbles.help.Help;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding.BindingOption;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.color.Color;

/**
 * Example program demonstrating help component.
 * <p>
 * Shows a help menu that toggles between short and full help views.
 *
 * @see <a href="https://github.com/charmbracelet/bubbletea/blob/main/examples/help/main.go">bubbletea/examples/help</a>
 */
public class HelpExample implements Model {

    private final Help help = new Help();
    private final Style inputStyle = Style.newStyle().foreground(Color.color("#FF75B7"));

    private Binding upBinding = Binding.create(new BindingOption.WithKeys("up", "k"), new BindingOption.WithHelp("↑/k", "move up"));
    private Binding downBinding = Binding.create(new BindingOption.WithKeys("down", "j"), new BindingOption.WithHelp("↓/j", "move down"));
    private Binding leftBinding = Binding.create(new BindingOption.WithKeys("left", "h"), new BindingOption.WithHelp("←/h", "move left"));
    private Binding rightBinding = Binding.create(new BindingOption.WithKeys("right", "l"), new BindingOption.WithHelp("→/l", "move right"));
    private Binding helpBinding = Binding.create(new BindingOption.WithKeys("?"), new BindingOption.WithHelp("?", "toggle help"));
    private Binding quitBinding = Binding.create(new BindingOption.WithKeys("q", "esc", "ctrl+c"), new BindingOption.WithHelp("q", "quit"));

    private String lastKey;
    private boolean quitting;

    /**
     * Supplies the initial command for the model.
     *
     * @return initial command
     */
    @Override
    public Command init() {
        return null;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
    @Override
    public UpdateResult<? extends Model> update(Message msg) {
        if (msg instanceof WindowSizeMessage windowSizeMessage) {
            help.setWidth(windowSizeMessage.width());
            return UpdateResult.from(this);
        }

        if (msg instanceof KeyPressMessage keyPressMessage) {
            String key = keyPressMessage.key();

            switch (key) {
                case "up", "k" -> {
                    lastKey = "↑";
                    return UpdateResult.from(this);
                }
                case "down", "j" -> {
                    lastKey = "↓";
                    return UpdateResult.from(this);
                }
                case "left", "h" -> {
                    lastKey = "←";
                    return UpdateResult.from(this);
                }
                case "right", "l" -> {
                    lastKey = "→";
                    return UpdateResult.from(this);
                }
                case "?" -> {
                    help.setShowAll(!help.showAll());
                    return UpdateResult.from(this);
                }
                case "q", "ctrl+c", "esc" -> {
                    quitting = true;
                    return UpdateResult.from(this, QuitMessage::new);
                }
                default -> {
                    return UpdateResult.from(this);
                }
            }
        }

        return UpdateResult.from(this);
    }

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    @Override
    public String view() {
        if (quitting) {
            return "Bye!\n";
        }

        String status;
        if (lastKey == null || lastKey.isEmpty()) {
            status = "Waiting for input...";
        } else {
            status = "You chose: " + inputStyle.render(lastKey);
        }

        String helpView = help.view(java.util.List.of(
                upBinding, downBinding, leftBinding, rightBinding,
                helpBinding, quitBinding
        ));

        int newlines = 8 - status.lines().count() - helpView.lines().count();
        String padding = "\n".repeat(Math.max(0, newlines));

        return "\n" + status + padding + helpView;
    }

    /**
     * Runs the example program.
     *
     * @param args args
     */
    public static void main(String[] args) {
        new Program(new HelpExample()).run();
    }
}
