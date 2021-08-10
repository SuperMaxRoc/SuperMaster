package com.roc.SuperMaster.utility.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Roc
 * @Date 2021/8/10 17:13
 * @Version 1.0.0
 * @ClassName MyAnnotation.java
 * @Description 自定义注解
 * @UpdateUser Roc
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String name() default "";
}
