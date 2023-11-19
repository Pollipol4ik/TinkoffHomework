package edu.printer;


import edu.formatter.AsciiDocFormatter;
import edu.formatter.FormatterPrint;
import edu.formatter.MarkdownFormatter;
import edu.model.metrics.Metric;
import java.util.List;

public class Printer {
    private FormatterPrint getFormatPrinter(String format) {
        return switch (format) {
            case "markdown" -> new MarkdownFormatter();
            case "adoc" -> new AsciiDocFormatter();
            default -> throw new IllegalStateException("Unexpected value: " + format);
        };
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    public void printMetrics(String format, List<Metric> metrics) {
        FormatterPrint printer = getFormatPrinter(format);
        metrics.forEach(metric -> System.out.println(printer.print(metric)));
    }
}
