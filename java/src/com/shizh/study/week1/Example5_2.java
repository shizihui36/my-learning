package com.shizh.study.week1;

/**
 * @ClassName Example5_2
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/5
 **/
public class Example5_2 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        char b[] = {'a','b','c','d'};
        for (int n = 0 ; n < a.length;n++){
            System.out.println(a[n]);
        }
        for(int i:a){
            System.out.println(i);
        }
        for (char ch:b){
            System.out.println(ch);
        }
    }
}
