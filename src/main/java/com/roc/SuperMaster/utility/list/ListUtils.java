package com.roc.SuperMaster.utility.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @Author Roc
 * @Date 2021/8/26 20:09
 * @Version 1.0.0
 * @ClassName ListUtils.java
 * @Description ListUtils
 * @UpdateUser Roc
 */
@Slf4j
public class ListUtils {

    /**
     * @Author: WP
     * @Date: 2021/8/26 20:10
     * @Version 1.0
     * @Description: 随机获取list中的一个数据
     * @Description: listUtils+RandomUtils
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void randomGetList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("打印当前的List：" + list);
        //定义随机数
        Random random = new Random();
        //规定随机数的范围
        int i = random.nextInt(list.size());

        System.out.println(list.get(i));
    }
}
