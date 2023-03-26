package com.roc.SuperMaster.utility.annotation;

/**
 * @Author Roc
 * @Date 2021/8/10 17:17
 * @Version 1.0.0
 * @ClassName MyAnnotation01.java
 * @Description 我的第一个注解
 * @UpdateUser Roc
 */
@MyAnnotation(name = "我的第一个注解")
public class MyAnnotation01 {

    @MyAnnotation
    public void test01() {

    }
}
