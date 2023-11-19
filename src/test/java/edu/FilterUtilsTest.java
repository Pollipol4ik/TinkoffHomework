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
import static edu.task3.FilterUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterUtilsTest {
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
        Path pathFile = Paths.get("src/main/java/edu/task3");
        List<String> paths = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(pathFile, filter)) {
            entries.forEach(path -> paths.add(path.toString()));
            assertThat(paths).containsExactly("src\\main\\java\\edu\\task3\\img_hw.png");
            assertThat(paths).doesNotContain("src\\main\\java\\edu\\task3\\captcha.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}