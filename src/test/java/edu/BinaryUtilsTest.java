package edu;

import edu.task7.BinaryUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class BinaryUtilsTest {
    private static Stream<Arguments> firstRegexCorrectInputTest() {
        return Stream.of(
            Arguments.of("010"),
            Arguments.of("000"),
            Arguments.of("110"),
            Arguments.of("11010101010")
        );
    }

    private static Stream<Arguments> firstRegexIncorrectInputTest() {
        return Stream.of(
            Arguments.of("011"),
            Arguments.of("001"),
            Arguments.of("111"),
            Arguments.of("11110101010"),
            Arguments.of("00"),
            Arguments.of("310")
        );
    }

    private static Stream<Arguments> secondRegexCorrectInputTest() {
        return Stream.of(
            Arguments.of("00"),
            Arguments.of("11"),
            Arguments.of("1010101010011"),
            Arguments.of("0010101010010")
        );
    }

    private static Stream<Arguments> secondRegexIncorrectInputTest() {
        return Stream.of(
            Arguments.of("1"),
            Arguments.of("0"),
            Arguments.of("10"),
            Arguments.of("01"),
            Arguments.of("11110101010"),
            Arguments.of("0110101010101"),
            Arguments.of("034")
        );
    }

    private static Stream<Arguments> thirdRegexCorrectInputTest() {
        return Stream.of(
            Arguments.of("0"),
            Arguments.of("1"),
            Arguments.of("01"),
            Arguments.of("10"),
            Arguments.of("000")
        );
    }

    private static Stream<Arguments> thirdRegexIncorrectInputTest() {
        return Stream.of(
            Arguments.of("1000"),
            Arguments.of("100111000"),
            Arguments.of("03134"),
            Arguments.of("0daf")
        );
    }

    @ParameterizedTest
    @MethodSource("firstRegexCorrectInputTest")
    @DisplayName("#regex1 correct test")
    public void test1(String zerosAndOnes) {
        assertTrue(BinaryUtils.containsAtLeastThreeCharactersWithThirdZero(zerosAndOnes));
    }

    @ParameterizedTest
    @MethodSource("firstRegexIncorrectInputTest")
    @DisplayName("#regex1 incorrect test")
    public void test2(String zerosAndOnes) {
        assertFalse(BinaryUtils.containsAtLeastThreeCharactersWithThirdZero(zerosAndOnes));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex1 null and empty")
    public void regex1IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> BinaryUtils.containsAtLeastThreeCharactersWithThirdZero(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("secondRegexCorrectInputTest")
    @DisplayName("#regex2 correct test")
    public void test3(String zerosAndOnes) {
        assertTrue(BinaryUtils.startsAndEndsWithSameCharacter(zerosAndOnes));
    }

    @ParameterizedTest
    @MethodSource("secondRegexIncorrectInputTest")
    @DisplayName("#regex2 incorrect test")
    public void test4(String zerosAndOnes) {
        assertFalse(BinaryUtils.startsAndEndsWithSameCharacter(zerosAndOnes));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex2 null and empty")
    public void regex2IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> BinaryUtils.startsAndEndsWithSameCharacter(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("thirdRegexCorrectInputTest")
    @DisplayName("#regex3 correct test")
    public void test5(String zerosAndOnes) {
        assertTrue(BinaryUtils.lengthBetweenOneAndThree(zerosAndOnes));
    }

    @ParameterizedTest
    @MethodSource("thirdRegexIncorrectInputTest")
    @DisplayName("#regex3 incorrect test")
    public void test6(String zerosAndOnes) {
        assertFalse(BinaryUtils.lengthBetweenOneAndThree(zerosAndOnes));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("#regex3 null and empty")
    public void regex3IsNullOrEmpty(String testString) {
        assertThatThrownBy(() -> BinaryUtils.lengthBetweenOneAndThree(testString)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
