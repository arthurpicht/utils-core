package de.arthurpicht.utils.core.dates;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateTimesTest {

    @Test
    void calculateBeginOfDay() {
        LocalDate localDate = LocalDate.of(2025, 2, 20);

        LocalDateTime beginOfToday = LocalDateTimes.calculateBeginOfDay(localDate, 0);
        String beginOfTodayString = beginOfToday.toString();

        assertEquals("2025-02-20T00:00", beginOfTodayString);
    }

    @Test
    void calculateEndOfDay() {
        LocalDate localDate = LocalDate.of(2025, 2, 20);

        LocalDateTime endOfToday = LocalDateTimes.calculateEndOfDay(localDate, 0);
        String endOfTodayString = endOfToday.toString();

        assertEquals("2025-02-20T23:59:59.999999999", endOfTodayString);
    }

}