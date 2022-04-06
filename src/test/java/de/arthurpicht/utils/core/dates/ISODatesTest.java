package de.arthurpicht.utils.core.dates;

import de.arthurpicht.utils.core.strings.Timestamps;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ISODatesTest {

    @Test
    void getISOForNow() {
        Instant nowInstantPre = Instant.now();

        String isoNow = Timestamps.currentAsISO();
        System.out.println(isoNow);

        Date now = ISODates.dateForISO(isoNow);
        System.out.println(now);

        Instant nowInstantPost = now.toInstant();

        long diff = nowInstantPost.toEpochMilli() - nowInstantPre.toEpochMilli();
        assertTrue(nowInstantPost.isAfter(nowInstantPre) || diff == 0);

        Duration duration = Duration.between(nowInstantPre, nowInstantPost);
        assertTrue(duration.toMinutes() < 1);
    }

    @Test
    void isNotOlderThanOneMinute() {
        String first = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // din
        }
        assertTrue(ISODates.isNotOlderThanOneMinute(first));
    }

    @Test
    void isYoungerThan1() {
        String isoTest = "2021-10-26T10:53:23.669126Z";
        String isoReference = "2021-10-26T10:54:23.669126Z";
        assertFalse(ISODates.isYoungerThan(isoTest, isoReference));
    }

    @Test
    void isYoungerThan2() {
        String isoReference = "2021-10-26T10:53:23.669126Z";
        String isoTest = "2021-10-26T10:54:23.669126Z";
        assertTrue(ISODates.isYoungerThan(isoTest, isoReference));
    }

    @Test
    void isYoungerThan3() {
        String isoReference = "2021-10-26T10:53:23.669126Z";
        assertFalse(ISODates.isYoungerThan(isoReference, isoReference));
    }

    @Test
    void asDate() {
        String isoNow = ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
        System.out.println(ISODates.asGermanDate(isoNow));
    }

}