package edu.hw1;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {

    @Test
    public void testGetVideoLengthInSecondsMinutesSecondsFormat() {
        String videoLength = "5:30";
        int expectedTotalSeconds = 5 * 60 + 30;
        assertEquals(expectedTotalSeconds, Task1.getVideoLengthInSeconds(videoLength));

    }

    @Test
    public void testGetVideoLengthInSeconds_LongMinutes() {
        String videoLength = "120:45";
        int expectedTotalSeconds = 120 * 60 + 45;
        assertEquals(expectedTotalSeconds, Task1.getVideoLengthInSeconds(videoLength));
    }

}
