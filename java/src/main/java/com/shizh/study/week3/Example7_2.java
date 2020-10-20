package com.shizh.study.week3;

/**
 * @ClassName Example7_2
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/20
 **/
public class Example7_2 {
    public static void main(String[] args) {
        Son son = new Son();
        Grandon grandon = new Grandon();
        son.height = 180;
        son.hand = "一双大手";
        grandon.height = 155;
        grandon.hand = "一双小手";
        grandon.foot = "一双小脚";
        String str = son.getHand();
        System.out.printf("儿子: %s,%d\n",str,son.height);
        str = grandon.getHand();
        System.out.printf("孙子: %s,%s,%d\n",str,grandon.foot,grandon.height);
    }
}
