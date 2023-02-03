package com.roc.SuperMaster.utility.timeUtil;

import com.xkzhangsan.time.calculator.DateTimeCalculatorUtil;
import com.xkzhangsan.time.holiday.HolidayUtil;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @ClassName HolidayUtils
 * @Author: WangPeng
 * @Description 使用开源xk-time工具包
 * @date 2023/2/3 11:30
 * @Version 1.0.0
 */
public class HolidayUtils {

    @Test
    public void testXkTimeUtil() {
        List<Date> dateList = DateTimeCalculatorUtil.getDateList(2023, 01);
        System.out.println(dateList);
    }

}
