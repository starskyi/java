// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RouteService.java

package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService
{

    public abstract PageBean pageQuery(int i, int j, int k, String s);

    public abstract Route findOne(int i);
}
