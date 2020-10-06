package com.shizh.study.week1;
import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName maxmin
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/5
 **/

public  class ArrayTest {
      static  int Max = 5;
        public static void main(String[] args) {
            int sum = 0;
            int[] a = new int[Max];
            //创建随机数
            Random Random = new Random();
            //数组原始值
            for (int i = 0; i < Max; i++) {
                a[i] = Random.nextInt(10);
                //循环生成100以内的随机整数赋值给数组
                System.out.print(a[i] + " ");
            }
            System.out.println();
            int max = a[0];
            int min = a[0];
            for (int i = 0; i < Max; i++) {
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i] < min) {
                    min = a[i];
                }

            }

            System.out.println("最大值是:" + max);
            System.out.println("最小值是:" + min);
            sum = max + min;
            System.out.println("最大值和最小值的和:" + sum);

/*
            for (int i = 0; i < a.length-1; i++) {
                for (int j = i+1; j < a.length; j++){
                    if (a[i] > a[j ]) {
                        int temp = a[i];
                        a[i] = a[j ];
                        a[j] = temp;
                    }

                }
//                System.out.print(a[i]+" ");
             }
                for(int i = 0;i<a.length;i++ ){
                    System.out.print(a[i]+" ");
                }**/


                   for (int i = 0 ;i < a.length; i++){
                       int k=i;
                       for (int j = a.length-1; j >i; j--){
                           if (a[j]<a[k]){
                               k=j;
                           }
                           int temp=a[i];
                           a[i]=a[k];
                           a[k]=temp;
                       }

                   }
                   for (int i=0;i<a.length;i++){
                       System.out.print(a[i]+" ");
                   }

            }

        }




