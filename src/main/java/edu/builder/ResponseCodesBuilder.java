package edu.builder;

import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.HttpStatusCode;
import edu.model.LogSource;
import edu.model.NginxLog;
import edu.model.Response;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ResponseCodesBuilder extends LogStatsBuilder {
    private static final int MAX_INFO = 20;

    public ResponseCodesBuilder(LogFilter logFilter) {
        super(logFilter);
    }

    @Override
    public Components collect(LogSource logWrapper) {
        return Components.builder()
            .header("Коды ответа")
            .tableHeaders(List.of("Код", "Имя", "Количество"))
            .lines(getStatsLines(logWrapper))
            .build();
    }

    @Override
    protected List<String> getStatsLines(LogSource logWrapper) {
//        Map<Integer, Long> responseCodeCounts = logWrapper.logs().stream()
//            .filter(logFilter::hasPassedFilter)
//            .map(log -> log.response().statusCode())
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        return responseCodeCounts.entrySet().stream()
//            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
//            .limit(MAX_INFO)
//            .map(entry -> formatStatsLine(entry.getKey(), HttpStatusCode.getByValue(entry.getKey()), entry.getValue()))
//            .collect(Collectors.toList());
        return logWrapper.logs().stream()
            .filter(log -> logFilter.hasPassedFilter(log))
            .map(NginxLog::response)
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Response::statusCode, Collectors.counting()),
                map -> map.entrySet().stream()
                    .map(entry -> HttpStatusCode.getByValue(entry.getKey()) + "|"
                        + entry.getValue())
                    .sorted()
                    .collect(Collectors.toList())//.reversed()
            ));
    }

//    private String formatStatsLine(Integer statusCode, HttpStatusCode status, Long count) {
//        return String.format("%d|%s|%d", statusCode, status, count);
//    }
}


