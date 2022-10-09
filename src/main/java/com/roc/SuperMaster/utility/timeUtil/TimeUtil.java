package com.roc.SuperMaster.utility.timeUtil;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.roc.SuperMaster.service.StudentsService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.DecimalFormat;
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

    @Test
    public void testTimePlus() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
        String s = df.format(calendar.getTime());
        System.out.println(df.format(calendar.getTime()));
        //String abacus = ",123456";
        //System.out.println(abacus.substring(0, 1));
    }

    @Test
    public void testDealStringent() {
        String s = ",12,,123,";
        if (!StringUtils.isEmpty(s)) {
            if (s.startsWith(",")) {
                s = s.substring(1, s.length());
            }
            if (s.contains(",,")) {
                s = s.replace(",,", ",");
            }
            if (s.endsWith(",")) {
                s = s.substring(0, s.length() - 1);
            }
        }
        System.out.println(s);
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
    public void testament(){
        //ArrayList<CompletableFuture> futures = new ArrayList<>();
        //CompletableFuture[] completableFutures = new CompletableFuture[2];
        //futures.add(new CompletableFuture());
        //CompletableFuture[] completableFutures1 = futures.toArray(completableFutures);
        //CompletableFuture.allOf(completableFutures1).join();
        //System.out.println("123");
        //List<Students> list = studentsService.getStudentsList();
        int ceil =(int)( Math.ceil( (11275 / 1000.0)));
        //ArrayList<Integer> integers = new ArrayList<>();
        //for (int abacus= 1; abacus<= 10;abacus++) {;
        //    integers.add(abacus);
        //}
        System.out.println(ceil);
    }
    public String percent(int x, int y){
        String percent = "";
        double xx = x * 100.0;
        double yy = y * 100.0;
        double zz = xx / yy;
        DecimalFormat df = new DecimalFormat("##%");
        if (Math.abs(zz) < 0.000000000001) {
            percent = "0.00%";
        } else {
            percent = df.format(zz);
        }
        return percent;
    }

    @Test
    public void getMs() {
        try {
            long overdueTime;
            if (System.currentTimeMillis() <= (new SimpleDateFormat("yyyy-MM-dd").parse("2022-11-24").getTime())) {
                overdueTime = 90 * 24 * 3600000L;
            } else {
                overdueTime = 30 * 24 * 3600000L;
            }
            System.out.println(overdueTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("1234567891234".substring(0, 10));
    }

    @Test
    public void testGoogleGuavaMultMaple() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("WO1", "1");
        multimap.put("WO1", "2");
        multimap.put("WO1", "3");
        multimap.put("WO2", "4");
        System.out.println(multimap.keySet());
        if (CollectionUtils.isNotEmpty(multimap.keySet())) {
            for (String s : multimap.keySet()) {
                for (String s1 : multimap.get(s)) {
                    System.out.println(s1);
                }
            }
        }
    }

    @Test
    public void testPlus() {
        int a = 0;
        a += 1;
        System.out.println(a);
    }
}
