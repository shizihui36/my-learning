package com.shizh.study.month1;

import java.util.Scanner;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/29
 **/
public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        boolean p = isP(next);
        System.out.println("回文数:" + p);
    }
    public static boolean isP(String str){
        int start = 0;
        int end = str.length()-1;
        while (start < end){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

