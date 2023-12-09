package edu;


import edu.model.Log;
import edu.model.metrics.AddressBuilder;
import edu.model.metrics.InfoBuilder;
import edu.model.metrics.Metric;
import edu.model.metrics.MetricsBuilder;
import edu.model.metrics.ResourseBuilder;
import edu.model.metrics.ResponseCodesBuilder;
import edu.model.metrics.TypeBuilder;
import edu.parser.argsParser.ParseFormat;
import edu.parser.logparser.LogParser;
import edu.parser.logparser.NginxLogParser;
import edu.printer.Printer;
import edu.receiver.HttpLogReceiver;
import edu.receiver.PathLogReceiver;
import edu.receiver.Receiver;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import static edu.parser.argsParser.ArgsParser.getParseFormat;
import static edu.parser.pathparser.PathParser.getPaths;

public class LogAnalyzer {
    private OffsetDateTime fromDateOffset;
    private OffsetDateTime toDateOffset;

    public void run(String[] args) {
        ParseFormat parseFormat = getParseFormat(String.join(" ", args));
        Receiver receiver;
        List<String> paths = new ArrayList<>();
        if (parseFormat.path().startsWith("http")) {
            paths.add(parseFormat.path());
            receiver = new HttpLogReceiver(parseFormat.path());
        } else {
            List<Path> pathsToLogs = getPaths(parseFormat.path());
            paths = pathsToLogs.stream().map(Path::toString).toList();
            receiver = new PathLogReceiver(pathsToLogs);
        }
        getFromDate(parseFormat);
        getToDate(parseFormat);
        LogParser logParser = new NginxLogParser();
        List<Log> logs = filterLogsByDate(logParser.parseLogs(receiver.receive()));
        List<Metric> metrics = getAllMetrics(logs, paths);
        Printer printer = new Printer();
        printer.printMetrics(parseFormat.format(), metrics);
    }

    private List<Log> filterLogsByDate(List<Log> logs) {
        return logs.stream()
            .filter(log -> (log.date().isBefore(toDateOffset) && log.date().isAfter(fromDateOffset)))
            .toList();
    }

    private List<Metric> getAllMetrics(List<Log> logs, List<String> paths) {
        MetricsBuilder metricMainInfoBuilder = new InfoBuilder(
            fromDateOffset, toDateOffset, paths);
        MetricsBuilder metricResourcesInfoBuilder = new ResourseBuilder();
        MetricsBuilder metricResponseCodesInfoBuilder = new ResponseCodesBuilder();
        MetricsBuilder metricRequestMethodsInfoBuilder = new TypeBuilder();
        MetricsBuilder metricIpInfoBuilder = new AddressBuilder();
        return List.of(
            metricMainInfoBuilder.build(logs),
            metricResourcesInfoBuilder.build(logs),
            metricResponseCodesInfoBuilder.build(logs),
            metricRequestMethodsInfoBuilder.build(logs),
            metricIpInfoBuilder.build(logs)
        );
    }

    private void getFromDate(ParseFormat parseFormat) {
        if (!parseFormat.fromDate().isEmpty()) {
            LocalDate localDate = LocalDate.parse(parseFormat.fromDate());
            fromDateOffset = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        } else {
            fromDateOffset = OffsetDateTime.MIN;
        }
    }

    private void getToDate(ParseFormat parseFormat) {
        if (!parseFormat.toDate().isEmpty()) {
            LocalDate localDate = LocalDate.parse(parseFormat.toDate());
            toDateOffset = localDate.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
        } else {
            toDateOffset = OffsetDateTime.MAX;
        }
    }
}

