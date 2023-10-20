package edu.hw1;

public class Task2 {
    private static final int TEN = 10;

    protected Task2() {

    }

    public static int countDigits(int number) {

        int num = Math.abs(number);
        if (num != 0) {
            int count = 0;
            while (num != 0) {
                num /= TEN;
                count++;
            }
            return count;
        }
        return 1;

    }

}

