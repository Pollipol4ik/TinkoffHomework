package edu;


import edu.task1.ComputerClubUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ComputerClubTest {
    private static Stream<Arguments> data() {
        return Stream.of(Arguments.of(new String[]{"2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"},"Среднее время за сеанс: 3ч 40м"));
    }

    @ParameterizedTest
    @MethodSource ("data")
    @DisplayName("Correct input")
    public void testWithCorrectInput(String[] sessions,
        String expected) {
        assertThat(ComputerClubUtils.calculateAverageSessionTime(sessions)).isEqualTo(expected);
    }

    @Test
    @DisplayName("Incorrect input")
    public void testWithInCorrectInput() {
        String[] sessions = new String[]{
            "2021/04/11, 20:20 - 2021/04/11, 22:30"
        };
        assertThatThrownBy(() -> ComputerClubUtils.calculateAverageSessionTime(sessions)).isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Input null")
    public void countSessionIsNullOrEmpty(String[] sessions) {
        assertThatThrownBy(() -> ComputerClubUtils.calculateAverageSessionTime(sessions)).isInstanceOf(IllegalArgumentException.class);
    }

}
