package com.shizh.study.week2;

/**
 * @ClassName Example6_4
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/15
 **/
class A {
    int x,y,z;
    static int getContinueSum(int start,int end){
        int sum = 0;
        for (int i = start;i <= end; i++){
            sum = sum + i;
        }
        return sum;
    }
}
public class Example6_4 {
    public static void main(String[] args) {
        int result = A.getContinueSum(0,100);
        System.out.println(result);
    }
}
