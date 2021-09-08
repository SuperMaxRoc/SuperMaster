package com.roc.SuperMaster.utility.bigSet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author Roc
 * @Date 2021/9/8 15:11
 * @Version 1.0.0
 * @ClassName ListToArrayUtil.java
 * @Description 数组同集合的相互转换
 * @UpdateUser Roc
 */
@Slf4j
public class ListToArrayUtil {

    /**
     * @Author: WP
     * @Date: 2021/9/8 15:15
     * @Version 1.0
     * @Description: 数组转换成list
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void arrayToList(){
        String[] strings = {"1","2","333"};
        System.out.println("转换前的数组：" + Arrays.deepToString(strings));

        System.out.println("数组转换成List的第一种方式：Arrays.asList");
        List<String> stringsList01 = Arrays.asList(strings);
        System.out.println("转换后的List：" + stringsList01);


        System.out.println("数组转换成List的第二种方式：类似第一种");
        List<String> stringsList02 = new ArrayList<String>(Arrays.asList(strings));
        System.out.println("转换后的List：" + stringsList02);

        System.out.println("数组转换成List的第三种方式：for循环");
        List<String> stringsList03 = new ArrayList<String>();
        for (int i = 0; i < strings.length; i++) {
            stringsList03.add(strings[i]);
        }
        System.out.println("转换后的List:" + stringsList03);

        System.out.println("数组转换成List的第四种方式：Collection.addAll");
        List<String> stringsList04 = new ArrayList<>(strings.length);
        Collections.addAll(stringsList04,strings);
        System.out.println("转换后的List:" + stringsList04);
    }
    
    /**
     * @Author: WP
     * @Date: 2021/9/8 15:45
     * @Version 1.0
     * @Description: List转数组
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void listToArray(){

        //相同数据类型的list集合和数组的转换
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        arrayList.add("1");
        System.out.println("单一类型的List：" + arrayList);

        //for循环/···等等，能取到List中的数据，
        String[] strings = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            strings[i] = arrayList.get(i);
        }
        System.out.println("单一类型转换后的数组：" + Arrays.deepToString(strings));

        //不同数据类型的list集合和数组的转换
        //List：Object
        //数组：String
        List<Object> objectArrayList = new ArrayList<>();
        objectArrayList.add(1);
        objectArrayList.add("2");
        objectArrayList.add(null);
        objectArrayList.add(false);
        System.out.println("多种数据类型的List：" + objectArrayList);

        String[] stringsArray = new String[arrayList.size()];
        for (int i = 0; i < objectArrayList.size(); i++) {
            //放弃使用toString
            //需要转换的List不限制集合中的数据数据类型，且list集合是允许null存在，因为null.toString直接报空指针，所以保险起见使用String.valueOf
            //stringsArray[i] = objectArrayList.get(i).toString();
            stringsArray[i] = String.valueOf(objectArrayList.get(i));
        }
        System.out.println("多种数据类型转换后的数组：" + Arrays.deepToString(stringsArray));
    }
}
