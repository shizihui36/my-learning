package com.shizh.study.month;

import java.util.Scanner;

/**
 * @ClassName Test66
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/28
 **/
public class Test66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1.键盘录入一个源字符串变量scrStr接收
        System.out.print("请输入源字符串:");
        String srcStr = sc.nextLine();
        //2.键盘录入一个要删除的字符串由字符串变量delStr接收
        System.out.println("请输入要删除的字符串:");
        String delStr = sc.nextLine();
        //3.删除该字scrStr字符串中所有delStr字符串（最终的字符串中不能包含delStr）,要求打印删除后的结果以及删除了几个delStr字符串
        printCount(srcStr,delStr);
    }
    private static void printCount(String srcStr,String delStr){
        //删除后的结果
        String resultStr = srcStr.replace(delStr,"");
        //删除了几个delStr字符串
        int count = (srcStr.length() - resultStr.length()) / delStr.length();
        System.out.println("源字符串中总共包含:" + count + "个" + delStr +",\r\n删除" + delStr + "后的字符串:" + resultStr);
    }
}
