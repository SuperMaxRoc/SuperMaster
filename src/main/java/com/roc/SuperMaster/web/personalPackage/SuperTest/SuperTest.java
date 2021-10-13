package com.roc.SuperMaster.web.personalPackage.SuperTest;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @Author: WP
 * @Date: 2021/8/8 23:03
 * @Version 1.0
 * @ClassName TestChar.java
 * @Description testChar
 * @UpdateUser WP
 */
public class SuperTest {

    @Test
    public void testChar() {
        char uniChar = 0x0041;
        System.out.println(uniChar);
        Integer integer = 55;
        String s = "A";
        System.out.println(s);
        System.out.println(UUID.randomUUID());
        String string = " ";
        if (StringUtils.isBlank(string)) {
            System.out.println("是空白");
        } else {
            System.out.println("不是空白");
        }
    }

    @Test
    public void testList() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        strings.add("11");
        strings.add("10");
        strings.add(String.valueOf(1));
        strings.forEach(s -> System.out.println(s));
        long count = strings.stream().count();
        System.out.println(count);
        ListIterator<String> stringListIterator = strings.listIterator();

        for (String string : strings) {
            System.out.println(string);
        }
        strings.forEach(s -> System.out.println(s));

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
        Map<String, String> map = new HashMap<>();
        map.put("01", "02");
        map.forEach((k, v) -> System.out.println(k + v));
        int size = map.size();
        System.out.println(map.get(""));

        List<Object> list = new ArrayList<>();
        list.add(1);

        list.add("adb");
        System.out.println(list);
    }
}
