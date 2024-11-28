package com.star.springboot03configfile.service;

public interface EmailService {

    boolean send(String to,String title,String content);

}
