package edu.hw1;

import java.util.logging.Logger;

public class Task0 {
    protected Task0() {
    }

    private static Logger logger;
    private static final Logger LOGGER = logger.getLogger(String.valueOf(Task0.class));

    public static void main(String[] args) {

        sayHello();

    }

    public static void sayHello() {
        LOGGER.info("Привет, мир!");
    }
}
