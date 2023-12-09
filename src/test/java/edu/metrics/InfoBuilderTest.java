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

}
