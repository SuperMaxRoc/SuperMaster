package com.roc.SuperMaster.utility.quartzUtil;

import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author Roc
 * @Date 2021/8/6 13:25
 * @Version 1.0.0
 * @ClassName ScheduledExecutorService.java
 * @Description ScheduledExecutorService
 * @UpdateUser Roc
 */
//@RequestMapping("/ScheduledExecutorServiceHandle")
//@RestController
//@Api(tags = "定时任务的实现的第二种方式：ScheduledExecutor")
@Slf4j
public class ScheduledExecutorServiceHandle {
    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/8/6 9:47
     * @Version 1.0
     * @Description: test ScheduledExecutorService
     * @UpdateUser WP
     */
//    @ApiOperation(value = "测试ScheduledExecutorService")
//    @GetMapping("/ScheduledExecutorService")
    public void test() {
        try {
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//            scheduledExecutorService.scheduleAtFixedRate(() -> {
//                System.out.println("当前执行任务的时间：" + new Date());
//                    }, 1, 3, TimeUnit.SECONDS
//            );
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("当前执行任务的时间戳：" + System.currentTimeMillis());
                }
            };
            // 清空任务队列
            // task.cancel();
            // 开始执行任务:延迟一秒，以秒级为单位执行任务,每一秒执行
            // scheduledExecutorService.scheduleAtFixedRate(task,1,1,TimeUnit.SECONDS);
            // 开始执行任务：延迟一秒，仅此执行一次
            scheduledExecutorService.schedule(task, 1, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("捕获异常信息：{}", e.getMessage());
        }
    }
}
