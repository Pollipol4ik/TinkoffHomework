package edu;

import edu.task5.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import static edu.task5.ContactList.parseContacts;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ContactTest {
    private static Stream<Arguments> testInputs() {
        return Stream.of(
            Arguments.of(
                new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC",
                List.of(
                    new Contact("Thomas", "Aquinas"),
                    new Contact("Rene", "Descartes"),
                    new Contact("David", "Hume"),
                    new Contact("John", "Locke")
                )
            ),
            Arguments.of(new String[] {"Paul", "Leonhard", "Carl"}, "DESC",
                List.of(
                    new Contact("Paul"),
                    new Contact("Leonhard"),
                    new Contact("Carl")
                )
            )
        );
    }

    @ParameterizedTest
    @MethodSource("testInputs")
    @DisplayName("Ввод корректных данных")
    public void parseContactInRightOrder(
        String[] testPeopleInfo,
        String sortOrder,
        List<Contact> expected
    ) {
        assertThat(parseContacts(testPeopleInfo, sortOrder)).isEqualTo(expected);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Ввод пустой или нулевой строки")
    public void parseContactInputIsNullOrEmpty(String[] emptyStringArray) {
        assertThat(parseContacts(emptyStringArray, "DESC")).isEqualTo(Collections.emptyList());
    }

    @Test
    @DisplayName("Некорректный ввод")
    public void parseContactNameIsIncorrect() {
        String[] names = {"Peppa Pig12345", "Igor Corneenko"};
        assertThatThrownBy(()->parseContacts(names, "DESC")).isInstanceOf(IllegalArgumentException.class);
    }
}
