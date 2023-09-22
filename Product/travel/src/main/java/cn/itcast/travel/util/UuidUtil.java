// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UuidUtil.java

package cn.itcast.travel.util;

import java.io.PrintStream;
import java.util.UUID;

public final class UuidUtil
{

    private UuidUtil()
    {
    }

    public static String getUuid()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String args[])
    {
        System.out.println(getUuid());
        System.out.println(getUuid());
        System.out.println(getUuid());
        System.out.println(getUuid());
    }
}
