package edu.task3;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final Random random = new Random();
    private final static double CHANCE_FAULTY = 0.3;

    public DefaultConnectionManager() {

    }

    @Override
    public Connection getConnection() {
        if (random.nextDouble() < CHANCE_FAULTY) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
