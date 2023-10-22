package edu.task3;

import java.util.logging.Logger;

public class StableConnection implements Connection {
    private static final Logger LOGGER = Logger.getLogger(FaultyConnection.class.getName());

    @Override
    public void execute(String command) {
    }

    @Override
    public void close() {
        LOGGER.info("Stable connection closed");
    }
}
