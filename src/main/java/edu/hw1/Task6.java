package edu.hw1;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    protected Task6() {

    }

    public static int findKaprekarSteps(int n, int steps) {
        if (n == 6174) {
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
        int[] digits = new int[4];
        int num = n;
        for (int i = 3; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    private static int digitsToNumber(int[] digits) {
        int number = 0;
        for (int i = 0; i < digits.length; i++) {
            number = number * 10 + digits[i];
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int steps = findKaprekarSteps(n, 0);
        System.out.println(steps);
    }
}
