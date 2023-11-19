package edu.model.metrics;

import edu.model.Log;
import java.util.List;

public interface MetricsBuilder {
    Metric build(List<Log> logs);
}
