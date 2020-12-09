package com.shizh.study.week1;

import java.io.*;

/**
 * @ClassName BufferendRead
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class BufferendRead {
    public static void main(String[] args) {
        //文件路径
        String filePath = "C:/Users/Lenovo/Desktop/java/111.txt";

        File file = new File(filePath);

        BufferedReader reader = null;//字符输入流进行读取操作读取

        String tempString = null;//每一行的内容

        int line = 1;//行号

        try {
            //输入字节流，FileInputStream主要用来操作文件输入流
            FileInputStream intput = new FileInputStream(file);

            // System.out.println("以行为单位读取文件内容，一次读一整行：")
            //InputStreamReader是转换流，将字节流转成字符流
            reader = new BufferedReader(new InputStreamReader(intput));

            while ((tempString = reader.readLine()) != null) {
                System.out.println("第" + line + "行:" + tempString);
                line++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


