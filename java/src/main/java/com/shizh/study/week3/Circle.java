package com.shizh.study.week3;



/**
 * @ClassName Circle
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/


public class Circle extends Point {
    private int r;

    public Circle() {
        System.out.println("圆被初始化了");
    }

    public Circle(int x, int y, int r) {
        super(x,y);
        this.r = r;
        System.out.println("带参数的圆被初始化了");
    }
    @Override
    public void print(){
        super.print();
        System.out.println("圆的面积:" + Math.PI * r * r);
    }
    public double getArea(){
        return Math.PI * r * r;
    }
}