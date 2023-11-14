package edu;

import org.junit.jupiter.api.Test;
import edu.task3.DateParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DateParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"2023-11-13", "2023-01-01", "2023-12-31"})
    void testIsoDateParser(String input) {
        assertParsedDate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2023-11-13", "2023-01-01", "2023-12-31"})
    void testShortIsoDateParser(String input) {
        assertParsedDate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1/6/2023", "1/1/2010", "5/4/2000"})
    void testSlashDateParser(String input) {
        assertParsedDate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"8/4/23", "1/1/80", "3/9/12"})
    void testShortSlashDateParser(String input) {
        assertParsedDate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tomorrow", "today", "yesterday"})
    void testKeywordDateParser(String input) {
        assertParsedDate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 days ago", "5 days ago", "1 day ago"})
    void testAgoDateParser(String input) {
        assertParsedDate(input);
    }

    @Test
    void testInvalidInput() {
        assertInvalidDate("invalid_date");
    }

    private void assertParsedDate(String input) {
        Optional<LocalDate> result = DateParser.parseDate(input);
        assertTrue(result.isPresent(), "Failed to parse date for input: " + input);
    }

    private void assertInvalidDate(String input) {
        Optional<LocalDate> result = DateParser.parseDate(input);
        assertTrue(result.isEmpty(), "Expected date parsing to fail for input: " + input);
    }
}

