package com.shizh.study.week4;

/**
 * @ClassName Example5
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class Example5 {
    public static void main(String[] args) {
        B b = new B();
        b.showA();
        b.showB();
    }
}
interface A{
    public abstract void showA();
    public default void showB(){
        System.out.println("BBBB");
    }
}
class B implements A{
    @Override
    public void showA(){
        System.out.println("AAAA");
    }
}
