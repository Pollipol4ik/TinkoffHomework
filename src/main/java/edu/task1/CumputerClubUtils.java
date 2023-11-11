package edu.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CumputerClubUtils {

    public static void calculateAverageSessionTime(String[] input) {

        List<LocalDateTime> startTimes = new ArrayList<>();
        List<LocalDateTime> endTimes = new ArrayList<>();

        for (String session : input) {
            String[] sessionParts = session.split(" - ");
            startTimes.add(LocalDateTime.parse(sessionParts[0], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm")));
            endTimes.add(LocalDateTime.parse(sessionParts[1], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm")));
        }


        Duration totalDuration = Duration.ZERO;
        for (int i = 0; i < startTimes.size(); i++) {
            totalDuration = totalDuration.plus(Duration.between(startTimes.get(i), endTimes.get(i)));
        }


        long averageSeconds = totalDuration.getSeconds() / startTimes.size();
        long hours = averageSeconds / 3600;
        long minutes = (averageSeconds % 3600) / 60;

        System.out.println("Среднее время за сеанс: " + hours + "ч " + minutes + "м");
    }
}
