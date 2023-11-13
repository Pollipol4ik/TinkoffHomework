package edu;

import java.util.stream.Stream;
import edu.task8.RegexPatterns;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static org.assertj.core.api.Assertions.*;

public class RegexTest {
    private static Stream<Arguments> inputsForRegexFirst() {
        return Stream.of(
            Arguments.of("01011", true),
            Arguments.of("111", true),
            Arguments.of("10", false),
            Arguments.of("000", true),
            Arguments.of("5456", false),
            Arguments.of("1", true)
        );
    }

    private static Stream<Arguments> inputsForRegexSecond() {
        return Stream.of(
            Arguments.of("10", true),
            Arguments.of("111", false),
            Arguments.of("100", false),
            Arguments.of("0", true),
            Arguments.of("1010", true),
            Arguments.of("4045", false),
            Arguments.of("01", false)
        );
    }

    private static Stream<Arguments> inputsForRegexThird() {
        return Stream.of(
            Arguments.of("10", false),
            Arguments.of("111", false),
            Arguments.of("100", false),
            Arguments.of("1000", true),
            Arguments.of("000", true),
            Arguments.of("34522", false),
            Arguments.of("1", false)
        );
    }

    private static Stream<Arguments> inputsForRegexFourth() {
        return Stream.of(
            Arguments.of("1111", true),
            Arguments.of("000", true),
            Arguments.of("1000111", true),
            Arguments.of("11", false),
            Arguments.of("111", false)
        );
    }

    private static Stream<Arguments> inputsForRegexFifth() {
        return Stream.of(
            Arguments.of("10101", true),
            Arguments.of("1", true),
            Arguments.of("0", false),
            Arguments.of("1001", false),
            Arguments.of("1010", true),
            Arguments.of("1111", true),
            Arguments.of("0001", false)
        );
    }

    private static Stream<Arguments> inputsForRegexSixth() {
        return Stream.of(
            Arguments.of("11", false),
            Arguments.of("111", false),
            Arguments.of("100", true),
            Arguments.of("000000", true),
            Arguments.of("10101", false),
            Arguments.of("000", true),
            Arguments.of("54012", false),
            Arguments.of("1", false)
        );
    }

    private static Stream<Arguments> inputsForRegexSeventh() {
        return Stream.of(
            Arguments.of("11", false),
            Arguments.of("111", false),
            Arguments.of("100", true),
            Arguments.of("0", true),
            Arguments.of("10101", true),
            Arguments.of("000", true),
            Arguments.of("35632", false),
            Arguments.of("1", true)
        );
    }

    @ParameterizedTest
    @MethodSource("inputsForRegexFirst")
    @DisplayName("#regex1 test")
    public void regex1InputStringMatchesPattern(String testString, boolean expected) {
        boolean actual = RegexPatterns.isMatchesFirst(testString);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex1 null and empty")
    public void regex1IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> RegexPatterns.isMatchesFirst(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputsForRegexSecond")
    @DisplayName("#regex2 test")
    public void regex2InputStringMatchesPattern(String testString, boolean expected) {
        boolean actual = RegexPatterns.isMatchesSecond(testString);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex2 null and empty")
    public void regex2NullOrEmpty(String testString) {
        assertThatThrownBy(() -> RegexPatterns.isMatchesSecond(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputsForRegexThird")
    @DisplayName("#regex3 test")
    public void regex3InputStringMatchesPattern(String testString, boolean expected) {
        boolean actual = RegexPatterns.isMatchesThird(testString);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex3 null and empty")
    public void regex3IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> RegexPatterns.isMatchesThird(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputsForRegexFourth")
    @DisplayName("#regex4 test")
    public void regex4InputStringMatchesPattern(String testString, boolean expected) {
        boolean actual = RegexPatterns.isMatchesFourth(testString);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex4 null and empty")
    public void regex4IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> RegexPatterns.isMatchesFourth(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputsForRegexFifth")
    @DisplayName("#regex5 test")
    public void regex5InputStringMatchesPattern(String testString, boolean expected) {
        boolean actual = RegexPatterns.isMatchesFifth(testString);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex5 null and empty")
    public void regex5IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> RegexPatterns.isMatchesFifth(testString)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputsForRegexSixth")
    @DisplayName("#regex6 test")
    public void regex6InputStringMatchesPattern(String testString, boolean expected) {
        boolean actual = RegexPatterns.isMatchesSixth(testString);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex6 null and empty")
    public void regex6IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> RegexPatterns.isMatchesSixth(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("inputsForRegexSeventh")
    @DisplayName("#regex7 test")
    public void regex7InputStringMatchesPattern(String testString, boolean expected) {
        boolean actual = RegexPatterns.isMatchesSeventh(testString);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex7 null and empty")
    public void regex7IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> RegexPatterns.isMatchesSeventh(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }


}
