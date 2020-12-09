package com.shizh.study.week1;

import lombok.SneakyThrows;

import javax.swing.*;
import java.io.*;

/**
 * @ClassName TextLabel
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class TextThread implements Runnable{
    private JLabel textLabel;

    public void setTextLabel(JLabel textLabel){
        this.textLabel = textLabel;
    }
    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String filePath = "C:/Users/Lenovo/Desktop/java/111.txt";
            File file = new File(filePath);
            BufferedReader br;
            String tempString = null;
            try {
                br = new BufferedReader(new FileReader(filePath));

                while ((tempString = br.readLine()) != null) {
                    textLabel.setText(tempString + "\r\n");
                    Thread.sleep(2000);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    }