package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask6 {

    @Test
    public void testFindKaprekarStepsWithSameNumber() {
        Task6 task = new Task6();
        int result = task.findKaprekarSteps(6174, 0);
        assertEquals(0, result);

    }

    @Test
    public void testFindKaprekarSteps() {
        Task6 task = new Task6();
        int result1 = task.findKaprekarSteps(6621, 0);
        assertEquals(5, result1);

    }

    @Test
    public void testFindKaprekarStepsTwo() {
        Task6 task = new Task6();
        int result4 = task.findKaprekarSteps(6554, 0);
        assertEquals(4, result4);

    }

    @Test
    public void testFindKaprekarStepsThree() {
        Task6 task = new Task6();

        int result3 = task.findKaprekarSteps(1234, 0);
        assertEquals(3, result3);

    }

}
