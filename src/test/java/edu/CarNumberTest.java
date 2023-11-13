package edu;

import java.util.stream.Stream;
import edu.task5.CarNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.*;

public class CarNumberTest {

    private static Stream<Arguments> inputsForBasicTestIsCarNumberValid() {
        return Stream.of(
            Arguments.of("А023ВЕ775", true),
            Arguments.of("В455ОЛ750", true),
            Arguments.of("033ВАК777", false),
            Arguments.of("В033АК75", false),
            Arguments.of("В033АК5555", false)
        );
    }

    @ParameterizedTest
    @MethodSource("inputsForBasicTestIsCarNumberValid")
    @DisplayName("Basic test")
    public void isCarNumberValidIsValid(String testCarNumber, boolean expected) {
        boolean actual = CarNumber.isCarNumberValid(testCarNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null and empty test")
    public void isCarNumberValidIsNullOrEmpty(String testCarNumber) {
        assertThatThrownBy(() -> CarNumber.isCarNumberValid(testCarNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
