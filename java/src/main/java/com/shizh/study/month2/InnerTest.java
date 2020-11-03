package com.shizh.study.month2;

/**
 * @ClassName InnerTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/3
 **/
class Outer{
    public Outer(){
        System.out.println("Outer Class.");
    }
    class Inner{
        public void sayHi(){
            System.out.println("Hi,Inner.");
        }
    }
}
public class InnerTest {
    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner inner = out.new Inner();
        inner.sayHi();
    }
}

