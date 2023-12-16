package com.star.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({"classpath:jdbc.properties"})
@Import({JdbcConfig.class, MybatisConfig.class})
@ComponentScan({"com.star.service"})
@EnableTransactionManagement
public class SpringConfig {
}
