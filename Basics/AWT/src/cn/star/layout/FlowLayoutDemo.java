package cn.star.layout;

import java.awt.*;

public class FlowLayoutDemo {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示FlowLayout");

        //创建ScrollPane对象
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);

        //添加按钮
        for(int i = 0; i < 100; i++){
            frame.add(new Button("按钮" + i));
        }

        //组装组件

        //frame.add(sp);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        //设置可见
        frame.setVisible(true);
    }
}
