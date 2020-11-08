package com.shizh.study.one;

import javax.swing.*;

/**
 * @ClassName SwingLoginExample
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/8
 **/
public class SwingLoginExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Example");
        //设置窗体的宽和高
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * 创建面板，这个类似于HTML的div标签
         * 我们可以创建多个面板并在 JFrame中指定位置
         * 面板中我们可以添加文本字段，按钮以及其他组件
         */
        JPanel panel = new JPanel();
        //添加面板
        frame.add(panel);
        /**
         * 调用用户定义的方法添加组件到面板
         */
        placeCompoments(panel);
        frame.setVisible(true);
    }
    private static void placeCompoments(JPanel panel){
        //布局为空
        panel.setLayout(null);

        //创建 JLable
        JLabel userLabel = new JLabel("User:");

        /**
         * 这个方法定义了组件的位置
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);
        /**
         * 创建文本域用于用户输入
         */
        JTextField userTest = new JTextField(20);
        userTest.setBounds(100,20,165,25);
        panel.add(userTest);
        //输入密码的文本域
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);
        /**
         * 这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        //创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10,80,80,25);
        panel.add(loginButton);
    }
}
