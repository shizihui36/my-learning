package com.shizh.study.week1;

import java.awt.*;
import java.util.Random;

/**
 * @ClassName LineThread
 * @Description TODO 绘制线段过程
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class LineThread implements Runnable {
   private int x = 300;
   private int y = 200;
   private Frame frame;

   private Color[] colors = {Color.DARK_GRAY,Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN,Color.WHITE};

   void setFrame(Frame frame){
       this.frame = frame;
   }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //得到传入的窗体对象的绘制图像 不可新建  类似画笔
            Graphics g = this.frame.getGraphics();
            Random random = new Random();
            //得到颜色数组的随机下标
            int index = random.nextInt(colors.length);
            g.setColor(colors[index]);
            g.drawLine(x,y,400,600);
            x += 60;
            y += 50;
            if (x > 1000){
                break;
            }
        }
    }
}
