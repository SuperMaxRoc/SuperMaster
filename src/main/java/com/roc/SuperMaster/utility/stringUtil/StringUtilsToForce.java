package com.roc.SuperMaster.utility.stringUtil;

import io.swagger.annotations.ApiModel;
import org.junit.Test;

/**
 * @Author Roc
 * @Date 2021/9/13 16:57
 * @Version 1.0.0
 * @ClassName SpiltString.java
 * @Description 分隔字符串
 * @UpdateUser Roc
 */
@ApiModel(value = "String工具类")
public class StringUtilsToForce {

    /**
     * String相关的工具类
     * */

    //String类型的数组
    @Test
    public void testStrings(){
        String[] strings = new String[1];
        strings[0] = "true";
        System.out.println(strings[0]);
    }

    //分隔字符串
    @Test
    public void testSpilt(){
        String ids = "1,2";
        System.out.println(ids);
        String[] strings = ids.split(",");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

}
