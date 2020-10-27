package com.shizh.study.month;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Test1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("互换前:");
        System.out.println(a);
        System.out.println(b);
        int temp;
        //利用第三方变量, 是a,b的值互换
        temp = a;
        a = b;
        b = temp;
        //控制台输出变量a,b的互换后的值
        System.out.println("互换后:");
        System.out.println(a);
        System.out.println(b);
    }
}
