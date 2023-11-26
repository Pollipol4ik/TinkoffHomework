package edu;

import edu.task4.MonteCarloPiApproximation;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MonteCarloPiApproximationTest {
    private static final long ITERATIONS = 1000000000;

    @Test
    @DisplayName("approximatePi test")
    public void approximatePi_shouldReturnValueClosedToPi() {
        assertThat(MonteCarloPiApproximation.approximatePi(ITERATIONS)).isCloseTo(Math.PI, Offset.offset(0.01));
    }

    @Test
    @DisplayName("approximatePiParallel test")
    public void approximatePiParallel_shouldReturnValueClosedToPi() {
        assertThat(MonteCarloPiApproximation.approximatePiParallel(ITERATIONS)).isCloseTo(Math.PI, Offset.offset(0.01));
    }
}
