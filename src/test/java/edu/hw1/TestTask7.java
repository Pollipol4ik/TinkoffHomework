package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask7 {

    @Test
    public void testRotateLeft() {
        int n1 = 16;
        int shift1 = 1;
        int result1 = Task7.rotateLeft(n1, shift1);
        assertEquals(1, result1);

        int n2 = 17;
        int shift2 = 2;
        int result2 = Task7.rotateLeft(n2, shift2);
        assertEquals(6, result2);
    }

    @Test
    public void testRotateRight() {
        int n1 = 16;
        int shift1 = 1;
        int result1 = Task7.rotateRight(n1, shift1);
        assertEquals(8, result1);

    }
}
