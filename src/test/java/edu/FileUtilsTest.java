package edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static edu.task2.FileUtils.cloneFile;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUtilsTest {


    private final Path currentWorkingDir = Paths.get("").toAbsolutePath();
    private final Path filePath = currentWorkingDir.resolve("src/main/resources/hw6/test.txt");
    private final Path copyPath = currentWorkingDir.resolve("src/main/resources/hw6/test - копия.txt");
    private final Path secondCopyPath = currentWorkingDir.resolve("src/main/resources/hw6/test - копия (2).txt");


    @BeforeEach
    void deleteCopies() throws IOException {
        Files.deleteIfExists(filePath);
        Files.deleteIfExists(copyPath);
        Files.deleteIfExists(secondCopyPath);
    }

    @Test
    @DisplayName("First copy exist test")
    public void cloneFiles_shouldCreateFile() {
        cloneFile(filePath);
        assertTrue(Files.exists(filePath));
    }

    @Test
    @DisplayName("Second copy exist test")
    public void cloneFiles_shouldCreateSecondCopyOfFile() {
        cloneFile(filePath);
        cloneFile(filePath);
        assertTrue(Files.exists(copyPath));
    }

    @Test
    @DisplayName("First copy delete then clone again")
    public void cloneFiles_shouldCreateFirstCopyOfFile_whenSecondCopyExists() throws IOException {
        cloneFile(filePath);
        cloneFile(filePath);
        Files.delete(copyPath);
        cloneFile(filePath);
        assertTrue(Files.exists(copyPath));
    }
    @Test
    @DisplayName("Second copy test")
    public void cloneFiles_shouldCreateSecondCopy() throws IOException{
        cloneFile(filePath);
        cloneFile(filePath);
        cloneFile(filePath);
        assertTrue(Files.exists(secondCopyPath));
    }
}
