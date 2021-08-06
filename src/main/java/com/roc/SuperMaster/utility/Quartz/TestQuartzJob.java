package com.roc.SuperMaster.utility.Quartz;

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
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("当前执行的时间戳：" + System.currentTimeMillis());
    }
}
