package edu.task1;

public class AtbashCipher {
    private AtbashCipher() {
    }

    public static String encrypt(String input) {
        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char mirroredChar = (char) (base + ('Z' - Character.toUpperCase(c)));
                if (Character.isUpperCase(c)) {
                    result.append(mirroredChar);
                } else {
                    result.append(Character.toLowerCase(mirroredChar));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

}



