package com.shizh.study.month1;

/**
 * @ClassName Day
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/1
 **/
public class Day {
    public static void main(String[] args) {
        //获取随机分数
        int[] score = {95,92,75,56,98,71,80,58,91,91};
        //获取平均分
        int avg = getAvg(score);
        //定义计数的变量
        int count = 0;
        for (int i = 0;i < score.length; i++){
            if (score[i] > avg){
                count++;
            }
        }
        System.out.println("高于平均分:" + avg + "的个数有" + count + "个");
    }
    //获取平均分的方法
    public static int getAvg(int[] arr){
        int sum = 0;
        for (int i = 0;i< arr.length;i++){
            sum = sum + arr[i];
        }
        return sum / arr.length;
    }
}
