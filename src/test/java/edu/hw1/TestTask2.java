package edu.hw1;

//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import java.util.stream.Stream;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class TestTask2 {
//    @ParameterizedTest
//    @ArgumentsSource(ArgumentProviderSecond.class)
//    @DisplayName("Count of digits")
//    public void testCountDigits(int number, int ans) {
//        assertThat(Task2.countDigits(number)).isEqualTo(ans);
//    }
//
//}
//
//final class ArgumentProviderSecond implements ArgumentsProvider {
//
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
//        return Stream.of(
//            Arguments.of(0, 1),
//            Arguments.of(10, 2),
//            Arguments.of(544, 3),
//            Arguments.of(-123, 3),
//            Arguments.of(4666, 4)
//
//        );
//    }
//}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask2 {
    @ParameterizedTest
    @CsvSource(value = {
        "0, 1",
        "10, 2",
        "544, 3",
        "4666, 4"

    })
    @DisplayName("Ввод положительного числа")
    public void testCountDigits(int input, int ans) {
        assertThat(Task2.countDigits(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "-123, 3",
        "-2267, 4"
    })
    @DisplayName("Ввод отрицательного числа")
    public void testCountDigitsNegative(int input, int ans) {
        assertThat(Task2.countDigits(input)).isEqualTo(ans);
    }
}
