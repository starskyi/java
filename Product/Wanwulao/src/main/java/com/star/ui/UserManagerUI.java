package com.star.ui;

import com.star.dao.UserDao;
import com.star.domain.User;
import com.star.utils.ScreenUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static com.star.ui.MainInterface.jf;

public class UserManagerUI extends JDialog {

    int width = 1600;
    int height = 1000;

    JPanel btnPanel = new JPanel();

    JButton clientBtn = new JButton("普通用户管理");
    JButton merchantBtn = new JButton("商家用户管理");
    JButton deleteBtn = new JButton("删除");

    JTable table;

    Vector<String> titles = new Vector<String>();
    Vector<Vector> data = new Vector<Vector>();

    DefaultTableModel model;

    UserDao userDao = new UserDao();
    public UserManagerUI(){

        clientBtn.setFont(new Font(null, Font.BOLD, 22));
        merchantBtn.setFont(new Font(null, Font.BOLD, 22));
        deleteBtn.setFont(new Font(null, Font.BOLD, 22));
        btnPanel.setMaximumSize(new Dimension(width, 25));
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = JOptionPane.showConfirmDialog(jf, "是否删除");
                if(flag == 0){
                    //删除
                    String username = (String)table.getValueAt(table.getSelectedRow(), 3);
                    userDao.delUser(username);
                    model.removeRow(table.getSelectedRow());
                    model.fireTableDataChanged();
                }
            }
        });


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.clear();
                if(e.getActionCommand().equals("普通用户管理")){
                    List<User> users = userDao.findClient();
                    createData(users);

                }else{
                    List<User> users = userDao.findMerchant();
                    createData(users);
                }
                model.fireTableDataChanged();
            }
        };


        String[] ts = {"编号", "姓名", "性别", "账号", "密码", "余额"};

        titles.addAll(Arrays.asList(ts));


        model = new DefaultTableModel(data, titles);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setFont(new Font(null, Font.BOLD, 20));
        table.setRowHeight(30);
        table.setDefaultRenderer(Object.class, renderer);
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setPreferredSize(new Dimension(width, 40));
        tableHeader.setFont(new Font(null, Font.BOLD, 30));

        JScrollPane scrollPane = new JScrollPane(table);
        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(btnPanel);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(scrollPane);

        clientBtn.addActionListener(listener);
        merchantBtn.addActionListener(listener);
        btnPanel.add(clientBtn);
        btnPanel.add(merchantBtn);
        btnPanel.add(Box.createHorizontalStrut(1000));
        btnPanel.add(deleteBtn);

        add(vBox);
        setBounds((ScreenUtil.getScreenWidth() - width)/2, (ScreenUtil.getScreenHeight() - height)/2, width, height);
        setVisible(true);
    }

    public void createData(List<User> users){
        int i = 1;
        for(User user : users){
            Vector vector = new Vector();
            List<String> list = Arrays.asList(i + "", user.getName(), user.getSex(), user.getUsername(),
                    user.getPassword(), user.getMoney() + "");
            vector.addAll(list);
            data.add(vector);
            i++;
        }
    }
}
