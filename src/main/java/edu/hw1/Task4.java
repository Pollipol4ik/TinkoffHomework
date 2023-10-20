package edu.hw1;

public class Task4 {
    protected Task4() {

    }

    public static String fixString(String input) {
        StringBuilder sb = new StringBuilder(input.length());

        for (int i = 0; i < input.length() - 1; i += 2) {
            char current = input.charAt(i);
            char next = input.charAt(i + 1);
            sb.append(next).append(current);
        }

        if (input.length() % 2 != 0) {
            sb.append(input.charAt(input.length() - 1));
        }

        return sb.toString();
    }

}
