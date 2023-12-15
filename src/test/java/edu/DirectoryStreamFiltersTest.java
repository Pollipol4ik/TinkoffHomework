package edu;


import edu.task3.AbstractFilter;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static edu.task3.DirectoryStreamFilters.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DirectoryStreamFiltersTest {
    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE = Files::isReadable;
    public static DirectoryStream.Filter<Path> filter = REGULAR_FILE
        .and(READABLE)
        .and(largerThan(10))
        .and(magicNumber(0x89, 'P', 'N', 'G'))
        .and(typeMatches("png"))
        .and(regexContains("_"));

    @Test
    public void filters_shouldCorrectlyFilterFiles() {
        Path pathFile = Paths.get("src", "main", "java", "edu", "task3");
        List<Path> paths = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(pathFile, filter)) {
            entries.forEach(paths::add);
            assertThat(paths).containsExactly(Path.of("src", "main", "java", "edu", "task3", "image_hw6.png"));
            assertThat(paths).doesNotContain(Path.of("src", "main", "java", "edu", "task3", "photo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
