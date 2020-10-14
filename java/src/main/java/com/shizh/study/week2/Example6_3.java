package com.shizh.study.week2;

/**
 * @ClassName Example6_3
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/14
 **/
 class Rectangle {
    double x,y,width,height;
    public void setX(double a){
        x = a ;
    }
    double getX(){
        return x;
    }
    void setY(double b){
        y = b;
    }
    double getY(){
        return y;
    }
    void setWidth(double w){
        if (w > 0){
            width = w;
        }
    }
    double getWidth(){
        return width;
    }
    void  setHeight(double h){
        if (height > 0){
            height = h;
        }
    }
    double getHeight(){
        return height;
    }
}
class  Circle {
     double x,y,radius;
     public void setX(double a){
         x = a ;
     }
     public double getX(){
         return x;
     }
     public void setY(double b){
         y = b;
     }
     public double getY(){
         return  y;
     }
     public void  setRadius(double r){
         if(r > 0){
             radius = r;
         }
     }
     public  double getRadius(){
         return radius;
     }
}
class  Geometry {
    Rectangle rect;
    Circle circle;

    Geometry(Rectangle rect, Circle circle) {
        this.rect = rect;
        this.circle = circle;
    }

    public void setCirclePosition(double x, double y) {
        circle.setX(x);
        circle.setY(y);
    }

    public void setCircleRadius(double radius) {
        circle.setRadius(radius);
    }

    public void setRectanglePosition(double x, double y) {
        rect.setX(x);
        rect.setY(y);
    }

    public void setRectangleWidthAndHeight(double w, double h) {
        rect.setWidth(w);
        rect.setHeight(h);
    }

    public void showState() {
        double circleX = circle.getX();
        double rectX = rect.getX();
        if (rectX - rect.getWidth() >= circleX + circle.getRadius()) {
            System.out.println("矩形在圆的右侧");
        }
        if (rectX + rect.getWidth() <= circleX - circle.getRadius()) {
            System.out.println("矩形在圆的左侧");
        }
    }
}

    public class Example6_3 {
        public static void main(String[] args) {
            Rectangle rect = new Rectangle();
            Circle circle = new Circle();
            Geometry geometry;
            geometry = new Geometry(rect, circle);
            geometry.setRectanglePosition(30, 40);
            geometry.setRectangleWidthAndHeight(120, 80);
            geometry.setCirclePosition(260, 30);
            geometry.setCircleRadius(60);
            System.out.print("几何图形中圆和矩形的位置关系是:");
            geometry.showState();
            System.out.println("几何图形重新调整了圆和矩形的位置");
            geometry.setRectanglePosition(220,160);
            geometry.setCirclePosition(40,30);
            System.out.print("调整后，几何图形中圆和矩形的位置关系是:");
            geometry.showState();
        }
    }
