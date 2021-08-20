package com.roc.SuperMaster.web.personalPackage.testEverything;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.Test;

import java.util.UUID;

/**
 * @Author: WP
 * @Date: 2021/8/8 23:03
 * @Version 1.0
 * @ClassName TestChar.java
 * @Description testChar
 * @UpdateUser WP
 */
public class TestChar {
    @Test
    public void testChar(){
        char uniChar = 0x0041;
        System.out.println(uniChar);
        Integer integer = 55;
        String s = "A";
        System.out.println(s);
        System.out.println(UUID.randomUUID());
        String string = " ";
        if(StringUtils.isBlank(string)){
            System.out.println("是空白");
        }else {
            System.out.println("不是空白");
        }
    }
}
