package cn.star.layout;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutDemo1 {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示BoxLayout");

        //创建BoxLayout对象
        //BoxLayout boxlayout = new BoxLayout(frame, BoxLayout.X_AXIS);
        BoxLayout boxlayout = new BoxLayout(frame, BoxLayout.Y_AXIS);

        frame.setLayout(boxlayout);

        //创建组件
        Button btn1 = new Button("按钮1");
        Button btn2 = new Button("按钮2");

        frame.add(btn1);
        frame.add(btn2);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);

        //设置可见
        frame.setVisible(true);
    }
}
