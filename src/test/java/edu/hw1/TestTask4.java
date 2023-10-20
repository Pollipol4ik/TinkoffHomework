package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask4 {
    @ParameterizedTest
    @CsvSource(value = {
        "123456, 214365",
        "1287, 2178",
        "0, 0",
        "hTsii  s aimex dpus rtni.g , This is a mixed up string.",
        "badce, abcde",
        "a, a",
        "abcdef, badcfe"

    })
    @DisplayName("Ввод корректных данныа")
    public void testFixStringNumber(String input, String ans) {
        assertThat(Task4.fixString(input)).isEqualTo(ans);
    }
    @Test
    @DisplayName("Ввод пустой строки")
    public void fixString_shouldReturnException_whenInputEmpty() {
        String input = "";
        assertThatThrownBy(()->Task4.fixString(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Ввод нулево строки")
    public void fixString_shouldReturnException_whenInputNull() {
        assertThatThrownBy(()->Task4.fixString(null)).isInstanceOf(NullPointerException.class);
    }
}


