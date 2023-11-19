package edu;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;
import edu.builder.InfoBuilder;
import edu.filter.DateFilter;
import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.LogData;
import edu.model.LogSource;
import edu.model.NginxLog;
import edu.model.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InfoBuilderTest {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static Stream<Arguments> inputsForCollectTest() {
        return Stream.of(
            Arguments.of(
                new LogSource(
                    new LogData(List.of("test.log")),
                    List.of(
                        NginxLog.builder().response(Response.builder().bodyBytesSend(200).build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().response(Response.builder().bodyBytesSend(400).build())
                            .timeLocal(OffsetDateTime.now()).build()
                    )
                ),
                List.of(
                    "Файл(-ы)|'test.log'",
                    "Начальная дата|-",
                    "Конечная дата|-",
                    "Количество запросов|2",
                    "Средний размер ответа|300.0b"
                )
            ),
            Arguments.of(
                new LogSource(
                    new LogData(List.of("test1.log", "test2.log"), OffsetDateTime.now(), OffsetDateTime.now()),
                    List.of(
                        NginxLog.builder().response(Response.builder().bodyBytesSend(200).build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().response(Response.builder().bodyBytesSend(400).build())
                            .timeLocal(OffsetDateTime.now()).build()
                    )
                ),
                List.of(
                    "Файл(-ы)|'test1.log''test2.log'",
                    "Начальная дата|" + DATE_FORMATTER.format(OffsetDateTime.now()),
                    "Конечная дата|" + DATE_FORMATTER.format(OffsetDateTime.now()),
                    "Количество запросов|2",
                    "Средний размер ответа|300.0b"
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("inputsForCollectTest")
    @DisplayName("#collect test")
    public void collect_shouldReturnRequestsStats(LogSource testLogs, List<String> expectedLines) {
        Components actual =
            new InfoBuilder(LogFilter.link(new DateFilter(null, null))).collect(testLogs);
        assertThat(actual.lines()).containsExactlyInAnyOrderElementsOf(expectedLines);
    }
}
