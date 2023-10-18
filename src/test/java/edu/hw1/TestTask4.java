
package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask4 {

    @Test
    public void testFixStringEvenCharactersNumber() {
        Task4 task = new Task4();
        String input = "123456";
        String result = task.fixString(input);
        assertEquals("214365", result);

    }

    @Test
    public void testFixStringEvenCharactersString() {
        Task4 task = new Task4();
        String input1 = "hTsii  s aimex dpus rtni.g";
        String result1 = task.fixString(input1);

        assertEquals("This is a mixed up string.", result1);

    }

    @Test
    public void testFixStringEvenCharactersStringTwo() {
        Task4 task = new Task4();
        String input2 = "badce";
        String result2 = task.fixString(input2);
        assertEquals("abcde", result2);
    }

    @Test
    public void testFixStringEvenCharactersSymbols() {
        Task4 task = new Task4();
        String input3 = "a";
        String result3 = task.fixString(input3);
        assertEquals("a", result3);
    }

}
