package com.roc.SuperMaster.utility.streamUtil;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamUtil
 * @Description TODO
 * @Author Roc
 * @date 2022/4/5 10:57
 * @Version 1.0
 */
public class StreamUtil {


    @Test
    public void testDefaultComparator() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(3);
            add(0);
        }};

        List<Integer> integerList = arrayList.stream().sorted(Comparator.comparing(Integer::doubleValue).reversed()).collect(Collectors.toList()).subList(0, 4);
        System.out.println(integerList);
    }

    @Test
    public void testCustomComparator() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(3);
            add(0);
        }};

        List<Integer> integerList = arrayList.stream()
                .sorted(
                        (a, b) -> {
                            if (a > b) {
                                return -1;
                            } else if (a.equals(b)) {
                                return 0;
                            } else {
                                return 1;
                            }
                        }
                )
                .collect(Collectors.toList()).subList(0, 4);// 从大到小
        System.out.println(integerList);

        List<Integer> integerList02 = arrayList.stream()
                .sorted(
                        (a, b) -> {
                            if (a > b) {
                                return 1;
                            } else if (a.equals(b)) {
                                return 0;
                            } else {
                                return -1;
                            }
                        }
                )
                .collect(Collectors.toList()).subList(0, 4);
        System.out.println(integerList02);// 从小到大
    }

    @Test
    public void testStreamPeek() {
        ArrayList<String> arrayList = new ArrayList<String>() {{
            add("a");
            add("bb");
            add("ccc");
            add("dddd");
        }};
        List<String> collect = arrayList.stream()
                .filter(p -> p.length() > 2)
                .peek(p -> System.out.println("第一次打印的当前元素的值为：" + p))
                .map(String::toUpperCase)
                .peek(p -> System.out.println("第二次打印的当前元素的值为：" + p)).collect(Collectors.toList());
        //System.out.println(collect.size());
    }


}
