package edu;

import edu.task1.AtbashCipher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtbashCipherTest {

    @ParameterizedTest
    @CsvSource({
        "Hello, Svool",
        "World, Dliow",
        "'Hello world!', 'Svool dliow!'",
        "'Testing 123!', 'Gvhgrmt 123!'",
        "12345, 12345",
        "'Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler', 'Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi'",

    })
    public void testAtbashEncryption(String input, String expected) {
        assertEquals(expected, AtbashCipher.encrypt(input));
    }

    @Test
    void testEncryptEmptyString() {
        String result = AtbashCipher.encrypt("");
        assertEquals("", result);
    }
}
