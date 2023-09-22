// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ResultInfo.java

package cn.itcast.travel.domain;

import java.io.Serializable;

public class ResultInfo
    implements Serializable
{

    public ResultInfo()
    {
    }

    public ResultInfo(boolean flag)
    {
        this.flag = flag;
    }

    public ResultInfo(boolean flag, String errorMsg)
    {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public ResultInfo(boolean flag, Object data, String errorMsg)
    {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    private boolean flag;
    private Object data;
    private String errorMsg;
}
