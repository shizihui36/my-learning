package com.shizh.study.month2;

/**
 * @ClassName Regexpipei
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/2
 **/
public class Regexpipei {
    public static void main(String[] args) {
        tel();
        qq();
    }
    public static void tel(){
        String telnumber = "23922554466";
        String regex = "[1][3578]\\d{9}";
        System.out.println(telnumber.matches(regex));
    }
    public static void qq(){
        String qqid = "22356238";
        String regex = "[1-9]\\d{5,10}";
        System.out.println(qqid.matches(regex));
    }
}
