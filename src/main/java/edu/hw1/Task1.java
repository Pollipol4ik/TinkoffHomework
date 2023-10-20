package edu.hw1;

public class Task1 {
    private static final int SECONDS_IN_MINUTE = 60;
    //private static final Pattern NOT_NEGATIVE = Pattern.compile("^[0-9]*$");

    protected Task1() {

    }

    public static int getVideoLengthInSeconds(String videoLength) {
        String[] timeArray = videoLength.split(":");
        int minutes = Integer.parseInt(timeArray[0]);
        int seconds = Integer.parseInt(timeArray[1]);
//        if (!isValid(timeArray[0]) || !isValid(timeArray[1])) {
//            return -1;
//        }
        if (seconds >= SECONDS_IN_MINUTE || minutes < 0 || timeArray.length != 2) {
            return -1;
        }
        return minutes * SECONDS_IN_MINUTE + seconds;
    }

//    private static boolean isValid(String num) {
//        Matcher matcher = NOT_NEGATIVE.matcher(num);
//        return matcher.matches();
//    }
}


