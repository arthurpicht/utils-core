package de.arthurpicht.utils.core.dates;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Converting timestamps to string representations.
 */
public class TimestampStrings {

    public static final String DATE_HYPHEN_TIME = "yyyyMMdd-HHmmss";
    public static final String DATE_HYPHEN_TIME_MILLIS = "yyyyMMdd-HHmmss-SSS";
    public static final String DATE_GERMAN = "dd.MM.yyyy";
    public static final String DATE_GERMAN_TIME = "dd.MM.yyyy HH:mm:ss";

    /**
     * Converts specified instant to string with pattern yyyyMMdd-HHmmss.
     */
    public static String asHyphenTime(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    /**
     * Converts specified timestamp as millis since the epoch to string with pattern yyyyMMdd-HHmmss.
     */
    public static String asHyphenTime(long timestampEpochMillis) {
        Instant instant = Instant.ofEpochMilli(timestampEpochMillis);
        return asHyphenTime(instant);
    }

    /**
     * Returns current timestamp as string with pattern yyyyMMdd-HHmmss.
     */
    public static String currentAsHyphenTime() {
        return asHyphenTime(Instant.now());
    }

    /**
     * Converts specified instant to string with pattern yyyyMMdd-HHmmss-SSS.
     */
    public static String asHyphenTimeMillis(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME_MILLIS).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    /**
     * Converts specified timestamp as millis since the epoch to string with pattern yyyyMMdd-HHmmss-SSS.
     */
    public static String asHyphenTimeMillis(long timestampEpochMillis) {
        Instant instant = Instant.ofEpochMilli(timestampEpochMillis);
        return asHyphenTimeMillis(instant);
    }

    /**
     * Returns current timestamp as string with pattern yyyyMMdd-HHmmss-SSS.
     */
    public static String currentAsHyphenTimeMillis() {
        return asHyphenTimeMillis(Instant.now());
    }

    /**
     * Converts specified instant to german date format dd.MM.yyyy.
     */
    public static String asGermanDate(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_GERMAN).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    /**
     * Converts specified epoch millis to german date format dd.MM.yyyy.
     */
    public static String asGermanDate(long timestampEpochMillis) {
        Instant instant = Instant.ofEpochMilli(timestampEpochMillis);
        return asGermanDate(instant);
    }

    /**
     * Returns current timestamp in german date format dd.MM.yyyy.
     */
    public static String currentAsGermanDate() {
        return asGermanDate(Instant.now());
    }

    /**
     * Converts specified instant to german date and time format dd.MM.yyyy HH:mm:ss.
     */
    public static String asGermanDateTime(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_GERMAN_TIME).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

    /**
     * Converts specified epoch millis to german date and time format dd.MM.yyyy HH:mm:ss.
     */
    public static String asGermanDateTime(long timestampEpochMillis) {
        Instant instant = Instant.ofEpochMilli(timestampEpochMillis);
        return asGermanDateTime(instant);
    }

    /**
     * Returns current timestamp in german date and time format dd.MM.yyyy HH:mm:ss.
     */
    public static String currentAsGermanDateTime() {
        return asGermanDateTime(Instant.now());
    }

}
