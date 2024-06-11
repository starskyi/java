package com.star.ui;

import com.star.component.MenuLabel;
import com.star.dao.CommodityDao;
import com.star.domain.Commodity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ClassifyUI extends Box {

    CommodityDao commodityDao = new CommodityDao();

    JLabel cselected;

    JLabel phone = new MenuLabel("手机");
    JLabel computer = new MenuLabel("电脑");
    JLabel maleWear = new MenuLabel("男装");
    JLabel femaleWear = new MenuLabel("女装");
    JLabel food = new MenuLabel("美食");
    JLabel book = new MenuLabel("书籍");
    JLabel other = new MenuLabel("其他");


    List<Commodity> goods;

    JFrame jf = MainInterface.jf;

    HomeUI homeUI;
    public ClassifyUI(List<Commodity> goods1){
        super(BoxLayout.Y_AXIS);
        this.goods = goods1;
        setPreferredSize(new Dimension(1000, 500));
        Box menu = Box.createHorizontalBox();
        menu.setPreferredSize(new Dimension(2300, 100));

        cselected = phone;

        //顶部菜单条监听器
        MouseListener cmListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component component = e.getComponent();
                JLabel label = (JLabel) e.getComponent();
                cselected = label;
                phone.setBackground(null);
                computer.setBackground(null);
                maleWear.setBackground(null);
                femaleWear.setBackground(null);
                book.setBackground(null);
                food.setBackground(null);
                other.setBackground(null);
                label.setOpaque(true);
                label.setBackground(new Color(60, 64, 198));

                //展示对应页面
                if(component == phone){
                    //手机
                    update(1, 0);

                }else if(component == computer){
                    //电脑
                    update(2, 0);

                }else if(component == maleWear){
                    //男装
                    update(3, 0);

                }else if(component == femaleWear){
                    //女装
                    update(4, 0);

                }else if(component == food){
                    //美食
                    update(5, 0);

                }else if(component == book){
                    //书籍
                    update(6, 0);
                }else{
                    //家用
                    update(8, 0);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel label = (JLabel) e.getComponent();
                label.setOpaque(true);
                label.setBackground(new Color(60, 64, 198));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                JLabel label = (JLabel) e.getComponent();

                if(cselected != label){
                    label.setOpaque(false);
                    label.setBackground(null);
                }
            }
        };

        phone.addMouseListener(cmListener);
        computer.addMouseListener(cmListener);
        maleWear.addMouseListener(cmListener);
        femaleWear.addMouseListener(cmListener);
        food.addMouseListener(cmListener);
        book.addMouseListener(cmListener);
        other.addMouseListener(cmListener);

        phone.setOpaque(true);
        phone.setBackground(new Color(60, 64, 198));


        menu.add(phone);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(computer);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(maleWear);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(femaleWear);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(food);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(book);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(other);
        add(menu);

        homeUI = new HomeUI(goods, 1);
        add(homeUI);

    }


    public void update(int kind, int offset){
        remove(homeUI);
        goods = commodityDao.selectByKind(kind, offset);
        homeUI = new HomeUI(goods, kind);
        add(homeUI);
        revalidate();
        repaint();

    }
}
