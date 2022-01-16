package com.roc.SuperMaster.utility.sortAlgorithms;

import cn.hutool.core.util.ArrayUtil;
import org.junit.Test;

/**
 * @Author Roc
 * @Date 2022/1/16 9:48
 * @Version 1.0.0
 * @ClassName InsertSort.java
 * @Description 插入排序
 * @UpdateUser Roc
 */
public class InsertSort {

    @Test
    public void insertSort() {
        int[] a = {5, 0, 1, 2, 3, 85, 0, 1, 2};

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        System.out.println(ArrayUtil.toString(a));
    }

}
