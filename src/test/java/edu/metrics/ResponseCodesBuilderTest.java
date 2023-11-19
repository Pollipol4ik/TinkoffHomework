package edu.metrics;

import edu.model.metrics.Metric;
import edu.model.metrics.MetricsBuilder;

import java.util.List;
import edu.model.metrics.ResponseCodesBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static edu.TestUtils.logsForTests;

public class ResponseCodesBuilderTest {
    @Test
    @DisplayName("One file response metric build test")
    public void build_shouldReturnMetricForResponseInfo() {
        MetricsBuilder metricBuilder = new ResponseCodesBuilder();
        assertThat(metricBuilder.build(logsForTests)).isEqualTo(
            new Metric(
                "Коды ответа", List.of
                (
                    "Код|Имя|Количество",
                    "200|OK|6",
                    "400|Bad Request|1"
                )
            )
        );
    }
}
