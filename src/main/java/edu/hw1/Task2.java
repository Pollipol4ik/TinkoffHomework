package edu.hw1;

public class Task2 {
    private static final int TEN = 10;

    protected Task2() {

    }

    public static int countDigits(int number) {

        int num = number;
        int counter = 1;
        while (Math.abs(num) > TEN - 1) {
            num /= TEN;
            counter++;
        }
        return counter;
    }
}
