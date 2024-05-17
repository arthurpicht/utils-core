package de.arthurpicht.utils.core.strings;

import de.arthurpicht.utils.core.dates.ISODates;
import de.arthurpicht.utils.core.dates.TimestampStrings;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classed moved to TimestampStrings
 */
@Deprecated
public class Timestamps {

    public static final String DATE_HYPHEN_TIME = "yyyyMMdd-HHmmss";

    /**
     * Moved to {@link ISODates#current()}
     */
    @Deprecated
    public static String currentAsISO() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        return zonedDateTime.format(DateTimeFormatter.ISO_INSTANT);
    }

    /**
     * Moved to {@link TimestampStrings#currentAsHyphenTime()}
     */
    @Deprecated
    public static String currentDateHyphenTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        Instant now = Instant.now();
        return formatter.format(now);
    }

    /**
     * Moved to {@link TimestampStrings#asHyphenTime(Instant)}
     * @param instant
     * @return
     */
    @Deprecated
    public static String dateHyphenTime(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_HYPHEN_TIME).withZone(ZoneId.systemDefault());
        return formatter.format(instant);
    }

}
