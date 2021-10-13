package com.roc.SuperMaster.utility.bigSet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @Author Roc
 * @Date 2021/9/6 10:50
 * @Version 1.0.0
 * @ClassName ListUtils.java
 * @Description List集合相类关工具类及方法
 * @UpdateUser Roc
 */
@Slf4j
public class ListUtils {

    /**
     * java 数组和集合
     * https://www.cnblogs.com/tiandi/p/10641773.html
     * https://blog.csdn.net/feiyanaffection/article/details/81394745
     */

    /**
     * java集合和数组
     * https://www.cnblogs.com/summers/p/4094260.html
     * 详情请见Java 集合和数组.xlsx
     */

    /**
     * java集合类：源码浅析ArrayList、LinkedList和Vector的区别
     * https://blog.csdn.net/u012814441/article/details/80671604
     */

    /**
     * java中Set总结
     * https://www.jianshu.com/p/d6cff3517688
     */

    /**
     * java中Map总结
     * https://www.jianshu.com/p/27577315af0c
     */

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/8/26 20:10
     * @Version 1.0
     * @Description: 随机获取list中的一个数据
     * @Description: listUtils+RandomUtils
     * @UpdateUser WP
     */
    @Test
    public void randomGetList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println("打印当前的List：" + list);
        int i1 = list.hashCode();
        List<String> strings = new ArrayList<>();
        int i2 = strings.hashCode();
        System.out.println(i2 == i1);
        Map<String, String> stringStringHashMap = new HashMap<>();
        int i3 = stringStringHashMap.hashCode();
        System.out.println(i2 == i3);
        //定义随机数
        Random random = new Random();
        //规定随机数的范围
        int i = random.nextInt(list.size());
        System.out.println(list.get(i));
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/6 10:30
     * @Version 1.0
     * @Description: 遍历集合List
     * @UpdateUser WP
     */
    @Test
    public void traverseArrayList() {

        List<String> stringsList = new ArrayList<>();
        stringsList.add("1");
        stringsList.add("2");
        stringsList.add("3");
        stringsList.add("3");

        //for循环遍历
        System.out.println("---------------------");
        log.info("遍历List集合的第一种方式:for循环遍历");
        for (int i = 0; i < stringsList.size(); i++) {
            //循环时可以对list进行add、remove等操作
            System.out.println(stringsList.get(i));
        }
        System.out.println("---------------------");

        //forEach循环遍历
        System.out.println("---------------------");
        log.info("遍历List集合的第二种方式：forEach循环遍历--第一种形态");
        stringsList.forEach(s -> System.out.println(s));
        System.out.println("---------------------");
        log.info("遍历List集合的第二种方式：forEach循环遍历--第二种形态");
        for (String s : stringsList) {
            System.out.println(s);
        }
        System.out.println("---------------------");

        //迭代器
        System.out.println("---------------------");
        log.info("遍历List集合的第三种方式：迭代器");
        Iterator<String> iterator = stringsList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("---------------------");

        //while
        int iii = 0;
        log.info("遍历List集合的第四种方式：while");
        while (iii < stringsList.size()) {
            System.out.println(stringsList.get(iii));
            iii++;
        }
        //do···while
        int lll = 0;
        log.info("遍历List集合的第四种方式：do···while");
        do {
            System.out.println(stringsList.get(lll));
            lll++;
        } while (lll < stringsList.size());
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/6 11:31
     * @Version 1.0
     * @Description: for循环移除List中数据
     * @UpdateUser WP
     */
    @Test
    public void remove() {

        /**
         * Java List的remove()方法for循环陷阱
         * https://blog.csdn.net/weixin_44727906/article/details/91791982
         */

        List<String> stringsList = new ArrayList<>();
        stringsList.add("1");
        stringsList.add("2");
        stringsList.add("3");
        stringsList.add("4");
        stringsList.add("5");
        System.out.println("targetList:" + stringsList);
        System.out.println("stringsList的长度：" + stringsList.size());
        for (int i = 0; i < stringsList.size(); i++) {
            if (stringsList.get(i).equals("2") || stringsList.get(i).equals("3")) {
                //从List中移除目标值
                //为什么这里不直接remove(stringsList.get(i))?，仍需要加上i--；
                //list原来的索引：0,1,2,3,4
                //目标需要移走的索引：1，对应的元素值为"2"
                //执行操作的时候索引:1,开始移除
                //list的长度变小，被移除的右侧的元素的索引值统统左移
                //stringsList.remove(stringsList.get(i));
                stringsList.remove(stringsList.get(i));
                System.out.println("stringsList的长度：" + stringsList.size());
                //因为索引缩小，所以i--。
                i--;
            } else {
                System.out.println("存在的元素：" + stringsList.get(i));
            }
        }
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/8 14:53
     * @Version 1.0
     * @Description: 链表List
     * @UpdateUser WP
     */
    @Test
    public void linkedList() {
        LinkedList<String> stringsList = new LinkedList<>();
        //可以重复插入
        //允许null值存在
        stringsList.add("123");
        stringsList.add(null);
        stringsList.add(null);
        //LinkedList可以指定索引地址，然后进行插入
        //如果没有指定索引地址，则放在链表的最后方然后插入
        //同样如果相同索引地址同时插入的话，后者将替代前者的索引地址
        stringsList.add(0, "2");
        stringsList.add(0, "23");
        System.out.println("stringsList:" + stringsList);
        System.out.println("stringsList第一个元素：" + stringsList.getFirst());
        System.out.println("stringsList最后一个元素：" + stringsList.getLast());

        //Foreach循环+Lambda遍历LinkedList
        System.out.println("Foreach循环+Lambda遍历LinkedList");
        stringsList.forEach(System.out::println);

        //for循环遍历LinkedList
        for (int i = 0; i < stringsList.size(); i++) {
            System.out.println("stringsList索引地址：" + i + " targetString:" + stringsList.get(i));
        }
        //范围内清除元素：截取+清理
        //第一个参数：开始，第二个参数：截止到索引的地址，不清除第二参数对应的索引元素。
        //清除索引2和3之间的元素
        stringsList.subList(1, 3).clear();
        System.out.println("清理后的LinkedList长度：" + stringsList.size());
        for (int i = 0; i < stringsList.size(); i++) {
            System.out.println("stringsList索引地址：" + i + " targetString:" + stringsList.get(i));
        }
    }
}
