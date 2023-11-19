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

public class ResourseBuilder extends LogStatsBuilder {

    private static final int MAX_RESOURCES_LIMIT = 10;

    public ResourseBuilder(LogFilter logFilter) {
        super(logFilter);
    }

    @Override
    public Components collect(LogSource logWrapper) {
        return Components.builder()
            .header(String.format("%d самых часто запрашиваемых ресурсов", MAX_RESOURCES_LIMIT))
            .tableHeaders(List.of("Ресурс", "Количество"))
            .lines(getStatsLines(logWrapper))
            .build();
    }

    @Override
    protected List<String> getStatsLines(LogSource logWrapper) {
//        return logWrapper.logs().stream()
//            .filter(log -> logFilter.hasPassedFilter(log))
//            .map(NginxLog::request)
//            .map(Request::resource)
//            .map(str -> str.substring(str.lastIndexOf('/')))
//            .collect(Collectors.collectingAndThen(
//                Collectors.groupingBy(Function.identity(), Collectors.counting()),
//                map -> map.entrySet().stream()
//                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                    .map(entry -> String.format("'%s'|%d", entry.getKey(), entry.getValue()))
//                    .limit(MAX_RESOURCES_LIMIT)
//                    .toList()
//            ));
        return logWrapper.logs().stream()
            .filter(log -> logFilter.hasPassedFilter(log))
            .map(NginxLog::request)
            .map(Request::resource)
            .map(str -> str.substring(str.lastIndexOf('/')))
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                map -> map.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .map(entry -> "'" + entry.getKey() + "'" + "|" + entry.getValue())
                    .limit(MAX_RESOURCES_LIMIT)
                    .toList()
            ));
    }
}

