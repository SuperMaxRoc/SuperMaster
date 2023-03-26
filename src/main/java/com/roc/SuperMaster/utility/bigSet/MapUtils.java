package com.roc.SuperMaster.utility.bigSet;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Roc
 * @Date 2021/9/6 10:59
 * @Version 1.0.0
 * @ClassName MapUtils.java
 * @Description Map集合类的构建及相关方法
 * @UpdateUser Roc
 */
@Slf4j
public class MapUtils {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/8 10:10
     * @Version 1.0
     * @Description: 构建Map及遍历map
     * @UpdateUser WP
     */
    @Test
    public void hashMapUtils() {

        //HashMap
        //允许key和值为null
        //key不允许重复
        Map<String, String> map = new HashMap<>();
        map.put("1", "12");
        map.put(null, null);
        map.put("3", "12");
        map.put("4", "12");

        //map.toString
        System.out.println("map:" + map);
        System.out.println("map:" + map.toString());

        //for循环遍历
        System.out.println("遍历HashMap的第一种方法：for循环");
        for (String key : map.keySet()) {
            System.out.println("key:" + key + " value:" + map.get(key));
        }

        //迭代器
        System.out.println("遍历HashMap的第二种方法：迭代器");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> stringEntry = iterator.next();
            System.out.println("key:" + stringEntry.getKey() + " value:" + stringEntry.getValue());
        }

        //
        System.out.println("遍历HashMap的第三种方法");
        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }

        //遍历HashMap:取Key
        System.out.println("遍历HashMap:取Key");
        for (Map.Entry<String, String> m : map.entrySet()) {
            System.out.println(m.getKey());
        }

        //遍历HashMap:取Value
        System.out.println("遍历HashMap:取Value");
        for (String m : map.values()) {
            System.out.println(m);
        }
    }

    @Test
    public void treeMapUtils() {
        Map<Integer, Integer> integerTreeMap = new TreeMap<>();
        //key不能为null，且有且唯一，不允许重复
        //值可以为null
        integerTreeMap.put(1, null);
        integerTreeMap.put(2, 2);
        integerTreeMap.put(4, 2);
        integerTreeMap.put(3, 2);

        //TreeMap.toString
        System.out.println("integerTreeMap:" + integerTreeMap.toString());
        System.out.println("integerTreeMap:" + integerTreeMap);

        //打印结果：{1=2, 2=2, 3=2, 4=2}--->自动排序

        //迭代器
        System.out.println("遍历TreeMap的第一种方法：迭代器");
        Iterator<Map.Entry<Integer, Integer>> iterator = integerTreeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println("key:" + next.getKey() + " value:" + next.getValue());
        }
        //for循环
        System.out.println("遍历TreeMap的第二种方法：for循环");
        for (Integer m : integerTreeMap.keySet()) {
            System.out.println("key:" + m + " value:" + integerTreeMap.get(m));
        }

        //
        System.out.println("遍历TreeMap的第三种方法：");
        for (Map.Entry<Integer, Integer> m : integerTreeMap.entrySet()) {
            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }

        //
        System.out.println("遍历TreeMap：取Key");
        for (Map.Entry<Integer, Integer> m : integerTreeMap.entrySet()) {
            System.out.println("key:" + m.getKey());
        }

        //
        System.out.println("遍历TreeMap：取value");
        for (Object m : integerTreeMap.values()) {
            System.out.println("value:" + m);
        }
    }

    /**
     * 测试Guava的Map
     */
    @Test
    public void testGoogleGuavaMultMaple() {
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("WO1", "1");
        multimap.put("WO1", "2");
        multimap.put("WO1", "3");
        multimap.put("WO2", "4");
        System.out.println(multimap.keySet());
        if (CollectionUtils.isNotEmpty(multimap.keySet())) {
            for (String s : multimap.keySet()) {
                for (String s1 : multimap.get(s)) {
                    System.out.println(s1);
                }
            }
        }
    }
}
