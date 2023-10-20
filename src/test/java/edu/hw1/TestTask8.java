package edu.hw1;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask8 {
    @ParameterizedTest
    @ArgumentsSource(ArgumentProviderEighth.class)
    @DisplayName("Knight board capture test")
    public void testKnightBoardCapture(int[][] firstArray, boolean ans) {
        assertThat(Task8.isSafe(firstArray)).isEqualTo(ans);
    }

}

final class ArgumentProviderEighth implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
            Arguments.of(new int[][] {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
            }, true),
            Arguments.of(new int[][] {
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}}, false),
            Arguments.of(new int[][] {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
            }, false),
            Arguments.of(new int[][] {
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
            }, false),
            Arguments.of(new int[][] {
                {1, 0, 1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 1, 0}
            }, false)
        );
    }


}
