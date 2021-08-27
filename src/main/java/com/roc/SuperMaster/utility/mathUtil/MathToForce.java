package com.roc.SuperMaster.utility.mathUtil;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

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
        System.out.println(sin);

        //反正弦
        double asin = Math.asin(2);
        System.out.println(asin);

        //余弦值
        double cos = Math.cos(2);
        System.out.println(cos);
        //反余弦
        double acos = Math.acos(2);
        System.out.println(acos);

        //正切值
        double tan = Math.tan(90);
        System.out.println(tan);
        //反正切
        double atan = Math.atan(90);
        System.out.println(atan);

        //将用弧度表示的角转换成近似相等的用角度表示的角
        double toDegrees = Math.toDegrees(2);
        System.out.println(toDegrees);
        //将用角度表示的角转换成近似相等的用弧度表示的角
        double toRadians = Math.toRadians(2);
        System.out.println(toRadians);
    }

}
