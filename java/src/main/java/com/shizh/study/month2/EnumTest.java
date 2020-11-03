package com.shizh.study.month2;

/**
 * @ClassName EnumTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/3
 **/
enum ColorEnum{
    RED("红色",1),
    BLUE("蓝色",2),
    YELLOW("黄色",3),
    GREEN("绿色",4);
    ColorEnum(String name,int index){
        this.name = name;
        this.index = index;
    }
    private String name;
    private int index;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public  int getIndex(){
        return index;
    }
    public  void setIndex(int index){
        this.index = index;
    }
}
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(ColorEnum.RED.getName());
        System.out.println(ColorEnum.RED.getIndex());
    }
}
