package com.star.ui;

import com.star.component.BuyPanel;
import com.star.component.MenuLabel;
import com.star.dao.RecordDao;
import com.star.domain.Record;
import com.star.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class MyUI extends Box {

    JLabel selected;

    JLabel all = new MenuLabel("全部");
    JLabel unpaid = new MenuLabel("待支付");
    JLabel waitForReceive = new MenuLabel("待收货");
    JLabel received = new MenuLabel("已收货");

    JScrollPane scrollPane;

    JPanel recordPanel;

    RecordDao recordDao = new RecordDao();

    User user;

    List<Record> records;
    public MyUI(User user1){
        super(BoxLayout.Y_AXIS);
        this.user = user1;

        setPreferredSize(new Dimension(1000, 500));

        Box menu = Box.createHorizontalBox();

        menu.setPreferredSize(new Dimension(1000, 100));

        selected = all;

        //顶部菜单条监听器
        MouseListener cmListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component component = e.getComponent();
                JLabel label = (JLabel) e.getComponent();
                selected = label;
                all.setBackground(null);
                unpaid.setBackground(null);
                waitForReceive.setBackground(null);
                received.setBackground(null);
                label.setOpaque(true);
                label.setBackground(new Color(60, 64, 198));

                //展示对应页面
                if(component == all){
                    //所有
                    recordPanel.removeAll();
                    records = recordDao.selectByUid(user.getId());
                    recordPanel.setPreferredSize(new Dimension(1200, (records.size() + 1) * 320));
                    addRecordToPanel(records);
                    recordPanel.updateUI();

                }else if(component == unpaid){
                    //未支付
                    updateUI(user.getId(), 1);

                }else if(component == waitForReceive){
                    //待收货
                    updateUI(user.getId(), 2);
                }else{
                    //已收货
                    updateUI(user.getId(), 3);
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

                if(selected != label){
                    label.setOpaque(false);
                    label.setBackground(null);
                }
            }
        };

        all.addMouseListener(cmListener);
        unpaid.addMouseListener(cmListener);
        waitForReceive.addMouseListener(cmListener);
        received.addMouseListener(cmListener);

        all.setOpaque(true);
        all.setBackground(new Color(60, 64, 198));


        menu.add(all);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(unpaid);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(waitForReceive);
        menu.add(Box.createHorizontalStrut(20));
        menu.add(received);

        add(menu);

        records = recordDao.selectByUid(user.getId());
        System.out.println(records);
        recordPanel = new JPanel();
        recordPanel.setPreferredSize(new Dimension(1200, (records.size() + 1) * 320));
        addRecordToPanel(records);

        scrollPane = new JScrollPane(recordPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1200, 800));
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(30);
        add(scrollPane);
    }

    public void updateUI(int uid, int status){
        recordPanel.removeAll();
        records = recordDao.selectByStatus(uid, status);
        recordPanel.setPreferredSize(new Dimension(1200, (records.size() + 1) * 320));
        addRecordToPanel(records);
        recordPanel.updateUI();
    }

    public void addRecordToPanel(List<Record> records){

        for(Record record : records){
            recordPanel.add(new BuyPanel(record, user));
        }

    }
}
