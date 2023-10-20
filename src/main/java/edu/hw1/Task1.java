package edu.hw1;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    protected Task1() {

    }

    public static int getVideoLengthInSeconds(String videoLength) throws NumberFormatException {

        if (videoLength == null) {
            return -1;
        }

        String[] timeArray = videoLength.split(":");
        if (timeArray.length != 2) {
            return -1;
        }

        try {
            int minutes = Integer.parseInt(timeArray[0]);
            int seconds = Integer.parseInt(timeArray[1]);

            if (minutes >= 0 && seconds >= 0 && seconds < SECONDS_IN_MINUTE) {
                return minutes * SECONDS_IN_MINUTE + seconds;
            }
        } catch (NumberFormatException e) {
        }

        return -1;
    }

}
