package edu.task2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class FibonacciWithCustomThreadPoolTest {

    @Test
    @SneakyThrows
    @DisplayName("basic test")
    public void getFib_shouldCalculateFibForDifferentNumbersInMultipleThreads() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        List<Integer> expected = List.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        final List<Integer> actual = new CopyOnWriteArrayList<>();
        for (int i = 0; i <= 10; i++) {
            final int cur = i;
            threadPool.execute(() -> {
                actual.add(Fib.getFib(cur));
            });
        }
        threadPool.shutdown();
        threadPool.awaitTermination(60, TimeUnit.SECONDS);

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }
}
