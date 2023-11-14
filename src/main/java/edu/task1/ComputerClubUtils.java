package edu.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ComputerClubUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
    private static final Pattern SESSION_PATTERN =
        Pattern.compile("^(\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}) - (\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2})$");

    private ComputerClubUtils() {

    }

    public static String calculateAverageSessionTime(String[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Пустая статистика сессий");
        }

        List<LocalDateTime> startTimes = new ArrayList<>();
        List<LocalDateTime> endTimes = new ArrayList<>();

        for (String session : input) {
            if (!SESSION_PATTERN.matcher(session).matches()) {
                throw new IllegalArgumentException("Некорректный формат сессии: " + session);
            }

            String[] sessionParts = session.split(" - ");
            startTimes.add(LocalDateTime.parse(sessionParts[0], DATE_TIME_FORMATTER));
            endTimes.add(LocalDateTime.parse(sessionParts[1], DATE_TIME_FORMATTER));
        }

        Duration totalDuration = Duration.ZERO;
        for (int i = 0; i < startTimes.size(); i++) {
            totalDuration = totalDuration.plus(Duration.between(startTimes.get(i), endTimes.get(i)));
        }

        long secondsInHour = Duration.ofHours(1).getSeconds();
        long secondsInMinute = Duration.ofMinutes(1).getSeconds();

        long averageSeconds = totalDuration.getSeconds() / startTimes.size();

        long hours = averageSeconds / secondsInHour;
        long minutes = (averageSeconds % secondsInHour) / secondsInMinute;

        return "Среднее время за сеанс: " + hours + "ч " + minutes + "м";
    }
}
