package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask3 {

    @Test
    public void testIsNested() {
        Task3 task = new Task3();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {0, 6};

        boolean result = task.isNestable(arr1, arr2);

        assertTrue(result, "arr1 is nested in arr2");

    }

    @Test
    public void testIsNestedTwo() {
        Task3 task = new Task3();
        int[] arr1 = {3, 1};
        int[] arr2 = {4, 0};

        boolean result = task.isNestable(arr1, arr2);

        assertTrue(result, "arr1 is nested in arr2");

    }

    @Test
    public void testIsNestedThree() {
        Task3 task = new Task3();
        int[] arr1 = {3};
        int[] arr2 = {};

        boolean result = task.isNestable(arr1, arr2);

        assertFalse(result, "arr3 is not nested in arr4");

    }

    @Test
    public void testIsNestedFour() {
        Task3 task = new Task3();
        int[] arr1 = {1};
        int[] arr2 = {1};

        boolean result = task.isNestable(arr1, arr2);

        assertFalse(result, "arr3 is not nested in arr4");

    }

    @Test
    public void testIsNestedFive() {
        Task3 task = new Task3();
        int[] arr1 = {-1};
        int[] arr2 = {-2};

        boolean result = task.isNestable(arr1, arr2);

        assertFalse(result, "arr3 is not nested in arr4");

    }

    @Test
    public void testIsNestedSix() {
        Task3 task = new Task3();
        int[] arr1 = {1};
        int[] arr2 = {0, 2, 3};

        boolean result = task.isNestable(arr1, arr2);

        assertTrue(result, "arr3 is nested in arr4");

    }

    @Test
    public void testIsNotNested() {
        Task3 task = new Task3();
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {2, 3};

        boolean result = task.isNestable(arr3, arr4);

        assertFalse(result, "arr3 is not nested in arr4");
    }

    @Test
    public void testIsNotNestedTwo() {
        Task3 task = new Task3();
        int[] arr3 = {9, 9, 8};
        int[] arr4 = {8, 9};

        boolean result = task.isNestable(arr3, arr4);

        assertFalse(result, "arr3 is not nested in arr4");
    }
}
