package edu;

import edu.task1.AtbashCipher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AtbashCipherTest {
    @ParameterizedTest
    @CsvSource(value = {
        "Hello world!, Svool dliow!",
        "understand. ― Martin Fowler, fmwvihgzmw. ― Nzigrm Uldovi",
        "!№;%:?*()_, !№;%:?*()_"
    })
    @DisplayName("Ввод корректных строк")
    public void encodeString_shouldReturnValue_whenCorrectInput(String input, String ans) {
        assertThat(AtbashCipher.encodeString(input)).isEqualTo(ans);
    }

    @Test
    @DisplayName("Ввод пустой строки")
    public void encodeString_shouldReturnException_whenEmptyString() {
        assertThatThrownBy(() -> AtbashCipher.encodeString("")).isInstanceOf(IllegalArgumentException.class);
    }

}
