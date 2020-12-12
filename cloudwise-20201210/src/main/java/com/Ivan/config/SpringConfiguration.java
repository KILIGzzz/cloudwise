package com.Ivan.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author ：IvanZ
 * @version : 1.0
 * @date ：Created on 2020/12/10 16:55
 * @description ：JDBC配置类
 * @modified By：
 */
@Configuration
@ComponentScan("com.Ivan")
@PropertySource("classpath:jdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfiguration {
    @Value("jdbc.driver")
    private String driver;
    @Value("jdbc.url")
    private String url;
    @Value("jdbc.username")
    private String username;
    @Value("jdbc.password")
    private String password;

    @Bean("template")
    @Scope("prototype")
    public JdbcTemplate createQueryRunner(@Qualifier("dataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        try {
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
