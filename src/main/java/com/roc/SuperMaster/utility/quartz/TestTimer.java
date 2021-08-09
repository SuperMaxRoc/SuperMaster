package com.roc.SuperMaster.utility.quartz;

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
@RequestMapping("/testTimer")
@Api(tags = "用于测试实现定时任务的方法01")
public class TestTimer {

    /**
     * @Author: Roc
     * @Date: 2021/8/6 9:42
     * @Version 1.0
     * @Description: 测试Timer类
     * @UpdateUser Roc
     * @param
     * @return void
     */
    @ApiOperation(value = "测试java的Timer")
    @GetMapping("/testTimer")
    public void testTimer() {
        log.info("开始测试java的Timer类");
        try{
            //新建定时任务1
            TimerTask timerTask1 = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("当前执行任务的时间：" + new Date());
                }
            };
            //新建定时任务2
            TimerTask timerTask2 = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("当前执行任务的时间戳：" + System.currentTimeMillis());
                }
            };
            //新建计时器
            Timer timer = new Timer();
            //新建计时器的执行任务1：延迟一秒，此后每一秒执行一次
            timer.schedule(timerTask1,1000,1000);
            //新建计时器的执行任务2：延迟一秒，此后每一秒执行一次
            timer.schedule(timerTask2,2000,3000);

            //timer配置一个定时任务队列的方法
            //在时刻 time 处执行任务
            //schedule(TimerTask task, Date time)

            //延时 delay 毫秒后执行任务
            //schedule(TimerTask task, long delay)

            //固定延时重复执行，firstTime为首次执行时间，
            //往后没间隔 period 毫秒执行一次
            //schedule(TimerTask task, Date firstTime, long period)

            //固定延时重复执行
            //首次执行时间为当前时间延时 delay 毫秒
            //schedule(TimerTask task, long delay, long period)

            //固定频率重复执行，每过 period 毫秒执行一次
            //scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
            //固定频率重复执行
            //scheduleAtFixedRate(TimerTask task, long delay, long period)

            //清空定时任务1
            timerTask1.cancel();

            //清空队列的中的全部任务
            //timer.cancel();
        }catch (Exception e){
            e.printStackTrace();
            log.error("捕获异常信息：{}",e.getMessage());
        }
    }
}
