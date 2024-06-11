package com.star.ui;

import com.star.component.CommodityPanel;
import com.star.component.GoodsPanel;
import com.star.dao.CommodityDao;
import com.star.domain.Commodity;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.ArrayList;
import java.util.List;

public class HomeUI extends Box {
    CommodityDao commodityDao = new CommodityDao();
    static int kind = 0;

    public HomeUI(@NotNull final List<Commodity> goods, int kind) {
        super(BoxLayout.X_AXIS);
        HomeUI.kind = kind;
        final JPanel panel = new JPanel();

        final JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1000, 2000));
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(30);

        verticalScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                int visibleAmount = adjustable.getVisibleAmount();
                int maxValue = adjustable.getMaximum();
                int value = adjustable.getValue();
                if(value + visibleAmount +  300 >= maxValue){
                    List<Commodity> newGoods = null;
                    if( HomeUI.kind == 0){
                        if(commodityDao.findAll1().size() == goods.size()){
                            return;
                        }

                        newGoods = commodityDao.findAll(goods.size());
                    }else{
                        if(commodityDao.selectAllByKind(HomeUI.kind).size() == goods.size()){
                            return;
                        }
                        newGoods = commodityDao.selectByKind(HomeUI.kind, goods.size());
                    }
                    goods.addAll(newGoods);
                    panel.setPreferredSize(new Dimension(1400, (goods.size()/2 + 1) * 315));
                    updatePanel(newGoods, panel);
                    scrollPane.revalidate();
                    scrollPane.repaint();
                }


            }
        });

        panel.setPreferredSize(new Dimension(1400, (goods.size()/2 + 1) * 300));
        updatePanel(goods, panel);

        add(scrollPane);

    }

    public void updatePanel(List<Commodity> goods, JPanel panel){
        for(Commodity commodity : goods){
            try{
                panel.add(new CommodityPanel(commodity));
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        panel.revalidate();
        panel.repaint();
    }
}
