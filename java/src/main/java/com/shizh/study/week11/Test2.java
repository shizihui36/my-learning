package com.shizh.study.week11;

import java.util.Arrays;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/8
 **/
public class Test2 {
    public static void main(String[] args) {
        int arr[] = {75,23,98,44,57,12,29,64,38,82};
        int temp;
        for (int i = 0;i < arr.length-1;i++){
            for (int j = 0;j < arr.length-1-i;j++){

                if (arr[j] > arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
