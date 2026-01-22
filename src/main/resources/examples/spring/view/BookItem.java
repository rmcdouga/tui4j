package examples.spring.view;

import lombok.RequiredArgsConstructor;
import com.williamcallahan.tui4j.compat.bubbles.list.DefaultItem;
import examples.spring.model.Author;
import examples.spring.model.Book;

import java.util.List;

/**
 * Example program for book item.
 * tui4j: examples/spring/src/main/java/com/williamcallahan/tui4j/springexample/view/BookItem.java
 */
@RequiredArgsConstructor
public class BookItem implements DefaultItem {

    private final Book book;

    /**
     * Handles title for example.
     *
     * @return result
     */
    @Override
    public String title() {
        return book.getTitle();
    }

    /**
     * Handles authors for example.
     *
     * @return result
     */
    public String authors() {
        StringBuilder authorsString = new StringBuilder();

        List<Author> authors = book.getAuthors();
        for (int i = 0; i < authors.size(); i++) {
            authorsString.append("- ").append(authors.get(i).getName());
            if (i + 1 < authors.size()) {
                authorsString.append("\n");
            }
        }

        return authorsString.toString();
    }

    /**
     * Handles book for example.
     *
     * @return result
     */
    public Book book() {
        return book;
    }

    /**
     * Returns the description.
     *
     * @return result
     */
    public String getDescription() {
        return book.getDescription();
    }

    /**
     * Handles description for example.
     *
     * @return result
     */
    @Override
    public String description() {
        return book.getSynopsis();
    }

    /**
     * Handles filter value for example.
     *
     * @return result
     */
    @Override
    public String filterValue() {
        return book.getTitle();
    }
}
