package com.roc.SuperMaster.utility.ioUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Roc
 * @Date 2021/10/8 17:47
 * @Version 1.0.0
 * @ClassName SuperIo.java
 * @Description 超级IO
 * @UpdateUser Roc
 */
@Slf4j
public class SuperIo {

    @Test
    public void mkdir() {
        // 文件夹路径
        String filePath = "d:\\";
        String str = "一秒钟, 芝加哥七子审判, 致允熙, 心灵奇旅, 南山的部长们, 沐浴之王, 寄生虫, 悲惨世界, 坏家伙们, 铁雨, 海边的曼彻斯特, 春娇与志明123, 证人, 黑水, 幽灵少女, 星际探索, 少年的你, 末代皇帝, 秒速五厘米, 老千, 老千2·神之手, 狼少年, 好莱坞往事, 风之谷, 断背山, 大地惊雷, 潘菲洛夫28勇士, TheKing, 爱尔兰人, 霸王别姬, 赤壁, 猛禽小队, 机动部队, 局内人, 南方车站的聚会, 秦颂, 弱点, 逃组, 无望之子, 现在去见你, 饮食男女, 82年生的金智英, 信仰, 荆轲刺秦王, 听见你声音, 除暴, 超脱：人间师格, 锅匠、裁缝、士兵、间谍, 黑道之家, 两杆大烟枪, 美丽人生, 绅士们, 守法公民, 天气之子, 无法无天, 小情书, 小森林, 小偷家族, 战马, 终极斗士2, 银翼杀手2049, 师傅, 天堂电影院, 黄金三镖客, 黑客帝国, 爱在黄昏日落时, 变种人系列, 低俗小说, 拆弹专家, 飞越疯人院, lifeisbeautiful, 致命ID, 超验骇客, 看不见的客人, 钢琴家, 突袭, 春光乍泄, 金枝玉叶, 阿飞正传, 纵横四海, 胭脂扣, 大红灯笼高高挂, 我身体里的家伙, 飞鹰艾迪, 翻滚吧阿信, 冰球坏小子, 成事在人, 西部往事, 训练日, 偷拐抢骗, 枪火, 黄海, 上帝之城, 江湖儿女, 误杀2, 公牛历险记, 全金属外壳, 正义联盟, 宫崎骏全集, 驭风男孩, 魔发奇缘, 最后的前线, 007（丹尼尔·克雷格）全集, SAS, 人潮汹涌, 只有你, 精灵旅社, 模仿游戏, 菲利普船长, 伦敦战场, 我脑海中的橡皮擦, 弱点, 心之全蚀";
        //ArrayList<String> stringArrayList = new ArrayList<>();
        String[] strings = str.split(",");
        try {
            for (String dir : strings) {
                String targetDir = filePath + dir;
                File file = new File(targetDir);
                boolean mkdir = file.mkdir();
                System.out.println(mkdir);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: WP
     * @Date: 2021/11/23 11:26
     * @Version 1.0
     * @Description: FileInputStream
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void testIo() throws Exception{
        String filePath = "D:\\abc.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        //创建字节缓冲区
        byte[] bytes = new byte[1024];
        int count = 0;
        if ((count = fileInputStream.read(bytes)) != -1){
            //英文字母不区分大小及英文标点符号写占一个字节。
            //数字占一个字节。
            //汉字及汉字标点符号目前测试的占三个字节。
            System.out.println("总共的字节数：" + count);
            System.out.println(new String(bytes));
        }
    }

    @Test
    public void tes() throws Exception {
        String filePath = "D:\\abc.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int count = 0;
        while ((count = fileInputStream.read()) != -1) {
            System.out.print(count + " ");
        }
    }

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
    public void parseWord() {
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
