package com.shizh.study.week1;

import java.util.concurrent.Callable;

/**
 * @ClassName SellTick
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/7
 **/
//public class SellTick extends Thread {
//    private static int ticket = 20;
//
//    @Override
//    public void run(){
//        while (true){
//            if (ticket > 0){
//                System.out.println(getName() + ":卖票，票号为:"+ ticket);
//                ticket--;
//            }else {
//                break;
//            }
//        }
//    }
//}
public class SellTick implements Runnable{
    //总票数
   private int total = 20;
   //票的编号
   private int no = total+1;
   private Object obj = new Object();
    @Override
    public void run() {
       while (true){
           synchronized (this.obj){
               if (this.total > 0){
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   String msg = Thread.currentThread().getName()+"售出第 " + (this.no -this.total)+"张票";
                   System.out.println(msg);
                   this.total--;
               }else {
                   System.out.println("票已售完，请下次再来！");
                   System.exit(0);
               }
           }
       }
    }
}
