package edu.hw1;

import java.util.Arrays;

public class Task6 {
    private static final int DIGIT = 6174;
    private static final int TEN = 10;
    private static final int DIGIT_SIZE = 4;
    private final static int MIN_VALUE = 1000;
    private final static int MAX_VALUE = 9998;

    protected Task6() {

    }

    public static int findKaprekarSteps(int n, int steps) {
        if (n < MIN_VALUE || n > MAX_VALUE) {
            return -1;
        }
        if (n == DIGIT) {
            return steps;
        }

        int[] digits = getDigits(n);
        Arrays.sort(digits);
        int asc = digitsToNumber(digits);

        Arrays.sort(digits);
        reverseArray(digits);
        int desc = digitsToNumber(digits);

        int result = desc - asc;
        return findKaprekarSteps(result, steps + 1);

    }

    private static int[] getDigits(int n) {
        int[] digits = new int[DIGIT_SIZE];
        int num = n;
        for (int i = DIGIT_SIZE - 1; i >= 0; i--) {
            digits[i] = num % TEN;
            num /= TEN;
        }
        return digits;
    }

    private static int digitsToNumber(int[] digits) {
        int number = 0;
        for (int i = 0; i < digits.length; i++) {
            number = number * TEN + digits[i];
        }
        return number;
    }

    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
