package com.roc.SuperMaster.utility.EnumUtil;

import cn.hutool.core.util.EnumUtil;
import com.roc.SuperMaster.entity.enums.StudentStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName EnumUtils
 * @Description 枚举类工具类
 * @Author Roc
 * @date 2022/4/17 11:17
 * @Version 1.0
 */
@Slf4j
public class EnumUtils {

    /**
     * 2022年4月17日11:18:55
     * 问题：传入的Key是否在定义的枚举类中，可以捕获异常或者转换处理
     */

    /**
     * values()方法：将枚举类的所有对象以数组形式返回，利用此方法可以方便地遍历枚举类的值。
     * valueOf(String name)方法：返回枚举类中对象名为name的对象。若没有，则抛出IllegalArgumentException的异常。
     * toString()方法：返回枚举类对象的名称
     */

    /**
     * 测试使用HuTool的枚举工具类
     */

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/17 14:26
     * @Description: Enum类的常用方法及对传入的key值的两种处理方法（委婉处理及捕获异常）
     */
    @Test
    public void testEnumCommonMethod() {
        System.out.println("----------枚举类的Key转换为数组打印----------");
        Arrays.stream(StudentStatus.values()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-----------------------------------------");

        System.out.println("----------判断传入的值是否在定义的枚举类中，并对其处理----------");
        //前两项在，最后一项不在
        String requestParams = "Entrance,UpGrade,hello";

        List<String> studentStatusList4String = Arrays.stream(StudentStatus.values()).collect(Collectors.toList()).stream().map(x -> x.getStatusKey()).collect(Collectors.toList());
        if (StringUtils.isNotEmpty(requestParams)) {
            String[] statusArrays = requestParams.split(",");
            for (String status : statusArrays) {
                if (studentStatusList4String.contains(status)) {
                    System.out.println(
                            new StringBuilder()
                                    .append(status)
                                    .append(":")
                                    .append(StudentStatus.valueOf(status).getStatusDesc()).toString());
                } else {
                    System.out.println(
                            new StringBuilder()
                                    .append(status)
                                    .append(":")
                                    .append("请检查当前数据的合理性").toString());
                }
            }
        }
        System.out.println("-----------------------------------------");

        System.out.println("----------判断传入的值是否在定义的枚举类中，并对其处理----------");
        try {
            if (StringUtils.isNotEmpty(requestParams)) {
                String[] statusArrays = requestParams.split(",");
                for (String status : statusArrays) {
                    System.out.println(StudentStatus.valueOf(status).getStatusDesc());
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("请检查当前数据的合理性");
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/17 14:28
     * @Description: 测试使用HuTool的枚举工具类
     */
    @Test
    public void testHutoolForEnum() {

        System.out.println("---------使用Hutool的EnumUtil.getNames---------");
        List<String> namesByStudentStatus = EnumUtil.getNames(StudentStatus.class);
        namesByStudentStatus.forEach(System.out::println);

        System.out.println("---------使用Hutool的EnumUtil.getFileNames---------");
        List<String> fieldNames = EnumUtil.getFieldNames(StudentStatus.class);
        fieldNames.forEach(System.out::println);

        System.out.println("---------使用Hutool的EnumUtil.getEnumMap-->getKeySet---------");
        LinkedHashMap<String, StudentStatus> enumMap = EnumUtil.getEnumMap(StudentStatus.class);
        Set<String> strings = enumMap.keySet();
        strings.forEach(System.out::println);

        System.out.println("---------使用Hutool的EnumUtil.getEnumMap-->getValueSet---------");
        Set<Map.Entry<String, StudentStatus>> entries = enumMap.entrySet();
        for (Map.Entry<String, StudentStatus> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getStatusDesc());
        }

        System.out.println("---------使用Hutool的EnumUtil.getNameFieldMap---------");
        System.out.println(EnumUtil.getNameFieldMap(StudentStatus.class, "statusDesc").get("Discontinue"));

        System.out.println("---------使用Hutool的EnumUtil.contains---------");
        System.out.println(EnumUtil.contains(StudentStatus.class, "hello"));

    }

}
