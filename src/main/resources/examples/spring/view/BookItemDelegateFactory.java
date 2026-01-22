package examples.spring.view;

import com.williamcallahan.tui4j.compat.bubbles.help.KeyMap;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbles.list.DefaultDelegate;
import org.springframework.stereotype.Component;

/**
 * Example program for book item delegate factory.
 * tui4j: examples/spring/src/main/java/com/williamcallahan/tui4j/springexample/view/BookItemDelegateFactory.java
 */
@Component
public class BookItemDelegateFactory {

    /**
     * Support type for the Spring example.
     */
    public static class DelegateKeyMap implements KeyMap {

        private final Binding remove;
        private final Binding choose;

        /**
         * Creates DelegateKeyMap to keep example ready for use.
         */
        public DelegateKeyMap() {
            this.remove = new Binding(
                    Binding.withKeys("x"),
                    Binding.withHelp("x", "delete")
            );
            this.choose = new Binding(
                    Binding.withKeys("enter"),
                    Binding.withHelp("enter", "choose")
            );
        }

        /**
         * Handles short help for example.
         *
         * @return result
         */
        @Override
        public Binding[] shortHelp() {
            return new Binding[]{
                    choose,
                    remove
            };
        }

        /**
         * Handles full help for example.
         *
         * @return result
         */
        @Override
        public Binding[][] fullHelp() {
            return new Binding[][]{
                    new Binding[]{remove, choose}
            };
        }

        /**
         * Handles remove for example.
         *
         * @return result
         */
        public Binding remove() {
            return remove;
        }

        /**
         * Handles choose for example.
         *
         * @return result
         */
        public Binding choose() {
            return choose;
        }
    }

    /**
     * Handles new bok item delegate for example.
     *
     * @param keyMap key map
     * @return result
     */
    public DefaultDelegate newBokItemDelegate(DelegateKeyMap keyMap) {
        DefaultDelegate defaultDelegate = new DefaultDelegate();
        defaultDelegate.setShortHelpFunc(keyMap::shortHelp);
        defaultDelegate.setFullHelpFunc(keyMap::fullHelp);
        return defaultDelegate;
    }
}
