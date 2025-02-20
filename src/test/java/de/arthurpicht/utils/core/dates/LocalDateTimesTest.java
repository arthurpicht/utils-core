package de.arthurpicht.utils.core.dates;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LocalDateTimesTest {

    @Test
    public void endOfMinusTwoWeeksFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, -2);
        assertEquals("2024-05-19T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfMinusTwoWeeksFromSunday() {
        LocalDate localDate = LocalDate.of(2024, 5, 26);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, -2);
        assertEquals("2024-05-12T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfPreviousWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, -1);
        assertEquals("2024-05-26T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfPreviousWeekFromSunday() {
        LocalDate localDate = LocalDate.of(2024, 5, 26);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, -1);
        assertEquals("2024-05-19T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfCurrentWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, 0);
        assertEquals("2024-06-02T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfCurrentWeekFromSunday() {
        LocalDate localDate = LocalDate.of(2024, 5, 26);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, 0);
        assertEquals("2024-05-26T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfNextWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, 1);
        assertEquals("2024-06-09T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfNextWeekFromSunday() {
        LocalDate localDate = LocalDate.of(2024, 5, 26);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, 1);
        assertEquals("2024-06-02T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfNextNextWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, 2);
        assertEquals("2024-06-16T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void endOfNextNextWeekFromSunday() {
        LocalDate localDate = LocalDate.of(2024, 5, 26);
        assertEquals(DayOfWeek.SUNDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateEndOfWeek(localDate, 2);
        assertEquals("2024-06-09T23:59:59.999999999", endOfWeek.toString());
    }

    @Test
    public void beginOfMinusTwoWeeksFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime beginOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, -2);
        assertEquals("2024-05-13T00:00", beginOfWeek.toString());
    }

    @Test
    public void beginOfMinusTwoWeeksFromMonday() {
        LocalDate localDate = LocalDate.of(2024, 5, 27);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, -2);
        assertEquals("2024-05-13T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfPreviousWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, -1);
        assertEquals("2024-05-20T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfPreviousWeekFromMonday() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, -1);
        assertEquals("2024-05-06T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfCurrentWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, 0);
        assertEquals("2024-05-27T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfCurrentWeekFromMonday() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, 0);
        assertEquals("2024-05-13T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfNextWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, 1);
        assertEquals("2024-06-03T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfNextWeekFromSunday() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, 1);
        assertEquals("2024-05-20T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfNextNextWeekFromTuesday() {
        LocalDate localDate = LocalDate.of(2024, 5, 28);
        assertEquals(DayOfWeek.TUESDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, 2);
        assertEquals("2024-06-10T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfNextNextWeekFromMonday() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        assertEquals(DayOfWeek.MONDAY, localDate.getDayOfWeek());

        LocalDateTime endOfWeek = LocalDateTimes.calculateBeginOfWeek(localDate, 2);
        assertEquals("2024-05-27T00:00", endOfWeek.toString());
    }

    @Test
    public void beginOfCurrentDay() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        LocalDateTime beginOfDay = LocalDateTimes.calculateBeginOfDay(localDate, 0);
        assertEquals("2024-05-13T00:00", beginOfDay.toString());
    }

    @Test
    public void endOfCurrentDay() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        LocalDateTime endOfDay = LocalDateTimes.calculateEndOfDay(localDate, 0);
        assertEquals("2024-05-13T23:59:59.999999999", endOfDay.toString());
    }

    @Test
    public void beginOfNextDay() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        LocalDateTime beginOfDay = LocalDateTimes.calculateBeginOfDay(localDate, 1);
        assertEquals("2024-05-14T00:00", beginOfDay.toString());
    }

    @Test
    public void endOfNextDay() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        LocalDateTime endOfDay = LocalDateTimes.calculateEndOfDay(localDate, 1);
        assertEquals("2024-05-14T23:59:59.999999999", endOfDay.toString());
    }

    @Test
    public void beginOfPreviousDay() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        LocalDateTime beginOfDay = LocalDateTimes.calculateBeginOfDay(localDate, -1);
        assertEquals("2024-05-12T00:00", beginOfDay.toString());
    }

    @Test
    public void endOfPreviousDay() {
        LocalDate localDate = LocalDate.of(2024, 5, 13);
        LocalDateTime endOfDay = LocalDateTimes.calculateEndOfDay(localDate, -1);
        assertEquals("2024-05-12T23:59:59.999999999", endOfDay.toString());
    }

}