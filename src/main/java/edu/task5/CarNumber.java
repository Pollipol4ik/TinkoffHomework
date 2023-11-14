package edu.task5;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class CarNumber {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[АВЕКМНОРСТУХ]{1}\\d{3}[АВЕКМНОРСТУХ]{2}\\d{3}$");

    private CarNumber() {
    }

    public static boolean isCarNumberValid(String carNumber) {
        if (StringUtils.isBlank(carNumber)) {
            throw new IllegalArgumentException("carNumber should not be null or empty");
        }
        return NUMBER_PATTERN.matcher(carNumber).find();
    }
}
