package com.roc.SuperMaster.utility.springUtil;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName LogAnnotation
 * @Author: WangPeng
 * @Description TODO
 * @date 2023/3/26 16:01
 * @Version 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    String value();

}