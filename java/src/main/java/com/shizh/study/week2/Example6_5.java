package com.shizh.study.week2;

/**
 * @ClassName Example6_5
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/16
 **/
class StudentNo{
    int number;
    StudentNo(int n){
        number = n;
    }
    void speak(){
        System.out.println("Student类的包名是week2,我的学号:" + number);
    }
}
public class Example6_5 {
    public static void main(String[] args) {
        StudentNo stu = new StudentNo(10201);
        stu.speak();
        System.out.println("主类的包名也是week2");
    }
}
