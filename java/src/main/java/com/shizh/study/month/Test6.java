package com.shizh.study.month;

/**
 * @ClassName Test6
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Test6 {
    public static void main(String[] args) {
        int a = 20;
        boolean bo = ++a % 3 == 0 && a++ % 7 == 0;
        System.out.println("bo的值:"+bo);
        System.out.println(a);
        System.out.println("----------");
        int b = 20;
        boolean bo2 = b++ % 3 == 0 && ++b % 7 == 0;
        System.out.println("bo2的值:"+bo2);
        System.out.println("b的值:"+b);
    }
}
