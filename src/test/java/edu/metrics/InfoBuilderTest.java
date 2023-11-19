package edu.metrics;


import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import edu.model.Log;
import edu.model.metrics.InfoBuilder;
import edu.model.metrics.Metric;
import edu.parser.logparser.LogParser;
import edu.parser.logparser.NginxLogParser;
import edu.receiver.PathLogReceiver;
import edu.receiver.Receiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.TestUtils.logsForTests;
import static edu.parser.pathparser.PathParser.getPaths;
import static org.assertj.core.api.Assertions.assertThat;


public class InfoBuilderTest {
    private final OffsetDateTime fromDateOffset = OffsetDateTime.of(2023, 10, 5, 0, 0, 0, 0, ZoneOffset.UTC);
    private final OffsetDateTime toDateOffset = OffsetDateTime.of(2023, 10, 7, 0, 0, 0, 0, ZoneOffset.UTC);

    @Test
    @DisplayName("One file main metric build test")
    public void build_shouldReturnMetricForMainInfo() {
        InfoBuilder metricBuilder = new InfoBuilder(
            OffsetDateTime.MIN, OffsetDateTime.MAX,
            List.of(
                "src/main/resources/log1.txt"
            )
        );
        assertThat(metricBuilder.build(logsForTests)).isEqualTo(
            new Metric(
                "Общая информация", List.of
                (
                    "Метрика|Значение", "Файл(ы)|`src/main/resources/log1.txt`",
                    "Начальная дата|-", "Конечная дата|-",
                    "Количество запросов|7", "Средний размер ответа|1779.7142857142858"
                )
            )
        );
    }

//    @Test
//    @DisplayName("Two files with date main metric build test")
//    public void build_shouldReturnMetricForMainInfoWithoutSomeLogs() {
//        Receiver receiver;
//        List<Path> pathsToLogs = getPaths("src/main/resources/*");
//        receiver = new PathLogReceiver(pathsToLogs);
//        LogParser logParser = new NginxLogParser();
//        List<Log> logs = filterLogsByDate(logParser.parseLogs(receiver.receive()));
//        InfoBuilder metricBuilder = new InfoBuilder(
//            fromDateOffset,
//            toDateOffset,
//            List.of(
//                "src/main/resources/log1.txt", "src/main/resources/log2.txt"
//            )
//        );
//        assertThat(metricBuilder.build(logs)).isEqualTo(
//            new Metric(
//                "Общая информация", List.of
//                (
//                    "Метрика|Значение",
//                    "Файл(ы)|`src/main/resources/log1.txt`, `src/main/resources/log2.txt`",
//                    "Начальная дата|05.10.2023",
//                    "Конечная дата|07.10.2023",
//                    "Количество запросов|4",
//                    "Средний размер ответа|1479.0"
//                )
//            )
//        );
//    }
//
//    private List<Log> filterLogsByDate(List<Log> logs) {
//        return logs.stream()
//            .filter(log -> (log.date().isBefore(toDateOffset) && log.date().isAfter(fromDateOffset)))
//            .toList();
//    }
}
