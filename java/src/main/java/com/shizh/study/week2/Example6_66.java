package com.shizh.study.week2;

/**
 * @ClassName Example6_66
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/17
 **/
class StudentAge{
    private int age;
    public void setAge(int age){
        if (age >= 7 && age <= 28){
            this.age = age;
        }
    }
    public int getAge(){
        return age;
    }
}
public class Example6_66 {
    public static void main(String[] args) {
        StudentAge zhang = new StudentAge();
        StudentAge geng = new StudentAge();
        zhang.setAge(23);
        System.out.println("zhang的年龄:" + zhang.getAge());
        geng.setAge(25);
        System.out.println("geng的年龄:" + geng.getAge());
    }
}
