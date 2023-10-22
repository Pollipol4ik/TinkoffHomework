package edu.task3;

import java.util.logging.Logger;

public class FaultyConnection implements Connection {
    private static final Logger LOGGER = Logger.getLogger(FaultyConnection.class.getName());
    private final static double CHANCE_ERROR = 0.5;

    @Override
    public void execute(String command) {
        if (Math.random() <= CHANCE_ERROR) {
            throw new ConnectionException("Connection is not established");
        }
    }

    @Override
    public void close() {
        LOGGER.info("Faulty connection closed");
    }
}
