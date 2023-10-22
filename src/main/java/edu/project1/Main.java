package edu.project1;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        new ConsoleHangman(new InPartOfTheDictionary(new String[] {"java", "python", "javascript", "class",
            "programming"})).run();
    }
}
