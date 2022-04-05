package com.roc.SuperMaster.utility.jdbcUtil;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.roc.SuperMaster.entity.domain.Students;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName JDBCUtil
 * @Description TODO
 * @Author Roc
 * @date 2022/4/5 10:57
 * @Version 1.0
 */

@Slf4j
@RequestMapping("/JdbcTemplate")
@RestController
@Api(tags = "Spring-JDBCTemplate")
public class JDBCUtil {

    //使用注解注入属性
    @Value("${spring.datasource.url}")
    private String databaseUrl;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    /**
     * @param
     * @return void
     * @Author: WangPeng
     * @Date: 2022/4/5 10:58
     * @Description: ToDo
     */
    @GetMapping("/queryOne")
    public void testJdbc() {
        try {

            //1.构造数据源
            //1.使用Druid创建数据源（不必在当前系统中配置Druid）
            DruidDataSource druidDataSource = new DruidDataSource() {
                {
                    setUrl(databaseUrl);
                    setDriverClassName(driverClassName);
                    //setUrl("jdbc:mysql://localhost:3306/school?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true&serverTimezone=GMT%2B8");
                    //setUsername("root");
                    //setPassword("123456");
                    //setDriverClassName("com.mysql.cj.jdbc.Driver");
                }
            };
            druidDataSource.setPassword(password);
            druidDataSource.setUsername(userName);

            //1.使用DBCP创建数据源
            BasicDataSource dbcpDataSource = new BasicDataSource() {
                {
                    setUrl(databaseUrl);
                    setUsername("root");
                    setPassword("123456");
                    setDriverClassName("com.mysql.cj.jdbc.Driver");
                }
            };

            //1.使用C3P0创建数据源
            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

            comboPooledDataSource.setJdbcUrl(databaseUrl);
            comboPooledDataSource.setUser(userName);
            comboPooledDataSource.setPassword(password);
            comboPooledDataSource.setDriverClass(driverClassName);

            //2.建立使用模板建立JDBC链接
            JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource);

            //3.构建固定SQL
            String sql = "select * from students";

            //4.构建返回体接受返回值
            BeanPropertyRowMapper<Students> rowMapper = new BeanPropertyRowMapper<>(Students.class);

            //5.使用JDBC执行
            List<Students> query = jdbcTemplate.query(sql, rowMapper);

            //6.循环打印
            query.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
