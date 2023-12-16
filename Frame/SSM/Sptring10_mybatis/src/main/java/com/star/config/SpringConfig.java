package com.star.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.star")
@PropertySource("classpath:db.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
public class SpringConfig {
}
