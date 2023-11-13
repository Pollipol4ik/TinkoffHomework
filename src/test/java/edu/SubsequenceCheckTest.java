package edu;

import edu.task6.SubsequenceCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SubsequenceCheckTest {
    private static Stream<Arguments> textAndItsSubstring() {
        return Stream.of(
            Arguments.of("COUNTRY", "COUNT", true),
            Arguments.of("java", "av", true),
            Arguments.of("without", "any errors", false),
            Arguments.of("moscow", "moscowcity", false)
        );
    }

    @ParameterizedTest
    @MethodSource("textAndItsSubstring")
    @DisplayName("Substring validation")
    public void isSubstringOfGivenText(
        String text,
        String substring,
        boolean isCorrect
    ) {
        assertThat(SubsequenceCheck.isSubsequence(text, substring)).isEqualTo(isCorrect);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null text")
    public void isSubstringTextIsEmpty(String text) {
        assertThatThrownBy(() -> SubsequenceCheck.isSubsequence(text, "substring")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null substring")
    public void isSubstringIsEmpty(String substring) {
        assertThatThrownBy(() -> SubsequenceCheck.isSubsequence("text", substring)).isInstanceOf(IllegalArgumentException.class);
    }
}
