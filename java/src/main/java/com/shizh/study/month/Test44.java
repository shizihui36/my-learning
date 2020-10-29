package com.shizh.study.month;

import java.util.Scanner;

/**
 * @ClassName Test44
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/28
 **/
public class Test44 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println("录入的字符串:" + next);
        String s = reverseStr(next);
        System.out.println("反转的字符串:" + s);
    }
    public static String reverseStr(String str){
        String s = "";
        char[] chars = str.toCharArray();
        for (int i = chars.length-1;i >= 0;i--){
            s += chars[i];
        }
        return s;
    }
}
