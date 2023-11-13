package edu.task5;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class CarNumber {

    private static final Pattern CAR_NUMBER_PATTERN = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");

    private CarNumber() {
    }

    public static boolean isCarNumberValid(String carNumber) {
        if (StringUtils.isBlank(carNumber)) {
            throw new IllegalArgumentException("carNumber should not be null or empty");
        }
        return CAR_NUMBER_PATTERN.matcher(carNumber).find();
    }
}
