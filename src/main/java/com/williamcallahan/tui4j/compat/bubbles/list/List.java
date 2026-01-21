package com.williamcallahan.tui4j.compat.bubbles.list;

import com.williamcallahan.tui4j.compat.bubbletea.Command;
import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.Model;
import com.williamcallahan.tui4j.compat.bubbletea.UpdateResult;
import com.williamcallahan.tui4j.ansi.Truncate;
import com.williamcallahan.tui4j.compat.lipgloss.Position;
import com.williamcallahan.tui4j.compat.lipgloss.Size;
import com.williamcallahan.tui4j.compat.lipgloss.Style;
import com.williamcallahan.tui4j.compat.lipgloss.join.VerticalJoinDecorator;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbletea.QuitMessage;
import com.williamcallahan.tui4j.compat.bubbles.help.Help;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;
import com.williamcallahan.tui4j.compat.bubbles.paginator.Paginator;
import com.williamcallahan.tui4j.compat.bubbles.paginator.Type;
import com.williamcallahan.tui4j.compat.bubbles.spinner.Spinner;
import com.williamcallahan.tui4j.compat.bubbles.spinner.SpinnerType;
import com.williamcallahan.tui4j.compat.bubbles.spinner.TickMessage;
import com.williamcallahan.tui4j.compat.bubbles.textinput.TextInput;

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
import static com.williamcallahan.tui4j.compat.bubbles.list.DefaultItemStyles.ELLIPSIS;

/**
 * Port of Bubbles list.
 * Bubble Tea: bubbletea/examples/list-simple/main.go
 */
public class List implements Model, com.williamcallahan.tui4j.compat.bubbles.help.KeyMap {

    private boolean showTitle;
    private boolean showFilter;
    private boolean showStatusBar;
    private boolean showPagination;
    private boolean showHelp;
    private boolean filteringEnabled;

    private String itemNameSingular;
    private String itemNamePlural;

    private String title;
    private Styles styles;
    private boolean infiniteScrolling;

    private KeyMap keys;
    private boolean disableQuitKeybindings;

    private Supplier<Binding[]> additionalShortHelpKeyMap;
    private Supplier<Binding[]> additionalFullHelpKeyMap;

    private Spinner spinner;
    private boolean showSpinner;
    private int width;
    private int height;
    private Paginator paginator;
    private int cursor;
    private Help help;
    private TextInput filterInput;
    private FilterState filterState;
    private boolean filterOnAcceptOnly;

    private Duration statusMessageLifetime;
    private String statusMessage;
    private Timer statusMessageTimer;
    private Future<? extends Message> statusMessageFuture;

    private ListDataSource dataSource;
    private boolean fetchingItems;
    private long totalItems = 0;
    private int totalPages;
    private long matchedItems = 0;
    private java.util.List<FilteredItem> currentPageItems;
    private ItemDelegate itemDelegate;

    /**
     * Creates a new list with the given items and dimensions.
     *
     * @param items list items
     * @param width width of the list
     * @param height height of the list
     */
    public List(Item[] items, int width, int height) {
        this(items, new DefaultDelegate(), width, height);
    }

    /**
     * Creates a new list with the given items, delegate and dimensions.
     *
     * @param items list items
     * @param delegate item delegate
     * @param width width of the list
     * @param height height of the list
     */
    public List(Item[] items, ItemDelegate delegate, int width, int height) {
        setup(new DefaultDataSource(this, items), delegate, width, height);
    }

    /**
     * Creates a new list with the given data source, delegate and dimensions.
     *
     * @param dataSource data source
     * @param delegate item delegate
     * @param width width of the list
     * @param height height of the list
     */
    public List(ListDataSource dataSource, ItemDelegate delegate, int width, int height) {
        setup(dataSource, delegate, width, height);
    }

    /**
     * Creates a new list with the given data source and dimensions.
     *
     * @param dataSource data source
     * @param width width of the list
     * @param height height of the list
     */
    public List(ListDataSource dataSource, int width, int height) {
        this(dataSource, new DefaultDelegate(), width, height);
    }

    private void setup(ListDataSource dataSource, ItemDelegate delegate, int width, int height) {
        this.dataSource = dataSource;
        this.currentPageItems = new ArrayList<>();
        this.filterState = FilterState.Unfiltered;
        this.itemDelegate = delegate;
        this.fetchingItems = false;

        this.width = width;
        this.height = height;
        this.title = "List";
        this.showTitle = true;
        this.showFilter = true;
        this.showStatusBar = true;
        this.showPagination = true;
        this.showHelp = true;
        this.itemNameSingular = "item";
        this.itemNamePlural = "items";
        this.filteringEnabled = true;
        this.keys = new KeyMap();
        this.styles = Styles.defaultStyles();
        this.statusMessageLifetime = Duration.ofSeconds(1);
        this.statusMessage = "";
        this.help = new Help();

        this.spinner = new Spinner(SpinnerType.LINE);
        spinner.setStyle(styles.spinner());

        this.filterInput = new TextInput();
        filterInput.setPrompt("Filter: ");
        filterInput.setPromptStyle(styles.filterPrompt());
        filterInput.cursor().setStyle(styles.filterCursor());
        filterInput.setCharLimit(64);
        filterInput.focus();

        this.paginator = new Paginator();
        paginator.setType(Type.Dots);
    }

    @Override
    public Command init() {
        paginator.setActiveDot(styles.activePaginationDot().render());
        paginator.setInactiveDot(styles.inactivePaginationDot().render());

        updatePagination();
        return fetchCurrentPageItems();
    }

    /**
     * Returns the data source.
     *
     * @return data source
     */
    public ListDataSource dataSource() {
        return dataSource;
    }

    /**
     * Refreshes the list.
     *
     * @param postRefresh tasks to run after refresh
     * @return refresh command
     */
    public Command refresh(Runnable... postRefresh) {
        return fetchCurrentPageItems(
                Stream.concat(
                        Stream.of(postRefresh),
                        Stream.of(this::keepCursorInBounds)).toArray(Runnable[]::new));
    }

    private Command fetchCurrentPageItems(Runnable... postFetch) {
        this.fetchingItems = true;
        updateKeybindings();

        String filterValue = filterState == FilterState.Unfiltered ? "" : filterInput.value();
        return batch(
                updateFilter(),
                startSpinner(),
                () -> new FetchedCurrentPageItems(
                        dataSource.fetchItems(
                                paginator.page(),
                                paginator.perPage(),
                                filterValue),
                        postFetch));
    }

    private Command updateFilter() {
        if (fetchingItems) {
            filterInput.blur();
            return null;
        } else {
            return filterInput.focus();
        }
    }

    /**
     * Sets whether to filter on accept only.
     *
     * @param filterOnAcceptOnly true to filter only on accept
     */
    public void setFilterOnAcceptOnly(boolean filterOnAcceptOnly) {
        this.filterOnAcceptOnly = filterOnAcceptOnly;
    }

    /**
     * Sets whether filtering is enabled.
     *
     * @param filteringEnabled true to enable filtering
     * @return command to run
     */
    public Command setFilteringEnabled(boolean filteringEnabled) {
        this.filteringEnabled = filteringEnabled;
        if (!filteringEnabled) {
            return resetFiltering();
        }
        return null;
    }

    /**
     * Returns whether filtering is enabled.
     *
     * @return true if filtering is enabled
     */
    public boolean filteringEnabled() {
        return filteringEnabled;
    }

    /**
     * Sets the list title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets whether to show the title.
     *
     * @param showTitle true to show title
     * @return command to run
     */
    public Command setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
        return fetchCurrentPageItems();
    }

    /**
     * Sets the filter text.
     *
     * @param filter the filter text
     * @return command to run
     */
    public Command setFilterText(String filter) {
        this.filterState = FilterState.Filtering;
        this.filterInput.setValue(filter);
        return fetchCurrentPageItems();
    }

    /**
     * Sets the filter state.
     *
     * @param filterState the filter state
     * @return command to run
     */
    public Command setFilterState(FilterState filterState) {
        this.paginator.setPage(0);
        this.cursor = 0;
        this.filterState = filterState;
        this.filterInput.cursorEnd();
        this.filterInput.focus();

        return fetchCurrentPageItems();
    }

    /**
     * Returns whether the title is shown.
     *
     * @return true if title is shown
     */
    public boolean showTitle() {
        return showTitle;
    }

    /**
     * Sets whether to show the filter.
     *
     * @param showFilter true to show filter
     */
    public void setShowFilter(boolean showFilter) {
        this.showFilter = showFilter;
        updatePagination();
    }

    /**
     * Returns whether the filter is shown.
     *
     * @return true if filter is shown
     */
    public boolean showFilter() {
        return showFilter;
    }

    /**
     * Sets whether to show the status bar.
     *
     * @param showStatusBar true to show status bar
     */
    public void setShowStatusBar(boolean showStatusBar) {
        this.showStatusBar = showStatusBar;
        updatePagination();
    }

    /**
     * Returns whether the status bar is shown.
     *
     * @return true if status bar is shown
     */
    public boolean showStatusBar() {
        return showStatusBar;
    }

    /**
     * Sets the item name singular and plural forms.
     *
     * @param singular singular name
     * @param plural plural name
     */
    public void setStatusBarItemName(String singular, String plural) {
        this.itemNameSingular = singular;
        this.itemNamePlural = plural;
    }

    /**
     * Returns the singular item name.
     *
     * @return singular item name
     */
    public String itemNameSingular() {
        return itemNameSingular;
    }

    /**
     * Returns the plural item name.
     *
     * @return plural item name
     */
    public String itemNamePlural() {
        return itemNamePlural;
    }

    /**
     * Sets whether to show pagination.
     *
     * @param showPagination true to show pagination
     */
    public void setShowPagination(boolean showPagination) {
        this.showPagination = showPagination;
        updatePagination();
    }

    /**
     * Returns whether pagination is shown.
     *
     * @return true if pagination is shown
     */
    public boolean showPagination() {
        return showPagination;
    }

    /**
     * Sets whether to show help.
     *
     * @param showHelp true to show help
     * @return command to run
     */
    public Command setShowHelp(boolean showHelp) {
        this.showHelp = showHelp;
        return fetchCurrentPageItems();
    }

    /**
     * Returns whether help is shown.
     *
     * @return true if help is shown
     */
    public boolean showHelp() {
        return showHelp;
    }

    /**
     * Selects the item at the given index.
     *
     * @param index item index
     * @return command to run
     */
    public Command select(int index) {
        this.paginator.setPage(index / paginator.perPage());
        this.cursor = index & paginator.perPage();
        return fetchCurrentPageItems();
    }

    /**
     * Resets the selection to the first item.
     */
    public void resetSelected() {
        select(0);
    }

    /**
     * Sets the item delegate.
     *
     * @param itemDelegate item delegate
     * @return command to run
     */
    public Command setItemDelegate(ItemDelegate itemDelegate) {
        this.itemDelegate = itemDelegate;
        return fetchCurrentPageItems();
    }

    /**
     * Returns the selected item.
     *
     * @return selected item
     */
    public Item selectedItem() {
        java.util.List<FilteredItem> visibleItems = visibleItems();

        if (cursor < 0 || visibleItems.isEmpty() || visibleItems.size() <= cursor) {
            return null;
        }
        return visibleItems.get(cursor).item();
    }

    /**
     * Returns the visible items.
     *
     * @return visible items
     */
    public java.util.List<FilteredItem> visibleItems() {
        return currentPageItems;
    }

    /**
     * Returns the absolute index of the cursor.
     *
     * @return absolute index
     */
    public int index() {
        return paginator.page() * paginator.perPage() + cursor;
    }

    /**
     * Returns the cursor position on the current page.
     *
     * @return cursor position
     */
    public int cursor() {
        return cursor;
    }

    /**
     * Moves to the next page.
     *
     * @return command to run
     */
    public Command nextPage() {
        if (!paginator.onLastPage()) {
            paginator.nextPage();
            cursor = 0;
            return fetchCurrentPageItems();
        }
        return null;
    }

    /**
     * Moves to the previous page.
     *
     * @return command to run
     */
    public Command prevPage() {
        if (paginator.page() > 0) {
            paginator.prevPage();
            cursor = 0;
            return fetchCurrentPageItems();
        }
        return null;
    }

    /**
     * Returns the current filter state.
     *
     * @return filter state
     */
    public FilterState filterState() {
        return filterState;
    }

    /**
     * Returns the current filter value.
     *
     * @return filter value
     */
    public String filterValue() {
        return filterInput.value();
    }

    /**
     * Returns whether the user is currently entering a filter.
     *
     * @return true if setting filter
     */
    public boolean settingFilter() {
        return this.filterState == FilterState.Filtering;
    }

    /**
     * Returns whether the list is currently filtered.
     *
     * @return true if filtered
     */
    public boolean isFiltered() {
        return this.filterState == FilterState.FilterApplied;
    }

    /**
     * Returns the list width.
     *
     * @return width
     */
    public int width() {
        return width;
    }

    /**
     * Returns the list height.
     *
     * @return height
     */
    public int height() {
        return height;
    }

    /**
     * Sets the spinner type.
     *
     * @param spinnerType spinner type
     */
    public void setSpinnerType(SpinnerType spinnerType) {
        spinner.setType(spinnerType);
    }

    /**
     * Starts the spinner.
     *
     * @return command to run
     */
    public Command startSpinner() {
        this.showSpinner = true;
        return spinner::tick;
    }

    /**
     * Stops the spinner.
     */
    public void stopSpinner() {
        this.showSpinner = false;
    }

    /**
     * Disables quit keybindings.
     */
    public void disableQuitKeybindings() {
        this.disableQuitKeybindings = true;
        keys.quit().setEnabled(false);
        keys.forceQuit().setEnabled(false);
    }

    /**
     * Creates a new status message command.
     *
     * @param status status message
     * @return command to run
     */
    public Command newStatusMessage(String status) {
        this.statusMessage = status;

        if (statusMessageTimer != null) {
            statusMessageTimer.cancel();
        }

        statusMessageTimer = new Timer();
        return () -> {
            BlockingQueue<StatusMessageTimeoutMessage> queue = new ArrayBlockingQueue<>(1);
            statusMessageTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    queue.offer(new StatusMessageTimeoutMessage());
                }
            }, statusMessageLifetime.toMillis());

            try {
                return queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new StatusMessageTimeoutMessage();
            } finally {
                statusMessageTimer.cancel();
                statusMessageTimer = null;
            }
        };
    }

    /**
     * Sets the lifetime of status messages.
     *
     * @param statusMessageLifetime lifetime duration
     */
    public void setStatusMessageLifetime(Duration statusMessageLifetime) {
        this.statusMessageLifetime = statusMessageLifetime;
    }

    /**
     * Sets the size of the list.
     *
     * @param width width
     * @param height height
     * @return command to run
     */
    public Command setSize(int width, int height) {
        int promptWidth = Size.width(styles.title().render(filterInput.prompt()));

        this.width = width;
        this.height = height;
        this.help.setWidth(width);
        this.filterInput.setWidth(width - promptWidth - Size.width(spinnerView()));
        updatePagination();

        return fetchCurrentPageItems();
    }

    /**
     * Sets the width of the list.
     *
     * @param width width
     * @return command to run
     */
    public Command setWidth(int width) {
        return setSize(width, height);
    }

    /**
     * Sets the height of the list.
     *
     * @param height height
     * @return command to run
     */
    public Command setHeight(int height) {
        return setSize(width, height);
    }

    /**
     * Resets the filtering state.
     *
     * @return command to run
     */
    protected Command resetFiltering() {
        if (filterState == FilterState.Unfiltered) {
            return null;
        }

        this.filterState = FilterState.Unfiltered;
        this.filterInput.reset();

        return fetchCurrentPageItems();
    }

    protected void updateKeybindings() {
        if (filterState == FilterState.Filtering || fetchingItems) {
            keys.cursorUp().setEnabled(false);
            keys.cursorDown().setEnabled(false);
            keys.nextPage().setEnabled(false);
            keys.prevPage().setEnabled(false);
            keys.goToStart().setEnabled(false);
            keys.goToEnd().setEnabled(false);
            keys.filter().setEnabled(false);
            keys.clearFilter().setEnabled(false);
            if (!fetchingItems) {
                keys.cancelWhileFiltering().setEnabled(true);
            }
            keys.acceptWhileFiltering().setEnabled(!"".equals(filterInput.value()));
            keys.quit().setEnabled(false);
            keys.showFullHelp().setEnabled(false);
            keys.closeFullHelp().setEnabled(false);
        } else {
            boolean hasItems = !(totalItems == 0);
            keys.cursorUp().setEnabled(hasItems);
            keys.cursorDown().setEnabled(hasItems);
            keys.goToStart().setEnabled(hasItems);
            keys.goToEnd().setEnabled(hasItems);
            keys.filter().setEnabled(filteringEnabled && hasItems);

            boolean hasPages = paginator.totalPages() > 0;
            keys.nextPage().setEnabled(hasPages);
            keys.prevPage().setEnabled(hasPages);
            keys.clearFilter().setEnabled(filterState == FilterState.FilterApplied);
            keys.cancelWhileFiltering().setEnabled(false);
            keys.acceptWhileFiltering().setEnabled(false);
            keys.quit().setEnabled(!disableQuitKeybindings);

            if (help.showAll()) {
                keys.showFullHelp().setEnabled(true);
                keys.closeFullHelp().setEnabled(true);
            } else {
                boolean minHelp = countEnabledBindings(fullHelp()) > 1;
                keys.showFullHelp().setEnabled(minHelp);
                keys.closeFullHelp().setEnabled(minHelp);
            }
        }
    }

    private void hideStatusMessage() {
        this.statusMessage = "";

        // Cancel the active timer if it's still running
        if (statusMessageFuture != null && !statusMessageFuture.isDone()) {
            statusMessageFuture.cancel(true);
        }
    }

    boolean updatePagination() {
        int index = index();
        int availHeight = this.height;

        paginator.setTotalPages(totalPages);

        if (showTitle || (showFilter && filteringEnabled)) {
            availHeight -= Size.height(titleView());
        }
        if (showStatusBar) {
            availHeight -= Size.height(statusView());
        }
        if (showPagination) {
            availHeight -= Size.height(paginationView());
        }
        if (showHelp) {
            availHeight -= Size.height(helpView());
        }

        this.cursor = index % paginator.perPage();
        paginator.setPerPage(Math.max(1, availHeight / (itemDelegate.height() + itemDelegate.spacing())));

        if (paginator.page() >= paginator.totalPages()) {
            paginator.setPage(Math.max(0, paginator.totalPages() - 1));
            updateKeybindings();
            return true;
        }

        updateKeybindings();
        return false;
    }

    @Override
    public UpdateResult<List> update(Message msg) {
        java.util.List<Command> commands = new LinkedList<>();

        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (Binding.matches(keyPressMessage, keys.forceQuit())) {
                return UpdateResult.from(this, QuitMessage::new);
            }
        } else if (msg instanceof FetchedCurrentPageItems fetchedCurrentPageItems) {
            stopSpinner();
            this.fetchingItems = false;

            FetchedItems fetchedItems = fetchedCurrentPageItems.fetchedItems();
            this.currentPageItems = fetchedItems.items();
            this.matchedItems = fetchedItems.matchedItems();
            this.totalItems = fetchedItems.totalItems();
            this.totalPages = fetchedItems.totalPages();

            updateKeybindings();

            for (Runnable runnable : fetchedCurrentPageItems.postFetch()) {
                runnable.run();
            }

            // page changed thus need to re-fetch
            boolean forcedPageChange = updatePagination();
            if (forcedPageChange) {
                return UpdateResult.from(this, fetchCurrentPageItems());
            }

            return UpdateResult.from(this, updateFilter());
        } else if (msg instanceof TickMessage && showSpinner) {
            commands.add(spinner.update(msg).command());
        } else if (msg instanceof StatusMessageTimeoutMessage) {
            hideStatusMessage();
        }

        if (filterState == FilterState.Filtering) {
            commands.add(handleFiltering(msg));
        } else {
            commands.add(handleBrowsing(msg));
        }

        return UpdateResult.from(this, batch(commands));
    }

    private Command handleBrowsing(Message msg) {
        java.util.List<Command> commands = new LinkedList<>();

        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (Binding.matches(keyPressMessage, keys.clearFilter())) {
                commands.add(resetFiltering());
            } else if (Binding.matches(keyPressMessage, keys.quit())) {
                return QuitMessage::new;
            } else if (Binding.matches(keyPressMessage, keys.cursorUp())) {
                commands.add(cursorUp());
            } else if (Binding.matches(keyPressMessage, keys.cursorDown())) {
                commands.add(cursorDown());
            } else if (Binding.matches(keyPressMessage, keys.prevPage())) {
                commands.add(cursorLeft());
            } else if (Binding.matches(keyPressMessage, keys.nextPage())) {
                commands.add(cursorRight());
            } else if (Binding.matches(keyPressMessage, keys.goToStart())) {
                commands.add(gotoStart());
            } else if (Binding.matches(keyPressMessage, keys.goToEnd())) {
                commands.add(gotoEnd());
            } else if (Binding.matches(keyPressMessage, keys.filter())) {
                hideStatusMessage();
                commands.add(TextInput::blink);

                if (!paginator.onFirstPage()) {
                    paginator.setPage(0);
                }

                this.filterState = FilterState.Filtering;
                filterInput.cursorEnd();
                filterInput.focus();
                updateKeybindings();

                commands.add(fetchCurrentPageItems(() -> this.cursor = 0));

                return batch(commands);
            } else if (Binding.matches(keyPressMessage, keys.showFullHelp())
                    || Binding.matches(keyPressMessage, keys.closeFullHelp())) {
                help.setShowAll(!help.showAll());
                updatePagination();

                commands.add(fetchCurrentPageItems());
            }
            commands.add(itemDelegate.update(msg, this));
        }
        return batch(commands);
    }

    private Command gotoStart() {
        if (paginator.onFirstPage()) {
            return null;
        }

        paginator.setPage(0);
        this.cursor = 0;
        return fetchCurrentPageItems();
    }

    private Command gotoEnd() {
        if (paginator.onLastPage()) {
            return null;
        }

        paginator.setPage(paginator.totalPages() - 1);
        return fetchCurrentPageItems(this::keepCursorInBounds);
    }

    private Command cursorLeft() {
        if (paginator.onFirstPage()) {
            return null;
        }
        paginator.prevPage();
        return fetchCurrentPageItems();
    }

    private Command cursorRight() {
        if (paginator.onLastPage()) {
            return null;
        }
        paginator.nextPage();
        return fetchCurrentPageItems(this::keepCursorInBounds);
    }

    private void keepCursorInBounds() {
        int itemsOnPage = visibleItems().size();
        if (cursor > itemsOnPage - 1) {
            this.cursor = Math.max(0, itemsOnPage - 1);
        }
    }

    /**
     * Moves the cursor up.
     *
     * @return command to run
     */
    public Command cursorUp() {
        this.cursor--;
        if (cursor < 0) {
            if (paginator.page() == 0) {
                if (infiniteScrolling) {
                    paginator.setPage(paginator.totalPages() - 1);
                    return fetchCurrentPageItems(() -> cursor = paginator.itemsOnPage(visibleItems().size()) - 1);
                }

                this.cursor = 0;
                return null;
            }

            if (infiniteScrolling) {
                paginator.setPage(paginator.totalPages() - 1);
                return fetchCurrentPageItems(() -> cursor = paginator.itemsOnPage(visibleItems().size()) - 1);
            }

            paginator.prevPage();
            return fetchCurrentPageItems(() -> cursor = visibleItems().size() - 1);
        }
        return null;
    }

    /**
     * Moves the cursor down.
     *
     * @return command to run
     */
    public Command cursorDown() {
        int itemsOnPage = visibleItems().size();
        this.cursor++;

        if (cursor < itemsOnPage) {
            return null;
        }

        if (!paginator.onLastPage()) {
            paginator.nextPage();
            return fetchCurrentPageItems(
                    () -> cursor = 0);
        }

        if (cursor > itemsOnPage) {
            this.cursor = 0;
            return null;
        }

        this.cursor = itemsOnPage - 1;

        if (infiniteScrolling) {
            return fetchCurrentPageItems(
                    () -> cursor = 0);
        }

        return null;
    }

    private Command handleFiltering(Message msg) {
        java.util.List<Command> commands = new LinkedList<>();

        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (Binding.matches(keyPressMessage, keys.cancelWhileFiltering())) {
                resetFiltering();

                commands.add(fetchCurrentPageItems(() -> {
                    keys.filter().setEnabled(true);
                    keys.clearFilter().setEnabled(false);
                }));

            } else if (Binding.matches(keyPressMessage, keys.acceptWhileFiltering())) {
                hideStatusMessage();

                if (totalItems > 0) {
                    java.util.List<FilteredItem> h = visibleItems();
                    if (!h.isEmpty()) {
                        filterInput.blur();
                        this.filterState = FilterState.FilterApplied;
                        updateKeybindings();

                        if (filterInput.isEmpty()) {
                            commands.add(resetFiltering());
                        }
                    } else {
                        commands.add(resetFiltering());
                    }
                }
            }
        }

        String beforeChange = filterInput.value();
        UpdateResult<TextInput> updateResult = filterInput.update(msg);
        boolean filterChanged = !Objects.equals(beforeChange, updateResult.model().value());
        this.filterInput = updateResult.model();
        commands.add(updateResult.command());

        if (filterChanged && !filterOnAcceptOnly) {
            commands.add(fetchCurrentPageItems(() -> {
                keys.acceptWhileFiltering().setEnabled(!filterInput.isEmpty());
                updatePagination();
            }));
        }
        return batch(commands);
    }

    @Override
    public String view() {
        java.util.List<String> sections = new ArrayList<>();
        int availHeight = this.height;

        if (showTitle || (showFilter && filteringEnabled)) {
            String v = titleView();
            sections.add(v);
            availHeight -= Size.height(v);
        }

        if (showStatusBar) {
            String v = statusView();
            sections.add(v);
            availHeight -= Size.height(v);
        }

        String pagination = null;
        if (showPagination) {
            pagination = paginationView();
            availHeight -= Size.height(pagination);
        }

        String help = null;
        if (showHelp) {
            help = helpView();
            availHeight -= Size.height(help);
        }

        String content = Style.newStyle().height(availHeight).render(populatedView());
        sections.add(content);

        if (showPagination) {
            sections.add(pagination);
        }

        if (showHelp) {
            sections.add(help);
        }

        return VerticalJoinDecorator.joinVertical(Position.Left, sections.toArray(new String[0]));
    }

    private String titleView() {
        StringBuilder view = new StringBuilder();
        Style titleBarStyle = styles.titleBar().copy();
        String spinnerView = spinnerView();
        int spinnerWidth = Size.width(spinnerView);
        String spinnerLeftGap = " ";
        boolean spinnerOnLeft = titleBarStyle.leftPadding() >= spinnerWidth + Size.width(spinnerLeftGap) && showSpinner;

        if (showSpinner && spinnerOnLeft) {
            view.append(spinnerView).append(spinnerLeftGap);
            int titleBarGap = titleBarStyle.leftPadding();
            titleBarStyle = titleBarStyle.paddingLeft(titleBarGap - spinnerWidth - Size.width(spinnerLeftGap));
        }

        if (showFilter && filterState == FilterState.Filtering) {
            view.append(filterInput.view());
        } else if (showTitle) {
            view.append(styles.title().render(title));
            if (filterState != FilterState.Filtering) {
                view.append(" ").append(statusMessage);
                view = new StringBuilder(Truncate.truncate(view.toString(), width - spinnerWidth, ELLIPSIS));
            }
        }

        if (showSpinner && !spinnerOnLeft) {
            int availSpace = width - Size.width(styles.titleBar().render(view.toString()));
            if (availSpace > spinnerWidth) {
                view
                        .append(" ".repeat(availSpace - spinnerWidth))
                        .append(spinnerView);
            }
        }

        if (!view.isEmpty()) {
            return titleBarStyle.render(view.toString());
        }
        return view.toString();
    }

    private String statusView() {
        StringBuilder status = new StringBuilder();
        int visibleItems = visibleItems().size();

        String itemName = itemNameSingular;
        if (visibleItems != 1) {
            itemName = itemNamePlural;
        }

        String itemsDisplay = "%d %s".formatted(matchedItems, itemName);

        if (filterState == FilterState.Filtering) {
            if (visibleItems == 0) {
                status = new StringBuilder(styles.statusEmpty().render("Nothing matched"));
            } else {
                status = new StringBuilder(itemsDisplay);
            }
        } else if (totalItems == 0) {
            status = new StringBuilder(styles.statusEmpty().render("No " + itemNamePlural));
        } else {
            boolean filtered = filterState == FilterState.FilterApplied;

            if (filtered) {
                String f = filterInput.value().trim();
                f = Truncate.truncate(f, 10, ELLIPSIS);
                status.append("“%s” ".formatted(f));
            }

            status.append(itemsDisplay);
        }

        if (filterState == FilterState.Filtering || filterState == FilterState.FilterApplied) {
            long numFiltered = totalItems - visibleItems;
            if (numFiltered > 0) {
                status
                        .append(styles.dividerDot().render())
                        .append(styles.statusBarFilterCount().render("%d filtered".formatted(numFiltered)));
            }
        }

        return styles.statusBar().render(status.toString());
    }

    private String paginationView() {
        Style style = styles.paginationStyle().copy();
        if (itemDelegate.spacing() == 0 && style.topMargin() == 0) {
            style = style.marginTop(1);
        }

        if (paginator.totalPages() < 2) {
            return style.render("");
        }

        paginator.setType(Type.Dots);
        String view = paginator.view();
        if (Size.width(view) > width) {
            paginator.setType(Type.Arabic);
            view = styles.arabicPagination().render(paginator.view());
        }

        return style.render(view);
    }

    private String populatedView() {
        java.util.List<FilteredItem> items = visibleItems();

        StringBuilder b = new StringBuilder();

        if (items.isEmpty()) {
            if (filterState == FilterState.Filtering) {
                return "";
            }
            return styles.noItems().render("No " + itemNamePlural + ".");
        }

        for (int i = 0; i < items.size(); i++) {
            itemDelegate.render(b, this, paginator.page() * paginator.perPage() + i, items.get(i));
            if (i != items.size() - 1) {
                b.append("\n".repeat(itemDelegate.spacing() + 1));
            }
        }

        int itemsOnPage = items.size();
        if (itemsOnPage < paginator.perPage()) {
            int emptyLines = (paginator.perPage() - itemsOnPage) * (itemDelegate.height() + itemDelegate.spacing());
            if (items.isEmpty()) {
                emptyLines -= itemDelegate.height() - 1; // Edge case adjustment
            }
            b.append("\n".repeat(emptyLines));
        }
        return b.toString();
    }

    private String helpView() {
        return styles.helpStyle().render(help.render(this));
    }

    private String spinnerView() {
        return spinner.view();
    }

    private int countEnabledBindings(Binding[][] groups) {
        int count = 0;
        for (Binding[] group : groups) {
            for (Binding binding : group) {
                if (binding.isEnabled()) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Binding[] shortHelp() {
        java.util.List<Binding> kb = new LinkedList<>(Arrays.asList(
                keys.cursorUp(),
                keys.cursorDown()));

        boolean filtering = filterState == FilterState.Filtering;
        if (!filtering) {
            if (itemDelegate instanceof KeyMap delegateKeyMap) {
                kb.addAll(Arrays.asList(delegateKeyMap.shortHelp()));
            }
        }

        kb.addAll(Arrays.asList(
                keys.filter(),
                keys.clearFilter(),
                keys.acceptWhileFiltering(),
                keys.cancelWhileFiltering()));

        if (!filtering && additionalShortHelpKeyMap != null) {
            kb.addAll(Arrays.asList(additionalShortHelpKeyMap.get()));
        }

        kb.addAll(Arrays.asList(
                keys.quit(),
                keys.showFullHelp()));

        return kb.toArray(new Binding[0]);
    }

    @Override
    public Binding[][] fullHelp() {
        java.util.List<Binding[]> kb = new LinkedList<>();
        kb.add(new Binding[] {
                keys.cursorUp(),
                keys.cursorDown(),
                keys.nextPage(),
                keys.prevPage(),
                keys.goToStart(),
                keys.goToEnd()
        });

        boolean filtering = filterState == FilterState.Filtering;
        if (!filtering) {
            if (itemDelegate instanceof KeyMap delegateKeyMap) {
                kb.addAll(Arrays.asList(delegateKeyMap.fullHelp()));
            }
        }

        java.util.List<Binding> listLevelBindings = new LinkedList<>(Arrays.asList(
                keys.filter(),
                keys.clearFilter(),
                keys.acceptWhileFiltering(),
                keys.cancelWhileFiltering()));

        if (!filtering && additionalFullHelpKeyMap != null) {
            listLevelBindings.addAll(Arrays.asList(additionalFullHelpKeyMap.get()));
        }

        kb.add(listLevelBindings.toArray(new Binding[0]));
        kb.add(new Binding[] {
                keys.quit(),
                keys.closeFullHelp()
        });
        return kb.toArray(new Binding[0][]);
    }

    /**
     * Returns the styles used by the list.
     *
     * @return list styles
     */
    public Styles styles() {
        return styles;
    }

    /**
     * Sets additional key bindings for short help.
     *
     * @param additionalShortHelpKeyMap supplier of bindings
     */
    public void setAdditionalShortHelpKeys(Supplier<Binding[]> additionalShortHelpKeyMap) {
        this.additionalShortHelpKeyMap = additionalShortHelpKeyMap;
    }

    /**
     * Sets additional key bindings for full help.
     *
     * @param additionalFullHelpKeyMap supplier of bindings
     */
    public void setAdditionalFullHelpKeys(Supplier<Binding[]> additionalFullHelpKeyMap) {
        this.additionalFullHelpKeyMap = additionalFullHelpKeyMap;
    }
}
