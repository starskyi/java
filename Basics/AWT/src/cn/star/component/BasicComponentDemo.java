package cn.star.component;
import javax.swing.*;
import java.awt.*;

public class BasicComponentDemo {
    Frame frame = new Frame("这里测试基本组件");

    TextArea area  = new TextArea(4, 30);
    Choice choice = new Choice();

    CheckboxGroup group = new CheckboxGroup();
    Checkbox male = new Checkbox("男", group, true);
    Checkbox female = new Checkbox("女", group, false);
    Checkbox isMarried = new Checkbox("是否已婚？");

    List list = new List();

    TextField field = new TextField(30);
    Button sure_btn = new Button("确定");

    void init(){
        //组装底部
        Box bot_box = Box.createHorizontalBox();
        bot_box.add(field);
        bot_box.add(sure_btn);


        //组装上部
        choice.addItem("红色");
        choice.addItem("绿色");
        choice.addItem("蓝色");

        list.add("红色");
        list.add("绿色");
        list.add("蓝色");

        Box r_box = Box.createHorizontalBox();
        r_box.add(Box.createHorizontalGlue());
        r_box.add(choice);
        r_box.add(Box.createHorizontalStrut(10));
        r_box.add(male);
        r_box.add(female);
        r_box.add(isMarried);
        //r_box.add(Box.createHorizontalGlue());

        Box vBox1 = Box.createVerticalBox();
        vBox1.add(area);
        vBox1.add(r_box);

        Box hBox = Box.createHorizontalBox();
        hBox.add(vBox1);
        hBox.add(list);




        frame.add(hBox);
        frame.add(bot_box, BorderLayout.SOUTH);
        //设置窗口大小与可见
        //frame.setBounds(100,100,500,300);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){

        new BasicComponentDemo().init();
    }
}
