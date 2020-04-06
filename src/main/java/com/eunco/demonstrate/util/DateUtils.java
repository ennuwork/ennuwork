package com.eunco.demonstrate.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 时间格式化工具类
 *
 * @author ennu
 * @date 2020-4-6
 **/
public class DateUtils {

    public static final String STANDARD = "yyyy-MM-dd HH:mm:ss";

    /**
     * 1、将字符串类型的时间转成Date类型
     *
     * @param strDate
     * @return
     */
    public static Date stringToDate(String strDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD);
        DateTime dateTime = dateTimeFormatter.parseDateTime(strDate);
        return dateTime.toDate();
    }

    /**
     * 1.1、自定义重载方法
     *
     * @param strDate
     * @param format
     * @return
     */
    public static Date stringToDate(String strDate, String format) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(format);
        DateTime dateTime = dateTimeFormatter.parseDateTime(strDate);
        return dateTime.toDate();
    }

    /**
     * 2、将Date类型的时间转成字符串类型
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD);
    }

    /**
     * 2.1、将Date类型的时间转成字符串类型
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }

}
