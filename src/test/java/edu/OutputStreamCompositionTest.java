package edu;

import edu.task4.OutputStreamComposition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputStreamCompositionTest {
    private final Path filePath = Paths.get("src/main/resources/hw6/composition.txt");
    private final String line = "Programming is learned by writing programs. ― Brian Kernighan";

    @Test
    @DisplayName("Creation of file test")
    public void streamComposition_shouldCreateFile() {
        OutputStreamComposition.streamComposition();
        assertTrue(Files.exists(filePath));
    }

    @Test
    @DisplayName("Created file has correct line inside")
    public void streamComposition_shouldWriteLineInCreatedFile() throws IOException {
        OutputStreamComposition.streamComposition();
        assertEquals(line, Files.readAllLines(filePath).get(0));
    }
}

