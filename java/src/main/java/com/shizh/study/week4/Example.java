package com.shizh.study.week4;

/**
 * @ClassName Example
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
public class Example {
    public static void main(String[] args) {
        fun (3);
    }
    public static void fun(int n){
        if(n == 1){
            System.out.printf("a:%d\n",n);
        }else {
            System.out.printf("b:%d\n",n);
            fun(n-1);
            System.out.printf("c:%d\n",n);
        }
    }

}
