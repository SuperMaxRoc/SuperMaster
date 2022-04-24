package com.roc.SuperMaster.utility.thirdPartUtilPackage.guava;

import com.google.common.base.Joiner;
import com.roc.SuperMaster.entity.systemDomain.User;
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
    public void joiner() {
        List<String> stringList = new ArrayList<String>(Arrays.asList("1", "2"));
        System.out.println(Joiner.on(",").join(stringList));
        String string = String.join("1", stringList);

        List<User> users = new ArrayList<>();

        users.add(new User());
        users.add(new User());

        System.out.println(string);
    }

    //https://blog.csdn.net/github_shequ/article/details/112001280
    //Joiner/Splitter：字符串拼接/字符串分隔
    //CharMatcher：字符串匹配器
    //java基本类型的扩展类：ints/Bytes/Shorts/Ints/Iongs/Floats/Doubles/Chars/Booleans
    //Multiset：游离在List/Set之间的灰色地带：无序可重复
    //MultiMap：允许插入多个相同的Key
    //BiMap：双向Map：key和Value一一对应，可以通过value寻找对应的Key
    //函数式编程
    //异步回调
    //不可变集合
    //https://blog.csdn.net/pzjtian/article/details/106910046?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2.pc_relevant_default&utm_relevant_index=5
    //https://blog.csdn.net/weixin_41563161/article/details/109765790?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-2.pc_relevant_default&utm_relevant_index=5

    //com.google.common.annotations：普通注解类型。
    //com.google.common.base：基本工具类库和接口。
    //com.google.common.cache：缓存工具包，非常简单易用且功能强大的JVM内缓存。
    //com.google.common.collect：带泛型的集合接口扩展和实现，以及工具类，这里你会发现很多好玩的集合。
    //com.google.common.eventbus：发布订阅风格的事件总线。
    //com.google.common.hash： 哈希工具包。
    //com.google.common.io：I/O工具包。
    //com.google.common.math：原始算术类型和超大数的运算工具包。
    //com.google.common.net：网络工具包。
    //com.google.common.primitives：八种原始类型和无符号类型的静态工具包。
    //com.google.common.reflect：反射工具包。
    //com.google.common.util.concurrent：多线程工具包。
}
