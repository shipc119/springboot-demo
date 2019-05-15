package com.shipc.demo.test.config.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DataSourceConfiguration
 * @Description 数据源配置
 * @Author shipc
 * @Date 2019/5/10 9:13
 * @Version 1.0
 */
@Configuration
public class DataSourceConfiguration {

    /**
     * 数据源的配置：主备分离
     */


    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.slave1")
    public DataSource slaveDataSource_1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.slave2")
    public DataSource slaveDataSource_2() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "myRoutingDataSource")
    public DataSource routingDataSource() {
        return new MyRoutingDataSource(masterDataSource(), slaveDataSources());
    }

    @Bean(name = "slaveDataSources")
    public List<DataSource> slaveDataSources() {
        List<DataSource> list = new ArrayList<>();
        list.add(slaveDataSource_1());
        list.add(slaveDataSource_2());
        return list;
    }

}
