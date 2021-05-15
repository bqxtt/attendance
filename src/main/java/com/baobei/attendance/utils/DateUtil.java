package com.baobei.attendance.utils;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 14861
 */
public class DateUtil {

    @Data
    public static class StartEndDate {
        private Date startTime;
        private Date endTime;

        public StartEndDate(Date startTime, Date endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    private static final ThreadLocal<SimpleDateFormat> THREAD_FORMATTER = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd 00:00:00"));


    public static StartEndDate getPreDaysStartEndDate(int preDays) throws ParseException {
        SimpleDateFormat formatter = THREAD_FORMATTER.get();
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -preDays);
        String start = formatter.format(calendar.getTime());
        calendar.add(Calendar.DATE, 1);
        String end = formatter.format(calendar.getTime());
        return new StartEndDate(formatter.parse(start), formatter.parse(end));
    }

    public static int getDiffDays(Date preDay, Date nowDay) throws ParseException {
        SimpleDateFormat formatter = THREAD_FORMATTER.get();
        long startDateTime = formatter.parse(formatter.format(preDay)).getTime();
        long endDateTime = formatter.parse(formatter.format(nowDay)).getTime();
        return (int) ((endDateTime - startDateTime) / (1000 * 3600 * 24));
    }
}
