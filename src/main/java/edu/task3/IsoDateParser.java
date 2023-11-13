package edu.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

 public class IsoDateParser extends DateParserStrategy {
     final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

     @Override
     public Optional<LocalDate> parse(String input) {
         try {
             return Optional.of(LocalDate.parse(input, DATE_TIME_FORMATTER));
         } catch (Exception e) {
             return parseNext(input);
         }
     }
}
