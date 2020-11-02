package com.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
//<context:property-placeholder location="classpath:druid.properties"></context:property-placeholder>
@PropertySource("classpath:druid.properties")
public class SpringDruidConfig {
    @Value("${username}")
    public  String username;
    @Value("${password}")
    public  String password;
    @Value("${url}")
    public  String url;
    @Value("${initialSize}")
    public  int initialSize;
    @Value("${maxActive}")
    public  int maxActive;
    @Value("${maxWait}")
    public  int maxWait;

    @Bean(name = "DataSource")
    public  DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        return druidDataSource;
    }
    @Bean(name = "JdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    @Bean(name = "NamedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
