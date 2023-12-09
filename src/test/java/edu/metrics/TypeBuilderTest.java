package edu.metrics;


import java.util.List;
import edu.model.metrics.Metric;
import edu.model.metrics.MetricsBuilder;
import edu.model.metrics.TypeBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.TestUtils.logsForTests;
import static org.assertj.core.api.Assertions.assertThat;


public class TypeBuilderTest {
    @Test
    @DisplayName("One file request metric build test")
    public void build_shouldReturnMetricForResourcesInfo() {
        MetricsBuilder metricBuilder = new TypeBuilder();
        assertThat(metricBuilder.build(logsForTests)).isEqualTo(
            new Metric(
                "HTTP запросы", List.of
                (
                    "Запрос|Количество",
                    "GET|6",
                    "PUT|1"
                )
            )
        );
    }
}
