package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask5 {

    @Test
    public void testIsPalindromOrHasIt() {

        int number1 = 11211230;
        boolean result1 = Task5.isPalindromeDescendant(number1);
        assertTrue(result1);

        int number2 = 13001120;
        boolean result2 = Task5.isPalindromeDescendant(number2);
        assertTrue(result2);

        int number3 = 23336014;
        boolean result3 = Task5.isPalindromeDescendant(number3);
        assertTrue(result3);


        int number4 = 314;
        boolean result4 = Task5.isPalindromeDescendant(number3);
        assertTrue(result4);

    }
}
