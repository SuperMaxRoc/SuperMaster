package com.roc.SuperMaster.config.dataSourceConfig;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName HCCReportDataSourceConfig
 * @Description HCCReportDataSourceConfig
 * @Author WangPeng
 * @date 2022/8/4 10:53
 * @Version 1.0
 */

@Slf4j
@Configuration
@MapperScan(basePackages = "com.haier.hcc.riskcontrolcenter.dao.hccReport",
        sqlSessionFactoryRef = "hccReportSqlSessionFactory"
)
public class HCCReportDataSourceConfig {

    //xml路径
    static final String MAPPER_LOCATION = "classpath:mybatis/mappers/hccReport/*.xml";
    //mybatis配置
    static final String MAPPER_CONFIG = "classpath:mybatis/mybatis-config.xml";

    @Value("${hccReport.datasource.url}")
    private String url;

    @Value("${hccReport.datasource.username}")
    private String username;

    @Value("${hccReport.datasource.password}")
    private String password;

    @Value("${hccReport.datasource.driverClassName}")
    private String driverClassName;

    @Value("${hccReport.datasource.initialSize}")
    private int initialSize;

    @Value("${hccReport.datasource.maxActive}")
    private int maxActive;

    @Value("${hccReport.datasource.maxWait}")
    private int maxWait;

    //@Value("${hccReport.datasource.slowSqlMillis}")
    //private int slowSqlMillis;


    @Bean(name = "hccReportDataSource")
    public DataSource hccReportDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);

        return dataSource;
    }

    @Bean(name = "hccReportTransactionManager")
    public DataSourceTransactionManager hccReportTransactionManager() {
        return new DataSourceTransactionManager(hccReportDataSource());
    }

    @Bean(name = "hccReportSqlSessionFactory")
    public SqlSessionFactory hccReportSqlSessionFactory(@Qualifier("hccReportDataSource") DataSource hccReportDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(hccReportDataSource);
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(HCCReportDataSourceConfig.MAPPER_CONFIG));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(HCCReportDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }


}
