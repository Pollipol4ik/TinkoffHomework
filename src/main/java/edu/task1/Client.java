package edu.task1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import lombok.NonNull;
import lombok.SneakyThrows;

public class Client {

    private static final int BUFFER_SIZE = 1024;
    private static final List<String> CLIENT_MESSAGES = List.of("личности", "оскорбления", "глупый", "интеллект");
    private final InetSocketAddress hostAddress;

    public Client(String host, int port) {
        this.hostAddress = new InetSocketAddress(host, port);
    }

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    @SneakyThrows
    public void connect(@NonNull String messageToSend) {
        try (SocketChannel client = SocketChannel.open(hostAddress)) {

            sendToServer(client, messageToSend);
            receiveAndPrintResponse(client);
        }
    }

    private void sendToServer(SocketChannel client, String message) throws Exception {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));
        while (buffer.hasRemaining()) {
            client.write(buffer);
        }
    }

    private void receiveAndPrintResponse(SocketChannel client) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        int bytesRead;
        while ((bytesRead = client.read(buffer)) != -1) {
            if (bytesRead == 0) {
                continue;
            }
            System.out.println(new String(buffer.array(), 0, bytesRead, StandardCharsets.UTF_8));
            break;
        }
    }

    private static String getRandomMessage() {
        Random random = ThreadLocalRandom.current();
        return CLIENT_MESSAGES.get(random.nextInt(CLIENT_MESSAGES.size()));
    }
}

