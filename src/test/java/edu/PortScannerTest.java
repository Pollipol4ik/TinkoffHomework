package edu;

import edu.task6.PortScanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PortScannerTest {
    @Test
    @DisplayName("printUsedPorts test")
    public void printUsedPorts_shouldPrintListOfUsedPorts() {
        assertDoesNotThrow(PortScanner::scanPorts);
    }
}
