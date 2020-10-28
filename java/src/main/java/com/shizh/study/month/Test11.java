package com.shizh.study.month;

/**
 * @ClassName Test11
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Test11 {
    public static void main(String[] args) {
        printNum();
    }
    public static void printNum(){
        int i = 10;
        int j = 20;
        //i与5的商加上j 赋值给j
        j += i /5;
        int k = j;
        System.out.println("i:" + i + " j: " + j +" k: " + k );
    }
}
