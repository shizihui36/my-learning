package com.shizh.study.week1;

/**
 * @ClassName Example5_8
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/11
 **/
 class Compute{
    public double getResult(double a , int ... x){
        double result = 0 ;
        int sum = 0;
        for (int i = 0 ; i < x.length; i++ ){
            sum =  sum + x[i];
        }
      result = a * sum ;
        return result;
    }
}

public class Example5_8 {
    public static void main(String[] args) {
        Compute compute = new Compute();
        double result = compute.getResult(1.0 /3, 10, 20, 30);
        System.out.println("10,20,30的平均数:" + result);
        result = compute.getResult(1.0/6,66,12,5,89,2,51);
        System.out.println("66,12,5,89,2,51的平均数:" + result);
    }

}
