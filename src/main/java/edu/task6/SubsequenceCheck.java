package edu.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubsequenceCheck {
    public static boolean isSubsequence(String s, String t) {
        StringBuilder patternBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            patternBuilder.append(".*").append(c);
        }
        patternBuilder.append(".*");

        String regex = patternBuilder.toString();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(t);

        return matcher.matches();
    }

}
