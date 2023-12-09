package edu.print;

import edu.printer.Printer;
import edu.model.metrics.Metric;;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MetricPrinterTest {
    @Test
    @DisplayName("Wrong format test")
    public void printMetrics_shouldThrowException_whenFormatIsNotCorrect() {
        Printer printer = new Printer();
        assertThatThrownBy(() -> printer.printMetrics("notmarkdown", List.of(
            new Metric("Test", List.of("aboba|aboba"))
        )));
    }
}
