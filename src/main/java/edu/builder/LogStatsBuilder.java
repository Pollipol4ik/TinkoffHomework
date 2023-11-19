package edu.builder;

import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.LogSource;
import java.util.List;

public abstract class LogStatsBuilder {

    protected LogFilter logFilter;

    public LogStatsBuilder(LogFilter logFilter) {
        this.logFilter = logFilter;
    }

    public abstract Components collect(LogSource logSource);

    protected abstract List<String> getStatsLines(LogSource logSource);
}
