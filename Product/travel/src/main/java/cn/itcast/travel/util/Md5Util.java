// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Md5Util.java

package cn.itcast.travel.util;

import java.io.PrintStream;
import java.security.MessageDigest;

public final class Md5Util
{

    private Md5Util()
    {
    }

    public static String encodeByMd5(String password)
        throws Exception
    {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte byteArray[] = md5.digest(password.getBytes());
        return byteArrayToHexString(byteArray);
    }

    private static String byteArrayToHexString(byte byteArray[])
    {
        StringBuffer sb = new StringBuffer();
        byte abyte0[] = byteArray;
        int i = abyte0.length;
        for(int j = 0; j < i; j++)
        {
            byte b = abyte0[j];
            String hex = byteToHexString(b);
            sb.append(hex);
        }

        return sb.toString();
    }

    private static String byteToHexString(byte b)
    {
        int n = b;
        if(n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return (new StringBuilder()).append(hex[d1]).append(hex[d2]).toString();
    }

    public static void main(String args[])
        throws Exception
    {
        String password = "123456";
        String passwordMD5 = encodeByMd5(password);
        System.out.println(password);
        System.out.println(passwordMD5);
    }

    private static String hex[] = {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
        "a", "b", "c", "d", "e", "f"
    };

}
