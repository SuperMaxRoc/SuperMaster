package com.roc.SuperMaster.utility.quartzUtil;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Author Roc
 * @Date 2021/8/6 13:25
 * @Version 1.0.0
 * @ClassName TestSpringTask.java
 * @Description SpringTask
 * @UpdateUser Roc
 */
//@RequestMapping("/TestSpringTask")
//@RestController
//@Api(tags = "定时任务的实现的第二种方式：SpringTask")
@Slf4j
public class SpringTaskHandle {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/8/6 11:52
     * @Version 1.0
     * @Description: 测试SpringTask
     * @UpdateUser WP
     */
//    @Scheduled(cron = "0/2 * * * * ?")
    public void testSpringTask() {
        log.info("开始测试Spring Task");
        try {
            System.out.println("当前执行任务的时间：" + new Date());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("捕获异常信息：{}", e.getMessage());
        }
    }
}
