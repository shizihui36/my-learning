package com.shizh.study.week11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName Set接口测试
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/16
 **/
public class SetTest {
    public static void main(String[] args) {
        System.out.println("TreeSet的例子");
       Student s1 = Student.builder().name("a").age(20).build();
       Student s2 = Student.builder().name("b").age(18).build();
       Student s3 = Student.builder().name("c").age(22).build();
       Set<Student> studentSet = new TreeSet<>();
       studentSet.add(s1);
       studentSet.add(s2);
       studentSet.add(s3);
        System.out.println(studentSet);
      Set<String> set = new HashSet<>();
      set.add("C");
      set.add("A");
      set.add("B");
        System.out.println("使用for循环遍历");
        Object[] array = set.toArray();
        for (Object o : array){
            System.out.println(o.toString());
        }
        System.out.println("使用iterator循环遍历");
        Iterator<String>  iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.hasNext()+",");
        }
        set.forEach(s -> System.out.println(s));
        set.forEach(System.out::print);
        //使用方法引用遍历
        System.out.println("使用引用方法遍历");
        set.forEach(System.out::print);

    }
}
