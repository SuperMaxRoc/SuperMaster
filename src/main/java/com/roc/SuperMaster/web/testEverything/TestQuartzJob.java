package com.roc.SuperMaster.web.testEverything;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author Roc
 * @Date 2021/8/5 17:45
 * @Version 1.0.0
 * @ClassName testQuartzJob.java
 * @Description 用于测试实现定时任务的方法
 * @UpdateUser Roc
 */
@Slf4j
@RestController
@RequestMapping
@Api(tags = "")
public class TestQuartzJob {

    @GetMapping("/testTimer")
    @ApiOperation(value = "测试java的Timer")
    public void testTimer() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("当前执行任务的时间：" + new Date());
            }
        };
        //计时器
        Timer timer = new Timer();
        timer.schedule(timerTask,1000,1000);
    }
}
