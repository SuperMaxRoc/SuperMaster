package com.roc.SuperMaster.utility.quartz;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author Roc
 * @Date 2021/8/6 13:25
 * @Version 1.0.0
 * @ClassName TestScheduledExecutorService.java
 * @Description TestScheduledExecutorService
 * @UpdateUser Roc
 */
@Slf4j
@RequestMapping("/TestScheduledExecutorService")
@RestController
@Api(tags = "用于测试实现定时任务的方法02")
public class TestScheduledExecutorService {
    /**
     * @Author: WP
     * @Date: 2021/8/6 9:47
     * @Version 1.0
     * @Description: test ScheduledExecutorService
     * @UpdateUser WP
     * @param
     * @return void
     */
    @ApiOperation(value = "测试ScheduledExecutorService")
    @GetMapping("/testScheduledExecutorService")
    public void test(){
        try{
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
//            scheduledExecutorService.scheduleAtFixedRate(() -> {
//                System.out.println("当前执行任务的时间：" + new Date());
//                    }, 1, 3, TimeUnit.SECONDS
//            );
            TimerTask task = new TimerTask(){
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
            scheduledExecutorService.schedule(task,1, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
            log.error("捕获异常信息：{}",e.getMessage());
        }
    }
}
