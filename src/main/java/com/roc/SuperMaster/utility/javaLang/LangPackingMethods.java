package com.roc.SuperMaster.utility.javaLang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author Roc
 * @Date 2021/11/19 11:09
 * @Version 1.0.0
 * @ClassName LangPackingMethods.java
 * @Description java中基本类型与包装类的装箱拆箱
 * @UpdateUser Roc
 */
@Slf4j
public class LangPackingMethods {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/11/19 11:11
     * @Version 1.0
     * @Description: 自动装箱
     * @UpdateUser WP
     */
    @Test
    public void packing() {
        Integer integer01 = new Integer(100);
        Integer integer02 = Integer.valueOf(100);
        Integer integer03 = 100;
        Integer integer04 = 100;
        Integer integer05 = 200;
        Integer integer06 = 200;
        Integer integer07 = new Integer(200);
        Integer integer08 = new Integer(200);

        System.out.println("-------------------");
        System.out.println(integer01);
        System.out.println(integer02);
        System.out.println(integer03);
        System.out.println(integer04);
        System.out.println(integer05);
        System.out.println(integer06);
        System.out.println(integer07);
        System.out.println(integer08);
        System.out.println("-------------------");
        System.out.println(integer01 == integer02);
        System.out.println(integer03 == integer04);
        System.out.println(integer05 == integer06);
        System.out.println(integer07 == integer08);
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/11/19 11:11
     * @Version 1.0
     * @Description: 自动拆箱
     * @UpdateUser WP
     */
    @Test
    public void unpacking() {
        Integer integer = 100;
        int i01 = integer.intValue();
        int i02 = integer;
        System.out.println(i01);
        System.out.println(i02);
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/11/19 11:39
     * @Version 1.0
     * @Description: Integer/int 与 String 的相互转换
     * @UpdateUser WP
     */
    @Test
    public void integerToToString() {

        try {
            String str01 = "150";
            //String str02 = "150o";
            //String to int/Integer
            int i1 = Integer.parseInt(str01);
            //int i4 = Integer.parseInt(str02);

            System.out.println(i1);
            //System.out.println(i4);

            System.out.println("----------------------------------");

            int i = 100;
            Integer integer = 100;
            //int/Integer to String
            String str03 = i + "";
            String str04 = integer + "";
            String i001 = Integer.toString(i, 2);
            String i002 = Integer.toString(integer, 2);
            System.out.println(i001);
            System.out.println(i002);
            System.out.println(str04.getClass());
            System.out.println(str03.getClass());
        } catch (NumberFormatException e) {
            System.out.println("String转换为Integer/int不能携带非数字");
        } finally {
            System.out.println("----------------------------------");
            System.out.println("Integer/int 与 String 的相互转换结束");
        }
    }
}
