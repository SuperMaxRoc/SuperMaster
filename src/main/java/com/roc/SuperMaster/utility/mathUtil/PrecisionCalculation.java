package com.roc.SuperMaster.utility.mathUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author Roc
 * @Date 2021/8/30 9:38
 * @Version 1.0.0
 * @ClassName PrecisionCalculation.java
 * @Description java高精度计算（适用于金钱计算）
 * @UpdateUser Roc
 */
@Slf4j
public class PrecisionCalculation {

    //为什么需要使用BigDecimal/BigInteger?---》为了避免丢失精度
    //不论是float 还是double都是浮点数，而计算机是二进制的，浮点数会失去一定的精确度。
    //注:根本原因是:十进制值通常没有完全相同的二进制表示形式;十进制数的二进制表示形式可能不精确。只能无限接近于那个值。
    /**
     * @Author: WP
     * @Date: 2021/8/30 15:17
     * @Version 1.0
     * @Description: 测试精度丢失
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void losePrecision(){
        System.out.println(0.3 - 0.1);
        System.out.println(0.3 * 0.1);
        System.out.println(0.3 / 0.1);
        System.out.println(0.3 + 0.1);
    }

    //什么是BigDecimal/BigInteger？
    //BigDecimal
    //Java在java.math包中提供的API类BigDecimal，用来对超过16位有效位的数进行精确的运算。双精度浮点型变量double可以处理16位有效数。
    //在实际应用中，需要对更大或者更小的数进行运算和处理。float和double只能用来做科学计算或者是工程计算，在商业计算中要用java.math.BigDecimal。
    //BigDecimal所创建的是对象，我们不能使用传统的+、-、*、/等算术运算符直接对其对象进行数学运算，而必须调用其相对应的方法。
    //方法中的参数也必须是BigDecimal的对象。构造器是类的特殊方法，专门用来创建对象，特别是带有参数的对象。

    //BigInteger
    //BigInteger类型的数字范围较 Integer 类型的数字范围要大得多。

    /**
     * @Author: WP
     * @Date: 2021/8/30 16:09
     * @Version 1.0
     * @Description: test BigInteger的常用方法
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testBigInteger(){

        //public BigInteger add(BigInteger val):做加法运算
        //public BigInteger subtract(BigInteger val):做减法运算
        //public BigInteger multiply(BigInteger val):做乘法运算
        //public BigInteger divide(BigInteger val):做除法运算
        //public BigInteger remainder(BigInteger val):做取余操作
        //public BigInteger pow(int exponet):进行取参数的 exponet 次方操作
        //public BigInteger negate():取相反数
        //public BigInteger shiftLegt(int n):将数字左移 n 位，如果 n 为负数，做右移操作
        //public BigInteger shiftRight(int n):将数字右移 n 位，如果 n 为负数，做左移操作
        //public int compareTo(BigInteger val):做数字比较操作
        //public BigInteger max(BigInteger val):返回较大的数值

        BigInteger bigInteger01 = new BigInteger("1000000000");
        BigInteger bigInteger02 = new BigInteger("1000000000000000000000000000000000000000000000000000000");

        //+
        BigInteger add = bigInteger01.add(bigInteger02);
        System.out.println("+:" + add);

        //-
        BigInteger subtract = bigInteger01.subtract(bigInteger02);
        System.out.println("-:" + subtract);

        //*
        BigInteger multiply = bigInteger01.multiply(bigInteger02);
        System.out.println("*:" + multiply);
        //除
        BigInteger divide = bigInteger02.divide(bigInteger01);
        System.out.println("/:" + divide);

        //max:最大值
        BigInteger max = bigInteger01.max(bigInteger02);
        System.out.println("max:" + max);
    }

    /**
     * @Author: WP
     * @Date: 2021/8/30 16:10
     * @Version 1.0
     * @Description: test BigDecimal的常用方法
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testBigDecimal(){
        //构建BigDecimal的方式
        //public BigDecimal(double val)
        //public BigDecimal(float val)
        //public BigDecimal(int val)
        //public BigDecimal(String val)

        //为什么不推荐new BigDecimal(double val)
        BigDecimal bigDecimal = new BigDecimal(0.1);
        //sout:0.1000000000000000055511151231257827021181583404541015625
        //严重丢失精度
        System.out.println(bigDecimal);

        //两种推荐的BigDecimal构造方法
        BigDecimal bigDecimal01 = new BigDecimal("2.3");
        BigDecimal bigDecimal02 = BigDecimal.valueOf(4.5);
        BigDecimal bigDecimal03 = new BigDecimal(Double.toString(2.3));

        //打印创建的BigDecimal
        System.out.println("bigDecimal01:" + bigDecimal01);
        System.out.println("bigDecimal02:" + bigDecimal02);
        System.out.println("bigDecimal03:" + bigDecimal03);

        //+
        BigDecimal add = bigDecimal01.add(bigDecimal02);
        System.out.println("+:" + add);

        //-
        BigDecimal subtract = bigDecimal01.subtract(bigDecimal02);
        System.out.println("-:" + subtract);
        //*
        BigDecimal multiply = bigDecimal01.multiply(bigDecimal02);
        System.out.println("*:" + multiply);

        //除
        //public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
        //第一参数：除数
        //第二参数：小数点后保留数
        //第三参数：舍入模式：ROUND_HALF_UP四舍五入
        /**
         * ROUND_CEILING    //向正无穷方向舍入
         *
         * ROUND_DOWN    //向零方向舍入
         *
         * ROUND_FLOOR    //向负无穷方向舍入
         *
         * ROUND_HALF_DOWN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5
         *
         * ROUND_HALF_EVEN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP，如果是偶数，使用ROUND_HALF_DOWN
         *
         * ROUND_HALF_UP    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6
         *
         * ROUND_UNNECESSARY    //计算结果是精确的，不需要舍入模式
         *
         * ROUND_UP    //向远离0的方向舍入
         * */
        BigDecimal divide = bigDecimal01.divide(bigDecimal02,10, BigDecimal.ROUND_HALF_UP);
        System.out.println("/:" + divide);
    }
}
