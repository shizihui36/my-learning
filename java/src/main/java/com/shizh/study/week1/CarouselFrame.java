package com.shizh.study.week1;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

/**
 * @ClassName CarouselFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class CarouselFrame extends JFrame {
    private JLabel bgLabel;
   private JLabel timeLabel;
   private JLabel TextLabel;
    public CarouselFrame() {
        init();
        setTitle("Carouselframe");
        setSize(1024, 897);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        bgLabel = new JLabel();
        CarouseThread ct = new CarouseThread();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();
        this.getContentPane().add(bgLabel,BorderLayout.CENTER);
        //时间线程和标签

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("微软雅黑",Font.BOLD,24));
        this.getContentPane().add(timeLabel,BorderLayout.SOUTH);
        TimeThread tt = new TimeThread();
        tt.setTimeLabel(timeLabel);
        new Thread(tt).start();

        TextLabel = new JLabel();
        TextLabel.setFont(new Font("微软雅黑",Font.BOLD,35));
        this.getContentPane().add(TextLabel,BorderLayout.NORTH);
        TextThread txt = new TextThread();
        txt.setTextLabel(TextLabel);
         new Thread(txt).start();
    }


    public static void main(String[] args) {
        new CarouselFrame();

    }
}