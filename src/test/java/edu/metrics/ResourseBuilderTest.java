package edu.metrics;


import java.util.List;
import edu.model.metrics.Metric;
import edu.model.metrics.MetricsBuilder;
import edu.model.metrics.ResourseBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.TestUtils.logsForTests;
import static org.assertj.core.api.Assertions.assertThat;

public class ResourseBuilderTest {
    @Test
    @DisplayName("One file resources metric build test")
    public void build_shouldReturnMetricForResourcesInfo() {
        MetricsBuilder metricBuilder = new ResourseBuilder();
        assertThat(metricBuilder.build(logsForTests)).isEqualTo(
            new Metric(
                "Запрашиваемые ресурсы", List.of
                (
                    "Ресурсы|Количество",
                    "`/exuding-Secured/contingency%20Future-proofed.css`|2",
                    "`/Focused-encoding.svg`|1",
                    "`/info-mediaries.php`|1",
                    "`/Future-proofed/Customer-focused/Upgradable/internet%20solution_Re-contextualized.css`|1",
                    "`/architecture/attitude-oriented/success/Cross-platform-neutral.css`|1",
                    "`/multi-state/orchestration.png`|1"
                )
            )
        );
    }
}
