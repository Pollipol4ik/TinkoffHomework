package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask7 {

    @Test
    public void testRotateLeft() {
        Task7 task = new Task7();
        int n1 = 16;
        int shift1 = 1;
        int result1 = task.rotateLeft(n1, shift1);
        assertEquals(1, result1);

    }

    @Test
    public void testRotateLeftTwo() {
        Task7 task = new Task7();
        int n2 = 17;
        int shift2 = 2;
        int result2 = task.rotateLeft(n2, shift2);
        assertEquals(6, result2);
    }

    @Test
    public void testRotateRight() {
        Task7 task = new Task7();
        int n1 = 8;
        int shift1 = 1;
        int result1 = task.rotateRight(n1, shift1);
        assertEquals(4, result1);

    }
}
