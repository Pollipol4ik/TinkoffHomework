package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask5 {

    @Test
    public void testIsPalindromOrHasIt() {
        Task5 task = new Task5();

        int number1 = 11211230;
        boolean result1 = task.isPalindromeDescendant(number1);
        assertTrue(result1);

        int number2 = 13001120;
        boolean result2 = task.isPalindromeDescendant(number2);
        assertTrue(result2);

        int number3 = 23336014;
        boolean result3 = task.isPalindromeDescendant(number3);
        assertTrue(result3);


        int number4 = 314;
        boolean result4 = task.isPalindromeDescendant(number4);
        assertTrue(result4);

    }
}
