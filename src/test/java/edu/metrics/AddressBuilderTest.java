package edu.metrics;


import java.util.List;
import edu.model.metrics.AddressBuilder;
import edu.model.metrics.Metric;
import edu.model.metrics.MetricsBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.TestUtils.logsForTests;
import static org.assertj.core.api.Assertions.assertThat;

public class AddressBuilderTest {
    @Test
    @DisplayName("One file IP metric build test")
    public void build_shouldReturnMetricForIpInfo() {
        MetricsBuilder metricBuilder = new AddressBuilder();
        assertThat(metricBuilder.build(logsForTests)).isEqualTo(
            new Metric(
                "IP адреса", List.of
                (
                    "IP адрес|Количество запросов|Время последнего запроса",
                    "141.96.175.104|1|25.09.2023 06:10:36",
                    "165.138.198.30|1|27.09.2023 06:10:36",
                    "72.153.133.97|1|07.10.2023 06:10:36",
                    "72.153.133.99|1|05.10.2023 06:10:36",
                    "11.71.87.42|1|23.09.2023 06:10:36",
                    "185.253.246.248|1|30.09.2023 06:10:36",
                    "204.196.83.88|1|02.10.2023 06:10:36"
                )
            )
        );
    }
}
