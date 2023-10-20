package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask2 {

    @ParameterizedTest
    @CsvSource(value = {
        "10, 2",
        "123, 3",
        "4666, 4",
        "10023, 5"
    })
    @DisplayName("Ввод положительных чисел")
    void countDigitsInputPositiveNumbers(int number, int answer) {
        assertThat(Task2.countDigits(number)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-9, 1",
        "-10, 2",
        "-123, 3",
        "-5466, 4"
    })
    @DisplayName("Ввод отрицательных чисел")
    void countDigitsInputNegativeNumbers(int number, int answer) {
        assertThat(Task2.countDigits(number)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "00, 1",
        "0, 1",
        "000, 1",
        "00000, 1"
    })
    @DisplayName("Ввод нуля")
    void countDigitsInputZeroNumber(int number, int answer) {
        assertThat(Task2.countDigits(number)).isEqualTo(answer);
    }
}
