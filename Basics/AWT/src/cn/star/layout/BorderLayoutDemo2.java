package cn.star.layout;

import java.awt.*;

public class BorderLayoutDemo2 {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示BorderLayout");

        frame.setLayout(new BorderLayout());

        frame.add(new Button("北方"), BorderLayout.NORTH);
        frame.add(new Button("南方"), BorderLayout.SOUTH);


        Panel p = new Panel();
        p.add(new Button("中间"));
        p.add(new TextField("这是一个文本域"));

        frame.add(p);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);

        //设置可见
        frame.setVisible(true);
    }
}
