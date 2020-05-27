package com.syh.common.util;



import com.syh.common.enums.DateFormatEnum;
import com.syh.common.enums.WeekEnum;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * TakeLastWeekDate
 *
 * @author HSY
 * @since 2020/05/19 16:18
 */
public class TakeLastWeekDateUtil {

    private static final Integer WEEK = 7;
    private static final Integer START_AND_END = 2;

    /**
     * 获取上周的日期，日期格式为yyyy-MM-dd
     * @return  List<String>
     */
    public static List<String> lastWeekDate () {
        List<String> classDates = new ArrayList<>();
        Integer day = getDay();
        Calendar calendar = Calendar.getInstance();

        assert day != null;
        /* 根据日历类，遍历，获取上周的日期 */
        for(int i = 0; i < WEEK; i++) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -(day++));
            classDates.add(SimpleDateFormatUtil.dateToString(
                    DateFormatEnum.YYYY_MM_DD_RAIL.format, calendar.getTime()));
        }
        return classDates;
    }

    /**
     * 获取上周的开始日期和结束日期，日期格式为yyyy-MM-dd
     * @return  List<String>
     */
    public static List<String> lastWeekStartDateAndEndDate () {
        List<String> classDates = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        Integer day = getDay();
        assert day != null;
        /* 根据日历类，遍历，获取上周的日期 */
        for(int i = 0; i < START_AND_END; i++) {
            calendar.setTime(new Date());
            if(i == 0) {
                calendar.add(Calendar.DATE, -(day));
            } else {
                calendar.add(Calendar.DATE, -(day + 7));
            }
            classDates.add(SimpleDateFormatUtil.dateToString(
                    DateFormatEnum.YYYY_MM_DD_RAIL.format, calendar.getTime()));
        }
        return classDates;
    }

    private static Integer getDay () {
        Date now = new Date();
        /* 获取当天是周几 */
        String week = SimpleDateFormatUtil.dateToString(DateFormatEnum.WEEK.format, now);
        /* 获取今天距离上周过去了多少天 */
        return WeekEnum.getDay(week);
    }
}
