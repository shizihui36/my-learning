package com.shizh.study.week2;

/**
 * @ClassName Example6_41
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/15
 **/
  class People{
    int leg,hand;
    String name;
    People(String s){
        name = s;
        this.init();
    }
    void init(){
        leg = 2;
        hand = 2;
        System.out.println(name + "有" + hand + "只手" + leg + "条腿");
    }
}
public class Example6_41 {
    public static void main(String[] args) {
        People boshi = new People("布什");
    }
}
