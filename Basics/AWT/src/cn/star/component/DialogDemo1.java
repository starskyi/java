package cn.star.component;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo1 {
    public static void main(String[] args){
        Frame frame = new Frame();

        //创建对话框
        Dialog d1 = new Dialog(frame, "模式对话框", true);
        Dialog d2 = new Dialog(frame, "非模式对话框", false);
        d1.setBounds(20,30,100,100);
        d2.setBounds(20,30,100,100);

        //创建按钮
        Button btn1 = new Button("模式对话框");
        Button btn2 = new Button("非模式对话框");

        //创建监听对象
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String cmd = e.getActionCommand();
                System.out.println(cmd);
                if(cmd.equals("模式对话框")) {
                    d1.setVisible(true);
                }else{
                    d2.setVisible(true);
                }
            }
        };
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);

        frame.add(btn1, BorderLayout.NORTH);
        frame.add(btn2);
        frame.setBounds(100,100,500,300);
        //frame.pack();
        frame.setVisible(true);
    }
}
