package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask3 {

    @Test
    public void testIsNested() {
        Task3 task = new Task3();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0,6};

        boolean result = task.isNestable(arr1, arr2);

        assertTrue(result, "arr1 is nested in arr2");
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {2,3};

        result = task.isNestable(arr3, arr4);

        assertFalse(result, "arr3 is not nested in arr4");
    }
}
