package com.roc.SuperMaster.utility.quartzUtil;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author Roc
 * @Date 2021/8/6 13:25
 * @Version 1.0.0
 * @ClassName TestSpringTask.java
 * @Description TestSpringTask
 * @UpdateUser Roc
 */
@Slf4j
@RequestMapping("/TestSpringTask")
@RestController
@Api(tags = "用于测试实现定时任务的方法03")
public class TestSpringTask {

    /**
     * @Author: WP
     * @Date: 2021/8/6 11:52
     * @Version 1.0
     * @Description: 测试SpringTask
     * @UpdateUser WP
     * @param
     * @return void
     */
//    @Scheduled(cron = "0/2 * * * * ?")
    public void testSpringTask(){
        log.info("开始测试Spring Task");
        try{
            System.out.println("当前执行任务的时间：" + new Date());
        }catch (Exception e){
            e.printStackTrace();
            log.error("捕获异常信息：{}",e.getMessage());
        }
    }
}
