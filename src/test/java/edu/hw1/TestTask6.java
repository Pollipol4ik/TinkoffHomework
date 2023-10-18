package edu.hw1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestTask6 {

    @Test
    public void testFindKaprekarSteps() {
        Task6 task = new Task6();
        int result = task.findKaprekarSteps(6174, 0);
        assertEquals(0, result);

        int result1 = task.findKaprekarSteps(6621, 0);
        assertEquals(5, result1);


        int result2 = task.findKaprekarSteps(1234, 0);
        assertEquals(3, result2);


        int result3 = task.findKaprekarSteps(5432, 0);
        assertEquals(3, result3);

        int result4 = task.findKaprekarSteps(6554, 0);
        assertEquals(4, result4);

    }
}
