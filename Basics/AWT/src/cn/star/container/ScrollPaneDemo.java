package cn.star.container;

import java.awt.*;

public class ScrollPaneDemo {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示ScrollPane");

        //创建ScrollPane对象
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        //添加文本框和按钮
        TextField text = new TextField("这是一个文本域");
        Button btn = new Button("这是一个按钮");

        //组装组件
        sp.add(text);
        sp.add(btn);
        frame.add(sp);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);

        //设置可见
        frame.setVisible(true);
    }
}
