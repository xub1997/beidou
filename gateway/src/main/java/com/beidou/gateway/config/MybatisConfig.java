package com.beidou.gateway.config;



import com.alibaba.druid.pool.DruidDataSource;
import com.beidou.common.interceptor.SqlStatementInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




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

    /**
     * 配置 sql打印拦截器
     * application.yml中 febs.showsql: true 时生效
     *
     * @return SqlStatementInterceptor
     */
    @Bean
    SqlStatementInterceptor sqlStatementInterceptor() {
        return new SqlStatementInterceptor();
    }

}
