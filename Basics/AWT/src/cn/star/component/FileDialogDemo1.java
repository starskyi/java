package cn.star.component;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialogDemo1 {
    public static void main(String[] args){
        Frame frame = new Frame();

        FileDialog open = new FileDialog(frame, "选择要打开的文件", FileDialog.LOAD);
        FileDialog save = new FileDialog(frame, "选择要保存的文件", FileDialog.SAVE);

        //创建按钮
        Button btn1 = new Button("打开文件");
        Button btn2 = new Button("保存文件");

        //创建监听对象
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if(cmd.equals("打开文件")){
                    open.setVisible(true);
                    String directory = open.getDirectory();
                    String file = open.getFile();
                    System.out.println("文件打开路径为:" + directory);
                    System.out.println("文件名为:" + file);
                }else{
                    save.setVisible(true);
                    String directory = save.getDirectory();
                    String file = save.getFile();
                    System.out.println("文件保存路径为:" + directory);
                    System.out.println("文件名为:" + file);
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
