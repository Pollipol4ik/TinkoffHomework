package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask7 {
    @ParameterizedTest
    @CsvSource(value = {
        "8,1,4",
        "2,1,1",
        "0,2,0",
        "16,1,8",
        "-1, 1, -1",
        "-1, 3, -1"

    })
    @DisplayName("Тест сдвига вправо")
    public void rotateRightTest(int input, int shift, int ans) {
        assertThat(Task7.rotateRight(input, shift)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "17,2,6",
        "16,1,1",
        "2,1,1",
        "0,2,0",
        "7, -1, -1",
        "10, -3, -1"
    })
    @DisplayName("Тест сдвига влево")
    public void rotateLeftTest(int input, int shift, int ans) {
        assertThat(Task7.rotateLeft(input, shift)).isEqualTo(ans);
    }
}
