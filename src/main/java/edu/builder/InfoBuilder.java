package edu.builder;

import edu.filter.LogFilter;
import edu.model.Components;
import edu.model.LogSource;
import edu.model.NginxLog;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class InfoBuilder extends LogStatsBuilder {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public InfoBuilder(LogFilter logFilter) {
        super(logFilter);
    }

    @Override
    public Components collect(LogSource logWrapper) {
        return Components.builder()
            .header("Общая информация")
            .tableHeaders(List.of("Метрика", "Значение"))
            .lines(getStatsLines(logWrapper))
            .build();
    }

//    @Override
//    protected List<String> getStatsLines(LogSource logWrapper) {
//        String fileNames = logWrapper.logData().sources().stream()
//            .map(source -> "'" + source + "'")
//            .collect(Collectors.joining("|"));
//
//        String startDate = logWrapper.logData().from() == null ? "-" : DATE_FORMATTER.format(logWrapper.logData().from());
//        String endDate = logWrapper.logData().to() == null ? "-" : DATE_FORMATTER.format(logWrapper.logData().to());
//        String totalRequests = String.valueOf(getTotalAmountOfLogs(logWrapper.logs()));
//        String avgResponseSize = String.valueOf(getAvgResponseSize(logWrapper.logs()));
//
//        return List.of(
//            "Файл(-ы)|" + fileNames,
//            "Начальная дата|" + startDate,
//            "Конечная дата|" + endDate,
//            "Количество запросов|" + totalRequests,
//            "Средний размер ответа|" + avgResponseSize + "b"
//        );
//    }
@Override
protected List<String> getStatsLines(LogSource logWrapper) {
    StringBuilder metaData = new StringBuilder();
    metaData.append("Файл(-ы)|");
    for (String source : logWrapper.logData().sources()) {
        metaData.append("'").append(source).append("'");
    }
    metaData
        .append("\n")
        .append("Начальная дата|")
        .append(logWrapper.logData().from() == null ? "-" : DATE_FORMATTER.format(logWrapper.logData().from()))
        .append("\n")
        .append("Конечная дата|")
        .append(logWrapper.logData().to() == null ? "-" : DATE_FORMATTER.format(logWrapper.logData().to()))
        .append("\n")
        .append("Количество запросов|")
        .append(getTotalAmountOfLogs(logWrapper.logs()))
        .append("\n")
        .append("Средний размер ответа|")
        .append(getAvgResponseSize(logWrapper.logs()))
        .append("b");
    return List.of(metaData.toString().split("\n"));
}



    private double getAvgResponseSize(List<NginxLog> logs) {
        double totalBytes = logs.stream()
            .filter(log -> logFilter.hasPassedFilter(log))
            .mapToDouble(log -> log.response().bodyBytesSend())
            .sum();

        return totalBytes / logs.size();
    }

    private long getTotalAmountOfLogs(List<NginxLog> logs) {
        return logs.stream().filter(log -> logFilter.hasPassedFilter(log)).count();
    }
}
