package edu.task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class BinaryUtils {
    private static final String NULL_MESSAGE = "binary string should not be null";
    private static final Pattern FIRST_PATTERN = Pattern.compile("^[01]{2}0[01]*$");
    private static final Pattern SECOND_PATTERN = Pattern.compile("^([01]).*\\1$");
    private static final Pattern THIRD_PATTERN = Pattern.compile("^[01]{1,3}$");


    private BinaryUtils() {
    }

    public static boolean containsAtLeastThreeCharactersWithThirdZero(String input) {

        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = FIRST_PATTERN.matcher(input);
        return matcher.matches();
    }

    public static boolean startsAndEndsWithSameCharacter(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = SECOND_PATTERN.matcher(input);
        return matcher.matches();
    }

    public static boolean lengthBetweenOneAndThree(String input) {

        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        Matcher matcher = THIRD_PATTERN.matcher(input);
        return matcher.matches();
    }
}
