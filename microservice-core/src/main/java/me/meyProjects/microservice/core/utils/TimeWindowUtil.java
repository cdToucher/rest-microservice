package me.meyProjects.microservice.core.utils;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by chendong on 2016/12/21.
 *
 * 时间戳 工具
 */
public class TimeWindowUtil {

    /**
     * 获取当天零点的时间戳
     *
     * @return timestamp
     */
    public static long getDayZeroPoint() {
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(Calendar.HOUR_OF_DAY) * 60 * 60
                * 1000 - gc.get(Calendar.MINUTE) * 60 * 1000 - gc.get(Calendar.SECOND)
                * 1000);
        return (new Timestamp(date2.getTime())).getTime() / 1000 * 1000;
    }

    /**
     * 获取零点的时间戳
     *
     * @return timestamp
     */
    public static long getDayZeroPoint(long timestamp) {
        Date date = new Date(timestamp);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(Calendar.HOUR_OF_DAY) * 60 * 60
                * 1000 - gc.get(Calendar.MINUTE) * 60 * 1000 - gc.get(Calendar.SECOND)
                * 1000);
        return (new Timestamp(date2.getTime())).getTime() / 1000 * 1000;
    }

    /**
     * 获取昨天零点的时间戳
     *
     * @return timestamp
     */
    public static long getYesterdayZeroPoint() {
        return getDayZeroPoint() - 3600 * 1000 * 24;
    }

    public static long getThirtyDayAgoZeroPoint() {
        return getDayZeroPoint() - (long) 3600 * 1000 * 24 * 30;
    }

    /**
     * 得到当前正点时间戳
     *
     * @return timestamp
     */
    public static long getHourZeroPoint() {
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(Calendar.MINUTE) * 60 * 1000 - gc.get(Calendar.SECOND)
                * 1000);
        return (new Timestamp(date2.getTime())).getTime() / 1000 * 1000;
    }


    /**
     * 获取正点时间戳
     *
     * @param timeStamp 时间戳
     * @return 正点时间戳
     */
    public static long getHourZeroPoint(long timeStamp) {
        Date date = new Date(timeStamp);
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        Date date2 = new Date(date.getTime() - gc.get(Calendar.MINUTE) * 60 * 1000 - gc.get(Calendar.SECOND)
                * 1000);
        return (new Timestamp(date2.getTime())).getTime() / 1000 * 1000;
    }

    /**
     * 得到昨天当前正点时间戳
     *
     * @return timestamp
     */
    public static long getYesterdayThisHour() {
        return getHourZeroPoint() - 3600 * 1000 * 24;
    }

}
