package edu;

import edu.task4.RomanNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumberTest {
    private static Stream<Arguments> testsInputs() {
        return Stream.of(
            Arguments.of(1, "I"),
            Arguments.of(11, "XI"),
            Arguments.of(16, "XVI"),
            Arguments.of(1000, "M"),
            Arguments.of(3999, "MMMCMXCIX"),
            Arguments.of(9, "IX"),
            Arguments.of(5, "V")
        );
    }

    @ParameterizedTest
    @MethodSource("testsInputs")
    @DisplayName("Ввод корректных данных")
    public void numberConvertedToRomanNumber(int testNumber, String expected) {
        String actual = RomanNumber.convertToRoman(testNumber);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-2",
        "4001"
    })
    @DisplayName("Ввод некорректных данных")
    public void numberInputIsIncorrect(int testNumber) {
        assertThatThrownBy(() -> RomanNumber.convertToRoman(testNumber)).isInstanceOf(IllegalArgumentException.class);
    }
}
