package examples.spring.view;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import examples.spring.model.Author;
import examples.spring.model.Book;
import examples.spring.repository.BookRepository;
import org.springframework.stereotype.Service;

/**
 * Example program for books generator.
 * tui4j: examples/spring/src/main/java/com/williamcallahan/tui4j/springexample/view/BooksGenerator.java
 */
@Service
@RequiredArgsConstructor
public class BooksGenerator {

    private final Faker faker;
    private final BookRepository bookRepository;

    /**
     * Handles generate books for example.
     *
     * @param booksCount books count
     */
    @Transactional
    public void generateBooks(int booksCount) {
        for (int i = 0; i < booksCount; i++) {
            Book book = new Book();
            book.setTitle(faker.book().title());
            book.setSynopsis(String.join(" ", faker.lorem().sentence(3)));

            // generate authors
            int numAuthors = faker.number().numberBetween(1, 4);
            for (int j = 0; j < numAuthors; j++) {
                Author author = new Author();
                author.setName(faker.name().fullName());
                book.getAuthors().add(author);
            }

            book.setDescription(String.join("\n", faker.lorem().paragraphs(2)));
            bookRepository.save(book);
        }
    }
}
