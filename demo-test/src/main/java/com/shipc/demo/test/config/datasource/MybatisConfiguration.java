package com.shipc.demo.test.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @ClassName MybatisConfiguration
 * @Description
 * @Author shipc
 * @Date 2019/5/14 15:54
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = {}, sqlSessionFactoryRef = "sqlSessionFactory", sqlSessionTemplateRef = "sqlSessionTemplate")
public class MybatisConfiguration {

    @Autowired
    @Qualifier(value = "myRoutingDataSource")
    private DataSource routingDataSource;


    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sessionFactory() throws Exception{
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(this.routingDataSource);
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sessionFactory) {
        return new SqlSessionTemplate(sessionFactory);
    }
}
