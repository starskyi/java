package com.star.service.impl;

import com.star.dao.LogDao;
import com.star.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public void log(String in, String out, Double money) {
        logDao.log(out + "向" + in + "转了" + money);
    }
}
