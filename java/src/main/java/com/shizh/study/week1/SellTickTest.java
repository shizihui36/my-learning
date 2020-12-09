package com.shizh.study.week1;

/**
 * @ClassName SellTickTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
public class SellTickTest {

public static void main(String[] args) {
      SellTick st = new SellTick();
      Thread t1 = new Thread(st,"售票窗口1");
       Thread t2 = new Thread(st,"售票窗口2");
       t1.start();
       t2.start();

    }
}
