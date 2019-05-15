package com.shipc.demo.test.base;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @ClassName TestConfig
 * @Description
 * @Author shipc
 * @Date 2019/5/9 19:21
 * @Version 1.0
 */
@Configuration
//@Transactional(value = "")  // 事务
public class TestConfig {

    @Autowired
    @Qualifier("myRoutingDataSource")
    private DataSource dataSource;

    /**
     * 初始化H2数据库
     */
    @Bean
    public InitializingBean initH2DataBase(){
        ClassPathResource initSql = new ClassPathResource("sql/sys_ddl.sql");
        ClassPathResource dataSql = new ClassPathResource("sql/sys_data_init.sql");

        DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDataSource(dataSource);
        dataSourceInitializer.setDatabasePopulator(new ResourceDatabasePopulator(false, true, "utf-8", initSql, dataSql));
        dataSourceInitializer.setEnabled(true);

        return dataSourceInitializer;
    }
}
