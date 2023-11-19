package edu;


import java.util.List;
import java.util.stream.Stream;
import edu.formatter.MarkdownFormatter;
import edu.model.Components;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;

public class MarkdownFormatterTest {

    private static Stream<Arguments> inputsForFormatTest() {
        return Stream.of(
            Arguments.of(
                new Components("Общая информация", List.of("Метрика", "Значение"), List.of(
                    "Файл(-ы)|'test.log'",
                    "Начальная дата|-",
                    "Конечная дата|-",
                    "Количество запросов|2",
                    "Средний размер ответа|300.0b"
                )),
                """
                    ### Общая информация
                    |              Метрика|  Значение|
                    |:-------------------:|:--------:|
                    |             Файл(-ы)|'test.log'|
                    |       Начальная дата|         -|
                    |        Конечная дата|         -|
                    |  Количество запросов|         2|
                    |Средний размер ответа|    300.0b|
                    """
            )
        );
    }

    @ParameterizedTest
    @MethodSource("inputsForFormatTest")
    @DisplayName("#format test")
    public void format_shouldReturnFormattedStringInMarkdownFormat(Components toFormat, String expected) {
        String actual = new MarkdownFormatter().format(toFormat);
        assertThat(actual).isEqualTo(expected);
    }
}
