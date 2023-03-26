package com.roc.SuperMaster.utility.sortAlgorithms;

import cn.hutool.core.util.ArrayUtil;
import org.junit.Test;

/**
 * @author WP
 * @version 1.0
 * @Date 2022/1/15 23:30
 * @ClassName BubbleSort.class
 * @Description 冒泡排序
 * @UpdateUser Roc
 */
public class BubbleSort {
    @Test
    public void bubbleSort() {

        int[] a = {0, 5, 1, 2, 3, 85, 0, 1, 2};
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                int temp;
                //如果后面的比前面的大就交换
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(ArrayUtil.toString(a));
    }
}
