package com.roc.SuperMaster.utility.exceptionUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author Roc
 * @Date 2021/11/17 18:13
 * @Version 1.0.0
 * @ClassName ExceptionsUtil.java
 * @Description 异常处理
 * @UpdateUser Roc
 */
@Slf4j
public class ExceptionsUtil {

    /**
     * @Author: WP
     * @Date: 2021/11/18 17:15
     * @Version 1.0
     * @Description: ToDo
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testException(){
        int a = 1;
        int b = 0;
        try {
            System.out.println(a/b);
        } catch (ArithmeticException e) {
            System.out.println("123");
            //添加throw将异常直接抛出，程序终止
            //不抛出异常，吃掉异常~
            //throw e;
        } finally {
            System.out.println("这是一个异常处理测试方法~");
        }
    }

}
