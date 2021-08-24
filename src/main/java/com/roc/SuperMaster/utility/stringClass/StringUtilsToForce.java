package com.roc.SuperMaster.utility.stringClass;

import io.swagger.annotations.ApiModel;
import org.junit.Test;

/**
 * @author Roc
 * @version 1.0
 * @date 2021/7/13 17:18
 */
@ApiModel(value = "String工具类")
public class StringUtilsToForce {

    /**
     * String相关的工具类
     *
     * */
    @Test
    public void testStrings(){
        String[] strings = new String[1];
        strings[0] = "true";
        System.out.println(strings[0]);


    }

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
