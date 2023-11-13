package edu.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

 public class ShortIsoDateParser extends DateParserStrategy {
     final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d");

     @Override
     Optional<LocalDate> parse(String date) {
         try {
             return Optional.of(LocalDate.parse(date, DATE_TIME_FORMATTER));
         } catch (Exception e) {
             return parseNext(date);
         }
     }
}
