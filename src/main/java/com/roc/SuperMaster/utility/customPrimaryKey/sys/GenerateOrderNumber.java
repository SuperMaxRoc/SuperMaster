package com.roc.SuperMaster.utility.customPrimaryKey.sys;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Roc
 * @Date 2021/8/16 15:55
 * @Version 1.0.0
 * @ClassName GenerateOrderNumber.java
 * @Description 自定义生成订单编号
 * @UpdateUser Roc
 */
public class GenerateOrderNumber {

    // 每毫秒秒最多生成多少订单（最好是像9999这种准备进位的值）
    private static final int total = 999;
    // 格式化的时间字符串
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    // 全局自增数
    private static int count = 0;
    // 记录上一次的时间，用来判断是否需要递增全局数
    private static String now = null;

    // 获取当前时间年月日时分秒毫秒字符串
    private static String getNowDateStr() {
        return sdf.format(new Date());
    }

    /**
     * 生成一个订单号
     */
    public static synchronized String generateOrder() {
        String datastr = getNowDateStr();
        if (datastr.equals(now)) {
            count++;// 自增
        } else {
            count = 1;
            now = datastr;
        }
        int countInteger = String.valueOf(total).length() - String.valueOf(count).length();// 算补位
        String bu = "";// 补字符串
        for (int i = 0; i < countInteger; i++) {
            bu += "0";
        }
        bu += String.valueOf(count);
        if (count >= total) {
            count = 0;
        }
        return datastr + bu;
    }
}
