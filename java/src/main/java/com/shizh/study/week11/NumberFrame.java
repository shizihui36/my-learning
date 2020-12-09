package com.shizh.study.week11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName NumberFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/8
 **/
public class NumberFrame extends JFrame implements ActionListener {
    private JButton pauseBtn,resumBtn;
    private NumberThread numberThread;

    public NumberFrame(){
        init();
        setTitle("线程的恢复与暂停");
        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        pauseBtn = new JButton("暂停");
        resumBtn = new JButton("恢复");
        pauseBtn.addActionListener(this);
        resumBtn.addActionListener(this);
        JLabel numberLabel = new JLabel();
        Font font = new Font("微软雅黑", Font.BOLD, 50);
        numberLabel.setFont(font);
        setLayout(new FlowLayout(FlowLayout.CENTER,30,100));
        add(numberLabel);
        add(pauseBtn);
        add(resumBtn);
        numberThread = new NumberThread();
        numberThread.setNumLabel(numberLabel);
        Thread thread = new Thread(numberThread);
        thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pauseBtn){
            numberThread.pauseThread();
        }
        if (e.getSource() == resumBtn){
            numberThread.resumeThread();
        }
    }

    public static void main(String[] args) {
        new NumberFrame();
    }
}
