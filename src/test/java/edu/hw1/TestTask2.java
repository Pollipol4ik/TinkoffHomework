package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "5, 1",
        "10, 2",
        "-5, 1",
        "544, 3",
        "-123, 3",
        "4666, 4",
        "2147483647, 10",
        "-2147483648, 10"
    })
    public void testCountDigits(int number, int expected) {
        int result = Task2.countDigits(number);
        assertEquals(expected, result);
    }
}


