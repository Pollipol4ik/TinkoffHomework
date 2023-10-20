package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class TestTask3 {
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderThird.class)
    @DisplayName("Nestable array tests")
    public void isNestable_shouldReturnValue_whenCorrectInput(int[] firstArray, int[] secondArray, boolean ans) {
        assertThat(Task3.isNestable(firstArray, secondArray)).isEqualTo(ans);
    }

}

final class ArgumentProviderThird implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}, true),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0}, true),
            Arguments.of(new int[] {3}, new int[] {}, false),
            Arguments.of(new int[] {1}, new int[] {1}, false),
            Arguments.of(new int[] {-1}, new int[] {-2}, false),
            Arguments.of(new int[] {1}, new int[] {0, 2, 3}, true),
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}, false),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3}, false)
        );
    }
}
