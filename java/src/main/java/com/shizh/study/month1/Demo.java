package com.shizh.study.month1;

import java.util.ArrayList;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/29
 **/
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = getArrayList();
        System.out.println("源字符串:");
        System.out.println(list);
        //删除集合中长度大于5的元素
        delStrFromList01(list);
        System.out.println("删除后:");
        System.out.println(list);
    }
    //返回存储多个字符串的ArrayList集合
    private static ArrayList<String> getArrayList(){
        ArrayList<String> list = new ArrayList<>();
        list.add("bca");
        list.add("bubcdbc");
        list.add("aaaccc");
        list.add("你好吗？");
        list.add("我很好，你最近怎么样？");
        list.add("你在干嘛");
        list.add("别走啊");
        return list;
    }
    //删除list集合中所有长度>5的字符串
    private static void delStrFromList01(ArrayList<String> list){
        //创建ArrayList集合对象
        ArrayList<String> newList = new ArrayList<String>();
        //遍历原集合对象
        for (int i = 0;i < list.size();i++){
            //获取当前元素
            String str = list.get(i);
            //如果str的长度大于等于5,就将str添加到新集合中
            if (str.length()>5){
                newList.add(str);
            }
        }
        for(Object str : newList){
            list.remove(str);
        }
    }
}
