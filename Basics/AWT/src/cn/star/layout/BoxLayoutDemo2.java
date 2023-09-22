package cn.star.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo2 {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示BoxLayout");

        //创建Box容器
        Box hBox = Box.createHorizontalBox();
        Box vBox = Box.createVerticalBox();

        Button btn1 = new Button("按钮1");
        Button btn2 = new Button("按钮2");
        Button btn3 = new Button("按钮3");
        Button btn4 = new Button("按钮4");
        Button btn5 = new Button("按钮5");

        hBox.add(btn1);
        hBox.add(btn2);

        vBox.add(btn3);
        vBox.add(btn4);
        vBox.add(btn5);

        frame.add(hBox, BorderLayout.NORTH);
        frame.add(vBox);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);

        //设置可见
        frame.setVisible(true);
    }
}
