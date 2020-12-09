package com.shizh.study.week1;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName CarouseThread
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class CarouseThread implements Runnable {
          private String[] imgs = {
            "https://s3.ax1x.com/2020/11/20/DlYJ41.jpg",
            "https://s3.ax1x.com/2020/11/20/DlYajO.jpg",
            "https://s3.ax1x.com/2020/11/21/D38MB4.png",
            "https://s3.ax1x.com/2020/11/21/D38841.jpg",
            "https://s3.ax1x.com/2020/11/21/D38wHH.jpg"
          };
          //添加本地文件

  //创建显示图片的组件
    private JLabel bgLabel;

    void setBgLabel(JLabel bgLabel){
        this.bgLabel = bgLabel;
    }
    @Override
    public void run() {
        int index = 0;
        int len = imgs.length;
        while (true){
        try {
            //创建url
            URL url = new URL(imgs[index]);
            //创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //连接超时就释放
            connection.setConnectTimeout(5000);
            //得到连接目标的字节输入流
            InputStream is = connection.getInputStream();
            //字节缓冲输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //缓冲区
            byte[] buffer = new byte[1024];
            int length = 0;
            //通过缓冲区读取文件
            while ((length = is.read(buffer)) != -1){
               baos.write(buffer,0,length);
            }
            byte[] bytes = baos.toByteArray();
            //将字节数组通过字节输入流读入
            is.read(bytes);
            //通过bytes构建图标icon
            Icon icon = new ImageIcon(bytes);
            //将icon设置为背景标签的图标
            this.bgLabel.setIcon(icon);
            Thread.sleep(2000);
            baos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        index ++;
        //处理数组最后一个元素
        if (index == len ){
            index = 0;
        }
    }


}
}