package com.shizh.study.month2;

/**
 * @ClassName Replace
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/2
 **/
public class Replace {
    public static void main(String[] args) {
        //将数字替换成#
        replace("adfan11526251adfan123456","\\d{5,}","##");
        //将叠词替换成*
        replace("asskkddd123456ssssss","(.)\\1+","**");
        //将叠词替换成一个单独的词
        replace("asskkddd123456ssssss","(.)\\1+","$1");
    }
    public static void replace(String str,String regex,String replacement){
        str = str.replaceAll(regex,replacement);
        System.out.println(str);
    }
}
