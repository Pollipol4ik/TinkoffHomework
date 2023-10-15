package edu.hw1;

import java.util.Scanner;

public class Task2 {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int digitCount = countDigits(number);
        System.out.println(digitCount);
    }

}
