package edu;

import edu.builder.AddressBuilder;
import edu.builder.InfoBuilder;
import edu.builder.LogStatsBuilder;
import edu.builder.ResourseBuilder;
import edu.builder.ResponseCodesBuilder;
import edu.builder.TypeBuilder;
import edu.filter.DateFilter;
import edu.filter.LogFilter;
import edu.formatter.AsciiDocFormatter;
import edu.formatter.MarkdownFormatter;
import edu.formatter.StatusFormatter;
import edu.model.Argument;
import edu.model.LogData;
import edu.model.LogSource;
import edu.model.TimingInterval;
import edu.model.TypeFormat;
import edu.parser.LogParser;
import edu.printer.CommandLinePrinter;
import edu.printer.Printer;
import edu.receiver.PathReceiverSelector;
import edu.receiver.Receiver;
import edu.receiver.Selector;
import edu.receiver.UrlSelector;
import edu.resolver.ArgumentResolver;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogAnalyzer {
    private final List<Argument> arguments;
    private final Printer printer;
    private List<LogStatsBuilder> collectors;
    private TypeFormat formatType = TypeFormat.MARKDOWN;
    private LogSource logSourceWrapper;
    private TimingInterval timeInterval;
    private LogFilter logFilter;

    public LogAnalyzer(String[] args) {
        this.arguments = new ArgumentResolver().resolve(args);
        this.printer = new CommandLinePrinter();
    }

    public void run() {
        initAllParameters();
        // arguments(0).value() is always paths
        loadAllLogsToWrapper(arguments.get(0).value().split(" "));
        initLogFilter();
        initCollectors();
        printStats();
    }

    private void initAllParameters() {
        TimingInterval.TimingIntervalBuilder timeIntervalBuilder = TimingInterval.builder();
        for (Argument argument : arguments) {
            switch (argument.type()) {
                case FORMAT -> {
                    formatType = TypeFormat.findByValue(argument.value());
                }
                case TO -> {
                    timeIntervalBuilder.to(argument.value());
                }
                case FROM -> {
                    timeIntervalBuilder.from(argument.value());
                }
                default -> {
                }
            }
        }
        timeInterval = timeIntervalBuilder.build();
    }

    private void loadAllLogsToWrapper(String[] paths) {
        List<String> lines = new ArrayList<>();

        for (String path : paths) {
            Receiver logRetriever = getRetriever(path);
            lines.addAll(logRetriever.receive());
        }
        logSourceWrapper = new LogSource(
            new LogData(List.of(paths), timeInterval.from(), timeInterval.to()),
            lines.stream().map(LogParser::parseLog).collect(
                Collectors.toList())
        );
    }

    private Receiver getRetriever(String path) {
        Selector selector = Selector.link(new PathReceiverSelector(), new UrlSelector());
        return selector.selectRetriever(path);
    }

    private void initLogFilter() {
        logFilter = LogFilter.link(new DateFilter(timeInterval.to(), timeInterval.from()));
    }

    private void initCollectors() {
        collectors = new ArrayList<>();
        collectors.add(new AddressBuilder(logFilter));
        collectors.add(new InfoBuilder(logFilter));
        collectors.add(new ResourseBuilder(logFilter));
        collectors.add(new ResponseCodesBuilder(logFilter));
        collectors.add(new TypeBuilder(logFilter));
    }

    private void printStats() {
        StatusFormatter formatter = switch (formatType) {
            case ADOC -> new AsciiDocFormatter();
            default -> new MarkdownFormatter();
        };
        for (LogStatsBuilder collector : collectors) {
            printer.print(formatter.format(collector.collect(logSourceWrapper)));
        }
    }
}

