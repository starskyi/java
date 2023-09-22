// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FavoriteService.java

package cn.itcast.travel.service;


public interface FavoriteService
{

    public abstract boolean isFavorite(String s, int i);

    public abstract boolean addFavorite(String s, int i);
}
