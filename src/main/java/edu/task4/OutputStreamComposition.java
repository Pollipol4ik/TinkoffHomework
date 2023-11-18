package edu.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class OutputStreamComposition {
    private OutputStreamComposition() {
    }

    private static final String MESSAGE = "Programming is learned by writing programs. ― Brian Kernighan";

    public static void streamComposition() {
        try (OutputStream outputStream = Files.newOutputStream(Path.of("src/main/resources/hw6/composition.txt"));
             CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32());
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             OutputStreamWriter outputStreamWriter =
                 new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             PrintWriter printWriter = new PrintWriter(outputStreamWriter)) {
            printWriter.println(MESSAGE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
