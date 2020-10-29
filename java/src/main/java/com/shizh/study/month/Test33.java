package com.shizh.study.month;

/**
 * @ClassName Test33
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Test33 {
    public static void main(String[] args) {
        add();
        sub();
        mul();
        div();
        remain();
    }
    public static void add(){
        int x = 10;
        int y = 20;
        System.out.println("x,y的和:"+(x + y));
    }
    public static void sub(){
        int x = 30;
        int y = 5;
        System.out.println("x,y的差:" + (x - y));
    }
    public static void mul(){
        int x = 14;
        int y = 8;
        System.out.println("x,y的积:" +(x * y));
    }
    public static void div(){
        int x = 52;
        int y = 9;
        System.out.println("x,y的商:"+(x / y));
    }
    public static void remain(){
        int x = 65;
        int y = 6;
        System.out.println("x,y的余数:"+(x % y));
    }
}
