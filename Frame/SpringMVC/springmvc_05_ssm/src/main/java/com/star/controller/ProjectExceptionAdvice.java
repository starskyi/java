package com.star.controller;

import com.star.exception.BusinessException;
import com.star.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        //记录日志
        //通知运维人员
        //通知开发人员
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException e){
        //记录日志
        //通知运维人员
        //通知开发人员
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        //记录日志
        //通知运维人员
        //通知开发人员
        e.printStackTrace();
        return new Result(Code.UNKNOWN_ERR, null, "系统繁忙，请稍后再试");
    }
}
