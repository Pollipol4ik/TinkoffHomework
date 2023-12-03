package edu.task4;

public class RomanNumber {
    private static final int MINIMAL_VALUE = 1;
    private static final int MAXIMAL_VALUE = 3999;
    private static final int[] ARABIC_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_SYMBOLS =
        {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    private RomanNumber() {
    }

    public static String convertToRoman(int num) {
        if (num < MINIMAL_VALUE || num > MAXIMAL_VALUE) {
            throw new IllegalArgumentException("Number should be between 1 and 3999");
        }
        StringBuilder roman = new StringBuilder();
        int number = num;

        for (int i = 0; i < ROMAN_SYMBOLS.length; i++) {
            while (number >= ARABIC_VALUES[i]) {
                roman.append(ROMAN_SYMBOLS[i]);
                number -= ARABIC_VALUES[i];
            }
        }

        return roman.toString();
    }
}
