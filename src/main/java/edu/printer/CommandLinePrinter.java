package edu.printer;

public class CommandLinePrinter implements Printer {

    @SuppressWarnings("checkstyle:RegexpSinglelineJava")
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
