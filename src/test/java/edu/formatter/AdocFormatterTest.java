package edu.formatter;

import edu.model.metrics.Metric;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AdocFormatterTest {

    @Test
    @DisplayName("Adoc format test")
    public void print_shouldReturnStringInAdocFormat() {
        FormatterPrint formatPrinter = new AsciiDocFormatter();
        Metric metric = new Metric("Test", List.of("Test column|Number", "first|1", "second|2"));
        String formattedString = """
            ==== Test

            |==================
            |Test column|Number

            |      first|     1
            |     second|     2
            |==================
            """;
        assertThat(formatPrinter.print(metric)).isEqualTo(formattedString);
    }
}