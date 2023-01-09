package com.roc.SuperMaster.service;

import com.roc.SuperMaster.utility.webResult.ExecuteResult;

/**
 * @ClassName FormatSQLService
 * @Description TODO
 * @Author WangPeng
 * @date 2023/1/9 10:08
 * @Version 1.0
 */
public interface FormatSQLService {

    /**
     * @param preparingSQL
     * @param parameters
     * @return java.lang.String
     * @Author: WangPeng
     * @Date: 2023/1/9 10:12
     * @Description: 拼接SQL
     */
    ExecuteResult<String> formatSql(String preparingSQL, String parameters);

}
