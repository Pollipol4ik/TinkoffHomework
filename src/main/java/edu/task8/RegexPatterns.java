package edu.task8;

import org.apache.commons.lang3.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatterns {
    private static final String NULL_MESSAGE = "binary string should not be null";
    private static final Pattern FIRST_PATTERN = Pattern.compile("^(.{2})*.$");
    private static final Pattern SECOND_PATTERN = Pattern.compile("^(0.{2})*.$|^(1.{2})*..$");
    private static final Pattern THIRD_PATTERN = Pattern.compile("^(.*0.*){3,}$");
    private static final Pattern FOURTH_PATTERN = Pattern.compile("^(?!11$|111$).*$");
    private static final Pattern FIFTH_PATTERN = Pattern.compile("^(.{2}1)*.{0,1}$");
    private static final Pattern SIXTH_PATTERN = Pattern.compile("^(.*0.*){2,}.*1?.*$");
    private static final Pattern SEVENTH_PATTERN = Pattern.compile("^(?!.*11).*");

    private RegexPatterns() {
    }

    public static boolean isMatchesFirst(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = FIRST_PATTERN.matcher(s);
        return matcher.matches();
    }

    public static boolean isMatchesSecond(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = SECOND_PATTERN.matcher(s);
        return matcher.matches();
    }

    public static boolean isMatchesThird(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = THIRD_PATTERN.matcher(s);
        return matcher.matches();
    }

    public static boolean isMatchesFourth(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = FOURTH_PATTERN.matcher(s);
        return matcher.matches();
    }

    public static boolean isMatchesFifth(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = FIFTH_PATTERN.matcher(s);
        return matcher.matches();
    }

    public static boolean isMatchesSixth(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = SIXTH_PATTERN.matcher(s);
        return matcher.matches();
    }

    public static boolean isMatchesSeventh(String s) {
        if (StringUtils.isBlank(s)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = SEVENTH_PATTERN.matcher(s);
        return matcher.matches();
    }
}
