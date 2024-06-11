package com.star.service.impl;

import com.star.dao.AccountDao;
import com.star.dao.LogDao;
import com.star.service.AccountService;
import com.star.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Autowired
    private LogService logService;

    @Override
    public void transfer(String in, String out, Double money) throws IOException{
        try{
            accountDao.inMoney(in, money);
            //if(true)throw new IOException("error");
            //int a = 1/0;
            accountDao.outMoney(out, money);
        }finally{
            logService.log(in, out, money);
        }

    }
}
