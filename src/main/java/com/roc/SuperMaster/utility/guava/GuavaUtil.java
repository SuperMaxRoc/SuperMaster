package com.roc.SuperMaster.utility.guava;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Roc
 * @Date 2021/9/13 16:42
 * @Version 1.0.0
 * @ClassName GuavaUtil.java
 * @Description Google开源的“强大”的工具类
 * @UpdateUser Roc
 */
@Slf4j
public class GuavaUtil {


    @Test
    public void joiner(){
        List<String> stringList = new ArrayList<String>(Arrays.asList("1","2"));
        System.out.println(Joiner.on(",").join(stringList));
        String string = String.join("1",stringList);

        System.out.println(string);
    }

}
