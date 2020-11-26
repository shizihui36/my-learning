package com.shizh.study.week3;

import lombok.Data;

/**
 * @ClassName Sequential
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/20
 **/
public  class Sequential {      //定义
    final int initcapacity = 10;
    private String  data[];
    int top = -1;

    public boolean empty(){  //判断栈是否为空
        return top == -1;
    }
    public void push(String E){  //进栈操作
        if (top == -1){
            top ++;
            data[top] = E;
        }
    }
    public void pop(){
        if(empty()){
            throw new IllegalArgumentException("栈空");

        }
    }
}
