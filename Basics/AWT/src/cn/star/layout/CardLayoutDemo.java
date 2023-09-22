package cn.star.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo {
    public static void main(String[] args){
        //创建windows 对象
        Frame frame = new Frame("这里演示CardLayout");

       //创建Panel对象,存放卡片对象
        Panel panel = new Panel();

        //创建CardLayout对象
        CardLayout cardlay = new CardLayout();

        panel.setLayout(cardlay);
        String[] names = {"第一张","第二张","第三张","第四张","第五张"};
        for(int i = 0; i < names.length; i++){
            panel.add(names[i], new Button(names[i]));
        }
        frame.add(panel);
        //创建另一个Panel对象,存放多个按钮组件
        Panel panel2 = new Panel();
        Button btn1 = new Button("第一张");
        Button btn2 = new Button("下一张");
        Button btn3 = new Button("上一张");
        Button btn4 = new Button("第四张");
        Button btn5 = new Button("最后一张");

        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String cmd = e.getActionCommand();
                switch(cmd){
                    case "第一张":
                        cardlay.first(panel);
                        break;
                    case "下一张":
                        cardlay.next(panel);
                        break;
                    case "上一张":
                        cardlay.previous(panel);
                        break;
                    case "第四张":

                        ((CardLayout)panel.getLayout()).show(panel, "第四张");
                        break;
                    case "最后一张":
                        cardlay.last(panel);
                        break;
                    default:
                        break;
                }
            }
        };

        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);
        btn4.addActionListener(listener);
        btn5.addActionListener(listener);

        panel2.add(btn1);
        panel2.add(btn2);
        panel2.add(btn3);
        panel2.add(btn4);
        panel2.add(btn5);


        frame.add(panel2, BorderLayout.SOUTH);

        //设置大小,位置
        frame.setBounds(100, 100, 500, 300);

        //设置可见
        frame.setVisible(true);
    }
}
