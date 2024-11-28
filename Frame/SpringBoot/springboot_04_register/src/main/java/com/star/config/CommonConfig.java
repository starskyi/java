package com.star.config;

import cn.itcast.pojo.Country;
import cn.itcast.pojo.Province;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    //如果配置文件中配置了指定的信息,则注入,否则不注入
    //@ConditionalOnProperty(prefix = "country",name = {"name","system"})
    @Bean
    public Country country(@Value("${country.name}")String name, @Value("${country.system}")String system) {
        Country country = new Country();
        country.setName(name);
        country.setSystem(system);
        return country;
    }

    //如果ioc容器中不存在Country,则注入Province,否则不注入
    //@ConditionalOnMissingBean(Country.class)

    //如果当前环境中存在DispatcherServlet类,则注入Province,否则不注入
    //如果当前引入了web起步依赖,则环境中有DispatcherServlet,否则没有
    //@ConditionalOnClass(name = "org.springframework.web.servlet.DispatcherServlet")

    //如果方法需要使用ioc容器中已有的对象，直接在方法上声明即可，spring会自动注入
    @Bean
    public Province province(Country country) {
        System.out.println("province:" + country);
        return new Province();
    }
}
