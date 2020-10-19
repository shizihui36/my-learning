package com.shizh.study.week3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Overload
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/
@Data
@Builder
@AllArgsConstructor

public  class Overload {
    public static int sum (int a ,int b){
       return a + b;
    }
    public String sum (String s1 ,String s2){
        return s1 + s2;
    }
    public static int second(int second1,int second2 ){
        int sum1 = second1+second2;
        if (sum1 < 60){
            System.out.println(sum1+ "秒");
        }else {
            int minute = sum1 /60;
            int second = sum1 % 60;
            System.out.println(minute + "分" + second +"秒");
        }
        return 1;
    }
}
