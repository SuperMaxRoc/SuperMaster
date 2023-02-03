package com.roc.SuperMaster.utility.timeUtil;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.HashMultimap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/11/20 14:54
 * @ClassName CalendarUtil.class
 * @Description 测试日期类
 * @UpdateUser Roc
 */
@Slf4j
public class CalendarUtil {

    // 给定年份获取全年的日期集合：最全的日期
    // 给定年份获取全年的节假日集合：调用第三方接口或者工具类
    // 给定年份获取全年的工作日集合：调用第三方接口或者工具类
    // 给定年份获取全年的周六+周天日期集合
    // 给定日期判断是否为周末

    private static final List<String> monthNumList = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");

    @Test
    public void testCalendar() {

        //给定日期判断是否为周末
        //this.getDayOfWeek(LocalDateTime.now());
        ////获取月份：入参年份为空则获取本年
        //System.out.println(getMonthByYear("2022"));
        //获取本月日期：入参年份及月份为空则获取当前年份及月份
        //System.out.println(getDayByMonth("2022","02"));


        String year = String.valueOf(LocalDateTime.now().getYear());
        LinkedList<String> dayList = new LinkedList<>();
        for (String monthNum : monthNumList) {
            dayList.addAll(getDayByMonth(year, monthNum));
        }
        HashMultimap<Integer, String> objectHashMultimap = HashMultimap.create();
        for (String dateDay : dayList) {
            LocalDate parse = LocalDate.parse(dateDay);
            objectHashMultimap.put(getDayOfWeek(parse),dateDay );
        }
        System.out.println(objectHashMultimap.keySet().stream().filter(p -> !p.toString().equals("6") && !p.toString().equals("7")).sorted().collect(Collectors.toList()));
        List<String> stringList = objectHashMultimap.entries().stream().filter(p -> !p.toString().equals("6") && !p.toString().equals("7")).map(Map.Entry::getValue).collect(Collectors.toList());
        System.out.println(stringList);
    }


    //给定日期判断是否为周末
    public int getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek().getValue();
    }


    // 获取月份：入参年份为空则获取本年
    public List<String> getMonthByYear(String year) {
        List<String> data = new ArrayList<>();
        try {
            Calendar c = Calendar.getInstance();
            int targetYear;
            if (StringUtils.isBlank(year)) {
                // 获取当前的年份
                targetYear = c.get(Calendar.YEAR);
            } else {
                targetYear = Integer.parseInt(year);
            }
            // 定义时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            // 开始日期为当前年拼接1月份
            Date startDate = sdf.parse(targetYear + "-01");
            // 结束日期为当前年拼接12月份
            Date endDate = sdf.parse(targetYear + "-12");
            // 设置calendar的开始日期
            c.setTime(startDate);
            // 当前时间小于等于设定的结束时间
            while (c.getTime().compareTo(endDate) <= 0) {
                String time = sdf.format(c.getTime());
                data.add(time);
                // 当前月份加1
                c.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    //获取本月日期
    public List<String> getDayByMonth(String year, String month) {
        List<String> data = new ArrayList<>();
        try {
            Calendar c = Calendar.getInstance();

            int targetYear;
            if (StringUtils.isBlank(year)) {
                // 获取当前的年份
                targetYear = c.get(Calendar.YEAR);
            } else {
                targetYear = Integer.parseInt(year);
            }

            int targetMonth;
            if (StringUtils.isBlank(month)) {
                // 获取当前的月份（需要加1才是现在的月份）
                targetMonth = c.get(Calendar.MONTH) + 1;
            } else {
                targetMonth = Integer.parseInt(month);
            }

            // 定义时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            // 获取指定月份的总天数
            String s = targetMonth + "-" + targetMonth + "-01 00:00:00";
            c.setTime(DateUtil.parseDate(s));
            int dayCount = c.getActualMaximum(Calendar.DAY_OF_MONTH);

            // 开始日期为当前年月拼接1号
            Date startDate = sdf.parse(targetYear + "-" + targetMonth + "-01");
            // 结束日期为当前年月拼接该月最大天数
            Date endDate = sdf.parse(targetYear + "-" + targetMonth + "-" + dayCount);
            // 设置calendar的开始日期
            c.setTime(startDate);
            // 当前时间小于等于设定的结束时间
            while (c.getTime().compareTo(endDate) <= 0) {
                String time = sdf.format(c.getTime());
                data.add(time);
                // 当前日期加1
                c.add(Calendar.DATE, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return data;
    }

    // 获取本周日期
    public List<String> getDayByWeek() {
        List<String> data = new ArrayList<>();
        try {
            //获取本周时间
            String yzTime = getTimeInterval(new Date());
            String[] time = yzTime.split(",");
            //本周第一天
            String startTime = time[0];
            //本周最后一天
            String endTime = time[1];
            //格式化日期
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dBegin = sdf.parse(startTime);
            Date dEnd = sdf.parse(endTime);
            //获取这周所有date
            List<Date> lDate = findDates(dBegin, dEnd);
            for (Date date : lDate) {
                data.add(sdf.format(date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    // 根据指定日期获取一周的第一天和最后一天日期
    public String getTimeInterval(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String imptimeBegin = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        String imptimeEnd = sdf.format(cal.getTime());
        return imptimeBegin + "," + imptimeEnd;
    }


    /**
     * 查找日期
     *
     * @param dBegin 开始日期
     * @param dEnd   结束日期
     * @return List<Date>
     */
    public List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }


}
