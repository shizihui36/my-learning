package com.shizh.study.month2;

import javax.swing.*;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName ExceptionTest
 * @Description 运行时的异常
 * @Author Lenovo
 * @Date 2020/11/2
 **/
public class ExceptionTest {
    public static void main(String[] args) {
        //1.ArithmeticException 算术异常
//        int result = 0;
//        try {
//             result = 3 / 0;
//        }catch (ArithmeticException e){
//            //弹框
//            //JOptionPane.showMessageDialog(null,"除数不能为0");
//            System.err.println("除数不能为0" + new Date());
             // System.out.println(e.getMessage());
//           // e.printStackTrace();
//        }
//
//        System.out.println(result);

        //2. ArrayIndexOfBoundException 数组索引越界异常
//        int[] a = new int[]{1,2,3,4,5};
//        System.out.println(a[5]);
//        try {
//            System.out.println(a[5]);
//        }catch (ArrayIndexOutOfBoundsException e){
//           System.err.println("数组越界异常");
//           System.err.println("异常的原因:" + e.getCause());
//           System.err.println("异常的详细信息:"+ e.getMessage());
//           System.err.println("异常对象e:" + e.toString());
//        }
        //3. NumberFormatExpection 数字格式化异常
        System.out.println("请输入价格:");
        Scanner scanner = new Scanner(System.in);
        //从键盘读入一串字符串
        String priceStr = scanner.nextLine();
        //将字符串转化为整形
        int price = Integer.parseInt(priceStr);
        System.out.println("price = :"+price);

        try {
             price = Integer.parseInt(priceStr);
        }catch (NumberFormatException e){
            System.err.println("异常的详细信息" + e.getMessage() );
        }

    }
}
