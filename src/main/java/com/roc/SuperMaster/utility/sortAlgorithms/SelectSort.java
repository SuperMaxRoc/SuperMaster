package com.roc.SuperMaster.utility.sortAlgorithms;

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author WP
 * @version 1.0
 * @Date 2022/1/15 22:55
 * @ClassName SelectSort.class
 * @Description 选择排序
 * @UpdateUser Roc
 */
public class SelectSort {
    @Test
    public void selectSort() {
        /*
         * 选择排序：
         *   首先找到数组中最小的那个元素，其次，将它和数组中第一个元素交换位置（如果第一个元素就是最小元素，那么它就和自己交换）
         *   其次，在剩下的元素中找到最小的元素，将它和第二个元素交换位置。如此反复，直到将整个数组排序。
         *   这种方法称之为选择排序。
         * */
        int[] a = {0, 5, 1, 2, 3, 85, 0, 1, 2};
        //目标数组的长度

        for (int i = 0; i < a.length; i++) {
            int min = i;
            //选出之后待排序中值最小的位置
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        System.out.println(ArrayUtil.toString(a));
    }
}
