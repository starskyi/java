// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MailUtils.java

package cn.itcast.travel.util;

import java.io.PrintStream;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public final class MailUtils
{

    public MailUtils()
    {
    }

    public static boolean sendMail(String to, String text, String title){
        try {
            final Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.qq.com");

            // 发件人的账号
            props.put("mail.user", USER);
            //发件人的密码
            props.put("mail.password", PASSWORD);

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            String username = props.getProperty("mail.user");
            InternetAddress form = new InternetAddress(username);
            message.setFrom(form);

            // 设置收件人
            InternetAddress toAddress = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAddress);

            // 设置邮件标题
            message.setSubject(title);

            // 设置邮件的内容体
            message.setContent(text, "text/html;charset=UTF-8");
            // 发送邮件
            Transport.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String args[])
        throws Exception
    {
        sendMail("3161686754@qq.com", "\u4F60\u597D\uFF0C\u8FD9\u662F\u4E00\u5C01\u6D4B\u8BD5\u90AE\u4EF6\uFF0C\u65E0\u9700\u56DE\u590D\u3002", "\u6D4B\u8BD5\u90AE\u4EF6");
        System.out.println("\u53D1\u9001\u6210\u529F");
    }

    private static final String USER = "3161686754@qq.com";
    private static final String PASSWORD = "rcctrdtcbkwydfce";
}
