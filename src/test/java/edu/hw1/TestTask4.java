
package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask4 {

    @Test
    public void testFixStringEvenCharacters() {
        String input = "123456";
        String result = Task4.fixString(input);
        assertEquals("214365", result);
    }

    @Test
    public void testFixStringOddCharacters() {
        String input = "hTsii  s aimex dpus rtni.g";
        String result = Task4.fixString(input);
        assertEquals("This is a mixed up string.", result);
    }

    @Test
    public void testFixStringEmpty() {
        String input = "badce";
        String result = Task4.fixString(input);
        assertEquals("abcde", result);
    }

    @Test
    public void testFixStringSingleCharacter() {
        String input = "a";
        String result = Task4.fixString(input);
        assertEquals("a", result);
    }
}
