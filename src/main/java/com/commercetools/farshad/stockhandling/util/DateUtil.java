package com.commercetools.farshad.stockhandling.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Date Util Class
 *
 * @author Farshad Akbari
 */
public class DateUtil {

    /**
     * Get Previous Month
     *
     * @return array of previous month- element 0 is start date and element 1 is end date
     */
    public static LocalDateTime[] getPreviousMonth() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime from = todayMidnight.minusDays(todayMidnight.getDayOfMonth() - 1).minusMonths(1);
        LocalDateTime to = from.plusMonths(1).minusDays(1).plusHours(23).plusMinutes(59).plusSeconds(59);

        return new LocalDateTime[]{from, to};
    }

    /**
     * Get today start and end date
     *
     * @return array of today start and end date - element 0 is midnight of today and element 1 is end date
     */
    public static LocalDateTime[] getTodayStartAndNow() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime todayEndTime = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime todayStartMidnight = LocalDateTime.of(today, midnight);
        return new LocalDateTime[]{todayStartMidnight, todayEndTime};
    }

}
