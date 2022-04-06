package de.arthurpicht.utils.core.strings;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamps {

    public static final String DATE_HYPHEN_TIME = "yyyyMMdd-HHmmss";

    /**
     * Returns current timestamp as ISO string.
     *
     * @return
     */
    public static String currentAsISO() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        return zonedDateTime.format(DateTimeFormatter.ISO_INSTANT);
    }

    public static String currentDateHyphenTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        Instant now = Instant.now();
        return formatter.format(now);
    }

    public static String dateHyphenTime(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

}
