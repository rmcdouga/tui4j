package com.williamcallahan.tui4j.compat.bubbletea.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.ansi.Truncate;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Position;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Size;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.Style;
import com.williamcallahan.tui4j.compat.bubbletea.lipgloss.join.VerticalJoinDecorator;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.QuitMessage;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.help.Help;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.help.KeyMap;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator.Paginator;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.paginator.Type;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner.Spinner;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner.SpinnerType;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.spinner.TickMessage;
import com.williamcallahan.tui4j.compat.bubbletea.bubbles.textinput.TextInput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.stream.Stream;
import static com.williamcallahan.tui4j.compat.bubbletea.Command.batch;
import static com.williamcallahan.tui4j.compat.bubbletea.bubbles.list.DefaultItemStyles.ELLIPSIS;

/**
 * @deprecated Deprecated in tui4j as of 0.3.0 because this type moved; use {@link com.williamcallahan.tui4j.compat.bubbles.list.List} instead.
 * This transitional shim is temporary and will be removed in an upcoming release.
 */
@Deprecated(since = "0.3.0")
public class List extends com.williamcallahan.tui4j.compat.bubbles.list.List {

    @Deprecated(since = "0.3.0")
    public List(Item[] items, int width, int height) {
        super(items, width, height);
    }

    @Deprecated(since = "0.3.0")
    public List(Item[] items, ItemDelegate delegate, int width, int height) {
        super(items, delegate, width, height);
    }

    @Deprecated(since = "0.3.0")
    public List(ListDataSource dataSource, ItemDelegate delegate, int width, int height) {
        super(dataSource, delegate, width, height);
    }

    @Deprecated(since = "0.3.0")
    public List(ListDataSource dataSource, int width, int height) {
        super(dataSource, width, height);
    }

}
