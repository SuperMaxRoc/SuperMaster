package com.roc.SuperMaster.utility.javaLang;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @ClassName ExceptionUtils
 * @Description 异常处理
 * @Author WangPeng
 * @date 2022/4/19 10:01
 * @Version 1.0
 */
@Slf4j
public class ExceptionUtils {

    /**
     * 自定义异常~~
     */

    /**
     * 统一异常捕获处理~~~
     */

    /**
     * 打印异常
     *
     * 使用日志门面框架打印（其中包括第三方工具类，例如HuTool）
     * 统一异常捕获，然后处理异常
     */

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/19 10:04
     * @Description: 合理有效可以高速搜索的异常打印机制
     */
    @Test
    public void testExceptionPrint() {

        try {
            //万能的1/0
            System.out.println(1 / 0);
        } catch (Exception e) {
            //异常类型，异常信息，堆栈信息
            e.printStackTrace();

            ////有异常信息
            //log.error(e.getMessage());

            ////有异常信息，无异常类型和堆栈信息
            //log.error("errorMsg:"+ e.getMessage());

            ////有异常类型和异常信息，无堆栈信息
            //log.error("errorMsg:" + e);

            //////有异常类型，异常信息，堆栈信息
            //log.error("errorMsg:", e);

            ////异常类型，异常信息，堆栈信息
            //log.error("errorMsg:" + ExceptionUtil.stacktraceToString(e));
        }

    }

}
