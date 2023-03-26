package com.roc.SuperMaster.utility.sortAlgorithms;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author Roc
 * @Date 2022/1/16 10:14
 * @Version 1.0.0
 * @ClassName ShellSort.java
 * @Description 希尔排序:失败
 * @UpdateUser Roc
 */
public class ShellSort {
    @Test
    public void shellSort() {
        int[] a = {0, 5, 1, 2, 3, 85, 0, 1, 2, 9, 8, 8, 55};

        for (int gap = a.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < a.length; i++) {
                int temp = a[i], j;
                for (j = i; j >= gap && temp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                    a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
