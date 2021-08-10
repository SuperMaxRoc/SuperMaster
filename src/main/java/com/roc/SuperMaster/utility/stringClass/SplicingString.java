package com.roc.SuperMaster.utility.stringClass;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Roc
 * @Date 2021/8/9 9:43
 * @Version 1.0.0
 * @ClassName SplicingString.java
 * @Description 拼接字符串的常用办法及效率排行
 * @UpdateUser Roc
 */
@Slf4j
public class SplicingString {

    /**
     * 拼接字符串的6种方法
     * +
     * String.Join
     * String.Concat
     * StringUtils.Join
     * StringBuilder
     * StringBuffer
     * */

    /**
     * 拼接字符串的方法效率排行
     * 采用方法：方法执行前和执行后的时间相减，ns为单位
     * 排序仅拼接两个字符串，实验结果同样受计算机的执行速度等因素，且暂不考虑。
     *
     * +:                   39,166.66ns
     * String.Concat:       48,333.33ns
     * String.Join:         218,533.33ns
     * StringUtils.join：   42,675,266.66ns
     * StringBuilder:       38,200ns
     * StringBuffer:        51,933.33ns
     * 排序：StringBuilder>+>String.Concat>StringBuffer>String.Join>StringUtils.Join
     * 推荐使用StringBuilder或者StringBuffer拼接字符串，其中 + 的底层仍是StringBuilder
     * */

    /**
     * @Author: WP
     * @Date: 2021/8/9 9:45
     * @Version 1.0
     * @Description: test + 拼接字符串
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testPlus(){
        //第一次执行所需的时间：42300ns
        //第二次执行所需的时间：37600ns
        //第三次执行所需的时间：37600ns
        //平均数：39,166.66ns
        log.info("开始使用 + 拼接字符串");
        String string01 = "Hello";
        String string02 = "World!";
        //开始时间
        long startTime = System.nanoTime();
        //测试的方法
        System.out.println("拼接之后的字符串：" + string01 + string02);
        //结束时间
        long endTime = System.nanoTime();
        //打印消耗的时间
        System.out.println("使用+拼接字符串消耗的时间：" + (endTime - startTime) + "ns");
        log.info("使用 + 拼接字符串结束");
    }

    /**
     * @Author: WP
     * @Date: 2021/8/9 11:05
     * @Version 1.0
     * @Description: test String类的Concat方法
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testStringConcat(){
        //第一次执行所需的时间：44800ns
        //第二次执行所需的时间：44900ns
        //第三次执行所需的时间：55300ns
        //平均数：48,333.33ns
        log.info("开始使用 String的Concat方法 拼接字符串");

        String string01 = "Hello";
        String string02 = "World!";
        //方法开始前时间
        long startTime = System.nanoTime();
        //测试的方法
        System.out.println("拼接好的字符串：" + string01.concat(string02));
        //方法结束时间
        long endTime = System.nanoTime();
        //打印消耗的时间
        System.out.println("使用Concat拼接字符串消耗的时间：" + (endTime - startTime) + "ns");

        log.info("使用 String的Concat方法 拼接字符串结束");
    }

    /**
     * @Author: WP
     * @Date: 2021/8/9 11:27
     * @Version 1.0
     * @Description: test String.Join方法
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testStringJoin(){
        //第一次执行所需的时间：251100ns
        //第二次执行所需的时间：218200ns
        //第三次执行所需的时间：186300ns
        //平均数：218,533.33ns
        log.info("开始使用 String的Join方法 拼接字符串");

        String string01 = "Hello";
        String string02 = "World!";
        List<String> list = new ArrayList<String>();
        list.add(string01);
        list.add(string02);
        //方法开始前时间
        long startTime = System.nanoTime();
        //测试的方法
        System.out.println("拼接好的字符串：" + String.join(" ",list));
        //方法结束时间
        long endTime = System.nanoTime();
        //打印消耗的时间
        System.out.println("使用String.join拼接字符串消耗的时间：" + (endTime - startTime) + "ns");

        log.info("使用 String的Join方法 拼接字符串结束");
    }

    /**
     * @Author: WP
     * @Date: 2021/8/9 11:27
     * @Version 1.0
     * @Description: test StringUtils.Join
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testStringUtilsJoin(){
        //第一次执行所需的时间：43648600ns
        //第二次执行所需的时间：44905100ns
        //第三次执行所需的时间：39472100ns
        //平均数：42,675,266.66ns
        log.info("开始使用 StringUtils的Join方法 拼接字符串");

        String string01 = "Hello";
        String string02 = "World!";
        List<String> list = new ArrayList<String>();
        list.add(string01);
        list.add(string02);
        //方法开始前时间
        long startTime = System.nanoTime();
        //测试的方法
        System.out.println("拼接好的字符串：" + StringUtils.join(list,' '));
        //方法结束时间
        long endTime = System.nanoTime();
        //打印消耗的时间
        System.out.println("使用StringUtils的Join方法拼接字符串消耗的时间：" + (endTime - startTime) + "ns");

        log.info("使用 StringUtils的Join方法 拼接字符串结束");
    }

    /**
     * @Author: WP
     * @Date: 2021/8/9 11:28
     * @Version 1.0
     * @Description: test StringBuilder
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testStringBuilder(){
        //第一次执行所需的时间：40600ns
        //第二次执行所需的时间：35400ns
        //第三次执行所需的时间：38600ns
        //平均数：38200ns
        log.info("开始使用 StringBuilder 拼接字符串");

        String string01 = "Hello";
        String string02 = "World!";
        //方法开始前时间
        long startTime = System.nanoTime();
        //测试的方法
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string01).append(string02);
        System.out.println(stringBuilder.toString());
        //方法结束时间
        long endTime = System.nanoTime();
        //打印消耗的时间
        System.out.println("使用StringBuilder拼接字符串消耗的时间：" + (endTime - startTime) + "ns");

        log.info("使用 StringBuilder 拼接字符串结束");
    }

    /**
     * @Author: WP
     * @Date: 2021/8/9 11:28
     * @Version 1.0
     * @Description: test StringBuffer
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testStringBuffer(){
        //第一次执行所需的时间：49600ns
        //第二次执行所需的时间：61100ns
        //第三次执行所需的时间：45100ns
        //平均数：51,933.33ns
        log.info("开始使用 StringBuffer 拼接字符串");

        String string01 = "Hello";
        String string02 = "World!";
        //方法开始前时间
        long startTime = System.nanoTime();
        //测试的方法
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string01).append(string02);
        System.out.println(stringBuffer.toString());
        //方法结束时间
        long endTime = System.nanoTime();
        //打印消耗的时间
        System.out.println("使用StringBuffer接字符串消耗的时间：" + (endTime - startTime) + "ns");

        log.info("使用 StringBuffer 拼接字符串结束");
    }

}