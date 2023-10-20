package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTask4 {
    @ParameterizedTest
    @CsvSource(value = {
        "123456, 214365",
        "1287, 2178",
        "0, 0",
        "hTsii  s aimex dpus rtni.g , This is a mixed up string.",
        "badce, abcde",
        "a, a",
        "abcdef, badcfe",
        "'', IllegalArgumentException"

    })
    @DisplayName("Ввод корректных данныа")
    public void testFixStringNumber(String input, String ans) {
        if ("IllegalArgumentException".equals(ans)) {
            assertThrows(IllegalArgumentException.class, () -> Task4.fixString(input));
        } else {
            assertEquals(ans, Task4.fixString(input));
        }
    }

}


