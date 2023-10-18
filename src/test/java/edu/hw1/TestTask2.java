package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {

    @Test
    public void testCountDigits() {
        Task2 task = new Task2();
        assertEquals(1, task.countDigits(0));
        assertEquals(2, task.countDigits(10));
        assertEquals(3, task.countDigits(544));
        assertEquals(3, task.countDigits(-123));
        assertEquals(4, task.countDigits(4666));
    }
}
