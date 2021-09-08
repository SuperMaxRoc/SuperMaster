package com.roc.SuperMaster.utility.bigSet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author Roc
 * @Date 2021/9/6 11:02
 * @Version 1.0.0
 * @ClassName IteratorUtils.java
 * @Description 迭代器
 * @UpdateUser Roc
 */
@Slf4j
public class IteratorUtils {

    /**
     * 深入理解Java中的迭代器
     * 迭代器模式：就是提供一种方法对一个容器对象中的各个元素进行访问，而又不暴露该对象容器的内部细节。
     * https://www.cnblogs.com/zyuze/p/7726582.html
     */
    /**
     * @Author: WP
     * @Date: 2021/9/8 10:00
     * @Version 1.0
     * @Description: 迭代器遍历List集合
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void iteratorToGetList(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        Iterator<String> iterator = strings.iterator();
        //使用while循环
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
