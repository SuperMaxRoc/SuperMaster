package com.roc.SuperMaster.utility.bigSet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author Roc
 * @Date 2021/11/16 14:26
 * @Version 1.0.0
 * @ClassName SparseArrayUtils.java
 * @Description 稀疏数组与原始数组的相互转换
 * @UpdateUser Roc
 */
@Slf4j
public class SparseArrayUtils {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/11/16 14:41
     * @Version 1.0
     * @Description: 回顾之前的一维数组知识：数组元素可重复，无顺序，有默认值
     * @UpdateUser WP
     */
    @Test
    public void testOneArrays() {
        //一维数组的创建
        //一维数组的遍历
        int[] a = {1, 23, 3, 5, 4, 5, 1, 1, 1};
        printOneArray(a);

        int[] ints = new int[10];
        printOneArray(ints);

        //一维数组的遍历：增强for循环
        String[] strings = new String[5];
        for (String string : strings) {
            System.out.print(string + "\t");
        }
    }

    /**
     * @Author: WP
     * @Date: 2021/11/16 16:20
     * @Version 1.0
     * @Description: 二维数组的遍历
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void testTwoArrays() {
        //二维数组
        int[][] ints = new int[6][6];
        ints[1][4] = 1;
        ints[4][5] = 1;

        System.out.println("原始数组：");
        printTwoArrays(ints);
        System.out.println("稀疏数组：");
        int[][] sparseArraysConvert = sparseArraysConvert(ints);
        printTwoArrays(sparseArraysConvert);
        System.out.println("从稀疏数组转换为原始数组：");
        printTwoArrays(twoArraysConvert(sparseArraysConvert));

    }

    /**
     * @param ints
     * @return void
     * @Author: WP
     * @Date: 2021/11/16 14:34
     * @Version 1.0
     * @Description: 一维数组的遍历
     * @UpdateUser WP
     */
    public static void printOneArray(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints.length == 0) {
                System.out.println("数组为空");
            }
            if (i == ints.length - 1) {
                System.out.print(ints[i] + "\n");
            } else {
                System.out.print(ints[i] + " ");
            }
        }
    }


    public static void printTwoArrays(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * @Author: WP
     * @Date: 2021/11/16 16:11
     * @Version 1.0
     * @Description: 目标二维数组转换为稀疏数组
     * @UpdateUser WP
     * @param ints
     * @return void
     */
    public static int[][] sparseArraysConvert(int[][] ints) {

        /*
        目标：寻求适合全部合适的二维数组转换为稀疏数组的方法
        */

        //稀疏数组的构成
        //其实稀疏数组仅记录大部分元素为0，或者为同一数值的情况，例如棋盘游戏，一旦出现大规模的不同的，转换稀疏数组甚至还不如之前的存储方式
        //可以理解为时间战胜了空间
        //第一行：记录一共有多少行和多少列，记录有多少不同的值
        //剩下的记录值的位置

        //值的个数
        int numCount = 0;

        if (ints.length != 0){
            //寻找值的个数
            for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints[i].length; j++) {
                    if (ints[i][j] != 0) {
                        numCount++;
                    }
                }
            }

            //用于接收数据的稀疏数组
            int[][] sparse = new int[numCount+1][3];
            //给与稀疏数组赋值：优先存储目标二维数组的基础信息：几行几列，几个特殊值
            sparse[0][0] = ints.length;
            sparse[0][1] = ints[0].length;
            sparse[0][2] = numCount;

            //开始赋值
            int count = 0;
            for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints[i].length; j++) {
                    if (ints[i][j] != 0) {
                        count++;
                        sparse[count][0] = i;
                        sparse[count][1] = j;
                        sparse[count][2] = ints[i][j];
                    }
                }
            }
            return sparse;
        }else {
            System.out.println("~~~~~~~~~目标数组不规范~~~~~~~~~");
            return null;
        }
    }

    /**
     * @Author: WP
     * @Date: 2021/11/16 17:04
     * @Version 1.0
     * @Description: 稀疏数组转换为原始数组
     * @UpdateUser WP
     * @param ints
     * @return int[][]
     */
    public static int[][] twoArraysConvert(int[][] ints){
        int row = ints[0][0];
        int col = ints[0][1];
        int[][] target = new int[row][col];

        int rowNum = 0;
        int colNum = 0;

        for (int i = 1; i < ints.length; i++) {
            rowNum =ints[i][0] ;
            colNum = ints[i][1] ;
            target[rowNum][colNum] = ints[i][2];
        }
        return target;
    }
}
