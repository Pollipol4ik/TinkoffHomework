package edu;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Stream;
import edu.builder.ResponseCodesBuilder;
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
import static org.assertj.core.api.Assertions.*;

public class ResponseCodesBuilderTest {

    private static Stream<Arguments> inputsForCollectTest() {
        return Stream.of(
            Arguments.of(
                new LogSource(
                    new LogData(List.of("testSource")),
                    List.of(
                        NginxLog.builder().response(Response.builder().statusCode(200).build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().response(Response.builder().statusCode(200).build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().response(Response.builder().statusCode(200).build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().response(Response.builder().statusCode(404).build())
                            .timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().response(Response.builder().statusCode(404).build())
                            .timeLocal(OffsetDateTime.now()).build()
                    )
                ), List.of("200|OK|3", "404|Not Found|2")
            ));
    }

    @ParameterizedTest
    @MethodSource("inputsForCollectTest")
    @DisplayName("#collect test")
    public void collect_shouldReturnRequestsStats(LogSource testLogs, List<String> expectedLines) {
        Components actual =
            new ResponseCodesBuilder(LogFilter.link(new DateFilter(null, null))).collect(testLogs);
        assertThat(actual.lines()).containsExactlyInAnyOrderElementsOf(expectedLines);
    }
}
