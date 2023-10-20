package edu.hw1;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    protected Task1() {

    }

    public static int getVideoLengthInSeconds(String videoLength) {
        String[] timeArray = videoLength.split(":");
        int minutes = Integer.parseInt(timeArray[0]);
        int seconds = Integer.parseInt(timeArray[1]);
        if (seconds >= SECONDS_IN_MINUTE || minutes < 0) {
            return -1;
        }
        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
