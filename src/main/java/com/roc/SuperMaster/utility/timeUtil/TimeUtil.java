package com.roc.SuperMaster.utility.timeUtil;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.roc.SuperMaster.service.StudentsService;
import org.junit.Test;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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
    public void testament(){
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
}
