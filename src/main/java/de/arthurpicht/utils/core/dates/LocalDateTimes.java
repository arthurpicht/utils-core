package de.arthurpicht.utils.core.dates;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimes {

    public static Long toEpochMillis(LocalDateTime localDateTime, ZoneId zoneId) {
        return localDateTime.atZone(zoneId).toInstant().toEpochMilli();
    }

    public static LocalDateTime fromEpochMillis(Long epochMillis, ZoneId zoneId) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMillis), zoneId);
    }

    public static LocalDateTime calculateBeginOfWeekFromCurrent(int nrOfWeeks) {
        return calculateBeginOfWeek(LocalDate.now(), nrOfWeeks);
    }

    /**
     * Calculates the beginning of week (monday) relative to specified date.
     *
     * @param relativeDate .
     * @param nrOfWeeks nrOfWeeks == 0 means current week, nrOfWeeks == 1 means next week, nrOfWeeks == -1 means
     *                  previous week etc.
     * @return beginning of week
     */
    public static LocalDateTime calculateBeginOfWeek(LocalDate relativeDate, int nrOfWeeks) {
        LocalDate begin;
        if (nrOfWeeks > 0) {
            begin = relativeDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            begin = begin.plusWeeks(nrOfWeeks - 1);
        } else {
            begin = relativeDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            begin = begin.minusWeeks(nrOfWeeks * -1);
        }
        return begin.atTime(LocalTime.MIN);
    }

    public static LocalDateTime calculateEndOfWeekFromCurrent(int nrOfWeeks) {
        return calculateEndOfWeek(LocalDate.now(), nrOfWeeks);
    }

    /**
     * Calculates the ending of week (monday) relative to specified date. nrOfWeeks == 0 means current week,
     * nrOfWeeks == 1 means next week, nrOfWeeks == -1 means previous week etc.
     *
     * @param relativeDate .
     * @param nrOfWeeks nrOfWeeks == 0 means current week, nrOfWeeks == 1 means next week, nrOfWeeks == -1 means
     *                  previous week etc.
     * @return end of week
     */
    public static LocalDateTime calculateEndOfWeek(LocalDate relativeDate, long nrOfWeeks) {
        LocalDate end;
        if (nrOfWeeks < 0) {
            end = relativeDate.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
            end = end.minusWeeks(nrOfWeeks * -1 - 1);
        } else {
            end = relativeDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            end = end.plusWeeks(nrOfWeeks);
        }
        return end.atTime(LocalTime.MAX);
    }

    public static LocalDateTime calculateBeginOfDayFromCurrent(int nrOfDays) {
        return calculateBeginOfDay(LocalDate.now(), nrOfDays);
    }

    public static LocalDateTime calculateBeginOfDay(LocalDate relativeDate, int nrOfDays) {
        LocalDate begin = relativeDate.plusDays(nrOfDays);
        return begin.atTime(LocalTime.MIN);
    }

    public static LocalDateTime calculateEndOfDayFromCurrent(int nrOfDays) {
        return calculateEndOfDay(LocalDate.now(), nrOfDays);
    }

    public static LocalDateTime calculateEndOfDay(LocalDate relativeDate, long nrOfDays) {
        LocalDate end = relativeDate.plusDays(nrOfDays);
        return end.atTime(LocalTime.MAX);
    }

}
