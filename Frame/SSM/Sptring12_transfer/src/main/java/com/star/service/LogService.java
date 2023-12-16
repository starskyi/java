package com.star.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface LogService {
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void log(String in, String out, Double money);
}
