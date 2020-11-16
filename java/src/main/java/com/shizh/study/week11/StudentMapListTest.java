package com.shizh.study.week11;

import com.shizh.study.month2.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StudentMapListTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/16
 **/
public class StudentMapListTest {
    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        List<Student> list2 = new ArrayList<>();
        list1.add(new Student("Alen",28));
        list1.add(new Student("Jack",21));
        list2.add(new Student("Alice",19));
        list2.add(new Student("Mary",22));
        Map<String,List<Student>> map = new HashMap<>();
        map.put("男生",list1);
        map.put("女生",list2);
        System.out.println("******按性别输出集合的结果******");
        for (Map.Entry<String, List<Student>> entry:map.entrySet()){
            System.out.println(entry.getKey());
            List<Student> list = entry.getValue();

            //Lambda遍历内层循环
            list.forEach(student -> {
                System.out.print(student.getName()+"\t"+student.getAge());
                System.out.println();
            });
        }
    }
}
