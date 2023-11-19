package edu.receiver;

public abstract class Selector {

    private Selector nextRetriever;

    public static Selector link(Selector first, Selector... chain) {
        Selector head = first;
        for (Selector selector : chain) {
            head.nextRetriever = selector;
            head = selector;
        }
        return first;
    }

    public abstract Receiver selectRetriever(String path);

    protected Receiver checkNext(String path) {
        if (nextRetriever == null) {
            throw new IllegalArgumentException("wrong path for logs");
        }
        return nextRetriever.selectRetriever(path);
    }
}
