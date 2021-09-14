package com.roc.SuperMaster.utility.bigSet;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @Author Roc
 * @Date 2021/9/14 16:19
 * @Version 1.0.0
 * @ClassName SetStreamHandle.java
 * @Description 流Stream：用于处理java集合运算和表达的高阶抽象
 * @UpdateUser Roc
 */
public class SetStreamHandle {

    /**
     * power by https://blog.csdn.net/y_k_y/article/details/84633001
     */

    /**
     * @Author: WP
     * @Date: 2021/9/14 16:24
     * @Version 1.0
     * @Description: 创建流
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void createStream(){
        List<String> stringList = new ArrayList<String>();

        stringList.add("1");
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");

        /**
         * 创建流
         * 由List的实例化对象创建
         * Arrays创建
         * 使用Stream的静态方法：有限的流和无限的流
         * 读取文件转换成流
         * 将字符串分隔成流
         */
        //创建流第一种方法
        Stream<String> stringStream = stringList.stream();
        stringStream.forEach(System.out::println);

        //Array创建流的第二种方法
        String[] strings = new String[0];
        Stream<String> stream = Arrays.stream(strings);

        //创建流的第三种方法
        //使用Stream中的静态方法：of(),iterate(),generate()
        //Stream通过limit()获取前N条元素
        Stream<List<String>> stringList1 = Stream.of(stringList);

        //iterate：迭代器方式创建无限流
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);
        stream2.forEach(System.out::println); // 0 2 4 6 8 10

        //Stream.generate+math.random
        Stream<Double> stream3 = Stream.generate(Math::random).limit(2);
        stream3.forEach(System.out::println);

        //使用 BufferedReader.lines() 方法，将每行内容转成流
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("F:\\test_stream.txt"));
            Stream<String> lineStream = reader.lines();
            lineStream.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //使用 Pattern.splitAsStream() 方法，将字符串分隔成流
        Pattern pattern = Pattern.compile(",");
        Stream<String> stringStream02 = pattern.splitAsStream("a,b,c,d");
        stringStream02.forEach(System.out::println);
    }

    /**
     * @Author: WP
     * @Date: 2021/9/14 16:59
     * @Version 1.0
     * @Description: Stream的基本使用:limit
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void useStreamByLimit(){
        List<String> stringList = new ArrayList<String>();

        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");
        //Stream.limit：获取n个元素
        Stream<String> stream = stringList.stream();
        Stream<String> limit = stream.limit(1);
        limit.forEach(System.out::println);//1
        //个人认为函数式编程一定程度来简便代码
        stringList.stream().limit(2).forEach(System.out::println);//1 2
    }

    /**
     * @Author: WP
     * @Date: 2021/9/14 17:11
     * @Version 1.0
     * @Description: Stream的基本使用:filter等
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void useStreamByFilter(){
        Integer[] integers = new Integer[5];
        integers[0] = 0;
        integers[1] = 1;
        integers[2] = 2;
        integers[3] = 3;
        integers[4] = 4;
        Stream<Integer> stream = Arrays.stream(integers);

        /**
         * filter：过滤流中的某些元素
         * limit(n)：获取n个元素
         * skip(n)：跳过n元素，配合limit(n)可实现分页
         * distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
         */

        //过滤大于2的数返回
        stream.filter(s -> s>2).forEach(System.out::println);//3 4

        //过滤大于2的数返回，跳过前1个数，及获取前两个数
        stream.filter(s -> s>2).skip(1).limit(1).forEach(System.out::println);//4
        stream.close();
    }

    /**
     * @Author: WP
     * @Date: 2021/9/14 17:27
     * @Version 1.0
     * @Description: Stream的基本使用:map和flatmap
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void useStreamByMap(){
        List<String> stringList = Arrays.asList("a,b,c", "1,2,3");

        //map
        stringList.stream().map(s -> s.replaceAll(",","")).forEach(System.out::println); //abc 123

        //flatmap
        stringList.stream().flatMap(s -> {
            String[] split = s.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).forEach(System.out::println);

    }

}
