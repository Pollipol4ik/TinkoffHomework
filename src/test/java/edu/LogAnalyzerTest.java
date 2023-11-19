package edu;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogAnalyzerTest {

    @Test
    @DisplayName("#run test")
    public void run_shouldNotThrowAnyException_whenEverythingIsRight() {
        Assertions.assertDoesNotThrow(() -> new LogAnalyzer(new String[] {"--path",
            "logs/logFirst.txt",
            "logs/logSecond.txt",
            "--format",
            "markdown", "--from", "2023-03-22", "--to", "2023-03-26"}).run());
    }
}
