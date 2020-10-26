package com.shizh.study.week4;

import java.io.*;

/**
 * @ClassName FileReadDemo
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/26
 **/
public class FileReadDemo {
    public static void main(String[] args) throws IOException {
        //创建一个文件File对象，注意需要显示抛出异常(IOException)
        //可以用try catch捕获，也可以在方法签名处使用throws抛出
        File inputFile = new File("C:/Users/Lenovo/Desktop/java/1.doc");
        //创建一个字节输入流，此处有上转型
        InputStream is = new FileInputStream(inputFile);
        //准备和文件大小一致的字节数组
        byte[] b = new byte[(int) inputFile.length()];
        //通过字节输出流将文件读入数组
        is.read(b);
        //准备输出文件对象
        File outputFile = new File("C:/Users/Lenovo/Desktop/java/2.doc");
        //准备输出流
        OutputStream os = new FileOutputStream(outputFile);
        os.write(b);
        is.close();
        os.close();
    }
}
