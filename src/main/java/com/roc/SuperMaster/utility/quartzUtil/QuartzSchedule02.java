package com.roc.SuperMaster.utility.quartzUtil;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author Roc
 * @Date 2021/8/6 13:35
 * @Version 1.0.0
 * @ClassName QuartzSchedule.java
 * @Description 使用Quartz的第二部：创建Quartz调用器Schedule
 * @UpdateUser Roc
 */
//@Api(tags = "定时任务的实现的第三种方式：QuartzSchedule")
//@RequestMapping("/QuartzScheduleHandle")
//@RestController
@Slf4j
public class QuartzSchedule02 {

    /**
     * @Author: WP
     * @Date: 2021/8/6 13:38
     * @Version 1.0
     * @Description: 实现Quartz调用器
     * @UpdateUser WP
     * @param
     * @return void
     */
//    @GetMapping("/QuartzSchedule")
//    @ApiOperation(value = "测试QuartzSchedule")
    public void testQuartzSchedule() throws SchedulerException{
        try{
            log.info("定时任务开始！");
            //1.创建调度器scheduler
            StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = stdSchedulerFactory.getScheduler();

            //2.创建JobDetail实例，并绑定执行类
            JobDetail build = JobBuilder.newJob(QuartzJob01.class).withIdentity("Quartz1", "QuartzGroup1").build();

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
