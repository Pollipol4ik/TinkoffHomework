package edu.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class UrlReceiver implements Receiver {

    private final String url;

    public UrlReceiver(String url) {
        this.url = url;
    }

    @Override
    public List<String> receive() {
        List<String> logs = new ArrayList<>();
        try {
            URI logSource = new URI(url);

            try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(logSource.toURL().openStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    logs.add(line);
                }
                return logs;
            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

