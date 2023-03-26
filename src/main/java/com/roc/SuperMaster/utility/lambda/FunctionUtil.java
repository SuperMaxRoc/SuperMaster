package com.roc.SuperMaster.utility.lambda;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @ClassName FunctionUtil
 * @Description 函数式接口编程
 * @Author Roc
 * @date 2022/4/17 23:27
 * @Version 1.0
 */
@Slf4j
public class FunctionUtil {

    final String s = "hello,world";

    /**
     * 新时代的程序猿/媛（/员）：lambda表达式，链式编程，函数式接口，Stream流式计算
     */

    /**
     * 四大函数式接口：
     * 1.消费者接口
     * 2.供给型接口
     * 3.函数型接口
     * 4.断定性接口
     */

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/17 23:34
     * @Description: 消费者接口：给啥用啥，无返回
     */
    @Test
    public void testConsumerApi() {
        System.out.println("消费者接口：给啥用啥，无返回");
        new Consumer<String>() {
            @Override
            public void accept(String s) {
                Arrays.stream(s.split(",")).collect(Collectors.toList()).forEach(System.out::println);
            }
        }.accept(s);
    }

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/17 23:41
     * @Description: 供给型接口：总会返回目标类型的值
     */
    @Test
    public void testSupplierApi() {
        System.out.println("供给型接口：总会返回目标值，可以提供入参");
        System.out.println(new Supplier<String>() {
            @Override
            public String get() {
                //System.out.println("供给型接口内部~~~");
                return s;
            }
        }.get());
    }

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/17 23:47
     * @Description: 函数型接口：喂and吐
     */
    @Test
    public void testFunctionApi() {
        System.out.println("函数型接口：喂and吐");
        new Function<String, List<String>>() {
            @Override
            public List<String> apply(String s) {
                return Arrays.stream(s.split(",")).collect(Collectors.toList());
            }

        }.apply(s).forEach(System.out::println);
    }

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/17 23:53
     * @Description: 断言型函数：判断目标是否符合预期值：简而言之，就是一个动作
     */
    @Test
    public void testPredicateApiary() {
        System.out.println("断言型函数：判断目标是否符合预期值");
        System.out.println(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (Arrays.stream(s.split(",")).collect(Collectors.toList()).size() > 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }.test(s));

        Predicate<String> predicate = new Predicate<String>() {
            @NotNull
            @Override
            public Predicate and(@NotNull Predicate other) {
                return Predicate.super.and(other);
            }

            @Override
            public boolean test(String o) {
                if (Arrays.stream(s.split(",")).collect(Collectors.toList()).size() > 1) {
                    return true;
                } else {
                    return false;
                }
            }
        };

    }

}
