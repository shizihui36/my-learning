package com.shizh.study.week11;

import javax.xml.crypto.Data;
import java.io.File;
import java.time.LocalDate;

/**
 * @ClassName Example
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/30
 **/
public class Example {
    public static void main(String[] args) {
        //创建文件
//        File file = new File("F:" + File.separator+ "1.txt");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getName());
        //创建文件夹（目录）如果目录不存在就创建目录
        File dir = new File("F:/hello");
        if (!dir.exists()) {
            boolean flag = dir.mkdir();
            System.out.println(flag);

        // 删除这个目录，注意判断是否存在

        if (dir.exists()){
             boolean del =  dir.delete();
        }
        }
//           //创建目录，目录名字以系统当前的日期为目录的名字
//            LocalDate today = LocalDate.now();
//            String dirName = today.getYear()+"-"+ today.getMonthValue()+"-"+ today.getDayOfMonth();
//            File dir1 = new File("F:" + dirName);
//            if (dir1.exists()){
//                boolean flag1 = dir.mkdir();
//                System.out.println(flag1);
         File file3 = new File("F:" + File.separator+"Java");




        String directory = "F:\\Java\\IO\\字节流"+ File.separator+ "字符流";
        File file2 = new File(directory);
        boolean result = file2.mkdirs();

        System.out.println("创建结果" + result);
        String[] dirNameArray = new String[]{"面向对象", "异常", "集合", "io", "多线程"};
        String[] childDirNameArray = new String[]{"字节流", "字符流"};
        File dir2 = new File("F:\\JetBrainProjects\\JavaLearn\\JavaBasic\\src\\main\\java\\org\\spianmo\\learn\\week11\\" + "Java");
        if (!dir2.exists()) {
            boolean flag = dir2.mkdir();
            System.out.println(flag ? "Java文件夹创建成功" : "Java文件夹创建失败");
        }
        for (String str : dirNameArray) {
            String targetDirName = dir2.getAbsolutePath() + File.separator + str;
            if (str.equals("io")) {
                for (String str1 : childDirNameArray) {
                    File tmpFile = new File(targetDirName + File.separator + str1);
                    boolean flag = tmpFile.mkdirs();
                    System.out.println(flag ? "文件"+tmpFile.getAbsolutePath()+"创建成功" : "文件"+ tmpFile.getAbsolutePath()+"创建失败");
                }
            } else {
                File tmpFile = new File(targetDirName);
                boolean flag = tmpFile.mkdirs();
                System.out.println(flag ? "文件"+targetDirName+"创建成功" : "文件"+targetDirName+"创建失败");
            }
        }
     }
    }

