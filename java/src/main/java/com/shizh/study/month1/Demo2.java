package com.shizh.study.month1;

import java.util.Scanner;

/**
 * @ClassName Demo2
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/29
 **/
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String next = scanner.next();
        int b = scanner.nextInt();
        String count = count(a,next,b);
        System.out.println(a + next + b +"=" + count);
    }
    public static String count(int a, String op,int b){
        int r = 0;
        if("+".equals(op)){
            r = a+b;
        }else if ("-".equals(op)){
            r = a - b;
        }else if ("*".equals(op)){
            r = a * b;
        }else if("/".equals(op)){
            r = a / b;
        }else if("%".equals(op)){
            r = a % b;
        }else {
            return null;
        }
        return r + "";
    }
}
