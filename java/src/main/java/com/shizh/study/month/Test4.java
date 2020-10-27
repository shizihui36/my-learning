package com.shizh.study.month;

/**
 * @ClassName Test4
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Test4 {
    public static void main(String[] args) {
        char ch = 'j';
        ch = (char)(ch + 32);
        System.out.println(ch);
        char ch2 = 'a';
        ch2 -= 32;
        System.out.println(ch2);
        double d3 = 3.5;
        int i3 = 100;
        double sum3 = d3 + i3;
        System.out.println("sum3的值:" + +sum3);
        System.out.println("sum3的整数部分的值:"+(int) sum3);
        double d4 = 5.8;
        int i4 = 300;
        int mul4 = (int)(d4 * i4);
        System.out.println("mul的整数部分值:"+mul4);
    }
}
