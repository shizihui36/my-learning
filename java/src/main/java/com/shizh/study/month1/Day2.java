package com.shizh.study.month1;

/**
 * @ClassName Day2
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/1
 **/
public class Day2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3,2,1};
        int[] arr2 = {1,2,3,4,3,2,1};
        System.out.println("是否一致:"+equals(arr,arr2));
    }
     //比较数组的内容
    public static boolean equals(int[] arr1,int[] arr2){
        //长度不同，返回false
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0;i < arr1.length;i++){
            //arr[i] 和 arr2[i]比较
            /**
             * 所有元素都相同才相同，也就是只要有一个不同，这两个数组就是不同
             */
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
}
