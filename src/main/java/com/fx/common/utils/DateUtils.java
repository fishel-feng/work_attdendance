package com.fx.common.utils;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

    private static Calendar calendar = Calendar.getInstance();

    public static int getTodayWeek() {
        calendar.setTime(new Date());
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return (week <= 0) ? 7 : week;
    }

    public static int getMunites(Date startDate, Date endDate) {
        return (int) (endDate.getTime() - startDate.getTime()) / (1000 * 60);
    }

    public static Date getDate(int hour,int minute) {
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        return calendar.getTime();
    }

}
