package com.roc.SuperMaster.utility.threadUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author Roc
 * @Date 2021/11/29 17:51
 * @Version 1.0.0
 * @ClassName TestThread.java
 * @Description ToDo
 * @UpdateUser Roc
 */
@Slf4j
public class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello");
    }

    @Test
    public void testThread01(){
        //int a = 100;
        //int b = 100;
        Integer integer01 = 120;
        Integer integer02 = 120;
        System.out.println(integer01==integer02);
        System.out.println(integer01.equals(integer02));

        //String s01 = "Hello";
        //String s02 = "Hello";
        //System.out.println(s01==s02);
    }
}
