package com.shizh.study.month2;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName ExpectionTest2
 * @Description 编译时异常
 * @Author Lenovo
 * @Date 2020/11/2
 **/
public class ExpectionTest2 {
    public static void main(String[] args) {
       try {
           byte[] b = readFile("C: /User/Lenovo/Desktop/java/1.jpg");
           System.out.println(b.length);
       }catch (IOException e){
           System.err.println("出现IO异常");
       }finally {
           System.out.println("无论有无异常都会执行代码段！");
       }
        System.out.println("其他代码");
    }
    public static byte[] readFile(String path) throws IOException{
        File file = new File(path);
        byte[] b = new byte[(int) file.length()];
        InputStream is = new FileInputStream(file);
        int result = is.read(b);
        System.out.println(result);
        is.close();
        return b;

    }

}
