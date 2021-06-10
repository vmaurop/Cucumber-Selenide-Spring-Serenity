package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Dates {

    private Dates() {
        throw new IllegalArgumentException("Dates class");
    }


    /**
     * Convert date from current format to expected format
     *
     * @param dateToConvert
     * @param currentFormat  available formats can be found at https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
     * @param expectedFormat
     * @return
     */
    public static String convertDate(String dateToConvert, String currentFormat, String expectedFormat) {
        DateTimeFormatter currentPattern = DateTimeFormatter.ofPattern(currentFormat);
        DateTimeFormatter expectedPattern = DateTimeFormatter.ofPattern(expectedFormat);
        LocalDate currentDate = LocalDate.parse(dateToConvert, currentPattern);
        return currentDate.format(expectedPattern);
    }


    /**
     * Convert date from current format to expected format
     *
     * @param dateToConvert
     * @param currentFormat
     * @param expectedFormat
     * @return
     */
    public static String convertDateTime(String dateToConvert, String currentFormat, String expectedFormat) {
        DateTimeFormatter currentPattern = DateTimeFormatter.ofPattern(currentFormat);
        DateTimeFormatter expectedPattern = DateTimeFormatter.ofPattern(expectedFormat);
        LocalDateTime currentDate = LocalDateTime.parse(dateToConvert, currentPattern);
        return currentDate.format(expectedPattern);
    }

    /**
     * Conver to Local date
     *
     * @param date
     * @param pattern
     * @return
     */
    public static LocalDate convertToDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(date, formatter);
    }

    /**
     * Convert to Local date time
     *
     * @param dateTime
     * @param pattern
     * @return
     */
    public static LocalDateTime convertToDateTime(String dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTime, formatter);
    }

}
