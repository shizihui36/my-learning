package com.shizh.study.week1;

/**
 * @ClassName Example5_6
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/9
 **/
 class Rect{
     double width,height,area;
     void setWidth(double width){
         if (width > 0){
             this.width = width;
         }
     }
     void setHeight (double height){
         if ( height > 0){
             this.height = height;
         }
     }
    double getWidth(){
         return  width;
    }
    double getHeight(){
         return  height;
    }
    double getArea(){
         area = width * height;
         return area;
    }
}
public class Example5_6 {
    public static void main(String[] args) {
        Rect rect = new Rect();
        double w = 12.76 ,h = 25.28;
        rect.setWidth(w);
        rect.setHeight(h);
        System.out.println("矩形对象的宽:" + rect.getWidth() + "高:" + rect.getHeight());
        System.out.println("矩形的面积:" + rect.getArea());
        System.out.println("更改向对象的方法参数传递值的w,h变量的值为100和256");
        w = 100;
        h = 256;
        System.out.println("矩形对象的宽:" + rect.getWidth() + "高:" + rect.getHeight());
    }
}
