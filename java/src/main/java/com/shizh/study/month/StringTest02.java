package com.shizh.study.month;

/**
 * @ClassName StringTest02
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/21
 **/
public class StringTest02 {
    public static void main(String[] args) {
        String s1 = "abc";
        s1 = "def";
        String s2 = "hello";
        String s3 = "hello";
        System.out.println(s2 == s3);
        String s4 = new String("abc");
        String s5 = new String("abc");
        System.out.println(s4 == s5);
        String s6 = "aaa";
        String s7 = "bbb";
        String s8 = s6 + s7;
        System.out.println(s8);
    }
}
