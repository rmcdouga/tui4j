package com.williamcallahan.tui4j.compat.bubbles.paginator;

import com.williamcallahan.tui4j.compat.bubbletea.Message;
import com.williamcallahan.tui4j.compat.bubbletea.KeyPressMessage;
import com.williamcallahan.tui4j.compat.bubbles.key.Binding;

/**
 * Port of the Bubble Tea paginator component.
 * Upstream: github.com/charmbracelet/bubbles/paginator (Model)
 * <p>
 * Bubbles: paginator/paginator.go.
 */
public class Paginator {

    /**
     * Port of the paginator option hook used during construction.
     * Upstream: github.com/charmbracelet/bubbles/paginator (Option)
     * <p>
     * Bubbles: paginator/paginator.go.
     */
    public interface Option {

        /**
         * Handles with total pages for this component.
         *
         * @param totalPages total pages
         * @return result
         */
        static Option withTotalPages(int totalPages) {
            return paginator -> paginator.totalPages = totalPages;
        }

        /**
         * Handles with per page for this component.
         *
         * @param perPage per page
         * @return result
         */
        static Option withPerPage(int perPage) {
            return paginator -> paginator.perPage = perPage;
        }

        /**
         * Handles apply for this component.
         *
         * @param paginator paginator
         */
        void apply(Paginator paginator);
    }

    private Type type;
    private int page;
    private int perPage;
    private int totalPages;
    private String activeDot;
    private String inactiveDot;
    private String arabicFormat;

    private KeyMap keyMap;

    /**
     * Creates Paginator to keep this component ready for use.
     *
     * @param options options
     */
    public Paginator(Option... options) {
        this.type = Type.Arabic;
        this.page = 0;
        this.perPage = 1;
        this.totalPages = 1;
        this.keyMap = KeyMap.defaultKeyMap();
        this.activeDot = "•";
        this.inactiveDot = "○";
        this.arabicFormat = "%d/%d";

        for (Option option : options) {
            option.apply(this);
        }
    }

    /**
     * Updates the type.
     *
     * @param type type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Handles items on page for this component.
     *
     * @param totalItems total items
     * @return result
     */
    public int itemsOnPage(int totalItems) {
        if (totalItems < 1) {
            return 0;
        }
        Bounds sliceBounds = getSliceBounds(totalItems);
        return sliceBounds.end() - sliceBounds.start();
    }

    /**
     * Returns the slice bounds.
     *
     * @param length length
     * @return result
     */
    public Bounds getSliceBounds(int length) {
        int start = page * perPage;
        int end = Math.min(page * perPage + perPage, length);
        return new Bounds(start, end);
    }

    /**
     * Handles prev page for this component.
     */
    public void prevPage() {
        if (page > 0) {
            page--;
        }
    }

    /**
     * Handles next page for this component.
     */
    public void nextPage() {
        if (!onLastPage()) {
            page++;
        }
    }

    /**
     * Handles on last page for this component.
     *
     * @return whether last page
     */
    public boolean onLastPage() {
        return page == totalPages - 1;
    }

    /**
     * Handles on first page for this component.
     *
     * @return whether first page
     */
    public boolean onFirstPage() {
        return page == 0;
    }

    /**
     * Applies an incoming message and returns the next model state.
     *
     * @param msg msg
     * @return next model state and command
     */
    public Paginator update(Message msg) {
        if (msg instanceof KeyPressMessage keyPressMessage) {
            if (Binding.matches(keyPressMessage, keyMap.nextPage())) {
                nextPage();
            } else if (Binding.matches(keyPressMessage, keyMap.prevPage())) {
                prevPage();
            }
        }
        return this;
    }

    /**
     * Renders the model view for display.
     *
     * @return rendered view
     */
    public String view() {
        if (type == Type.Dots) {
            return dotsView();
        }
        return arabicView();
    }

    /**
     * Handles dots view for this component.
     *
     * @return result
     */
    private String dotsView() {
        StringBuilder view = new StringBuilder();
        for (int i = 0; i < totalPages; i++) {
            if (i == page) {
                view.append(activeDot);
                continue;
            }
            view.append(inactiveDot);
        }
        return view.toString();
    }

    /**
     * Handles arabic view for this component.
     *
     * @return result
     */
    private String arabicView() {
        return String.format(arabicFormat, page + 1, totalPages);
    }

    /**
     * Handles total pages for this component.
     *
     * @return result
     */
    public int totalPages() {
        return totalPages;
    }

    /**
     * Handles per page for this component.
     *
     * @return result
     */
    public int perPage() {
        return perPage;
    }

    /**
     * Updates the per page.
     *
     * @param perPage per page
     */
    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    /**
     * Updates the page.
     *
     * @param page page
     */
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * Handles page for this component.
     *
     * @return result
     */
    public int page() {
        return page;
    }

    /**
     * Updates the total pages.
     *
     * @param totalPages total pages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * Updates the total pages from items size.
     *
     * @param items items
     * @return result
     */
    public int setTotalPagesFromItemsSize(int items) {
        if (items < 1) {
            return totalPages;
        }
        int n = items / perPage;
        if (items % perPage > 0) {
            n++;
        }
        this.totalPages = n;
        return n;
    }

    /**
     * Updates the active dot.
     *
     * @param activeDot active dot
     */
    public void setActiveDot(String activeDot) {
        this.activeDot = activeDot;
    }

    /**
     * Updates the inactive dot.
     *
     * @param inactiveDot inactive dot
     */
    public void setInactiveDot(String inactiveDot) {
        this.inactiveDot = inactiveDot;
    }
}
