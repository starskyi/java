package com.star.springboot03configfile.controller;

import com.star.springboot03configfile.service.HobbiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbiesController {

    @Autowired
    private HobbiesService hobbiesService;

    @RequestMapping("showhobbies")
    public String show(){
        return hobbiesService.showHobbies();
    }
}
