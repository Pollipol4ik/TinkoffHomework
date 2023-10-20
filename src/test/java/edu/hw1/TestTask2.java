package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask2 {
    @ParameterizedTest
    @CsvSource(value = {
        "4666, 4",
        "544, 3",
        "0000, 1",
        "-22, 2",
        "100, 3",
        "9, 1",
        "10, 2"
    })
    @DisplayName("Ввод корректных чисел")
    public void countDigits_shouldReturnValue_whenCorrectInput(int input, int ans) {
        assertThat(Task2.countDigits(input)).isEqualTo(ans);
    }
}


