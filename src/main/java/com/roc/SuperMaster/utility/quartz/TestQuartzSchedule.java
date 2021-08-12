package com.roc.SuperMaster.utility.quartz;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author Roc
 * @Date 2021/8/6 13:35
 * @Version 1.0.0
 * @ClassName TestQuartzSchedule.java
 * @Description 创建Quartz的执行类
 * @UpdateUser Roc
 */
@Component
@Api(tags = "testQuartzSchedule")
@Slf4j
@RequestMapping("/TestQuartzSchedule")
@RestController
public class TestQuartzSchedule {

    /**
     * @Author: WP
     * @Date: 2021/8/6 13:38
     * @Version 1.0
     * @Description: 实现Quartz调用器
     * @UpdateUser WP
     * @param
     * @return void
     */
    @GetMapping("/testQuartzSchedule")
    @ApiOperation(value = "测试QuartzSchedule")
    public void testQuartzSchedule() throws SchedulerException{
        try{
            log.info("定时任务开始！");
            //1.创建调度器scheduler
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = stdSchedulerFactory.getScheduler();

            //2.创建JobDetail实例，并绑定执行类
            JobDetail build = JobBuilder.newJob(TestQuartzJob.class).withIdentity("Quartz1", "QuartzGroup1").build();

            //3.构建Trigger的实例
            CronTrigger build1 = TriggerBuilder.newTrigger().withIdentity("Trigger1", "QuartzTrigger1")
                    .startNow()  //corn表达式生成地址：https://cron.qqe2.com/
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                    .build();

            //4.执行Quartz
            scheduler.scheduleJob(build,build1);
            scheduler.start();

            //5.利用TimeUnit实现延时操作
            TimeUnit.SECONDS.sleep(1);

            //6.关闭定时任务
            scheduler.shutdown();
            log.info("定时任务结束！");

        }catch (Exception e){
            e.printStackTrace();
            log.error("捕获异常信息：{}",e.getMessage());
        }
    }
}