package edu.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.*;

public class DefaultDatabaseHackerTest {

    private static Stream<Arguments> inputsForHackTest() {
        return Stream.of(
            Arguments.of(
                new HashMap<String, String>() {{
                    put("c505a69ec179afb91b357bbbd1b0e60d", "user1");
                    put("1b62d2b76347ebd300b15b458ce52b39", "user2");
                }},
                new HashMap<String, String>() {{
                    put("user1", "poly");
                    put("user2", "danil");
                }}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("inputsForHackTest")
    @DisplayName("#hack test")
    public void hack_shouldReturnMapWithUsernameAndHackedPassword(
        Map<String, String> db,
        Map<String, String> expected
    ) {
        DatabaseHacker hacker = new DefaultDatabaseHacker(db);
        Map<String, String> actual = hacker.hack();
        assertThat(actual).containsExactlyInAnyOrderEntriesOf(expected);
    }
}
