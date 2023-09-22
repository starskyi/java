package cn.star.layout;

import java.awt.*;

public class GridLayoutDemo {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示GridLayout");
        Panel panel = new Panel();

        panel.setLayout(new GridLayout(3,5,4,4));
        for(int i = 0; i < 10; i++){
            panel.add(new Button(i + ""));
        }
        panel.add(new Button("+"));
        panel.add(new Button("-"));
        panel.add(new Button("*"));
        panel.add(new Button("\\"));
        panel.add(new Button("."));

        Panel panel1 = new Panel();
        panel1.add(new TextField(60));

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);

        //设置可见
        frame.setVisible(true);
    }
}
