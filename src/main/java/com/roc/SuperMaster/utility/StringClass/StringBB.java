package com.roc.SuperMaster.utility.StringClass;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Author Roc
 * @Date 2021/8/9 14:42
 * @Version 1.0.0
 * @ClassName StringBB.java
 * @Description StringBuffer及StringBuilder常用功能解析及相同点不同点区分
 * @UpdateUser Roc
 */
@Slf4j
public class StringBB {

    /**
     * StringBB：StringBuilder+StringBuffer
     */

    /**
     * StringBuilder和StringBuffer区别
     * 不同点：
     * 1.线程安全
     *      StringBuffer是线程安全的，因为添加了synchronized锁
     *      StringBuilder不是线程安全
     * 2.执行效率
     *      StringBuilder执行效率比StringBuffer快，因为执行不需要判断锁
     * 相同点：
     * 1.底层实现
     *      StringBuilder及StringBuffer均继承了AbstractStringBuilder
     *      其中AbstractStringBuilder底层使用的仍是字符数组，但是没有使用final修饰，可以动态扩充，属于可变字符串。
     * 2.实现的方法和功能都是等价的
     * */

    /**
     * 参考文档：
     *1.Java StringBuffer 和 StringBuilder 类详解：
     *    https://www.runoob.com/java/java-stringbuffer.html
     *    https://www.runoob.com/manual/jdk11api/java.base/java/lang/StringBuffer.html
     *    https://www.runoob.com/manual/jdk11api/java.base/java/lang/StringBuilder.html
     *2.StringBuilder扩容规则：
     *    https://blog.csdn.net/chiting5096/article/details/100726861?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromMachineLearnPai2%7Edefault-3.control
     *3.StringBuffer扩容原理：
     *    https://www.jianshu.com/p/9b8ed3721b11
     *4.什么是线程安全？
     *    https://blog.csdn.net/zxc456733/article/details/78871972
     *5.java常量池：
     *    https://blog.csdn.net/qq_41376740/article/details/80338158
     * */

    @Test
    public void testStringBuffer(){
        StringBuffer stringBuffer = new StringBuffer();
        String string01 = "higher";
        String string02 = "faster";
        String string03 = "stronger";
        String string04 = "together";
        //当前容量
        System.out.println("当前stringBuffer的容量：" + stringBuffer.capacity());
        System.out.println("------------------------------------------------------------------------------");
        //拼接字符串
        String string = stringBuffer.append(string01)
                .append(" ")
                .append(string02)
                .append(" ")
                .append(string03)
                .append(" ")
                .append(string04)
                .toString();
        System.out.println("拼接字符串：" + string);
        System.out.println("------------------------------------------------------------------------------");
        //反转字符串
        stringBuffer.reverse();
        String reverse = stringBuffer.reverse().toString();
        //已经第二次反转
        System.out.println("反转字符串：" + reverse);
        System.out.println("------------------------------------------------------------------------------");
        //当前容量
        System.out.println("当前stringBuffer的容量：" + stringBuffer.capacity());//发现被扩容了
        System.out.println("------------------------------------------------------------------------------");
        //返回此序列中某个索引的char值，索引值从0开始
        char charAt = stringBuffer.charAt(0);
        System.out.println("返回某个具体索引值的char值：" + charAt);
        System.out.println("------------------------------------------------------------------------------");
        //返回第一次出现指定字符串中的索引
        int index = stringBuffer.indexOf(string02);
        System.out.println("返回第一次出现指定字符串中的索引:" + index);
        System.out.println("------------------------------------------------------------------------------");
        //返回长度，不考虑空字符串
        int length = stringBuffer.length();
        System.out.println("stringBuffer的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //插入新的字符串
        stringBuffer.insert(0,"dreaming");
        stringBuffer.insert(8," ");
        System.out.println("插入新字符串后的：" + stringBuffer.toString());
        System.out.println("当前stringBuffer的容量：" + stringBuffer.capacity());
        System.out.println("stringBuffer的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //替换此序列的字符串的字符
        stringBuffer.replace(0,8,"life");
        System.out.println("替换序列中的字符串后的：" + stringBuffer);
        System.out.println("当前stringBuffer的容量：" + stringBuffer.capacity());
        System.out.println("stringBuffer的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //删除某一段的字符
        stringBuffer.delete(0,3);
        System.out.println("删除后的stringBuffer：" + stringBuffer.toString());
        System.out.println("当前stringBuffer的容量：" + stringBuffer.capacity());
        System.out.println("stringBuffer的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //开始扩容
        stringBuffer.setLength(100);
        System.out.println("扩容后的StringBuffer：" + stringBuffer.toString());
        System.out.println("当前stringBuffer的容量：" + stringBuffer.capacity());
        System.out.println("------------------------------------------------------------------------------");
        //开始测试异常
        try{
            StringBuffer buffer = new StringBuffer();
            for (int i = 0;i<=3;i++){
                buffer.append(i);
                System.out.println(buffer);
            }
        }catch (StringIndexOutOfBoundsException e){
            log.info("捕获异常信息：{}" , e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        String string01 = "higher";
        String string02 = "faster";
        String string03 = "stronger";
        String string04 = "together";
        //当前容量
        System.out.println("当前StringBuilder的容量：" + stringBuilder.capacity());
        System.out.println("------------------------------------------------------------------------------");
        //拼接字符串
        String string = stringBuilder.append(string01)
                .append(" ")
                .append(string02)
                .append(" ")
                .append(string03)
                .append(" ")
                .append(string04)
                .toString();
        System.out.println("拼接字符串：" + string);
        System.out.println("------------------------------------------------------------------------------");
        //反转字符串
        stringBuilder.reverse();
        String reverse = stringBuilder.reverse().toString();
        //已经第二次反转
        System.out.println("反转字符串：" + reverse);
        System.out.println("------------------------------------------------------------------------------");
        //当前容量
        System.out.println("当前StringBuilder的容量：" + stringBuilder.capacity());//发现被扩容了
        System.out.println("------------------------------------------------------------------------------");
        //返回此序列中某个索引的char值，索引值从0开始
        char charAt = stringBuilder.charAt(0);
        System.out.println("返回某个具体索引值的char值：" + charAt);
        System.out.println("------------------------------------------------------------------------------");
        //返回第一次出现指定字符串中的索引
        int index = stringBuilder.indexOf(string02);
        System.out.println("返回第一次出现指定字符串中的索引:" + index);
        System.out.println("------------------------------------------------------------------------------");
        //返回长度，不考虑空字符串
        int length = stringBuilder.length();
        System.out.println("StringBuilder的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //插入新的字符串
        stringBuilder.insert(0, "dreaming");
        stringBuilder.insert(8, " ");
        System.out.println("插入新字符串后的：" + stringBuilder.toString());
        System.out.println("当前StringBuilder的容量：" + stringBuilder.capacity());
        System.out.println("StringBuilder的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //替换此序列的字符串的字符
        stringBuilder.replace(0, 8, "life");
        System.out.println("替换序列中的字符串后的：" + stringBuilder);
        System.out.println("当前StringBuilder的容量：" + stringBuilder.capacity());
        System.out.println("StringBuilder的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //删除某一段的字符
        stringBuilder.delete(0, 3);
        System.out.println("删除后的StringBuilder：" + stringBuilder.toString());
        System.out.println("当前StringBuilder的容量：" + stringBuilder.capacity());
        System.out.println("StringBuilder的长度：" + length);
        System.out.println("------------------------------------------------------------------------------");
        //开始扩容
        stringBuilder.setLength(100);
        System.out.println("扩容后的StringBuilder：" + stringBuilder.toString());
        System.out.println("当前StringBuilder的容量：" + stringBuilder.capacity());
        System.out.println("------------------------------------------------------------------------------");
        //开始测试异常
        try {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i <= 3; i++) {
                builder.append(i);
                System.out.println(builder);
            }
        } catch (StringIndexOutOfBoundsException e) {
            log.info("捕获异常信息：{}", e.getMessage());
            e.printStackTrace();
        }
    }
}