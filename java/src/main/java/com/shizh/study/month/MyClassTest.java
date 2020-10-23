package com.shizh.study.month;

/**
 * @ClassName MyClassTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/23
 **/
public class MyClassTest {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        obj.method();
        MyClass.methodStatic();
        myMethod();
        MyClassTest.myMethod();
    }
    public static void myMethod(){
        System.out.println("自己的方法");
    }
}
