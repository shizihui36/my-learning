package com.shizh.study.month;

/**
 * @ClassName BubbleSort
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/20
 **/
public class BubbleSort {
    public static void bubbleSort1(int[] a,int n ){
        int i, j;
        for (i = 0; i < n; i++){
            for (j = 1;j < n-1;j++){
                if(a[j-1] > a[j]){
                    int temp;
                    temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,0,9,3,12,7,8,3,4,65,22};
        BubbleSort.bubbleSort1(arr,arr.length);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
