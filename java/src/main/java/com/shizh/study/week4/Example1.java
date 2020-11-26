package com.shizh.study.week4;

import java.util.ArrayList;

/**
 * @ClassName Example1
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/27
 **/
  class TupElem<E> {
    int r;    //行号
    int c;    //列号
    int d;    //元素值

    public TupElem(int r1, int c1, int d1) {
      r = r1;
      c = c1;
      d = d1;
    }
}

 class TupClass{
      int rows;
      int clos;
      int nums;
      ArrayList<TupElem> data;
      public TupClass(){
          data = new ArrayList<TupElem>();
          nums = 0;
      }
      public void CreateTup(int [][] A,int m, int n ){
            rows = m;clos = n;
            for (int i = 0;i < m; i++){
                for (int j = 0; j < n ;j++){
                    if (A[i][j] != 0){
                        data.add(new TupElem(i,j,A[i][j]));
                        nums++;
                    }
                }
            }
      }
      public  boolean SetValue(int i , int j,int x){
          int k = 0;
          if(i <0 || i>=rows || j <0 || j>clos){
              return false;
          }
          while (k < nums && i > data.get(k).r){
              k++;
          }
          while (k < nums && i == data.get(k).r){
              k++;
          }
          if (data.get(k).r == i && data.get(k).c == j){
              data.set(k,new TupElem(i,j,x));
          }else {
              data.add(k,new TupElem(i,j,x));
              nums++;
          }
          return true;
      }
      public  int GetValue(int i ,int j){
          int k = 0;
          if(i < 0 || i > rows || j <0 || i > clos){
              return 0;
          }
          while (k < nums && data.get(k).r <i){
              k++;
          }
          while (k <nums && data.get(k).r == i && data.get(k).c<j){
              k++;
          }
          if (data.get(k).r == i && data.get(k).c ==j){
              return data.get(k).d;
          }
          return 0;
      }
      public void DispTup(){
        if (nums <= 0){
            return;
        }
          System.out.printf("行数 = %d,列数=%d, 非0元素个数=%d\n",rows,clos,nums);
           for (int i = 0;i<nums;i++){
               System.out.printf("%5d%5d%5d\n",data.get(i).r,data.get(i).c,data.get(i).d);
           }
      }
}
public class Example1 {
    public static void main(String[] args) {
      

    }
}
