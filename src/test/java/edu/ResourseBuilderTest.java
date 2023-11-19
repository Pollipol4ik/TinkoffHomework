package edu;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Stream;
import edu.builder.ResourseBuilder;
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

public class ResourseBuilderTest {

    private static Stream<Arguments> inputsForCollectTest() {
        return Stream.of(
            Arguments.of(
                new LogSource(
                    new LogData(List.of("testSource")),
                    List.of(
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_1").build())
                            .timeLocal(
                                OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_2").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_3").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_3").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_1").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_5").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_6").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_7").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_8").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_10").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_11").build())
                            .timeLocal(OffsetDateTime.now())
                            .build(),
                        NginxLog.builder().request(Request.builder().resource("/downloads/product_12").build())
                            .timeLocal(OffsetDateTime.now())
                            .build()
                    )
                ),
                // basic limit is 10
                List.of(
                    "'/product_1'|2",
                    "'/product_2'|1",
                    "'/product_3'|2",
                    "'/product_5'|1",
                    "'/product_6'|1",
                    "'/product_7'|1",
                    "'/product_8'|1",
                    "'/product_10'|1",
                    "'/product_11'|1",
                    "'/product_12'|1"
                )

            ));
    }

    @ParameterizedTest
    @MethodSource("inputsForCollectTest")
    @DisplayName("#collect test")
    public void collect_shouldReturnRequestsStats(LogSource testLogs, List<String> expectedLines) {
        Components actual =
            new ResourseBuilder(LogFilter.link(new DateFilter(null, null))).collect(testLogs);
        assertThat(actual.lines()).containsExactlyInAnyOrderElementsOf(expectedLines);
    }
}
