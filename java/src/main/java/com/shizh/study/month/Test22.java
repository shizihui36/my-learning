package com.shizh.study.month;

/**
 * @ClassName Test22
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Test22 {
    public static void main(String[] args) {
        printString();
    }
    public static void printString(){
        String str ;
        int num = 60;
        str = (num % 2 == 0)? "偶数" :"奇数";
        System.out.println("num是" + num + "是" + str );
    }
}
