package edu.task5;

import org.apache.commons.lang3.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNumber {
//
//    public static boolean validateLicensePlate(String licensePlate) {
//        String regex = "^[АВЕКМНОРСТУХABEKMHOPCTYX]{1}\\d{3}[АВЕКМНОРСТУХABEKMHOPCTYX]{2}\\d{2,3}$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(licensePlate);
//        return matcher.matches();
//    }
private static final Pattern CAR_NUMBER_PATTERN = Pattern.compile("^[A-ZА-Я\\d]{1}\\d{3}[A-ZА-Я]{2}\\d{3}$");

    private CarNumber() {
    }

    public static boolean isCarNumberValid(String carNumber) {
        if (StringUtils.isBlank(carNumber)) {
            throw new IllegalArgumentException("carNumber should not be null or empty");
        }
        return CAR_NUMBER_PATTERN.matcher(carNumber).find();
    }
}
