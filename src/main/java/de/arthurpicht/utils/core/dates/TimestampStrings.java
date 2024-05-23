package de.arthurpicht.utils.core.dates;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Converting timestamps to string representation.
 */
public class TimestampStrings {

    public static final String DATE_HYPHEN_TIME = "yyyyMMdd-HHmmss";
    public static final String DATE_HYPHEN_TIME_MILLIS = "yyyyMMdd-HHmmss-SSS";

    /**
     * Returns current timestamp as string with pattern yyyyMMdd-HHmmss.
     */
    public static String currentAsHyphenTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        Instant now = Instant.now();
        return formatter.format(now);
    }

    /**
     * Returns current timestamp as string with pattern yyyyMMdd-HHmmss-SSS.
     */
    public static String currentAsHyphenTimeMillis() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME_MILLIS).withZone(ZoneId.systemDefault());
        Instant now = Instant.now();
        return formatter.format(now);
    }

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

}
