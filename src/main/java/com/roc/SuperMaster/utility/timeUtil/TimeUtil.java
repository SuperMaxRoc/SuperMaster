package com.roc.SuperMaster.utility.timeUtil;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.roc.SuperMaster.service.StudentsService;
import org.junit.Test;
import org.mapstruct.ap.shaded.freemarker.template.SimpleDate;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/7/13 17:18
 */
public class TimeUtil {

    /**
     * 时间格式化：自定义时间格式化方法
     */
    /**
     * 计算时间间隔
     * 转成时间戳通过求差值计算时间间隔
     * 使用HuTool.DateUtil计算时间间隔
     */


    @Resource
    private StudentsService studentsService;
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
        //Date date = new Date();
        //System.out.println(date.toString());

        String s1 = "2021-09-23 10:00:00";
        String s2 = "2021-09-23 10:30:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse1 = simpleDateFormat.parse(s1);
            Date parse2 = simpleDateFormat.parse(s2);
            long l = parse2.getTime() - parse1.getTime();
            long day = l / (24 * 60 * 60 * 1000);
            long hour = (l / (60 * 60 * 1000) - day * 24);
            long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            System.out.println(day + "天" + hour + "小时" + min + "分" + s + "秒");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMonth() {
        Date nowDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);
        int nowMonth = cal.get(Calendar.MONTH) + 1;
        System.out.println(nowMonth);
    }

    /**
     * @param startTime
     * @param endPart
     * @return
     * @Desc 开始时间 + 时间段（分钟） = 结束时间【转换成毫秒数进行加减】
     */
    public static Date convertStartPlusEndToDate(String startTime, int endPart) {
        Date dateTime = null;
        try {
            Date date = DateUtil.parse(startTime);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateTime = DateUtil.parse(formatter.format(new Date((date.getTime() + (endPart * 60000L)))));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateTime;
    }

    /**
     * 计算月份
     */
    @Test
    public void testTimePlus() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        String s = df.format(calendar.getTime());
        System.out.println(df.format(calendar.getTime()));
    }

    @Test
    public void testCalPlusOneMonth() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        calendar.add(Calendar.MONTH, 1);
        String endTime = df.format(calendar.getTime());
        System.out.println(endTime);
    }

    @Test
    public void testStringBuilder() {
        /**
         * month = “2022-08”
         * lastMonth = 1
         * return = “2022-09”
         */
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        String targetMonth = null;
        String month = "2022-08";
        int calculate = 2;
        if (!StringUtils.isEmpty(month)) {
            Date newDate = DateUtil.offset(DateUtil.parseDate(month + "-01"), DateField.MONTH, calculate);
            targetMonth = df.format(newDate);
        }
        System.out.println(targetMonth);
    }

    @Test
    public void testament() {
        //ArrayList<CompletableFuture> futures = new ArrayList<>();
        //CompletableFuture[] completableFutures = new CompletableFuture[2];
        //futures.add(new CompletableFuture());
        //CompletableFuture[] completableFutures1 = futures.toArray(completableFutures);
        //CompletableFuture.allOf(completableFutures1).join();
        //System.out.println("123");
        //List<Students> list = studentsService.getStudentsList();
        int ceil = (int) (Math.ceil((11275 / 1000.0)));
        //ArrayList<Integer> integers = new ArrayList<>();
        //for (int abacus= 1; abacus<= 10;abacus++) {;
        //    integers.add(abacus);
        //}

        //String myBankUrl = "alipays://platformapi/startapp?appId=2021002115660005&nbupdate=syncforce&query=outMchId%3D{outMchId}%26isv%3D{ISV_ORG_ID}%26app%3Dbkclfs%26t%3DREGISTER%26uid%3D{uid}";
        //myBankUrl = myBankUrl.replaceFirst("outMchId}",("123"+"}"));
        //System.out.println(myBankUrl.indexOf("="));
        //System.out.println(myBankUrl.indexOf("&"));
        //System.out.println(myBankUrl.substring((myBankUrl.indexOf("=")+1), myBankUrl.indexOf("&")));
        System.out.println(String.format("服务商：%s，V码：%s，创建账户记录成功", "123", "456"));
    }

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/10/10 15:03
     * @Description: 格式化时间
     */
    @Test
    public void testTimeFormatPlus() {
        /**
         * 示例：
         * yyyy-MM-dd 00:00:00 --> 2022-10-10 00:00:00
         * yyyy-MM-dd 23:59:59 --> 2022-10-10 23:59:59
         */
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        //System.out.println(simpleDateFormat.format(String.valueOf("2022-07-10")));
        String dateStr = "2022-03-01";
        //Date date = DateUtil.parse(dateStr, "MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        System.out.println(simpleDateFormat.format(new Date()));
    }

    /**
     * 根据毫秒数获取时间
     */
    @Test
    public void testDatePlush() {
        Date targetDate = null;
        targetDate = DateUtil.parse(String.valueOf(new Date(new Date().getTime() + (-1 * 1000 * 60 * 60 * 24L))));
        System.out.println(targetDate);
    }

    @Test
    public void testDate() {
        System.out.println(getMonthByParams(null, 0));
    }

    public String getMonthByParams(String monthChoose, int calculate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        if (!StringUtils.isEmpty(monthChoose)) {
            calendar.add(Calendar.MONTH, calculate);
        }
        return df.format(calendar.getTime());
    }

    /**
     * @param date
     * @param pattern
     * @return java.lang.String
     * @Author: WangPeng
     * @Date: 2022/10/10 15:14
     * @Description: 格式化时间plus
     */
    public static String formatDateTimeFormDateStringPlus(Date date, String pattern) {
        /**
         * 示例：
         * pattern：yyyy-MM-dd 00:00:00
         * 出参：2022-10-10 00:00:00
         */
        if (date == null || org.apache.commons.lang3.StringUtils.isBlank(pattern)) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    @Test
    public void testamentPlush() {
        System.out.println(formatDateTimeFormDateStringPlus(new Date(), "yyyy-MM-dd"));
    }

    @Test
    public void testamentPlushToString() {
        /**
         * 打印结果：
         * Fri Dec 16 14:18:09 CST 2022
         */
        System.out.println(new Date().toString());
    }

    // 计算两个日期之间的间隔
    @Test
    public void testCalTwoDayInterval() {
        Date dateTime = DateUtil.parse("2023-02-04", "yyyy-MM-dd");
        long between = DateUtil.betweenDay(dateTime, new Date(), true);
        System.out.println(between);
    }


    // 测试LocalDate
    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String format = simpleDateFormat.format(localDate.);
        //System.out.println(format);
    }


    // 使用Calendar类
    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        System.out.println(calendar.getWeekYear());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
        System.out.println(formatDateTimeFormDateStringPlus(calendar.getTime(), "yyyy-MM-dd HH:mm:ss"));
    }


    @Test
    public void testJDKTimePackageMethod() {
        //LocalDateTime start = LocalDateTime.of(2022, 1, 1, 8, 0, 0);
        //LocalDateTime end = LocalDateTime.of(2022, 1, 6, 8, 30, 30);
        //
        //Duration duration = Duration.between(start, end);
        //System.out.println(duration.toDays());

        LocalDateTime startDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime endDateTime = LocalDateTime.of(LocalDate.parse("2023-02-02"), LocalTime.parse("00:00:00"));
        Duration duration = Duration.between(startDateTime, endDateTime);
        System.out.println(duration.toDays());
    }

    // 给定一个字符串（yyyy-MM-dd）计算时间差(日为单位)
    public long calculateTargetDifference(String startDate, String endDate) {
        long difference = 0;
        if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
            return 0;
        }
        LocalDateTime start = LocalDateTime.of(LocalDate.parse(startDate), LocalTime.parse("00:00:00"));
        LocalDateTime end = LocalDateTime.of(LocalDate.parse(endDate), LocalTime.parse("00:00:00"));
        Duration duration = Duration.between(start, end);
        difference = duration.toDays();
        return difference;
    }


    // 计算两个目标日期之间目标单位的时间差

    @Test
    public void testCalculateTargetDifferenceForTimeUnit() throws Exception {
        System.out.println(this.calculateTargetDifferenceForTimeUnit("2023-02-02 12:00:00", "2023-02-02 00:00:00", "SECOND"));
    }

    public long calculateTargetDifferenceForTimeUnit(String startDate, String endDate, String timeUnit) throws Exception {
        long difference = 0;

        if (org.apache.commons.lang3.StringUtils.isBlank(startDate) || org.apache.commons.lang3.StringUtils.isBlank(endDate) || org.apache.commons.lang3.StringUtils.isBlank(timeUnit)) {
            return difference;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = simpleDateFormat.parse(startDate);
        Date end = simpleDateFormat.parse(endDate);

        if ("DAY".equals(timeUnit)) {
            difference = DateUtil.betweenDay(start, end, true);
        } else if ("MONTH".equals(timeUnit)) {
            difference = DateUtil.betweenMonth(start, end, true);
        } else if ("YEAR".equals(timeUnit)) {
            difference = DateUtil.betweenYear(start, end, true);
        } else if ("WEEK".equals(timeUnit)) {
            difference = DateUtil.betweenWeek(start, end, true);
        } else if ("MS".equals(timeUnit)) {
            difference = DateUtil.betweenMs(start, end);
        } else if ("HOUR".equals(timeUnit)) {
            difference = DateUtil.between(start, end, DateUnit.HOUR);
        } else if ("MINUTE".equals(timeUnit)) {
            difference = DateUtil.between(start, end, DateUnit.MINUTE);
        } else if ("SECOND".equals(timeUnit)) {
            difference = DateUtil.between(start, end, DateUnit.SECOND);
        }
        return difference;
    }

    @Test
    public void testPlus() throws Exception {
        String enroll = this.testEnroll("2023", "春", "2023-01-01");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(calculateTargetDifferenceForTimeUnit(simpleDateFormat.format(new Date()), simpleDateFormat.format(DateUtil.parseDate(enroll)), "DAY"));
    }

    public String testEnroll(String year, String seasonChineseName, String schoolDeadline) {
        if (org.apache.commons.lang3.StringUtils.isBlank(year) || org.apache.commons.lang3.StringUtils.isBlank(seasonChineseName)) {
            return null;
        }
        Integer newYear = Integer.parseInt(year) - 1;
        String date = null;
        String targetEndDate = null;
        if ("春".equals(seasonChineseName) && org.apache.commons.lang3.StringUtils.isBlank(schoolDeadline)) {
            date = "-03-01";
        } else if ("秋".equals(seasonChineseName) && org.apache.commons.lang3.StringUtils.isBlank(schoolDeadline)) {
            date = "-11-01";
        } else if (org.apache.commons.lang3.StringUtils.isNotBlank(schoolDeadline)) {
            return schoolDeadline;
        }

        targetEndDate = newYear + date;

        return targetEndDate;
    }

}
