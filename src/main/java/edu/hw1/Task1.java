package edu.hw1;

import java.util.Scanner;

public class Task1 {
    protected Task1() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String videoLength = in.nextLine();
        int totalSeconds = getVideoLengthInSeconds(videoLength);
        System.out.println(totalSeconds);
    }

    public static int getVideoLengthInSeconds(String videoLength) {
        String[] timeArray = videoLength.split(":");
        int minutes = Integer.parseInt(timeArray[0]);
        int seconds = Integer.parseInt(timeArray[1]);
        int totalSeconds = minutes * 60 + seconds;
        return totalSeconds;
    }
}
