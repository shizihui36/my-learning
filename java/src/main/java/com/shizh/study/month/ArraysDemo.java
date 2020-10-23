package com.shizh.study.month;

import java.util.Arrays;

/**
 * @ClassName ArraysDemo
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/23
 **/
public class ArraysDemo {
    public static void main(String[] args) {
        int[] intArray = {10,20,30};
        //将int[]数组按照默认格式变成字符串
        String intStr = Arrays.toString(intArray);
        System.out.println(intStr);

        //对整形数组进行排序
        int[] array1 = {2,1,3,9,6};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));

        //对字符串数组进行排序
        String[] array2 = {"bbb","ccc","aaa"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2));

        //将一个随机字符串中的所有字符升序排列，并倒叙打印
        String str = "cbudobcoewfbcoewsnxoa";
        //如何进行升序排列:sort
        //必须是一个数组，才能用Arrays.sort方法
        // String --> 数组，用toCharArray

        char[] chars = str.toCharArray();
        //对字符数组进行升序排列
        Arrays.sort(chars);
        //倒序遍历
        for (int i = chars.length-1;i >= 0;i--){
            System.out.print(chars[i] + " ");
        }
    }
}
