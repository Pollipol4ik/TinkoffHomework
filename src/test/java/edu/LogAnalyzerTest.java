package edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LogAnalyzerTest {
    private final String[] args = {"--path", "src/main/resources/log1.txt", "--format", "adoc"};

    @Test
    @DisplayName("Application start test")
    public void run_shouldNotThrowAnyException() {
        LogAnalyzer logParserApplication = new LogAnalyzer();
        assertDoesNotThrow(() -> logParserApplication.run(args));
    }
}
