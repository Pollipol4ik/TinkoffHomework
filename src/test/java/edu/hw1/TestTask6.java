package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask6 {
    @ParameterizedTest
    @CsvSource(value = {
        "6174, 0, 0",
        "6621, 0, 5",
        "6554, 0, 4",
        "1234, 0, 3"
    })
    @DisplayName("Количество шагов")
    public void testCountSteps(int number, int steps, int ans) {
        assertThat(Task6.findKaprekarSteps(number,steps)).isEqualTo(ans);
    }

}
