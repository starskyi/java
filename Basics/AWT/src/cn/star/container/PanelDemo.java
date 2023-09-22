package cn.star.container;

import java.awt.*;

public class PanelDemo {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示Panel");

        //创建Panel对象
        Panel panel = new Panel();

        //添加文本框和按钮
        TextField text = new TextField("这是一个文本域");
        Button btn = new Button("这是一个按钮");

        //组装组件
        panel.add(text);
        panel.add(btn);
        frame.add(panel);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);

        //设置可见
        frame.setVisible(true);
    }
}
