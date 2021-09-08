package com.roc.SuperMaster.utility.bigSet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author Roc
 * @Date 2021/9/8 10:08
 * @Version 1.0.0
 * @ClassName SetUtils.java
 * @Description Set集合类的构建及相关方法
 * @UpdateUser Roc
 */
@Slf4j
public class SetUtils {

    /**
     * @Author: WP
     * @Date: 2021/9/8 13:39
     * @Version 1.0
     * @Description: HashSet的构建及相关方法
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void hashSetUtil(){
        HashSet<String> hashSet = new HashSet<>();
        //不允许有重复值
        //允许有null
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add(null);
        hashSet.add("1");
        System.out.println("hashSet的长度：" + hashSet.size());

        System.out.println("遍历HashSet的第一种方法：增强for循环");
        for (String m:hashSet) {
            System.out.println("hashSet:" + m);
        }

        System.out.println("遍历HashSet的第二种方法：迭代器");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println("hashSet:" + iterator.next());
        }
        hashSet.forEach((s) -> System.out.println("hashSet:" + s) );
    }
    
    /**
     * @Author: WP
     * @Date: 2021/9/8 13:41
     * @Version 1.0
     * @Description: TreeSet的构建及相关方法
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void treeSetUtil(){
        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        //TreeSet不允许重复
        //TreeSet不允许null
        //且会自动排序
        integerTreeSet.add(1);
        integerTreeSet.add(233);
        integerTreeSet.add(1);
        integerTreeSet.add(2);
        //integerTreeSet.add(null);
        System.out.println("integerTreeSet的长度：" + integerTreeSet.size());

        System.out.println("遍历TreeSet的第一种方法：for循环");
        for (Integer i:integerTreeSet) {
            System.out.println("integerTreeSet:" + i);
        }

        System.out.println("遍历TreeSet的第二种方法：迭代器");
        Iterator<Integer> iterator = integerTreeSet.iterator();
        while (iterator.hasNext()){
            System.out.println("integerTreeSet:" + iterator.next());
        }
        integerTreeSet.forEach(System.out::println);
    }

}
