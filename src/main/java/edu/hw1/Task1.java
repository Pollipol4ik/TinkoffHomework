package edu.hw1;


public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;

    protected Task1() {

    }

    public static int getVideoLengthInSeconds(String videoLength) {
        if (videoLength != null) {
            String[] timeArray = videoLength.split(":");
            if (timeArray[0].length() > 1 && timeArray[1].length() == 2 && timeArray.length == 2) {
                try {
                    int minutes = Integer.parseInt(timeArray[0]);
                    int seconds = Integer.parseInt(timeArray[1]);
                    if (seconds < SECONDS_IN_MINUTE && seconds >= 0 && minutes >= 0) {
                        return minutes * SECONDS_IN_MINUTE + seconds;
                    }
                } catch (NumberFormatException e) {
                    return -1;
                }
            }
        }
        return -1;
    }
}


