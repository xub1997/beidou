package business;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//配置一个自定义的SessionFactory
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class SessionFactoryConfig {

    private static final Logger log = LoggerFactory.getLogger(SessionFactoryConfig.class);

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driver"));
        dataSource.setUrl(env.getProperty("database.url"));
        dataSource.setUsername(env.getProperty("database.root"));
        dataSource.setPassword(env.getProperty("database.password"));
        return dataSource;
    }

    @Bean(value = "pDataSource")
    public Object getPDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("database.driver"));
        dataSource.setUrl(env.getProperty("database.purl"));
        dataSource.setUsername(env.getProperty("database.root"));
        dataSource.setPassword(env.getProperty("database.password"));
        return dataSource;
    }


    /*
    @Bean
    public HibernateTemplate hibernateTemplate() {
        return new HibernateTemplate((SessionFactory) sessionFactory());
    }

    @Bean(name = "sessionFactory")
    public Object sessionFactory() {
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(getDataSource());
        lsfb.setHibernateProperties(hibernateProperties());
        try {
            lsfb.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lsfb.getObject();
    }

    public HibernateTransactionManager hibTransMan() {
        return new HibernateTransactionManager((SessionFactory) sessionFactory());
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        return properties;
    }
*/

}