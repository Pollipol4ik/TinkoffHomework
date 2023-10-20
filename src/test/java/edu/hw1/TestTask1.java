package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask1 {
    @ParameterizedTest
    @CsvSource(value = {
        "5:30, 330",
        "120:45, 7245",
        "1:2, 62",
        "0:0, 0"

    })
    @DisplayName("Ввод корректной строки")
    public void minutesToSeconds_shouldReturnValue_whenCorrectInput(String input, int ans) {
        assertThat(Task1.getVideoLengthInSeconds(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "10:60, -1",
        "13:62, -1",
        "-4:23, -1",

    })
    @DisplayName("Ввод строки c неправильным временем")
    public void minutesToSeconds_shouldReturnValue_whenIncorrectTime(String input, int ans) {
        assertThat(Task1.getVideoLengthInSeconds(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "12:12:12, -1",
        "14:32:45:12, -1",
        "abc:def, -1",
        "1:abc, -1",
        "1:2:3, -1",
        "123:456, -1",
    })
    @DisplayName("Ввод строки неправильного формата")
    public void minutesToSeconds_shouldReturnValue_whenIncorrectStringFormat(String input, int ans) {
        assertThat(Task1.getVideoLengthInSeconds(input)).isEqualTo(ans);
    }

}

