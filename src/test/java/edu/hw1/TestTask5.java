package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask5 {
    @ParameterizedTest
    @CsvSource(value = {
        "11, true",
        "121, true",
        "323, true",
        "123321, true",
        "10101, true",
        "55555, true"
    })
    @DisplayName("Ввод строк являющихся палиндром")
    public void testIsPalindrome(int input, boolean ans) {
        assertThat(Task5.isPalindromeDescendant(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "102001, true",
        "11211230, true",
        "13001120, true",
        "23336014, true",
        "314, true"

    })
    @DisplayName("Ввод строк содержащих палиндром")
    public void testIsPalindromeDescendant(int input, boolean ans) {
        assertThat(Task5.isPalindromeDescendant(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "12, false",
        "312, false",
        "0, false",
        "45678, false",
        "4234234, false"
    })
    @DisplayName("Ввод строк не содержащих палиндром")
    public void testIsNotPalindromeDescendant(int input, boolean ans) {
        assertThat(Task5.isPalindromeDescendant(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-121, false",
        "-5678, false",
        "-11, false",
        "-1, false",
    })
    @DisplayName("Ввод отрицательных чисел")
    public void isPalindromeDescendanIsNegative(int input,boolean ans ) {
        assertThat(Task5.isPalindromeDescendant(input)).isEqualTo(ans);
    }
}

