package edu.hw1;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.ArgumentsProvider;
//import org.junit.jupiter.params.provider.ArgumentsSource;
//import java.util.stream.Stream;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class TestTask4 {
//    @ParameterizedTest
//    @ArgumentsSource(ArgumentProviderFourth.class)
//    @DisplayName("Fix string")
//    public void testFixString(String input, String ans) {
//        assertThat(Task4.fixString(input)).isEqualTo(ans);
//    }
//
//}
//
//final class ArgumentProviderFourth implements ArgumentsProvider {
//
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
//        return Stream.of(
//            Arguments.of("123456", "214365"),
//            Arguments.of("hTsii  s aimex dpus rtni.g", "This is a mixed up string."),
//            Arguments.of("badce", "abcde"),
//            Arguments.of("a", "a")
//
//        );
//    }
//}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask4 {
    @ParameterizedTest
    @CsvSource(value = {
        "123456, 214365",
        "1287, 2178"


    })
    @DisplayName("Ввод положительного числа")
    public void testFixStringNumber(String input, String ans) {
        assertThat(Task4.fixString(input)).isEqualTo(ans);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "hTsii  s aimex dpus rtni.g , This is a mixed up string.",
        "badce, abcde",
        "a, a"
    })
    @DisplayName("Ввод отрицательного числа")
    public void testFixStringLetter(String input, String ans) {
        assertThat(Task4.fixString(input)).isEqualTo(ans);
    }
}


