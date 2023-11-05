package edu;

import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationTest {
    private InputStream originalSystemIn;
    private InputStream mockSystemIn;

    @BeforeEach
    public void setUp() {
        originalSystemIn = System.in;
    }

    @AfterEach
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    private void setMockInput(String input) {
        mockSystemIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(mockSystemIn);
    }

    @ParameterizedTest
    @CsvSource({
        "11, 11, 1 1, 9 9, 1",
        "27, 27, 1 1, 25 25, 2",
        "15, 15, 1 1, 13 13, 1"
    })
    @DisplayName("Test valid input")
    public void testValidInput(int width, int height, String start, String end, int mazeChoice) {
        String input = String.format("%d\n%d\n%s\n%s\n%d", width, height, start, end, mazeChoice);
        setMockInput(input);
        Application application = new Application();

        assertDoesNotThrow(application::run);
    }

}

