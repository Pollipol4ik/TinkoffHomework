package edu.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubsequenceCheck {
    private SubsequenceCheck() {

    }

    public static boolean isSubsequence(String t, String s) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("String can not be null");
        }
        Pattern substringPattern = Pattern.compile(s);
        Matcher substringMatcher = substringPattern.matcher(t);
        return substringMatcher.find();
    }

}
