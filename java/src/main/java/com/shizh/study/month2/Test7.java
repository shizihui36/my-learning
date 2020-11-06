package com.shizh.study.month2;

/**
 * @ClassName Test7
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/6
 **/
public class Test7 {
    /**
     * 统计高于平均分的分数有多少个
     * 定义数组[95,92,75,56,98,71,80,58,91,91]
     * 定义getAvg方法，获取一个数组中的平均数
     */

        public static void main(String[] args) {
            //获取随机分数
            int[] score = {95, 92, 75, 56, 98, 71, 80, 58, 91, 91};
            //获取平均分
            int avg = getAvg(score);
            //定义计数的变量
            int count = 0;
            for (int i =0; i <score.length; i++){
                if (score[i] > avg){
                    count++;
                }
            }
            System.out.println("高于平均分:" + avg + "的 个数有" + count + "个");
        }
        //获取平均分的方法
        public static  int getAvg(int[] arr){
            int sum = 0;
            for (int i = 0; i < arr.length; i++){
                sum += arr[i];
            }
            return sum / arr.length;
        }
    }

