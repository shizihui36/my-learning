package com.shizh.study.week11;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/8
 **/
public class Test {
    public static void main(String[] args) {
        int array[] = {6,9,5,8,7,3,2,1};
        int temp ;
        for (int i = 1;i < array.length;i++){
            if (array[i] < array[i-1]){
                temp = array[i];
               for (int j = i;j>= 0;j--){
                   if (j>0 && array[j-1] >temp){
                       array[j] = array[j-1];
                   }else {
                       array[j] = temp;
                       break;
                   }
               }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}