package com.shizh.study.month;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName TraversalList
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/24
 **/
public class TraversalList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("tom","cat","Jane","jerry"));
        //方法1 集合类的通用遍历方式，从很早的版本就有，用迭代器迭代
        Iterator<String> it1 = list.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
        }
        System.out.println();

        for (Iterator it2 = list.iterator(); it2.hasNext();){
            System.out.println(it2.next());
        }
        System.out.println();
        for (String value : list){
            System.out.print(value);
        }
        System.out.println();
        for (int i = 0; i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println();

        list.forEach(item -> System.out.println(item));
        System.out.println();
        list.forEach(System.out::print);
    }
}
