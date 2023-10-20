package edu.hw1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final Pattern ONLY_DIGITS = Pattern.compile("^[0-9]+$");

    protected Task1() {

    }

    private static boolean isNumberValid(String num) {
        Matcher matcher = ONLY_DIGITS.matcher(num);
        return matcher.matches();
    }

    public static int getVideoLengthInSeconds(String videoLength) {
        String[] timeArray = videoLength.split(":");
        if (timeArray.length != 2) {
            return -1;
        }

        int minutes;
        int seconds;
        if (isNumberValid(timeArray[0]) && isNumberValid(timeArray[1])) {
            minutes = Integer.parseInt(timeArray[0]);
            seconds = Integer.parseInt(timeArray[1]);

            if (seconds < SECONDS_IN_MINUTE) {
                return minutes * SECONDS_IN_MINUTE + seconds;
            }
        }

        return -1;
    }
}





