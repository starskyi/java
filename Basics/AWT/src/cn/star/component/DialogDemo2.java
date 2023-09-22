package cn.star.component;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo2 {
    public static void main(String[] args){
        Frame frame = new Frame();

        //创建对话框
        Dialog d1 = new Dialog(frame, "模式对话框", true);
        d1.setBounds(100,100,300,200);


        //创建组件
        TextArea area = new TextArea(5,30);
        Button btn = new Button("确定");

        d1.add(area);
        d1.add(btn, BorderLayout.SOUTH);

        //创建按钮
        Button btn1 = new Button("模式对话框");


        //创建监听对象
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String cmd = e.getActionCommand();
                System.out.println(cmd);
                d1.setVisible(true);
            }
        };
        btn1.addActionListener(listener);


        frame.add(btn1);
        frame.setBounds(100,100,500,300);
        //frame.pack();
        frame.setVisible(true);
    }
}
