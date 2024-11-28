package com.star.springboot03configfile.service.impl;

import com.star.springboot03configfile.pojo.HobbiesProperties;
import com.star.springboot03configfile.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbiesServiceImpl implements HobbiesService {
    @Autowired
    private HobbiesProperties hobbiesProperties;

    @Override
    public String showHobbies() {
        return hobbiesProperties.toString();
    }
}
