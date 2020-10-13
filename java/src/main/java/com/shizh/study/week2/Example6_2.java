package com.shizh.study.week2;

/**
 * @ClassName Example6_2
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/13
 **/
 class Ladder{
double 上底,高;
static double 下底;
void 设置上底(double a){
    上底 = a;
}
void 设置下底(double b){
    下底 = b;
}
double 获取上底(){
    return 上底;
}
double 获取下底(){
    return 下底;
}
}

public class Example6_2 {
    public static void main(String[] args) {
        Ladder.下底 = 100;
        Ladder ladderOne = new Ladder();
        Ladder ladderTwo = new Ladder();
        ladderOne.设置上底(28);
        ladderTwo.设置下底(66);
         System.out.println("ladderOne 的上底:" + ladderOne.获取上底());
        System.out.println("ladderOne 的下底:" + ladderOne.获取下底());
        System.out.println("ladderTwo 的上底:" + ladderTwo.获取上底());
        System.out.println("ladderTwo 的下底:" + ladderTwo.获取下底());
    }
 }
