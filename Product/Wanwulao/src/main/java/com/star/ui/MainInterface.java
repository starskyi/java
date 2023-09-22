package com.star.ui;

import com.star.component.*;
import com.star.dao.AdminDao;
import com.star.dao.CommodityDao;
import com.star.dao.UserDao;
import com.star.domain.User;
import com.star.utils.ImageIoUtil;
import com.star.utils.ScreenUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;


public class MainInterface {
    public static SqlSession sqlSession;
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    public static JFrame jf = new JFrame("万物捞");

    //数据库访问对象
    CommodityDao commodityDao = new CommodityDao();


    int width = 2000;
    int height = 1200;

    JLabel selected;


    //当前用户
    //public static User user = new User(1, "zhangsan", "123456", "张三", "18534658", 0, "男", "三峡", 10000.0);
    public static User user;
    public static JLabel username;
    public static JLabel money;

    //菜单栏
    JLabel home = new MenuLabel("首页");
    JLabel recommend = new MenuLabel("推荐");
    JLabel classify = new MenuLabel("分类");
    JLabel message = new MenuLabel("消息");
    JLabel my = new MenuLabel("我的");

    //左侧菜单
    JButton userManage = new BestButton("用户管理", "userManage");
    JButton goodsManage = new BestButton("商品管理", "goodsMnage");
    JButton set = new BestButton("设置", "set");

    //设置菜单
    JPopupMenu setMenu = new JPopupMenu();
    JMenu  theme = new JMenu("主题");
    JMenuItem login;


    //商品展示容器
    JPanel panel = new JPanel();
    Box scrollBox;

    //商品搜搜框
    JTextField input;
    JButton searchBtn = new JButton("搜索");

    Box bigBox;
    Box leftBox;

    public void init() throws IOException {
        jf.setBounds((ScreenUtil.getScreenWidth() - width) / 2, (ScreenUtil.getScreenHeight() - height) / 2,
                width, height);
        jf.setIconImage(ImageIoUtil.read("img/logo.jpg"));

        panel.setPreferredSize(new Dimension(1000, 800));

        final Box searchBox = Box.createHorizontalBox();
        searchBox.setMinimumSize(new Dimension(3000, 60));
        searchBox.setMaximumSize(new Dimension(3000, 70));
        //搜索框
        JPanel p = new JPanel();
        p.setMinimumSize(new Dimension(2000, 60));

        input = new JTextField(20);


        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeUI homeUi = new HomeUI(commodityDao.selectByTitle("%" + input.getText() + "%"));
                updateUI(homeUi);
            }
        });
        searchBtn.setFont(new Font(null, Font.BOLD, 20));
        input.setFont(new Font(null, Font.BOLD, 30));
        input.setForeground(Color.GRAY);
        input.setText("请输入商品名称");

        //输入框添加焦点事件
        input.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("请输入商品名称")) {
                    input.setForeground(null);
                    input.setText("");
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(input.getText().equals("") || input.getText().replace(" ", "").length() <= 0){
                    input.setForeground(Color.GRAY);
                    input.setText("请输入商品名称");
                }
            }
        });

        //登录，注册
        JPanel p2 = new JPanel();
        JLabel loginL = new JLabel("登录");
        final JLabel registerL = new JLabel("注册");
        loginL.setFont(new Font(null, Font.BOLD, 30));
        registerL.setFont(new Font(null, Font.BOLD, 30));

        p.add(input);
        p.add(searchBtn);
        p2.add(loginL);
        p2.add(Box.createHorizontalStrut(30));
        p2.add(registerL);

        searchBox.add(p);
        searchBox.add(p2);

        selected = home;
        home.setOpaque(true);
        home.setBackground(new Color(60, 64, 198));


        Box topBox = Box.createHorizontalBox();
        topBox.setMaximumSize(new Dimension(3000, 100));
        topBox.add(Box.createHorizontalStrut(30));
        topBox.add(home);
        topBox.add(Box.createHorizontalStrut(40));
        topBox.add(recommend);
        topBox.add(Box.createHorizontalStrut(40));
        topBox.add(classify);
        topBox.add(Box.createHorizontalStrut(40));
        topBox.add(message);
        topBox.add(Box.createHorizontalStrut(40));
        topBox.add(my);
        topBox.setOpaque(true);
        topBox.setBackground(new Color(0, 206, 201));



        //登录注册监听器
        MouseListener mListener2 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //展示对应页面
                if(e.getComponent() == registerL){
                    //注册
                    new RegisterUI();
                }else{
                    //登录
                    new LoginUI();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel label = (JLabel) e.getComponent();
                label.setOpaque(true);
                label.setBackground(new Color(69, 238, 242));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel label = (JLabel) e.getComponent();
                label.setOpaque(false);
                label.setBackground(null);
            }
        };

        //顶部菜单条监听器
        MouseListener mListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component component = e.getComponent();
                JLabel label = (JLabel) e.getComponent();
                selected = label;
                home.setBackground(null);
                recommend.setBackground(null);
                classify.setBackground(null);
                message.setBackground(null);
                my.setBackground(null);
                label.setOpaque(true);
                label.setBackground(new Color(60, 64, 198));

                //展示对应页面
                if(component == home){
                    //首页
                    HomeUI homeUi = new HomeUI(commodityDao.findAll());
                    updateUI(homeUi);

                }else if(component == recommend){
                    //推荐
                    HomeUI recommendUi = new HomeUI(commodityDao.selectByCount());
                    updateUI(recommendUi);

                }else if(component == classify){
                    //分类
                    ClassifyUI classifyUI = new ClassifyUI(commodityDao.selectByKind(1));
                    updateUI(classifyUI);

                }else if(component == message){
                    //信息
                    JOptionPane.showMessageDialog(jf, "暂无消息");
                }else{
                    //我的
                    if(user != null){
                        MyUI myUI = new MyUI(user);
                        updateUI(myUI);
                    }else{
                        JOptionPane.showMessageDialog(jf, "您还没登录，请登录");
                    }

                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                jf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                JLabel label = (JLabel) e.getComponent();
                label.setOpaque(true);
                label.setBackground(new Color(60, 64, 198));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                jf.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                JLabel label = (JLabel) e.getComponent();

                if(selected != label){
                    label.setOpaque(false);
                    label.setBackground(null);
                }

            }
        };



        //设置按钮监听器
        ActionListener setListener = new ActionListener() {
            public void actionPerformed(ActionEvent e){
                setMenu.show(jf, 130, 1000);
            }
        };

        //登录按钮监听器
        final MouseListener loginLitener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(login.getText().equals("登录")){

                    new LoginUI();
                    login.setText("退出登录");
                    login.repaint();
                }else{
                    user = null;
                    username.setText("用户：无");
                    login.setText("登录");
                    login.repaint();
                }

            }
        };
        loginL.addMouseListener(mListener2);
        registerL.addMouseListener(mListener2);

        home.addMouseListener(mListener);
        recommend.addMouseListener(mListener);
        classify.addMouseListener(mListener);
        message.addMouseListener(mListener);
        my.addMouseListener(mListener);

        //商品展示容器


        scrollBox = Box.createHorizontalBox();
        scrollBox.add(new HomeUI(commodityDao.findAll()));


        bigBox = Box.createVerticalBox();

        bigBox.add(searchBox);
        bigBox.add(topBox);

        bigBox.add(scrollBox);

        //左侧容器
        JPanel headPanel = new JPanel();
        //头像
        HeadImage image = new HeadImage("img/logo.jpg", 60, jf);
        headPanel.add(image);
        username = new JLabel("用户：无");
        money = new JLabel("余额：无");
        username.setFont(new Font(null, Font.BOLD, 25));
        money.setFont(new Font(null, Font.BOLD, 25));


        headPanel.add(username);
        headPanel.add(money);


        //左侧菜单组装
        Box leftMenu = new BestBox(BoxLayout.Y_AXIS, 600, 300);
        set.addActionListener(setListener);


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(user == null){
                    JOptionPane.showMessageDialog(jf, "请登录");
                }else{
                    if(e.getActionCommand().equals("用户管理")){

                        new AdminLoginUI(userManage);
                    }else{
                        new AdminLoginUI(goodsManage);
                    }
                }

            }
        };
        userManage.addActionListener(listener);
        goodsManage.addActionListener(listener);


        leftMenu.add(userManage);
        leftMenu.add(Box.createVerticalStrut(20));
        leftMenu.add(goodsManage);
        leftMenu.add(Box.createVerticalStrut(20));
        leftMenu.add(set);
        leftMenu.add(Box.createVerticalStrut(100));

        //设置菜单组装

        setMenu.setPopupSize(new Dimension(200, 100));
        setMenu.add(theme);
        theme.setFont(new Font(null, Font.BOLD, 30));

        login = new JMenuItem("登录");
        login.addMouseListener(loginLitener);
        login.setFont(new Font(null, Font.BOLD, 30));
        setMenu.add(login);


        leftBox = Box.createVerticalBox();
        leftBox.setPreferredSize(new Dimension(100, 200));
        leftBox.setMinimumSize(new Dimension(100, 200));
        leftBox.setMaximumSize(new Dimension(100, 200));
        leftBox.setSize(new Dimension(100, 200));;
        leftBox.add(headPanel);
        leftBox.add(leftMenu);

        JSplitPane spl = new JSplitPane();
        spl.setContinuousLayout(true);
        spl.setDividerLocation(220);
        spl.setDividerSize(15);
        spl.setLeftComponent(leftBox);
        spl.setRightComponent(bigBox);



        jf.add(spl);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }

    public void updateUI(JComponent component){
        bigBox.remove(scrollBox);
        scrollBox = Box.createHorizontalBox();
        scrollBox.add(component);
        bigBox.add(scrollBox);
        bigBox.updateUI();
        jf.setVisible(false);
        jf.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new MainInterface().init();
    }

}
