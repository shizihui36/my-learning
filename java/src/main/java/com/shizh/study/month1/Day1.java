package com.shizh.study.month1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName Day1
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/1
 **/
public class Day1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,1};
        System.out.println(Arrays.toString(arr) +"是否对称:" + sym(arr));

        int [] arr2 = {1,2,3,4,5,2,1};
        System.out.println(Arrays.toString(arr2) + "是否对称:" + sym(arr2));
    }
    public static boolean sym(int[] arr){
        for (int start = 0,end = arr.length-1;start <= end;start++,end--){
            //如果两端一旦有元素不等，就返回false
            if (arr[start] != arr[end]){
                return false;
            }
        }
        return true;
    }
}
