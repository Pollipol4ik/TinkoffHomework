package edu;

import edu.task2.FridayThe13th;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FridayThe13thTest {
    private static Stream<Arguments> fridayFinderTest() {
        return Stream.of(
            Arguments.of(
                1984,
                List.of(
                    LocalDate.of(1984, 1, 13),
                    LocalDate.of(1984, 4, 13),
                    LocalDate.of(1984, 7, 13)
                )
            ),
            Arguments.of(
                2024,
                List.of(
                    LocalDate.of(2024, 9, 13),
                    LocalDate.of(2024, 12, 13)
                )
            )
        );
    }

    private static Stream<Arguments> datesForNextFridayTest() {
        return Stream.of(
            Arguments.of(
                LocalDate.of(1984, 1, 13),
                LocalDate.of(1984, 4, 13)
            ),
            Arguments.of(
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2023, 1, 13)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("fridayFinderTest")
    @DisplayName("Fridays 13th in correct years")
    public void findAllFridays13thInOneYearAllFridays(int year, List<LocalDate> fridays) {
        assertThat(FridayThe13th.findFridaysThe13th(year)).isEqualTo(fridays);
    }

    @Test
    @DisplayName("Fridays 13th in incorrect year test")
    public void findAllFridays13thInOneYearwhenYearBelowOne() {
        assertThatThrownBy(() -> FridayThe13th.findFridaysThe13th(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("datesForNextFridayTest")
    @DisplayName("Next friday 13th")
    public void findNextFriday13thNextFriday13th(LocalDate date, LocalDate nextFriday) {
        assertThat(FridayThe13th.findNextFridayThe13th(date)).isEqualTo(nextFriday);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null input")
    public void findNextFriday13thDateIsNull(LocalDate date) {
        assertThatThrownBy(() -> FridayThe13th.findNextFridayThe13th(date)).isInstanceOf(IllegalArgumentException.class);
    }
}
