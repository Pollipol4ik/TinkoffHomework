package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask1 {
    @ParameterizedTest
    @CsvSource(value = {
        "5:30, 330",
        "120:45, 7245",
        "00:00, 0",
        "9:31, 571",
        "05:4, 304",

    })
    @DisplayName("Ввод корректной строки")
    void minutesToSecondCorrectInput(String video, int seconds) {
        assertThat(Task1.getVideoLengthInSeconds(video)).isEqualTo(seconds);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "00:100, -1",
        "10:60, -1",
        "13:62, -1",
        "-4:23, -1",
        "10:-5, -1",
    })
    @DisplayName("Ввод строки c некорректными данными")
    void minutesToSecondIncorrect(String video, int seconds) {
        assertThat(Task1.getVideoLengthInSeconds(video)).isEqualTo(seconds);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "123:456, -1",
        "123, -1",
        "abc:3, -1",
        "1:abc, -1",
        "abcd:abcd, -1",
        " : , -1"
    })
    @DisplayName("Ввод переменных некорректного типа")
    void minutesToSecondIncorrectTypeInput(String video, int seconds) {
        assertThat(Task1.getVideoLengthInSeconds(video)).isEqualTo(seconds);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "40_43, -1",
        "23::15, -1",
        "12:12:12, -1",
        "14:32:45:12, -1",
        "1:2:3, -1"
    })
    @DisplayName("Ввод с некорректыми разделителем")
    void minutesToSecondIncorrectInput(String video, int seconds) {
        assertThat(Task1.getVideoLengthInSeconds(video)).isEqualTo(seconds);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "15:, -1",
        ":23, -1",
    })
    @DisplayName("Ввод неполной строки")
    void minutesToSecondNotFullInputString(String video, int seconds) {
        assertThat(Task1.getVideoLengthInSeconds(video)).isEqualTo(seconds);
    }

    @Test
    @DisplayName("Ввод пустой строки")
    void minutesToSecondNullStringInput() {
        assertThat(Task1.getVideoLengthInSeconds(null)).isEqualTo(-1);
         }
}

