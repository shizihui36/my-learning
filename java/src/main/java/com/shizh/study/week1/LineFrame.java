package com.shizh.study.week1;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName LineFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class LineFrame extends JFrame {
    public  LineFrame(){
        init();
        //
        getContentPane().setBackground(new Color(0,0,0));
        setTitle("line frame");
        setSize(1024,897);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public  void init(){
        LineThread lt = new LineThread();
        lt.setFrame(this);
        new Thread(lt).start();
    }
    public static void main(String[] args) {
        new LineFrame();
    }
}
