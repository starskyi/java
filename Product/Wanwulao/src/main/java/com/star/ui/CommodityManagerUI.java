package com.star.ui;

import com.star.dao.CommodityDao;
import com.star.domain.Commodity;
import com.star.utils.CreateDataUtil;
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

public class CommodityManagerUI extends JDialog{

    int width = 1600;
    int height = 1000;

    JPanel btnPanel = new JPanel();

    JButton addBtn = new JButton("添加");
    JButton deleteBtn = new JButton("删除");


    JTable table;

    Vector<String> titles = new Vector<String>();
    Vector<Vector> data = new Vector<Vector>();

    DefaultTableModel model;

    CommodityDao commodityDao = new CommodityDao();
    public CommodityManagerUI(){

        addBtn.setFont(new Font(null, Font.BOLD, 22));
        deleteBtn.setFont(new Font(null, Font.BOLD, 22));
        btnPanel.setMaximumSize(new Dimension(width, 25));
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = JOptionPane.showConfirmDialog(jf, "是否删除");
                if(flag == 0){
                    //删除
                    String image = (String)table.getValueAt(table.getSelectedRow(), 1);
                    commodityDao.del(image);
                    model.removeRow(table.getSelectedRow());
                    model.fireTableDataChanged();
                }
            }
        });


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CommodityAddUI(data, model);
                model.fireTableDataChanged();
            }
        };
        List<Commodity> goods = commodityDao.findAll(0);
        CreateDataUtil.createData(data, goods);
        String[] ts = {"编号", "图片", "描述", "商家", "价格", "库存"};

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

        addBtn.addActionListener(listener);
        btnPanel.add(addBtn);
        btnPanel.add(deleteBtn);

        add(vBox);
        setBounds((ScreenUtil.getScreenWidth() - width)/2, (ScreenUtil.getScreenHeight() - height)/2, width, height);
        setVisible(true);
    }

}
