package edu.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridayThe13th {
    private static final int FRIDAY_THE_13TH = 13;

//    public static void main(String[] args) {
//        int yearToCheck = 2024;
//
//        List<LocalDate> fridaysThe13th = findFridaysThe13th(yearToCheck);
//        System.out.println("Пятницы 13-е в " + yearToCheck + ": " + fridaysThe13th);
//
//        LocalDate currentDate = LocalDate.now();
//        LocalDate nextFridayThe13th = findNextFridayThe13th(currentDate);
//        System.out.println("Следующая пятница 13-е после " + currentDate + ": " + nextFridayThe13th);
//    }

    public static List<LocalDate> findFridaysThe13th(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("year should be > 0");
        }
        List<LocalDate> fridaysThe13th = new ArrayList<>();

        for (int month = 1; month <= FRIDAY_THE_13TH - 1; month++) {
            LocalDate date = LocalDate.of(year, month, FRIDAY_THE_13TH);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                fridaysThe13th.add(date);
            }
        }

        return fridaysThe13th;
    }

    public static LocalDate findNextFridayThe13th(LocalDate currentDate) {
        return currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))
            .with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).withDayOfMonth(FRIDAY_THE_13TH);
    }
}

