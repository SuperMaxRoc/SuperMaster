package com.roc.SuperMaster.utility.random;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

/**
 * @Author Roc
 * @Date 2021/8/12 20:50
 * @Version 1.0.0
 * @ClassName RandomUtils.java
 * @Description 随机数生成的相关用法
 * @UpdateUser Roc
 */
@Slf4j
public class RandomUtils {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/8/12 20:51
     * @Version 1.0
     * @Description: 生成8位随机数
     * @UpdateUser WP
     */
    @Test
    public void testRandom01() {
        StringBuilder str = new StringBuilder();//定义变长字符串
        Random random = new Random();
        //随机生成数字，并添加到字符串
        for (int i = 0; i < 8; i++) {
            str.append(random.nextInt(10));
        }
        //将字符串转换为数字并输出
        int num = Integer.parseInt(str.toString());
        System.out.println(num);
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/8/12 20:54
     * @Version 1.0
     * @Description: 测试8位自增编号
     * @UpdateUser WP
     */
    @Test
    public void testRandom02() {
        String equipmentCode = "SN";

        //String.format("%03d", i)在数字前面补零

    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/8/26 20:26
     * @Version 1.0
     * @Description: 获取一定范围内的随机数
     * @UpdateUser WP
     */
    @Test
    public void getRandom() {
        Random random = new Random();
        //规定随机数的最大范围
        int i = random.nextInt(100);
        System.out.println("100范围内的随机整数：" + i);
    }
}
