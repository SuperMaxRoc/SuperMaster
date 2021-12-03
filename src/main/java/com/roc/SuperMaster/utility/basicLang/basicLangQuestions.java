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
public class basicLangQuestions extends Object {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/8/30 17:31
     * @Version 1.0
     * @Description: 数据精度问题：单精度、双精度、半精度、混合精度的问题
     * @UpdateUser WP
     */
    @Test
    public void precision() {

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
        float b = 0.2f;
        System.out.println(a);
        System.out.println(b);
        BigDecimal bigDecimal = new BigDecimal(0.2);
        BigDecimal decimal = new BigDecimal(0.2);
        BigDecimal bigDecimal01 = BigDecimal.valueOf(0.2);
        BigDecimal bigDecimal02 = BigDecimal.valueOf(0.2);
        System.out.println(bigDecimal01.equals(bigDecimal));
        System.out.println(a == b);
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/12/3 9:26
     * @Version 1.0
     * @Description: 一次性解决==和equals()方法的区别，同时针对面试整理的面试题01
     * @UpdateUser WP
     */
    @Test
    public void testEquals01() {
        /*
        == vs equals()
        区别：
        1.== 关系运算符 equals()是Object类的方法。
        2.== 既可以比较基本类型，也可以比较引用类型，equals()仅可以比较引用类型。
            == 比较基本类型时直接对比目标的值，并返回结果
               比较引用类型，对比目标的内存地址，并返回结果
            equals()比较引用类型，默认是判断目标对象的内存地址，实际生产情况下指对比包装类及String类，因为上述类重写了继承Object类的方法，所以是对比目标对象的值
         */

        /**
         * 此处难点容易混淆的点也是 整数缓冲区和字符串常量池 的应用
         */

        int a = 100;
        int b = 100;
        int c = 200;
        int d = 200;
        System.out.println("--------------------------");
        System.out.println("== 对比基本类型");
        //true
        System.out.println(a == b);
        //true
        System.out.println(c == d);
        System.out.println("--------------------------");
        Integer integer01 = 100;
        Integer integer02 = 100;
        Integer integer03 = 200;
        Integer integer04 = 200;
        System.out.println("== 对比基本类型的包装类(一)");
        //true
        System.out.println(integer01 == integer02);
        //false
        System.out.println(integer03 == integer04);
        System.out.println("--------------------------");
        System.out.println("== 对比基本类型的包装类(二)");
        Integer integer05 = new Integer(100);
        Integer integer06 = new Integer(100);
        Integer integer07 = new Integer(200);
        Integer integer08 = new Integer(200);
        //false
        System.out.println(integer05 == integer06);
        //false
        System.out.println(integer05 == integer01);
        //false
        System.out.println(integer07 == integer08);
        //false
        System.out.println(integer07 == integer04);
        System.out.println("--------------------------");
        System.out.println("== 对比String类");
        String str01 = "Hello";
        String str02 = "He";
        String str03 = "llo";
        String str04 = str02 + str03;
        String str05 = "He" + "llo";
        String str06 = "He" + new String("llo");
        String str07 = new String("Hello");
        String str08 = new String("He") + new String("llo");
        //false
        System.out.println(str01 == str04);
        //true
        System.out.println(str01 == str05);
        //false
        System.out.println(str04 == str05);
        //false
        System.out.println(str01 == str06);
        //false
        System.out.println(str01 == str07);
        //false
        System.out.println(str01 == str08);
        //false
        System.out.println(str07 == str08);
        System.out.println("--------------------------");
    }
    
    /**
     * @Author: WP
     * @Date: 2021/12/3 10:49
     * @Version 1.0
     * @Description: 一次性解决==和equals()方法的区别，同时针对面试整理的面试题02
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void testEquals02(){
        Integer integer01 = 100;
        Integer integer02 = 100;
        Integer integer03 = 200;
        Integer integer04 = 200;
        System.out.println("equals 判断基本类型的包装类01");
        //true
        System.out.println(integer01.equals(integer02));
        //true
        System.out.println(integer03.equals(integer04));

        System.out.println("--------------------------");
        System.out.println("equals 判断基本类型的包装类02");
        Integer integer05 = new Integer(100);
        Integer integer06 = new Integer(100);
        Integer integer07 = new Integer(200);
        Integer integer08 = new Integer(200);
        //true
        System.out.println(integer05.equals(integer06));
        //true
        System.out.println(integer07.equals(integer08));

        System.out.println("--------------------------");
        System.out.println("equals 判断String类");
        String str01 = "Hello";
        String str02 = "He";
        String str03 = "llo";
        String str04 = str02 + str03;
        String str05 = "He" + "llo";
        String str06 = "He" + new String("llo");
        String str07 = new String("Hello");
        String str08 = new String("He") + new String("llo");
        //true
        System.out.println(str01.equals(str04));
        //true
        System.out.println(str01.equals(str05));
        //true
        System.out.println(str01.equals(str06));
        //true
        System.out.println(str01.equals(str07));
        //true
        System.out.println(str01.equals(str08));
        //true
        System.out.println(str07.equals(str08));
        System.out.println("--------------------------");
    }

}
