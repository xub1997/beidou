package com.beidou.position.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.beidou.position.interceptor.SqlStatementInterceptor;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class MybatisConfig {

    @Autowired
    DruidBean druidProperties;


    /**
     * druid的数据源
     */
    private DruidDataSource dataSourceStrom() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() {
        return dataSourceStrom();
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    /*
     * 配置事务管理
     * */
    @Bean
    @Primary
    public DataSourceTransactionManager masterTransactionManager() throws SQLException { return new DataSourceTransactionManager(dataSource()); }

    /**
     * 配置 sql打印拦截器
     *
     * @return SqlStatementInterceptor
     */
    @Bean
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }

}
