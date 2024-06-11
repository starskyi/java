package com.star.ui;

import com.star.component.MyLabel;
import com.star.component.MyTextField;
import com.star.dao.CommodityDao;
import com.star.domain.Commodity;
import com.star.utils.CreateDataUtil;
import com.star.utils.ScreenUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import java.util.Vector;

import static com.star.ui.MainInterface.jf;

public class CommodityAddUI extends JDialog {

    int width = 1100;
    int height = 900;


    JLabel imgL = new MyLabel("图片：");;
    JTextField imgT = new MyTextField("点击获取图片", 20);;
    FileDialog file = new FileDialog(jf);

    JLabel shopL = new MyLabel("商家：");
    JTextField shopT = new MyTextField(20);

    JLabel priceL = new MyLabel("价格：");
    JTextField priceT = new MyTextField(20);

    JLabel kindL = new MyLabel("类型：");
    JTextField kindT = new MyTextField(20);

    JLabel repositoryL = new MyLabel("库存：");
    JTextField repositoryT = new MyTextField(20);

    JLabel describeL = new MyLabel("标题：");
    JTextArea describeT = new JTextArea(10, 20);

    JButton addBtn = new JButton("添加");

    CommodityDao commodityDao = new CommodityDao();
    public CommodityAddUI(final Vector<Vector> data, final DefaultTableModel model){

        file.setVisible(false);
        Box imgBox = Box.createHorizontalBox();
        imgT.setEditable(false);
        imgT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                file.setVisible(true);
                String text = file.getFile();
                if(text != null){
                    int i = text.lastIndexOf(".");
                    String type = text.substring(i+1);
                    if(type.equalsIgnoreCase("jpg") || type.equalsIgnoreCase("jpeg") ||
                            type.equalsIgnoreCase("png") || type.equalsIgnoreCase("gif") ||
                            type.equalsIgnoreCase("bmp")){
                        imgT.setText((file.getDirectory() + text).replace("\\", "/"));
                    }else{
                        JOptionPane.showMessageDialog(jf, "请选择图片");
                    }

                }
            }
        });

        imgBox.add(imgL);
        imgBox.add(imgT);

        Box shopBox = Box.createHorizontalBox();
        shopBox.add(shopL);
        imgBox.add(Box.createHorizontalStrut(20));
        shopBox.add(shopT);

        Box priceBox = Box.createHorizontalBox();
        priceBox.add(priceL);
        imgBox.add(Box.createHorizontalStrut(20));
        priceBox.add(priceT);


        Box kindBox = Box.createHorizontalBox();
        kindT.setText("请输入(1-7):(1:手机, 2:电脑, 3:男装, 4:女装, 5:美食, 6:书籍, 7:其他)");
        kindT.setForeground(Color.GRAY);
        kindT.setFont(new Font(null, Font.BOLD, 15));
        kindT.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(kindT.getText().equals("请输入(1-7):(1:手机, 2:电脑, 3:男装, 4:女装, 5:美食, 6:书籍, 7:其他)")){
                    kindT.setForeground(null);
                    kindT.setFont(new Font(null, Font.BOLD, 30));
                    kindT.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(kindT.getText().replace(" ", "").length() <= 0){
                    kindT.setForeground(Color.GRAY);
                    kindT.setText("请输入(1-7):(1:手机, 2:电脑, 3:男装, 4:女装, 5:美食, 6:书籍, 7:其他)");
                }
            }
        });
        kindBox.add(kindL);
        kindBox.add(kindT);

        Box repositoryBox = Box.createHorizontalBox();
        repositoryBox.add(repositoryL);
        imgBox.add(Box.createHorizontalStrut(20));
        repositoryBox.add(repositoryT);

        Box describeBox = Box.createHorizontalBox();
        Box vBox2 = Box.createVerticalBox();
        vBox2.add(describeL);
        vBox2.add(Box.createVerticalStrut(400));
        describeT.setFont(new Font(null, Font.BOLD, 20));
        describeBox.add(vBox2);
        imgBox.add(Box.createHorizontalStrut(20));
        describeBox.add(describeT);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Commodity commodity = new Commodity();
                String shop = shopT.getText();
                String image = imgT.getText();
                String title = describeT.getText();
                try{
                    Integer kind = Integer.parseInt(kindT.getText());
                    Double price = Double.parseDouble(priceT.getText());
                    Integer repertory = Integer.parseInt(repositoryT.getText());
                    commodityDao.add(new Commodity(null, image, title, price, 0, repertory, shop, kind));


                    JOptionPane.showMessageDialog(jf, "添加成功");
                    data.clear();
                    CreateDataUtil.createData(data, commodityDao.findAll1());
                    model.fireTableDataChanged();
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(jf, "不好意思， 您的格式有误");
                }

            }
        });

        Box btnBox = Box.createHorizontalBox();
        btnBox.add(addBtn);

        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(imgBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(shopBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(priceBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(kindBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(repositoryBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(describeBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(btnBox);


        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));

        panel.add(vBox);
        add(panel);


        setBounds((ScreenUtil.getScreenWidth() - width)/2, (ScreenUtil.getScreenHeight() - height)/2, width, height);
        setVisible(true);
    }
}
