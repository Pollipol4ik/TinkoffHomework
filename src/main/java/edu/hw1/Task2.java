package edu.hw1;

public class Task2 {
    private static final int TEN = 10;

    protected Task2() {

    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        int count = 0;
        int num = number;
        while (num != 0) {
            num /= 10;
            count++;
        }

        return count;
    }

}

