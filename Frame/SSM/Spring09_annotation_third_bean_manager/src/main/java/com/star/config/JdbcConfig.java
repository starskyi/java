package com.star.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    @Bean
    public DataSource getDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
        ds.setName("root");
        ds.setPassword("root");
        return ds;
    }

}
