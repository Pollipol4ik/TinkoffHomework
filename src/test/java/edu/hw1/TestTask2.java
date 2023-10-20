package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask2 {
    @ParameterizedTest
    @CsvSource(value = {
        "0, 1",
        "10, 2",
        "544, 3",
        "4666, 4",
        "0000, 1",
        "-22, 2",
        "-123, 3",
        "9, 1",
        "-9, 1",
        "-4356, 4",
        "55555, 5",
        "-55555, 5"

    })
    @DisplayName("Ввод чисел")
    public void testCountDigits(int input, int ans) {
        assertThat(Task2.countDigits(input)).isEqualTo(ans);
    }
}

