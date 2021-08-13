package com.roc.SuperMaster.utility.random;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @Author Roc
 * @Date 2021/8/12 20:50
 * @Version 1.0.0
 * @ClassName TestRandom.java
 * @Description 测试随机数的相关用法
 * @UpdateUser Roc
 */
@Slf4j
public class TestRandom {

    /**
     * @Author: WP
     * @Date: 2021/8/12 20:51
     * @Version 1.0
     * @Description: 生成8位随机数
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testRandom01(){
        StringBuilder str = new StringBuilder();//定义变长字符串
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for(int i = 0;i < 8;i++){
            str.append(random.nextInt(10));
        }
        //将字符串转换为数字并输出
        int num=Integer.parseInt(str.toString());
        System.out.println(num);
    }

    /**
     * @Author: WP
     * @Date: 2021/8/12 20:54
     * @Version 1.0
     * @Description: 测试8位自增编号
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testRandom02(){
        String equipmentCode = "SN";

        //String.format("%03d", i)在数字前面补零


    }


}
