package edu.task7;

import org.apache.commons.lang3.StringUtils;
import java.util.regex.Pattern;

public class BinaryUtils {
    private static final String NULL_MESSAGE = "binary string should not be null";

    private BinaryUtils() {
    }
    public static boolean containsAtLeastThreeCharactersWithThirdZero(String input) {

        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        final Pattern pattern = Pattern.compile("[01]{2}0[01]+");
        return pattern.matcher(input).find();
    }

    // Начинается и заканчивается одним и тем же символом
    public static boolean startsAndEndsWithSameCharacter(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        final Pattern pattern = Pattern.compile("^(0|1)([01]*)(\\1)$");
        return pattern.matcher(input).find();
    }

    // Длина не менее 1 и не более 3
    public static boolean lengthBetweenOneAndThree(String input) {

        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(NULL_MESSAGE);
        }
        final Pattern pattern = Pattern.compile("^[01]{1,3}$");
        return pattern.matcher(input).find();
    }
}
