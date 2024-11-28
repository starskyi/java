package com.star.springboot03configfile.pojo;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "")
public class HobbiesProperties {
    public String[] hobbies;
}
