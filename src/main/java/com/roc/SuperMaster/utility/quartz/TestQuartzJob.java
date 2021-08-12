package com.roc.SuperMaster.utility.quartz;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * @Author Roc
 * @Date 2021/8/6 13:30
 * @Version 1.0.0
 * @ClassName TestQuartzJob.java
 * @Description 创建Quartz的Job
 * @UpdateUser Roc
 */
@Slf4j
@Api
@Component
public class TestQuartzJob implements Job {
    //使用Quartz的第一步
    //创建用于执行的job，相当于Timer的task
    /**
     * @Author: WP
     * @Date: 2021/8/9 22:32
     * @Version 1.0
     * @Description: 实现Job的execute方法
     * @UpdateUser WP
     * @param jobExecutionContext 
     * @return void
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("当前执行的时间戳：" + System.currentTimeMillis());
    }
}