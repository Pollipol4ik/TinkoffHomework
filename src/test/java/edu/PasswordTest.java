package edu;

import edu.task4.PasswordUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.stream.Stream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordTest {
    private static Stream<Arguments> correctPasswords() {
        return Stream.of(
            Arguments.of("~wifsak"),
            Arguments.of("$%^&*(")
        );
    }

    private static Stream<Arguments> wrongPasswords() {
        return Stream.of(
            Arguments.of("wifsak"),
            Arguments.of("wifsak___")
        );
    }

    @ParameterizedTest
    @MethodSource("correctPasswords")
    @DisplayName("Password with necessary symbols")
    public void test1(String signs) {
        assertTrue(PasswordUtils.isPasswordValid(signs));
    }

    @ParameterizedTest
    @MethodSource("wrongPasswords")
    @DisplayName("Password without necessary symbols")
    public void test2(String password) {
        assertFalse(PasswordUtils.isPasswordValid(password));
    }
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null and empty test")
    public void isPasswordValidIsNullOrEmpty(String testPassword) {
        assertThatThrownBy(() -> PasswordUtils.isPasswordValid(testPassword)).isInstanceOf(IllegalArgumentException.class);
    }
}
