package com.star.domain;

public class Mail {
    private Integer id;
    private String sendname;
    private String receivename;
    private String theme;
    private String context;
    private String date;
    private int status;

    public Mail(){

    }

    public Mail(Integer id, String sendname, String receivename, String theme, String context, String date, int status) {
        this.id = id;
        this.sendname = sendname;
        this.receivename = receivename;
        this.theme = theme;
        this.context = context;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendname() {
        return sendname;
    }

    public void setSendname(String sendname) {
        this.sendname = sendname;
    }

    public String getReceivename() {
        return receivename;
    }

    public void setReceivename(String receivename) {
        this.receivename = receivename;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", sendname='" + sendname + '\'' +
                ", receivename='" + receivename + '\'' +
                ", theme='" + theme + '\'' +
                ", context='" + context + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                '}';
    }
}
