package edu;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Stream;
import edu.builder.AddressBuilder;
import edu.filter.DateFilter;
import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.LogData;
import edu.model.LogSource;
import edu.model.NginxLog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class AddressBuilderTest {

    private static Stream<Arguments> inputsForCollectTest() {
        return Stream.of(
            Arguments.of(
                new LogSource(
                    new LogData(List.of("testSource")),
                    List.of(
                        NginxLog.builder().remoteAddress("192.73.252.145").timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().remoteAddress("192.73.252.145").timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().remoteAddress("192.73.252.145").timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().remoteAddress("192.73.253.145").timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().remoteAddress("192.73.253.145").timeLocal(OffsetDateTime.now()).build(),
                        NginxLog.builder().remoteAddress("192.73.252.145").timeLocal(OffsetDateTime.now()).build()
                    )
                ), List.of("192.73.252.145|4", "192.73.253.145|2")
            ));
    }

    @ParameterizedTest
    @MethodSource("inputsForCollectTest")
    @DisplayName("#collect test")
    public void collect_shouldReturnRequestsStats(LogSource testLogs, List<String> expectedLines) {
        Components actual =
            new AddressBuilder(LogFilter.link(new DateFilter(null, null))).collect(testLogs);
        assertThat(actual.lines()).containsExactlyInAnyOrderElementsOf(expectedLines);
    }
}
