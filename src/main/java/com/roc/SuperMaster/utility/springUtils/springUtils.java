package com.roc.SuperMaster.utility.springUtils;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @Author Roc
 * @Date 2021/8/16 13:54
 * @Version 1.0.0
 * @ClassName springUtils.java
 * @Description springUtils
 * @UpdateUser Roc
 */
@Api
@Slf4j
public class springUtils {

    @Test
    public void testSpringStopWatch(){
        try {
            //1.Task001
            StopWatch stopWatch = new StopWatch("SpringStopWatch001");
            stopWatch.start("计算for循环的时间");
            for (int i = 0; i < 1000; i++) {        }
            stopWatch.stop();
            //2.Task002
            stopWatch.start("起床");
            Thread.sleep(1000);
            stopWatch.stop();
            //3.Task003
            stopWatch.start("吃饭");
            Thread.sleep(2000);
            stopWatch.stop();

            System.out.println(stopWatch.prettyPrint());
            //总共执行时间
            System.out.println("总共执行时间:" + stopWatch.getTotalTimeMillis());

            //最后一条任务的Name
            System.out.println("最后一条任务的Name:" + stopWatch.getLastTaskName());

            //最后一条任务的Info
            System.out.println("最后一条任务的Name:" + stopWatch.getLastTaskInfo());

            //计算任务的总数
            System.out.println("任务的总数：" + stopWatch.getTaskCount());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
