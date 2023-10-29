package edu;

import edu.task2.ClusterizeString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.*;

public class ClusterizeStringTest {
    private static Stream<Arguments> basicTestsInputs() {
        return Stream.of(
            Arguments.of("()[]{}", new String[] {"()", "[]", "{}"}),
            Arguments.of("{(())}", new String[] {"{(())}"}),
            Arguments.of("((()))(())()()(()())", new String[] {"((()))", "(())", "()", "()", "(()())"}),
            Arguments.of("((())())(()(()()))", new String[] {"((())())", "(()(()()))"}),
            Arguments.of("[][][]", new String[] {"[]", "[]", "[]"}),
            Arguments.of("[[[]]]", new String[] {"[[[]]]"}),
            Arguments.of("[[[]]][[]][][][[][]]", new String[] {"[[[]]]", "[[]]", "[]", "[]", "[[][]]"}),
            Arguments.of("[[[]][]][[][[][]]]", new String[] {"[[[]][]]", "[[][[][]]]"}),
            Arguments.of("{}{}{}", new String[] {"{}", "{}", "{}"}),
            Arguments.of("{{{}}}", new String[] {"{{{}}}"}),
            Arguments.of("{{{}}}{{}}{}{}{{}{}}", new String[] {"{{{}}}", "{{}}", "{}", "{}", "{{}{}}"}),
            Arguments.of("{{{}}{}}{{}{{}{}}}", new String[] {"{{{}}{}}", "{{}{{}{}}}"})
        );
    }

    @ParameterizedTest
    @MethodSource("basicTestsInputs")
    @DisplayName("Тест с корректным вводом")
    public void bracketsLine_shouldReturnListOfBalancedBracketsClusters(String testBracketLine, String[] expected) {
        String[] actual = ClusterizeString.clusterize(testBracketLine).toArray(new String[0]);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "(((()",
        "(())(()",
        "{{}",
        "[[[",
        "[[}}"
    })
    @DisplayName("Некорректный ввод")
    public void bracketsLine_shouldThrowException_whenBracketsLinesIsIncorrect(String testBracketLine) {
        assertThatThrownBy(() -> ClusterizeString.clusterize(testBracketLine)).isInstanceOf(IllegalArgumentException.class);
    }
}
