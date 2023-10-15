package edu.hw1;

import java.util.Scanner;

public class Task5 {
    protected Task5() {

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        boolean isPalindromeOrHasIt = isPalindromeDescendant(number);
        System.out.println(isPalindromeOrHasIt);
    }

    public static boolean isPalindromeDescendant(int number) {
        if (isPalindrome(number)) {
            return true;
        }
        int num = number;
        while (num >= 10) {
            num = generateDescendant(num);
            if (isPalindrome(num)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPalindrome(int number) {
        String num = String.valueOf(number);
        int sizeNum = num.length();
        for (int i = 0; i < sizeNum; i++) {
            if (num.charAt(i) != num.charAt(sizeNum - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static int generateDescendant(int number) {
        String num = String.valueOf(number);
        int sizeNum = num.length();
        String res = "";
        if (sizeNum % 2 == 0) {
            for (int i = 0; i < sizeNum; i += 2) {
                res = res.concat(String.valueOf(
                    Integer.parseInt(num.substring(i, i + 1)) + Integer.parseInt(num.substring(i + 1, i + 2))));
            }
        } else {
            for (int i = 0; i < sizeNum - 1; i += 2) {
                res = res.concat(String.valueOf(
                    Integer.parseInt(num.substring(i, i + 1)) + Integer.parseInt(num.substring(i + 1, i + 2))));
            }
            res = res.concat(String.valueOf(num.charAt(sizeNum - 1)));
        }

        return Integer.parseInt(res);
    }

}
