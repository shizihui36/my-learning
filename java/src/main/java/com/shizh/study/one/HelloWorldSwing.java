package com.shizh.study.one;

import javax.swing.*;

/**
 * @ClassName HelloWorldSwing
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/8
 **/
public class HelloWorldSwing {
    private static void createAndShowGUI(){
        //确定一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        //创建窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //添加 “Hello World”标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
        //显示窗口
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(HelloWorldSwing::createAndShowGUI);
    }
}
