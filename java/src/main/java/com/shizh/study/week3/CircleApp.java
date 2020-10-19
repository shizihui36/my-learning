package com.shizh.study.week3;



/**
 * @ClassName CircleApp
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/

public class CircleApp {
    public static void main(String[] args) {
        Point point = new Point(10,20);
        Circle circle = new Circle(10,20,5);
        point.print();
        circle.print();
        CyLinder cyLinder = new CyLinder(10,20,5,6);
        cyLinder.print();
    }
}
