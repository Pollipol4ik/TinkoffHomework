package edu.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParser {

    private static final DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    // Регулярные выражения для разных форматов даты
    private static final String ISO_DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}$";
    private static final String SHORT_ISO_DATE_REGEX = "^\\d{4}-\\d{1,2}-\\d{1,2}$";
    private static final String SLASH_DATE_REGEX = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
    private static final String SHORT_SLASH_DATE_REGEX = "^\\d{1,2}/\\d{1,2}/\\d{2}$";
    private static final String KEYWORD_DATE_REGEX = "^(tomorrow|today|yesterday)$";
    private static final String AGO_DATE_REGEX = "^(\\d+)\\s+days?\\s+ago$";

    // Массив регулярных выражений в порядке их проверки
    private static final String[] DATE_FORMATS = {
        ISO_DATE_REGEX,
        SHORT_ISO_DATE_REGEX,
        SLASH_DATE_REGEX,
        SHORT_SLASH_DATE_REGEX,
        KEYWORD_DATE_REGEX,
        AGO_DATE_REGEX
    };

    // Метод для распознавания формата даты
    private static Optional<LocalDate> parseDateWithRegex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            switch (regex) {
                case ISO_DATE_REGEX:
                case SHORT_ISO_DATE_REGEX:
                case SLASH_DATE_REGEX:
                case SHORT_SLASH_DATE_REGEX:
                    return Optional.of(LocalDate.parse(input, ISO_DATE_FORMATTER));
                case KEYWORD_DATE_REGEX:
                    switch (input) {
                        case "tomorrow":
                            return Optional.of(LocalDate.now().plusDays(1));
                        case "today":
                            return Optional.of(LocalDate.now());
                        case "yesterday":
                            return Optional.of(LocalDate.now().minusDays(1));
                    }
                    break;
                case AGO_DATE_REGEX:
                    int daysAgo = Integer.parseInt(matcher.group(1));
                    return Optional.of(LocalDate.now().minusDays(daysAgo));
            }
        }

        return Optional.empty();
    }

    // Метод для обработки всех форматов даты
    public static Optional<LocalDate> parseDate(String input) {
        for (String format : DATE_FORMATS) {
            Optional<LocalDate> date = parseDateWithRegex(input, format);
            if (date.isPresent()) {
                return date;
            }
        }
        return Optional.empty();
    }
}
