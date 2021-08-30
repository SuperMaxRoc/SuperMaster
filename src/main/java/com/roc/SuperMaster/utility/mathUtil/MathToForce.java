package com.roc.SuperMaster.utility.mathUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author Roc
 * @Date 2021/8/25 10:47
 * @Version 1.0.0
 * @ClassName MathToForce.java
 * @Description 常见的数学类及方法
 * @UpdateUser Roc
 */
@Slf4j
public class MathToForce {

    /**
     * @Author: WP
     * @Date: 2021/8/27 16:01
     * @Version 1.0
     * @Description: 判断是否为数字的字符串
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void ispureNumberString(){
        String targetNumber = "1a1";
        //注意：此地引用org.apache.commons.lang3的StringUtils
        if (StringUtils.isNumeric(targetNumber)) {
            System.out.println("这是一个纯数字的字符串");
        }else {
            System.out.println("这不是一个纯数字的字符串");
        }
    }

    /**
     * @Author: WP
     * @Date: 2021/8/27 16:25
     * @Version 1.0
     * @Description: 纯数字字符串转为纯数字
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void pureNumberStringToNumber(){
        String target = "11";
        //转换成十进制的相应类型
        int parseInt = Integer.parseInt(target);
        double parseDouble = Double.parseDouble(target);

        System.out.println("十进制的相应类型：" + parseInt);
        System.out.println("十进制的相应类型：" + parseDouble);

        //转换成任意进制的相应类型
        //提供10、2、8或16进制的选择
        int parseInt1 = Integer.parseInt(target,2);
        int parseInt2 = Integer.parseInt(target,8);
        int parseInt3 = Integer.parseInt(target,16);

        System.out.println("二进制的Int：" + parseInt1);
        System.out.println("八进制的Int：" + parseInt2);
        System.out.println("十六进制的Int：" + parseInt3);
    }

    /**
     * @Author: WP
     * @Date: 2021/8/27 16:03
     * @Version 1.0
     * @Description: 判断是否为奇偶数
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void isOddOrEvenNumber(){
        int evenNumber = 10;
        int oddNumber = 11;
        //对目标进行取余计算
        if(evenNumber % 2 == 0){
            System.out.println(evenNumber + "是个偶数");
        }
        if(oddNumber % 2 != 0){
            System.out.println(oddNumber + "是个奇数");
        }
    }

    /**
     * @Author: WP
     * @Date: 2021/8/27 16:05
     * @Version 1.0
     * @Description: Math()获取一个double类型的随机数：随机数的范围0.0-1.0
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void getRandom(){
        double random = Math.random();
        System.out.println(random);
    }

    @Test
    public void trigonometricFunction(){
        //正弦值
        double sin = Math.sin(2);
        System.out.println("正弦值：" + sin);

        //反正弦
        double asin = Math.asin(2);
        System.out.println("反正弦：" + asin);

        //余弦值
        double cos = Math.cos(2);
        System.out.println("余弦值：" + cos);

        //反余弦
        double acos = Math.acos(2);
        System.out.println("反余弦：" + acos);

        //正切值
        double tan = Math.tan(90);
        System.out.println("正切值：" + tan);
        //反正切
        double atan = Math.atan(90);
        System.out.println("反正切：" + atan);

        //将用弧度表示的角转换成近似相等的用角度表示的角
        double toDegrees = Math.toDegrees(2);
        System.out.println("将用弧度表示的角转换成近似相等的用角度表示的角：" + toDegrees);

        //将用角度表示的角转换成近似相等的用弧度表示的角
        double toRadians = Math.toRadians(2);
        System.out.println("将用角度表示的角转换成近似相等的用弧度表示的角：" + toRadians);
    }

    /**
     * @Author: WP
     * @Date: 2021/8/28 18:05
     * @Version 1.0
     * @Description: 指数运算
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void exponentialOperation(){

    }

    /**
     * @Author: WP
     * @Date: 2021/8/28 18:08
     * @Version 1.0
     * @Description: 比大小
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void bigOrSmall(){
        int num01 = 10;
        int num02 = 9;
        final int max = Math.max(num01, num02);
        final int min = Math.min(num01, num02);

        System.out.println("较大的数：" + max);
        System.out.println("较小的数：" + min);
    }

    /**
     * @Author: WP
     * @Date: 2021/8/28 18:09
     * @Version 1.0
     * @Description: 平均数
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void average(){
        int num01 = 10;
        int num02 = 9;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(num01);
        arrayList.add(num02);

        System.out.println(arrayList.size());
        double i = Math.round((num01 + num02) / arrayList.size());
        System.out.println(i);

    }

    /**
     * @Author: WP
     * @Date: 2021/8/28 18:10
     * @Version 1.0
     * @Description: 比较数字相等
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void isEqual(){
        //解决世界性难题：==是判断两个人是不是住在同一个地址，而equals是判断同一个地址里住的人是不是同一个
        //判断的问题设计到java常量池的概念
        //同一类型且字面量相等的变量：引用地址相等。
        //同一类型但字面量不相等的变量：引用地址是不相等的。

        //同一类型且字面量相等的变量
        int num01 = 10;
        int num02 = 10;
        int num05 = 9+1;
        if (num01 == num02) {
            //true
            System.out.println("对比的数字相等");
        }
        if (num01 == num05) {
            //true
            System.out.println("对比的数字相等");
        }

        //同一类型且字面量不相等的变量
        int num03 = 10;
        int num04 = 11;
        if (num03 == num04) {
            //false
            System.out.println("对比的数字相等");
        }


        String string01 = "hello";
        String string02 = "hello";
        Integer string03 = 6;
        Integer string04 = 6;
        String string05 = "he" + "ll";
        System.out.println(string01 == string02);
        System.out.println(string01.equals(string02));
        System.out.println(string03.equals(string04));

        System.out.println(System.identityHashCode(string01));
        System.out.println(System.identityHashCode(string02));
        System.out.println(System.identityHashCode(string03));
        System.out.println(System.identityHashCode(string04));

        System.out.println("-----------------");
        System.out.println(string01.equals(string05));
        System.out.println(System.identityHashCode(string05));

    }

    /**
     * @Author: WP
     * @Date: 2021/8/28 18:11
     * @Version 1.0
     * @Description: 求整运算
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void toInteger(){

    }


    /**
     * @Author: WP
     * @Date: 2021/8/28 18:12
     * @Version 1.0
     * @Description: Math的静态常量
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void staticMath(){

    }

    /**
     * @Author: WP
     * @Date: 2021/8/28 18:13
     * @Version 1.0
     * @Description: 对数运算
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void logarithm() {

    }

}