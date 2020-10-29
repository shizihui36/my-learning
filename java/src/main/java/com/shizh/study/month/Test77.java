package com.shizh.study.month;

/**
 * @ClassName Test77
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/28
 **/
public class Test77 {
    public static void main(String[] args) {
        double random = Math.random()*100;
        System.out.println("随机数为:");
        System.out.println(random);
        String str = random +"";
        int index = str.indexOf(".");
        //System.out.println(index);

        String substring = str.substring(0,index + 3);
        System.out.println("转换为:");
        System.out.println(substring);
    }
}
