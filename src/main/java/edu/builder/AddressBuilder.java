package edu.builder;

import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.LogSource;
import edu.model.NginxLog;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressBuilder extends LogStatsBuilder {

    private static final int MAX_ADDRESSES_LIMIT = 8;

    public AddressBuilder(LogFilter logFilter) {
        super(logFilter);
    }

    @Override
    public Components collect(LogSource logWrapper) {
        return Components.builder()
            .header("%d самых часто запрашиваемых адресов".formatted(MAX_ADDRESSES_LIMIT))
            .tableHeaders(List.of("Адрес", "Количество"))
            .lines(getStatsLines(logWrapper))
            .build();
    }

    @Override
    protected List<String> getStatsLines(LogSource logWrapper) {
        return logWrapper.logs().stream()
            .filter(log -> logFilter.hasPassedFilter(log))
            .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(NginxLog::remoteAddress, Collectors.counting()),
                map -> map.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .map(entry -> entry.getKey() + "|" + entry.getValue())
                    .limit(MAX_ADDRESSES_LIMIT)
                    .collect(Collectors.toList())
            ));
    }
}
