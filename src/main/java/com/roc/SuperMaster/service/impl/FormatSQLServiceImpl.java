package com.roc.SuperMaster.service.impl;

import com.roc.SuperMaster.service.FormatSQLService;
import com.roc.SuperMaster.utility.webResult.ExecuteResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName FormatSQLServiceImpl
 * @Description TODO
 * @Author WangPeng
 * @date 2023/1/9 10:08
 * @Version 1.0
 */
@Service
@Slf4j
public class FormatSQLServiceImpl implements FormatSQLService {

    /**
     * @param preparingSQL
     * @param parameters
     * @return java.lang.String
     * @Author: WangPeng
     * @Date: 2023/1/9 10:12
     * @Description: 拼接SQL
     */
    @Override
    public ExecuteResult<String> formatSql(String preparingSQL, String parameters) {
        log.info("进入[拼接SQL]方法，待处理的SQL为{}，待处理的参数为：{}", preparingSQL, parameters);
        long startTime = System.currentTimeMillis();
        ExecuteResult<String> result = new ExecuteResult<>();
        String formatString = null;
        try {
            if (StringUtils.isBlank(preparingSQL) || StringUtils.isBlank(parameters)) {
                return ExecuteResult.fail("入参不可为空，请检查入参");
            }
            int countStr = countStr(preparingSQL, "?");
            String[] split = parameters.split(",");
            if (countStr != split.length) {
                return ExecuteResult.fail("待拼接参数坑位与萝卜数目不相符，请检查入参");
            }
            log.info("开始处理拼接~~~");
            LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(split));
            for (String item : linkedList) {
                String format = null;
                String s = null;
                if (item.contains("(String)")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    s = stringBuilder.append("'").append(item.replace("(String)", "")).append("'").toString();
                } else if (item.contains("(Integer)")) {
                    s = item.replace("(Integer)", "");
                } else if (item.contains("(Double)")) {
                    s = item.replace("(Double)", "");
                } else if (item.contains("(Boolean)")) {
                    s = item.replace("(Boolean)", "");
                } else {
                    int indexFirst = item.indexOf("(");
                    int indexLast = item.indexOf(")");
                    StringBuilder stringBuilder = new StringBuilder();
                    s = stringBuilder.append("'").append(item.substring(0, indexFirst)).append("'").toString();
                }
                format = s;
                preparingSQL = StringUtils.replaceOnce(preparingSQL, "?", format);
            }
            result.setData(preparingSQL);
            log.info("拼接处理完成~~~");
        } catch (Exception e) {
            log.error("[拼接SQL]方法执行失败", e);
            return ExecuteResult.fail("[拼接SQL]方法执行失败");
        }
        log.info("[拼接SQL]方法执行成功，耗时{}ms", (System.currentTimeMillis() - startTime));
        return result;
    }


    /**
     * @param longStr 长字符串
     * @param mixStr  子字符串
     * @return 包含个数
     */
    public static int countStr(String longStr, String mixStr) {
        //如果确定传入的字符串不为空，可以把下面这个判断去掉，提高执行效率
        //if(longStr == null || mixStr == null || "".equals(longStr.trim()) || "".equals(mixStr.trim()) ){
        //     return 0;
        //}
        int count = 0;
        int index = 0;
        while ((index = longStr.indexOf(mixStr, index)) != -1) {
            index = index + mixStr.length();
            count++;
        }
        return count;
    }
}
