package com.shizh.study.month1;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/31
 **/
public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(3);
               students.add(new Student("路飞",22,175));
               students.add(new Student("红发",40,180));
               students.add(new Student("白胡子",50,185));

               List<Student> list = students.stream()
                       .filter(stu -> stu.getStature() <180)
                       .collect(Collectors.toList());
        System.out.println(list);
    }
    public static class Student{
          String name;
          int ages;
          int stature;
        public Student(String name,int ages,int stature){
            super();
            this.name = name;
            this.ages = ages;
            this.stature = stature;
        }
        public String getName(){
            return name;
        }
        public int getAges(){
            return ages;
        }
        public int getStature(){
            return stature;
        }
    }

}
