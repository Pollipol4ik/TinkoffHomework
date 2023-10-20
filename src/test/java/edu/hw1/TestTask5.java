package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask5 {
    @ParameterizedTest
    @CsvSource(value = {
        "11, true",
        "11211230, true",
        "13001120, true",
        "23336014, true",
        "314, true",
        "121, true"

    })
    @DisplayName("Ввод положительного числа")
    public void testIsPalindromeDescendant(int input, boolean ans) {
        assertThat(Task5.isPalindromeDescendant(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "12, false",
        "312, false",
        "0, false",
        "45678, false"
    })
    @DisplayName("Ввод отрицательного числа")
    public void testIsNotPalindromeDescendant(int input, boolean ans) {
        assertThat(Task5.isPalindromeDescendant(input)).isEqualTo(ans);
    }
}

