package edu.receiver;

public class UrlSelector extends Selector {

    private static final String URL_PREFIX = "http";

    @Override
    public Receiver selectRetriever(String path) {
        if (path.startsWith(URL_PREFIX)) {
            return new UrlReceiver(path);
        }
        return checkNext(path);
    }
}

