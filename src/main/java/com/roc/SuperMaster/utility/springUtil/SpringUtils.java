package com.roc.SuperMaster.utility.springUtil;

import com.roc.SuperMaster.entity.serviceDomain.Guardian;
import com.roc.SuperMaster.entity.serviceDomain.Officer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StopWatch;

/**
 * @Author Roc
 * @Date 2021/8/16 13:54
 * @Version 1.0.0
 * @ClassName springUtils.java
 * @Description springUtils
 * @UpdateUser Roc
 */
@Slf4j
public class SpringUtils {

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/3 10:18
     * @Version 1.0
     * @Description: Spring计时器
     * @UpdateUser WP
     */
    @Test
    public void SpringStopWatchHandle() {
        try {
            //1.Task001
            StopWatch stopWatch = new StopWatch("SpringStopWatch001");
            stopWatch.start("计算for循环的时间");
            for (int i = 0; i < 1000; i++) {
            }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/7 16:08
     * @Description: BeanUtil
     */
    @Test
    public void beanUtil() {
        try {
            Guardian guardian = new Guardian();
            Officer officer001 = new Officer(1, true, guardian);
            Officer officer002 = new Officer(2, false, null);
            Officer officer003 = new Officer();
            Officer officer004 = officer001.clone();
            BeanUtils.copyProperties(officer001, officer003);
            System.out.println("officer001=officer002?:" + (officer001.equals(officer002)));
            System.out.println(officer003);
            System.out.println("officer003=officer001?:" + (officer003 == officer001));
            System.out.println("officer004=officer001?:" + (officer004 == officer001));
            System.out.println(officer001.getGuardian().hashCode());
            //System.out.println(officer003.getGuardian().hashCode());//空指针异常：并没有实际
            Officer officer005 = new Officer();
            System.out.println("------------------------");
            PropertyUtils.copyProperties(officer005, officer001);
            System.out.println(officer005);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
