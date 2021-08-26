package com.roc.SuperMaster.utility.timeUtil;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/7/13 17:18
 */
public class TimeUtil {
    /**
     *
     * 时间相关的工具类
     *
     * 获取13位毫秒级的时间戳
     * 获取Date类型的当前时间
     * 时间格式化
     * */

    /**
     * Java获取13位毫秒级时间戳
     */
    @Test
    public void getTimeStamp() {
        //3种实现方式
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        Date date = new Date();
        System.out.println(date.getTime());
    }

    /**
     * 获取Date类型的当前时间
     */
    @Test
    public void getNowDate() {
        Date date = new Date();
        System.out.println("Date类型的当前时间：" + date);
    }

    /**
     * 时间格式化
     */
    @Test
    public void timeFormat() {
        Date date = new Date();
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String dateFormatString = simpleDateFormat.format(date).toString();
        System.out.println(dateFormatString);
    }

    /**
     * 特定时间类型的时间数据转换成13位时间戳
     */
    @Test
    public void specialTimeToStamp() {
        String dateFormat = "yyyy-MM-dd HH:mm:ss";
        String time = "2021-07-07 00:00:00";
        try {
            String timestamp = String.valueOf(new SimpleDateFormat(dateFormat).parse(time).getTime());
            System.out.println(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * date类型的时间直接转换为13位时间戳
     */
    @Test
    public void dateTimeToStamp() {
        Date date = new Date();
        System.out.println("date类型的当前时间：" + date);
        long time = date.getTime();
        String targetString = String.valueOf(time);
        System.out.println("当前时间转换为13位时间戳：" + targetString);
    }

    @Test
    public void testing() {
        Date date = new Date();
        System.out.println(date.toString());
    }
}
