package com.star.springboot04register;

import cn.itcast.pojo.Country;
import com.star.anno.EnableCommonConfig;
import com.star.config.ConmonImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableCommonConfig
public class springboot04registerApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(springboot04registerApplication.class, args);

        Country country = context.getBean(Country.class);
        System.out.println(country);

        System.out.println(context.getBean("province"));
    }
}