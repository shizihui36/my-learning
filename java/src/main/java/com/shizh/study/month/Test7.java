package com.shizh.study.month;

/**
 * @ClassName Test7
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Test7 {
    public static void main(String[] args) {
        printNum();
    }
    private static void printNum(){
        int a = 9;
        int b = 9;
        int num = ++a;
        boolean bo = (num >= 10)?true:false;
        System.out.println("bo的值"+bo);
        int num2 = b++;
        boolean bo2 = (num2 >= 10)? true : false;
        System.out.println("bo2的值"+ bo2);
    }
}
