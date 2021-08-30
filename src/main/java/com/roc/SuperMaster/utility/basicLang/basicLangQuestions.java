package com.roc.SuperMaster.utility.basicLang;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author Roc
 * @Date 2021/8/30 17:27
 * @Version 1.0.0
 * @ClassName basic.java
 * @Description java基础语言包中有趣的问题
 * @UpdateUser Roc
 */
public class basicLangQuestions {

    /**
     * @Author: WP
     * @Date: 2021/8/30 17:31
     * @Version 1.0
     * @Description: 数据精度问题：单精度、双精度、半精度、混合精度的问题
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void precision(){

        /**
         * 数据精度问题
         */
        //精度问题常存在与程序涉及数学计算的时候以及程序语言基本数据类型转换过程中。
        //丢失精度会造成极其严重的问题，尤其是银行等金融行业。

        //自动类型转换
        //强制类型转换
        //整形与浮点型类型转换
        //char类型和int类型转换
        //数字比大小
        //https://blog.csdn.net/qq_37953002/article/details/102476979?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.essearch_pc_relevant&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.essearch_pc_relevant
        double a = 0.2;
        float b =  0.2f;
        System.out.println(a);
        System.out.println(b);
        BigDecimal bigDecimal = new BigDecimal(0.2);
        BigDecimal decimal = new BigDecimal(0.2);
        BigDecimal bigDecimal01 = BigDecimal.valueOf(0.2);
        BigDecimal bigDecimal02 = BigDecimal.valueOf(0.2);
        System.out.println(bigDecimal01.equals(bigDecimal));
        System.out.println(a == b);
    }

}
