package edu.task1;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ClientServerTest {

    private static final String HOST = "localhost";
    private static final int PORT = 8080;

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("Client and server basic test")
    @SneakyThrows
    public void run_shouldProcessRequestFromClient() {
        Client client = new Client(HOST, PORT);
        startServer();
        client.connect("интеллект");
        assertThat(outputStream.toString().replace("\u0000", "").trim())
            .isEqualToNormalizingWhitespace("Клиент: интеллект\nСервер: Чем ниже интеллект, тем громче оскорбления");

    }

    @SneakyThrows
    private void startServer() {
        Server server = new Server(HOST, PORT);
        Thread serverThread = new Thread(server::start);
        serverThread.start();
        Thread.sleep(2000);
    }

}
