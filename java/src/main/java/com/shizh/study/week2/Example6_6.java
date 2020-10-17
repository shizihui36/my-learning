package com.shizh.study.week2;

/**
 * @ClassName Example6_6
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/17
 **/
 class Triangle{
    double sideA,sideB,sideC;
    boolean isTriange;
    public Triangle(double a,double b, double c){
        sideA = a;
        sideB = b;
        sideC = c;
        if(a + b > c && a +c > b && c + b > a){
            isTriange = true;
        }else {
            isTriange = false;
        }
    }
    public void 计算面积(){
        if (isTriange){
            double p = (sideA + sideB + sideC)/2.0;
            double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
            System.out.println("是一个三角形，面积是:" + area);
        }else {
            System.out.println("不是一个三角形，不能计算面积");
        }
    }
    public void 修改三边(double a,double b,double c){
        sideA = a;
        sideB = b;
        sideC = c;
        if(a + b > c && a + c >b && c + b >a){
            isTriange = true;
        }else {
            isTriange = false;
        }
    }
}
public class Example6_6 {
    public static void main(String[] args) {
        Triangle tri = new Triangle(12,-3,100);
        tri.计算面积();
        tri.修改三边(3,4,5);
        tri.计算面积();
    }
}
