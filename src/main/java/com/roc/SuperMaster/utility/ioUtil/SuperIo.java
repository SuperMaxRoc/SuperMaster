package com.roc.SuperMaster.utility.ioUtil;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**
 * @Author Roc
 * @Date 2021/10/8 17:47
 * @Version 1.0.0
 * @ClassName SuperIo.java
 * @Description ToDo
 * @UpdateUser Roc
 */
@Slf4j
public class SuperIo {

    @Test
    public void mkdir(){
        // 文件夹路径
        String filePath = "d:\\";
        String str  = "一秒钟, 芝加哥七子审判, 致允熙, 心灵奇旅, 南山的部长们, 沐浴之王, 寄生虫, 悲惨世界, 坏家伙们, 铁雨, 海边的曼彻斯特, 春娇与志明123, 证人, 黑水, 幽灵少女, 星际探索, 少年的你, 末代皇帝, 秒速五厘米, 老千, 老千2·神之手, 狼少年, 好莱坞往事, 风之谷, 断背山, 大地惊雷, 潘菲洛夫28勇士, TheKing, 爱尔兰人, 霸王别姬, 赤壁, 猛禽小队, 机动部队, 局内人, 南方车站的聚会, 秦颂, 弱点, 逃组, 无望之子, 现在去见你, 饮食男女, 82年生的金智英, 信仰, 荆轲刺秦王, 听见你声音, 除暴, 超脱：人间师格, 锅匠、裁缝、士兵、间谍, 黑道之家, 两杆大烟枪, 美丽人生, 绅士们, 守法公民, 天气之子, 无法无天, 小情书, 小森林, 小偷家族, 战马, 终极斗士2, 银翼杀手2049, 师傅, 天堂电影院, 黄金三镖客, 黑客帝国, 爱在黄昏日落时, 变种人系列, 低俗小说, 拆弹专家, 飞越疯人院, lifeisbeautiful, 致命ID, 超验骇客, 看不见的客人, 钢琴家, 突袭, 春光乍泄, 金枝玉叶, 阿飞正传, 纵横四海, 胭脂扣, 大红灯笼高高挂, 我身体里的家伙, 飞鹰艾迪, 翻滚吧阿信, 冰球坏小子, 成事在人, 西部往事, 训练日, 偷拐抢骗, 枪火, 黄海, 上帝之城, 江湖儿女, 误杀2, 公牛历险记, 全金属外壳, 正义联盟, 宫崎骏全集, 驭风男孩, 魔发奇缘, 最后的前线, 007（丹尼尔·克雷格）全集, SAS, 人潮汹涌, 只有你, 精灵旅社, 模仿游戏, 菲利普船长, 伦敦战场, 我脑海中的橡皮擦, 弱点, 心之全蚀";
        //ArrayList<String> stringArrayList = new ArrayList<>();
        String[] strings = str.split(",");
        try {
            for (String dir:strings) {
                String targetDir = filePath + dir;
                File file = new File(targetDir);
                boolean mkdir = file.mkdir();
                System.out.println(mkdir);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
