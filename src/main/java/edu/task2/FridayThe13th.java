package edu.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class FridayThe13th {
    private static final int FRIDAY_THE_13TH = 13;

    private FridayThe13th() {

    }

    public static List<LocalDate> findFridaysThe13th(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("year should be > 0");
        }
        List<LocalDate> fridaysThe13th = new ArrayList<>();
        LocalDate localDate = LocalDate.of(year, Month.JANUARY, 1);
        while (localDate.getYear() == year) {
            localDate = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (localDate.getDayOfMonth() == FRIDAY_THE_13TH) {
                fridaysThe13th.add(localDate);
            }
        }

        return fridaysThe13th;
    }

    public static LocalDate findNextFridayThe13th(LocalDate currentDate) {
        if (currentDate == null) {
            throw new IllegalArgumentException("currentDate shouldn`t be null");
        }
        LocalDate localDate = currentDate;
        while (true) {
            localDate = localDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            if (localDate.getDayOfMonth() == FRIDAY_THE_13TH) {
                return localDate;
            }
        }

    }
}

