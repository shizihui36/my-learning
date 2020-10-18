package com.shizh.study.week2;
import lombok.Data;

import javax.xml.soap.Text;

/**
 * @ClassName Example6_7
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/18
 **/

  class CircleR{
       double radius;
       public CircleR(double r){
           radius = r;
       }
       public double getArea(){
           return 3.14 *radius*radius;
       }
}
 class Circular{
      CircleR bottom;
      double height;
      public Circular(CircleR c,double h){
          bottom = c;
          height = h;
      }
      public double getVolme(){
          return bottom.getArea() * height /3.0;
      }
}
public class Example6_7 {
    public static void main(String[] args) {
        CircleR circle = new CircleR(10);
        Circular circular = new Circular(circle,20);
        System.out.println("圆锥的体积:" + circular.getVolme());

    }
}
