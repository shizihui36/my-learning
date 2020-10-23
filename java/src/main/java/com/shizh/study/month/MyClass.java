package com.shizh.study.month;

/**
 * @ClassName MyClass
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/23
 **/
public class MyClass {

        int num;
        static int numStatic;

    public static void methodStatic() {
    }


    public void method(){
          System.out.println("这是一个成员方法。");
          System.out.println(num);
          System.out.println(numStatic);
      }

    public static void main(String[] args) {
        System.out.println("这个一个静态方法。");
        //静态方法可以访问静态变量
        System.out.println(numStatic);
        //静态不能直接访问非静态

        //静态方法中不能使用this关键字
        //System.out.println(this);
    }
}