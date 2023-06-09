package com.roc.SuperMaster.utility.stringUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author Roc
 * @Date 2021/9/13 16:57
 * @Version 1.0.0
 * @ClassName SpiltString.java
 * @Description 分隔字符串
 * @UpdateUser Roc
 */
@Slf4j
public class SpiltString {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/13 17:10
     * @Version 1.0
     * @Description: 广义切割字符串的三种方式
     * @UpdateUser WP
     */
    @Test
    public void spiltString() {
        String targetString = "a,b,c";

        //基于String.spilt的分隔字符串
        String[] split = targetString.split(",");
        System.out.println("基于String.spilt的分隔字符串:" + Arrays.deepToString(split));

        //基于String.substring的切割字符串
        String substring = targetString.substring(0, 1);
        System.out.println("基于String.substring的切割字符串:" + substring);

        //基于StringTokenizer的切割字符串
        StringTokenizer stringTokenizer = new StringTokenizer(targetString, ",");
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println("基于StringTokenizer的切割字符串:" + stringTokenizer.nextToken());
        }
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/13 17:17
     * @Version 1.0
     * @Description: 寻找指定的字符，然后切割目标前或者目标后的部分
     * @UpdateUser WP
     */
    @Test
    public void findTargetStringForSub() {

        /**
         * String.indexOf的应用
         */

        String string = "Http://www.baidu.com";
        //返回第一次出现"w"的索引地址
        int w = string.indexOf("w");
        String substringBefore = string.substring(0, w);
        String targetSubstring = string.substring(w, w + 3);
        String substringBack = string.substring(w, string.length());
        System.out.println(substringBefore);
        System.out.println(targetSubstring);
        System.out.println(substringBack);
    }

    /**
     * 字符串的首尾处理
     */
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
}
