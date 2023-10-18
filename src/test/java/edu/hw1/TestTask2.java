package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask2 {

    @Test
    public void testCountDigitsBeforeTen() {
        Task2 task = new Task2();
        assertEquals(1, task.countDigits(0));

    }

    @Test
    public void testCountDigitsBeforOneHundred() {
        Task2 task = new Task2();
        assertEquals(2, task.countDigits(10));

    }

    @Test
    public void testCountDigitsBeforOneThousand() {
        Task2 task = new Task2();
        assertEquals(3, task.countDigits(544));
    }

    @Test
    public void testCountDigitsNegativeNumber() {
        Task2 task = new Task2();
        assertEquals(3, task.countDigits(-123));
    }

    @Test
    public void testCountDigitsMoreOneThousand() {
        Task2 task = new Task2();
        assertEquals(4, task.countDigits(4666));
    }

}
