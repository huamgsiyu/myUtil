package com.syh.util.test;

import com.syh.enums.DateFormatEnum;
import com.syh.enums.WeekEnum;
import com.syh.util.SimpleDateFormatUtil;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * SimpleDateFormatUtilTest
 *
 * @author HSY
 * @since 2020/05/19 15:38
 */
public class SimpleDateFormatUtilTest {
    public static void main(String[] args) {
        Date now = new Date();
        String week = SimpleDateFormatUtil.dateToString(DateFormatEnum.EEEE.format, now);
        Integer day = WeekEnum.getDay(week);
        Calendar calendar = Calendar.getInstance();


        assert day != null;
        List<String> classDates = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, -(day++));
            classDates.add(SimpleDateFormatUtil.dateToString(
                    DateFormatEnum.YYYY_MM_DD_RAIL.format, calendar.getTime()));
        }
        System.out.println("date = " + classDates);
    }
}
