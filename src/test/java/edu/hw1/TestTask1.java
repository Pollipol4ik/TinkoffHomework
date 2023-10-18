package edu.hw1;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {

    @Test
    public void testGetVideoLengthInSecondsMinutesSecondsFormat() {
        Task1 task = new Task1();
        String videoLength = "5:30";
        int expectedTotalSeconds = 5 * 60 + 30;
        assertEquals(expectedTotalSeconds, task.getVideoLengthInSeconds(videoLength));

        String videoLength1 = "120:45";
        int expectedTotalSeconds1 = 120 * 60 + 45;
        assertEquals(expectedTotalSeconds1, task.getVideoLengthInSeconds(videoLength1));

        String videoLength2 = "10:60";
        int expectedTotalSeconds2 = -1;
        assertEquals(expectedTotalSeconds2, task.getVideoLengthInSeconds(videoLength2));
    }



}
