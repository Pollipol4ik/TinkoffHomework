package edu.task3;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
