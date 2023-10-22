package edu;

import edu.task1.Expr;
import edu.task1.Expr.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    private static Stream<Arguments> inputConstantTest() {
        return Stream.of(
            Arguments.of(new Constant(7), 7),
            Arguments.of(new Constant(-1), -1),
            Arguments.of(new Constant(0), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputConstantTest")
    @DisplayName("Тестирование констант")
    public void constantWithItsValue(Expr testConstant, double expected) {
        assertThat(testConstant.evaluate()).isEqualTo(expected);
    }

    private static Stream<Arguments> inputMultiplicationTest() {
        return Stream.of(
            Arguments.of(new Constant(4), new Constant(5), 20),
            Arguments.of(new Constant(-4), new Constant(-5), 20),
            Arguments.of(new Constant(-4), new Constant(5), -20),
            Arguments.of(new Constant(4), new Constant(-5), -20),
            Arguments.of(new Constant(0), new Constant(1), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputMultiplicationTest")
    @DisplayName("Тестирование умножения")
    public void twoConstantsWithTheirMultiplication(
        Expr firstFactor, Expr secondFactor, double result
    ) {
        Expr multiplicationActual = new Multiplication(firstFactor, secondFactor);
        assertThat(multiplicationActual.evaluate()).isEqualTo(result);

    }

    private static Stream<Arguments> inputNegateTest() {
        return Stream.of(
            Arguments.of(new Constant(1), -1),
            Arguments.of(new Constant(-1), 1),
            Arguments.of(new Constant(0),0)
        );
    }

    @ParameterizedTest
    @MethodSource("inputNegateTest")
    @DisplayName("Тестирование отрицания")
    public void expressionWithOppositeSign(Expr expr, double result) {
        Expr negativeExpression = new Negate(expr);
        assertThat(negativeExpression.evaluate()).isEqualTo(result);
    }

    private static Stream<Arguments> inputExponentTest() {
        return Stream.of(
            Arguments.of(new Constant(2), 5, 32),
            Arguments.of(new Constant(-7), 2, 49),
            Arguments.of(new Constant(-3), 3, -27),
            Arguments.of(new Constant(4), 0.5, 2),
            Arguments.of(new Constant(0), 5, 0),
            Arguments.of(new Constant(4), 0, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("inputExponentTest")
    @DisplayName("Тестирование возведения в степень")
    public void expressionAndDegreeToGivenDegree(
        Expr base, double exponent, double result
    ) {
        Expr expr = new Exponent(base, exponent);
        assertThat(expr.evaluate()).isEqualTo(result);
    }

    private static Stream<Arguments> inputAdditionTest() {
        return Stream.of(
            Arguments.of(new Constant(5), new Constant(12), 17),
            Arguments.of(new Constant(-5), new Constant(12), 7),
            Arguments.of(new Constant(5), new Constant(-3), 2),
            Arguments.of(new Constant(5), new Constant(-10), -5)

        );
    }

    @ParameterizedTest
    @MethodSource("inputAdditionTest")
    @DisplayName("Тестирование сложения")
    public void twoExpressionsWithTheirSum(Expr term1, Expr term2, double result) {
        Expr sum = new Addition(term1, term2);
        assertThat(sum.evaluate()).isEqualTo(result);
    }
}
