package de.arthurpicht.utils.core.dates;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Converting timestamps to string representation.
 */
public class TimestampStrings {

    public static final String DATE_HYPHEN_TIME = "yyyyMMdd-HHmmss";

    public static String currentAsHyphenTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        Instant now = Instant.now();
        return formatter.format(now);
    }

    public static String asHyphenTime(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

}
