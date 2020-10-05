package com.shizh.study;

/**
 * @ClassName Example5_1
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/5
 **/
public class Example5_1 {
    public static void main(String[] args) {
        int x = 5;
        int result = 1;
        for (int i = 1; i <= 5;i++){
            result = result * i;
        }
        System.out.println(x+"的阶乘是:"+result);
    }
}
