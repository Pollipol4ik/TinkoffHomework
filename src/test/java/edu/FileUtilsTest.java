package edu;

import java.nio.file.Path;
import edu.task2.FileUtils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    private static final String TEST_FILES_DIRECTORY = "src/test/resources/";

    @ParameterizedTest
    @MethodSource("providePathsToClone")
    void testCloneFile(Path filePath) {

        assertTrue(Files.exists(filePath));

        FileUtils.cloneFile(filePath);

        assertTrue(Files.exists(getClonedFilePath(filePath)));
    }
    private static Stream<Path> providePathsToClone() {
        return Stream.of(
            Paths.get(TEST_FILES_DIRECTORY, "test.txt")
            //Paths.get(TEST_FILES_DIRECTORY, "anotherFile.txt")

        );
    }

    // Helper method to get the path of the cloned file
    private Path getClonedFilePath(Path originalFilePath) {
        String fileName = originalFilePath.getFileName().toString();
        String clonedFileName = fileName.replaceFirst("\\.",  " – копия" + "\\.");
        return originalFilePath.getParent().resolve(clonedFileName);
    }
}
