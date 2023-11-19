package edu;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Stream;
import edu.builder.TypeBuilder;
import edu.filter.DateFilter;
import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.LogData;
import edu.model.LogSource;
import edu.model.NginxLog;
import edu.model.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TypeBuilderTest {
    private static Stream<Arguments> inputsForCollectTest() {
        return Stream.of(
            Arguments.of(
                new LogSource(
                    new LogData(List.of("testSource")),
                    List.of(
                        NginxLog.builder().request(Request.builder().type("GET").build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().request(Request.builder().type("GET").build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().request(Request.builder().type("GET").build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().request(Request.builder().type("PUT").build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().request(Request.builder().type("GET").build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().request(Request.builder().type("DELETE").build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().request(Request.builder().type("DELETE").build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().request(Request.builder().type("PATCH").build())
                            .timeLocal(OffsetDateTime.now()).build()
                    )
                ), List.of("GET|4", "PUT|1", "DELETE|2", "PATCH|1")
            ));
    }

    @ParameterizedTest
    @MethodSource("inputsForCollectTest")
    @DisplayName("#collect test")
    public void collect_shouldReturnRequestsStats(LogSource testLogs, List<String> expectedLines) {
        Components actual =
            new TypeBuilder(LogFilter.link(new DateFilter(null, null))).collect(testLogs);
        assertThat(actual.lines()).containsExactlyInAnyOrderElementsOf(expectedLines);
    }
}
