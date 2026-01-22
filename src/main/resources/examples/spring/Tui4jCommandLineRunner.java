package examples.spring;

import com.williamcallahan.tui4j.compat.bubbletea.Program;
import examples.spring.view.MainViewModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Example Spring Boot command line runner for TUI4J.
 */
@Component
public class Tui4jCommandLineRunner implements CommandLineRunner {

    private final MainViewModel tui4jApplication;

    /**
     * Creates Tui4jCommandLineRunner to keep example ready for use.
     *
     * @param tui4jApplication tui4j application
     */
    public Tui4jCommandLineRunner(MainViewModel tui4jApplication) {
        this.tui4jApplication = tui4jApplication;
    }

    /**
     * Handles run for example.
     *
     * @param args args
     */
    @Override
    public void run(String... args) throws Exception {
        new Program(tui4jApplication)
                .withAltScreen()
                .run();
    }
}
