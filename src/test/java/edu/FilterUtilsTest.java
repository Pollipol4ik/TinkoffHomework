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

import static edu.task3.FilterUtils.extensionFilter;
import static edu.task3.FilterUtils.magicNumberFilter;
import static edu.task3.FilterUtils.regexNameFilter;
import static edu.task3.FilterUtils.sizeFilter;
import static org.assertj.core.api.Assertions.assertThat;

public class FilterUtilsTest {
    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE = Files::isReadable;
    public static DirectoryStream.Filter<Path> filter = REGULAR_FILE
        .and(READABLE)
        .and(sizeFilter(1000000L))
        .and(magicNumberFilter(0x89, 'P', 'N', 'G'))
        .and(extensionFilter(".PNG"))
        .and(regexNameFilter("_"));

    @Test
    public void filters_shouldCorrectlyFilterFiles() {
        Path pathFile = Paths.get("src\\test\\java\\edu");
        List<String> paths = new ArrayList<>();
        try (DirectoryStream<Path> entries = Files.newDirectoryStream(pathFile, filter)) {
            entries.forEach(path -> paths.add(path.toString()));
            assertThat(paths).containsExactly("src\\test\\java\\edu\\image_hw.PNG");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
