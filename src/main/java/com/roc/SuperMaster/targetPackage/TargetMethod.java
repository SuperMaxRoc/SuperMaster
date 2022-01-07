package com.roc.SuperMaster.targetPackage;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Roc
 * @Date 2022/1/7 9:09
 * @Version 1.0.0
 * @ClassName TargetMethod.java
 * @Description ToDo
 * @UpdateUser Roc
 */
@Slf4j
public class TargetMethod {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2022/1/7 15:42
     * @Version 1.0
     * @Description: 2022.1.7发现target文件重复性记录较多，采用集合去重的方式去掉重复的记录。顺带复习下IO操作
     * @UpdateUser WP
     */
    @Test
    public void parseWord(){
        //获取目标文件的路径，改用File对象接收
        File file = new File("C:\\Users\\Roc\\Desktop\\new 10.txt");
        //用于输出文件的路径
        File file02 = new File("C:\\Users\\Roc\\Desktop\\new 11.txt");
        try (
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));

                FileWriter fileWriter = new FileWriter(file02);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            String lineText = null;
            List<String> list = new ArrayList<>();
            while ((lineText = bufferedReader.readLine()) != null) {
                String substring00 = lineText.substring(31);
                int i = substring00.lastIndexOf(".");
                String substring02 = substring00.substring(0, i);
                list.add(new StringBuilder().append("https://pic.netbian.com/tupian/")
                        .append(substring02)
                        .append(".html").toString());
            }
            Object[] objects = list.stream().distinct().toArray();
            List<Object> objects1 = Arrays.asList(objects);
            for (int i = 0; i < objects1.size(); i++) {
                bufferedWriter.write(objects1.get(i).toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
