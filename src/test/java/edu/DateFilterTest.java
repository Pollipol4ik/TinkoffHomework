package edu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.stream.Stream;
import edu.filter.DateFilter;
import edu.filter.LogFilter;
import edu.model.NginxLog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;

public class DateFilterTest {

    private static Stream<Arguments> inputsForHasPassedFilterTest() {
        return Stream.of(
            Arguments.of(
                new DateFilter("2023-03-22", "2023-04-22"),
                NginxLog.builder()
                    .timeLocal(OffsetDateTime.of(LocalDate.of(2023, 03, 24), LocalTime.MIDNIGHT, ZoneOffset.UTC))
                    .build(),
                true
            ),
            Arguments.of(
                new DateFilter("2023-03-22", "2023-04-22"),
                NginxLog.builder()
                    .timeLocal(OffsetDateTime.of(LocalDate.of(2023, 4, 24), LocalTime.MIDNIGHT, ZoneOffset.UTC))
                    .build(),
                false
            )
        );
    }

    @ParameterizedTest
    @MethodSource("inputsForHasPassedFilterTest")
    @DisplayName("#hasPassedFilter test")
    public void hasPassedFilter_shouldReturnTrue_whenLogPassesTest(
        LogFilter testFilter,
        NginxLog testLog,
        boolean expected
    ) {
        boolean actual = testFilter.hasPassedFilter(testLog);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("constructor wrong date format test")
    public void constructor_shouldThrowException_whenDateFormatIsIncorrect() {
        assertThatThrownBy(() -> new DateFilter(
            "2023.03.22",
            "2023.04.22"
        )).isInstanceOf(IllegalArgumentException.class);
    }
}
