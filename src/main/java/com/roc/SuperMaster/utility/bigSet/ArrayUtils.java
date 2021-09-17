package com.roc.SuperMaster.utility.bigSet;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author Roc
 * @Date 2021/8/26 20:09
 * @Version 1.0.0
 * @ClassName ArrayAndAggregateUtils.java
 * @Description 数组的相关方法
 * @UpdateUser Roc
 */
@Slf4j
public class ArrayUtils {

    /**
     * @Author: WP
     * @Date: 2021/9/6 16:18
     * @Version 1.0
     * @Description: 构建新的数组
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void newArrays(){

        /**
         * 初始化数组
         */

        System.out.println("一维数组开始：--------------------------------------");
        System.out.println("一维数组初始化！");

        //构建一维数组的方式01：静态初始化：数据类型[] 数组名 = new 数据类型[]{元素1,元素2,元素3…};
        String [] strings01 = {};

        //因为固定了数组及内容，故不能新增新的数组元素
        //strings01[0] = "0";
        //strings01[1] = "1";
        //strings01[2] = "2";
        //打印数组01
        System.out.println("一维数组01：" + Arrays.toString(strings01));
        //打印数组02
        System.out.println("一维数组01：" + Arrays.deepToString(strings01));

        //构建一维数组的方式02：动态初始化：数组存储的数据类型[ ] 数组名字 = new 数组存储的数据类型[数组长度];
        //构建一维数组的方式02：动态初始化：数组存储的数据类型 数组名字[ ] = new 数组存储的数据类型[数组长度];
        String [] strings02 = new String[5];
        String strings03[] = new String[5];

        strings02[0] = "0";
        strings02[1] = "1";
        strings02[2] = "2";
        strings02[3] = "3";
        strings02[4] = "1";
        strings02[4] = "4";//可覆盖赋值

        strings03[0] = "0";
        strings03[1] = "1";
        strings03[2] = "2";
        strings03[3] = "3";
        strings03[4] = "4";

        System.out.println("一维数组02：" + Arrays.toString(strings02));
        System.out.println("一维数组03：" + Arrays.toString(strings03));
        System.out.println("一维数组结束：--------------------------------------");

        System.out.println("二维数组开始：--------------------------------------");
        System.out.println("二维数组初始化！");

        //构建二维数组的方式01：静态初始化：数组存储的数据类型[ ][ ] 数组名字 = {{},{}···}
        int[][] ints01 = {{1,2},{1}};
        System.out.println("二维数组01：" + Arrays.deepToString(ints01));

        //构建二维数组的方式02：动态初始化01:数组存储的数据类型[ ][ ] 数组名字 = new数组存储的数据类型[数组长度][数组长度];
        //构建二维数组的方式02：动态初始化02:数组存储的数据类型 数组名字[ ][ ] = new数组存储的数据类型[数组长度][数组长度];
        int[][] ints02 = new int[2][3];
        int ints03 [][] = {};
        int ints04 [][] = new int[2][2];
        ints02[0][0] = 0;
        ints02[0][1] = 1;
        ints02[1][0] = 2;
        ints02[1][1] = 3;
        System.out.println("二维数组02的长度：" + ints02.length);
        System.out.println("二维数组02：" + Arrays.deepToString(ints02));
        System.out.println("二维数组结束：--------------------------------------");

        System.out.println("三维数组开始：--------------------------------------");
        System.out.println("三维数组初始化！");

        int [][][] int01 = {};
        System.out.println("三维数组01的长度：" + int01.length);

        int int02 [][][] = new int[1][2][3];
        int02[0][0][0] = 1;
        int02[0][0][1] = 1;
        int02[0][0][2] = 1;
        System.out.println("三维数组02的长度：" + int02.length);
        //打印数组
        System.out.println("三维数组02：" + Arrays.deepToString(int02));
        System.out.println("三维数组结束：--------------------------------------");
    }

    //一维数组OneDimensional
    //二维数组TwoDimensional
    //三维数组ThreeDimensional
    /**
     * @Author: WP
     * @Date: 2021/9/6 15:18
     * @Version 1.0
     * @Description: 遍历一维数组
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void traverseOneDimensionalArray(){
        String[] strings = new String[4];
        strings[0] = "0";
        strings[1] = "1";
        strings[2] = "2";
        strings[3] = "3";

        //普通for循环
        System.out.println("遍历一维数组的第一种方法：普通for循环");
        for (int i = 0; i < strings.length; i++) {
            System.out.println("一维数组：普通for循环:" + strings[i]);
        }
        //增强for循环
        System.out.println("遍历一维数组的第二种方法：增强for循环");
        for (String string : strings) {
            System.out.println("一维数组：增强for循环:" + string);
        }
        //while
        System.out.println("遍历一维数组的第三种方法：while");
        int iii = 0;
        while (iii < strings.length){
            System.out.println("一维数组：while:" + strings[iii]);
            iii++;
        }
        //do···while
        System.out.println("遍历一维数组的第四种方法：do···while");
        int lll = 0;
        do {
            System.out.println("一维数组：do···while:" + strings[lll]);
            lll++;
        }
        while (lll < strings.length);

        //迭代器
        System.out.println("遍历一维数组的第四种方法：迭代器");
        Iterator<String> iterator = Arrays.stream(strings).iterator();
        while (iterator.hasNext()){
            System.out.println("一维数组：迭代器：" + iterator.next());
        }
    }
    
    /**
     * @Author: WP
     * @Date: 2021/9/6 15:57
     * @Version 1.0
     * @Description: 遍历二维数组
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void traverseTwoDimensionalArray(){
        //定义一个两行三列的int类型的二维数组.
        //二维数组的长度为行数
        int ints01 [][] = new int[2][3];
        ints01[0][0] = 0;
        ints01[0][1] = 1;
        ints01[0][2] = 1;
        ints01[1][0] = 2;
        ints01[1][1] = 3;
        ints01[1][2] = 3;
        System.out.println("二维数组的长度：" + ints01.length);

        System.out.println();
        System.out.println("二维数组：" + Arrays.deepToString(ints01));

        //遍历二维数组01：普通for循环
        //遍历思路：循环外层，然后内层
        //因为二维数组的长度即是第一个数字也就是行数。
        //本质：并没有二维或者多维数组，均是一维数组的累计。
        //外层for循环拿到第几行，然后当成行的一维数组，循环得到当前行的列的值
        for (int i = 0; i < ints01.length; i++) {
            for (int j = 0; j < ints01[i].length; j++) {
                System.out.println("遍历二维数组01：普通for循环:"+ ints01[i][j]);
            }
        }

        //遍历二维数组02：增强for循环
        for (int[] i1:ints01) {
            for (int k:i1) {
                System.out.println("遍历二维数组02：增强for循环：" + k);
            }
        }
    }

    //
    @Test
    public void testException() {
//        String[] strings = {"1", "2", "12"};
//        Arrays.stream(strings).forEach(System.out::println);
//
//        for (String s : strings) {
//            System.out.println(s);
//        }
        String str = null;
        str += "参数编号："
                + "1"
                + "\t参数描述："
                + "2"
                + "\t参数值："
                + "3"
                + "\r\n";
        System.out.print(str);
    }
}
