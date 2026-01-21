package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.BatchMessage;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.SequenceMessage;
import com.williamcallahan.tui4j.compat.lipgloss.Renderer;
import com.williamcallahan.tui4j.compat.lipgloss.color.ColorProfile;
import com.williamcallahan.tui4j.compat.lipgloss.color.NoColor;
import com.williamcallahan.tui4j.term.TerminalInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Port of github.com/charmbracelet/bubbles/list/list_test.go.
 */
class ListTest {

    @BeforeEach
    void setUp() {
        TerminalInfo.provide(() -> new TerminalInfo(false, new NoColor()));
        Renderer.defaultRenderer().setColorProfile(ColorProfile.Ascii);
    }

    @Test
    void testStatusBarItemName() {
        List list = createList(new TestItem("foo"), new TestItem("bar"));

        assertThat(statusView(list)).contains("2 items");

        updateItems(list, new TestItem("foo"));

        assertThat(statusView(list)).contains("1 item");
    }

    @Test
    void testStatusBarWithoutItems() {
        List list = createList();

        assertThat(statusView(list)).contains("No items");
    }

    @Test
    void testCustomStatusBarItemName() {
        List list = createList(new TestItem("foo"), new TestItem("bar"));
        list.setStatusBarItemName("connection", "connections");

        assertThat(statusView(list)).contains("2 connections");

        updateItems(list, new TestItem("foo"));
        assertThat(statusView(list)).contains("1 connection");

        updateItems(list);
        assertThat(statusView(list)).contains("No connections");
    }

    @Test
    void testSetFilterText() {
        List list = createList(new TestItem("foo"), new TestItem("bar"), new TestItem("baz"));

        applyCommand(list, list.setFilterText("ba"));

        applyCommand(list, list.setFilterState(FilterState.Unfiltered));
        assertThat(visibleValues(list)).containsExactly("foo", "bar", "baz");

        applyCommand(list, list.setFilterState(FilterState.Filtering));
        assertThat(visibleValues(list)).containsExactly("bar", "baz");

        applyCommand(list, list.setFilterState(FilterState.FilterApplied));
        assertThat(visibleValues(list)).containsExactly("bar", "baz");
    }

    @Test
    void testSetFilterState() {
        List list = createList(new TestItem("foo"), new TestItem("bar"), new TestItem("baz"));

        applyCommand(list, list.setFilterText("ba"));

        applyCommand(list, list.setFilterState(FilterState.Unfiltered));
        String footer = footerLine(list.view());
        assertThat(footer).contains("up").doesNotContain("clear filter");

        applyCommand(list, list.setFilterState(FilterState.Filtering));
        footer = footerLine(list.view());
        assertThat(footer).contains("cancel").doesNotContain("more");

        applyCommand(list, list.setFilterState(FilterState.FilterApplied));
        footer = footerLine(list.view());
        assertThat(footer).contains("clear");
    }

    private static List createList(Item... items) {
        // Ensure the list has enough vertical space to display all items on one page.
        List list = new List(items, new TestDelegate(), 10, 100);
        applyCommand(list, list.init(), new StepBudget());
        return list;
    }

    private static void updateItems(List list, Item... items) {
        DefaultDataSource dataSource = (DefaultDataSource) list.dataSource();
        applyCommand(list, dataSource.setItems(items), new StepBudget());
    }

    private static void applyCommand(List list, Command command) {
        if (command == null) {
            return;
        }
        applyCommand(list, command, new StepBudget());
    }

    private static void applyCommand(List list, Command command, StepBudget budget) {
        if (command == null || !budget.consume()) {
            return;
        }
        applyMessage(list, executeCommand(command), budget);
    }

    private static Message executeCommand(Command command) {
        // Some Bubble Tea commands are time-based (tick) and will block; unit tests should not.
        FutureTask<Message> task = new FutureTask<>(command::execute);
        Thread t = new Thread(task, "tui4j-test-command");
        t.setDaemon(true);
        t.start();

        try {
            return task.get(50, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            task.cancel(true);
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void applyMessage(List list, Message msg, StepBudget budget) {
        if (msg == null || !budget.consume()) {
            return;
        }

        // Avoid infinite spinner ticks in unit tests (they're time-based in real programs).
        if (msg instanceof com.williamcallahan.tui4j.compat.bubbles.spinner.TickMessage) {
            return;
        }

        // Bubble Tea: Program handles Batch/Sequence by executing nested commands.
        if (msg instanceof BatchMessage batchMessage) {
            for (Command c : batchMessage.commands()) {
                applyCommand(list, c, budget);
            }
            return;
        }
        if (msg instanceof SequenceMessage sequenceMessage) {
            for (Command c : sequenceMessage.commands()) {
                applyCommand(list, c, budget);
            }
            return;
        }

        com.williamcallahan.tui4j.compat.bubbletea.UpdateResult<List> result = list.update(msg);
        if (result != null && result.command() != null) {
            applyCommand(list, result.command(), budget);
        }
    }

    private static final class StepBudget {
        private int remaining = 500;

        boolean consume() {
            if (remaining <= 0) {
                return false;
            }
            remaining--;
            return true;
        }
    }

    private static String statusView(List list) {
        try {
            Method method = List.class.getDeclaredMethod("statusView");
            method.setAccessible(true);
            return (String) method.invoke(list);
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("Failed to read status view", e);
        }
    }

    private static java.util.List<String> visibleValues(List list) {
        return list.visibleItems().stream()
                .map(item -> item.item().filterValue())
                .toList();
    }

    private static String footerLine(String view) {
        String[] lines = view.split("\n");
        return lines[lines.length - 1];
    }

    private record TestItem(String value) implements Item {
        @Override
        public String filterValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    private static final class TestDelegate implements ItemDelegate {
        @Override
        public void render(StringBuilder output, List list, int index, FilteredItem filteredItem) {
            output.append(index + 1).append(". ").append(filteredItem.item().filterValue());
        }

        @Override
        public int height() {
            return 1;
        }

        @Override
        public int spacing() {
            return 0;
        }

        @Override
        public Command update(Message msg, List listModel) {
            return null;
        }
    }
}
