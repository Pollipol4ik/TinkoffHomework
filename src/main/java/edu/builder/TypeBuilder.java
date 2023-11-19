package edu.builder;

import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.LogSource;
import edu.model.NginxLog;
import edu.model.Request;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TypeBuilder extends LogStatsBuilder {

    public TypeBuilder(LogFilter logFilter) {
        super(logFilter);
    }

    @Override
    public Components collect(LogSource logWrapper) {
        return Components.builder()
            .header("Типы запроса")
            .tableHeaders(List.of("Наименование запроса", "Количество вхождений"))
            .lines(getStatsLines(logWrapper))
            .build();
    }

    @Override
    protected List<String> getStatsLines(LogSource logWrapper) {
        return logWrapper.logs().stream()
            .filter(log -> logFilter.hasPassedFilter(log))
            .map(NginxLog::request)
            .map(Request::type)
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                map -> map.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .map(entry -> entry.getKey() + "|" + entry.getValue())
                    .collect(Collectors.toList())
            ));
    }
}
