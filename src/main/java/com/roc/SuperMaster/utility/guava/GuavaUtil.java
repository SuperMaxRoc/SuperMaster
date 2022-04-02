package com.roc.SuperMaster.utility.guava;

import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.base.Joiner;
import com.roc.SuperMaster.utility.lambda.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Roc
 * @Date 2021/9/13 16:42
 * @Version 1.0.0
 * @ClassName GuavaUtil.java
 * @Description Google开源的“强大”的工具类
 * @UpdateUser Roc
 */
@Slf4j
public class GuavaUtil {


    @Test
    public void joiner() {
        List<String> stringList = new ArrayList<String>(Arrays.asList("1", "2"));
        System.out.println(Joiner.on(",").join(stringList));
        String string = String.join("1", stringList);

        List<User> users = new ArrayList<>();

        users.add(new User());
        users.add(new User());

        System.out.println(string);


        String sql = "";
        try {
            DruidDataSource druidDataSource = new DruidDataSource();
            int[] ints = new JdbcTemplate(druidDataSource).batchUpdate(sql, new BatchPreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement ps, int i) throws SQLException {

                }

                @Override
                public int getBatchSize() {
                    return 1000;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
