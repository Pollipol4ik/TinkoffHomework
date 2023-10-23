package edu.task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }
}
