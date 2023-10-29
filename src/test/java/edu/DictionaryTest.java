package edu;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import edu.task3.FrequencyDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import static edu.task3.FrequencyDictionary.freqDict;
import static org.assertj.core.api.Assertions.*;

public class DictionaryTest {

    private static Stream<Arguments> testsInputs() {
        return Stream.of(
            Arguments.of(List.of("a", "bb", "a", "bb"), Map.of("bb", 2, "a", 2)),
            Arguments.of(List.of("this", "and", "that", "and"), Map.of("that", 1, "and", 2, "this", 1)),
            Arguments.of(List.of("код", "код", "код", "bug"), Map.of("код", 3, "bug", 1)),
            Arguments.of(List.of(1, 1, 2, 2), Map.of(1, 2, 2, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("testsInputs")
    @DisplayName("Basic tests for #getFrequencyDictionary")
    public <T> void listDictionaryOfItsElements(List<T> testList, Map<T, Integer> expected) {
        Map<T, Integer> actual = FrequencyDictionary.freqDict(testList);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Empty and null list test")
    public <T> void freqDictNullEmpty(List<T> list) {
        assertThatThrownBy(()->freqDict(list)).isInstanceOf(IllegalArgumentException.class);
    }
}
