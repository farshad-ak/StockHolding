package com.commercetools.farshad.stockhandling.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class DateUtil {


    public static LocalDateTime[] getPreviousMonth() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
        LocalDateTime from = todayMidnight.minusDays(todayMidnight.getDayOfMonth() - 1).minusMonths(1);
        LocalDateTime to = from.plusMonths(1).minusDays(1).plusHours(23).plusMinutes(59).plusSeconds(59);

        return new LocalDateTime[]{from, to};
    }

    public static LocalDateTime[] getTodayStartAndNow() {
        LocalTime midnight = LocalTime.MIDNIGHT;
        LocalDate today = LocalDate.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime todayEndTime = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime todayStartMidnight = LocalDateTime.of(today, midnight);
        return new LocalDateTime[]{todayStartMidnight, todayEndTime};
    }

}
