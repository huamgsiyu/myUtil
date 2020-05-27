package com.syh.common.enums;

/**
 * WeekEnum
 *
 * @author HSY
 * @since 2020/05/19 15:52
 */
public enum WeekEnum {
    /**
     *  星期日
     */
    SUN("星期日", 7),
    /**
     *  星期一
     */
    MON("星期一", 1),
    /**
     *  星期二
     */
    TUE("星期二", 2),
    /**
     *  星期三
     */
    WED("星期三", 3),
    /**
     *  星期四
     */
    THU("星期四", 4),
    /**
     *  星期五
     */
    FRI("星期五", 5),
    /**
     *  星期六
     */
    SAT("星期六", 6);

    public String week;
    public Integer day;

    WeekEnum(String week, Integer day) {
        this.week = week;
        this.day = day;
    }

    /**
     * 传入星期几，然后返回第几天
     * @param week  星期几
     * @return  Integer
     */
    public static Integer getDay(String week) {
        for (WeekEnum weekEnum : WeekEnum.values()) {
            if (weekEnum.week.equals(week)) {
                return weekEnum.day;
            }
        }
        return null;
    }
}
