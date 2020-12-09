package com.shizh.study.week11;

import java.io.*;
import java.util.Scanner;
import java.util.UUID;
import java.io.FileOutputStream;
/**
 * @ClassName TxtFileTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/30
 **/
public class TxtFileTest {
    public static void main(String[] args) throws IOException {
        //将键盘输入的一串文本保存到文件中
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        String fileName = UUID.randomUUID().toString();
        File file = new File("F:/hello/" + fileName+".txt");
       Writer out = new FileWriter(file,true);
        out.write(chars);
        out.close();

        //BufferedWriter
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(chars);
        bw.close();

        //FileOutputStream
        FileOutputStream fop = null;
        String content = s;
        fop = new FileOutputStream(file,true);
        byte[] contentBytes = content.getBytes();
        fop.write(contentBytes);
        fop.flush();
        fop.close();


    }

}
