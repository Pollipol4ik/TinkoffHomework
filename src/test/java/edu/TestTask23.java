package edu;

import java.util.stream.Stream;
import edu.task3.ConnectionManager;
import edu.task3.DefaultConnectionManager;
import edu.task3.FaultyConnection;
import edu.task3.FaultyConnectionManager;
import edu.task3.PopularCommandExecutor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class TestTask23 {
    @Test
    @DisplayName("Тест плохого соединения")
    public void faultyConnectionManagerGetConnection() {
        assertThat(new FaultyConnectionManager().getConnection()).isInstanceOf(FaultyConnection.class);
    }

    public static Stream<Arguments> remoteConnectionArguments() {
        return Stream.of(
            Arguments.of(new DefaultConnectionManager(), 2),
            Arguments.of(new FaultyConnectionManager(), 6)
        );
    }

    @DisplayName("Тесты работы типов соединения")
    @ParameterizedTest
    @MethodSource("remoteConnectionArguments")
    public void remoteConnectionTest(ConnectionManager manager, int maxAttempts) {
        PopularCommandExecutor popularCommandExecutor = new PopularCommandExecutor(manager, maxAttempts);
        popularCommandExecutor.updatePackages();
    }

    @Test
    @DisplayName("Некорректный ввод maxAttempts")
    public void shouldThrowExceptionIsIncorrect() {
        assertThatThrownBy(() -> new PopularCommandExecutor(new DefaultConnectionManager(), -1))
            .isInstanceOf(IllegalArgumentException.class);
    }

}


