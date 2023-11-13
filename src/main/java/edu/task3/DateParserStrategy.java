package edu.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DateParserStrategy {
    DateParserStrategy nextParser;

    public static DateParserStrategy makeChain(DateParserStrategy first, DateParserStrategy... dateParsers) {
        DateParserStrategy currentParser = first;
        for (var parser : dateParsers) {
            currentParser.nextParser = parser;
            currentParser = parser;
        }
        return first;
    }

    abstract Optional<LocalDate> parse(String date);

    protected Optional<LocalDate> parseNext(String date) {
        if (nextParser != null) {
            return nextParser.parse(date);
        } else {
            return Optional.empty();
        }
    }
}
