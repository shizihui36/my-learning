package com.shizh.study.week3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CyLinder
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CyLinder extends Circle {
    private int h;
    public  CyLinder(int x,int y,int r,int h){
        super(x, y, r);
        this.h = h;
    }
    @Override
    public void print(){
        super.print();
        System.out.println("圆柱体的体积:" + super.getArea() * this.h);
    }
}
