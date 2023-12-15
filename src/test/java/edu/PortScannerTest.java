package edu;

import edu.task6.PortScanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PortScannerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testScanPorts() {
        PortScanner.scanPorts();
        String output = outContent.toString();
        assertTrue(output.contains("Протокол") && output.contains("Порт") && output.contains("Сервис"));
    }
}
