package edu.task3;

import java.time.LocalDate;
import java.util.Optional;

public class DateParser {

    private static final DateParserStrategy[] DATE_PARSERS = {
        new IsoDateParser(),
        new ShortIsoDateParser(),
        new SlashDateParser(),
        new ShortSlashDateParser(),
        new KeywordDateParser(),
        new AgoDateParser()
    };

    private DateParser() {
    }


    public static Optional<LocalDate> parseDate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }

        DateParserStrategy parser = DateParserStrategy.makeChain(
            new IsoDateParser(),
            new ShortIsoDateParser(),
            new SlashDateParser(),
            new ShortSlashDateParser(),
            new KeywordDateParser(),
            new AgoDateParser()
        );
        return parser.parse(input);
    }
}

