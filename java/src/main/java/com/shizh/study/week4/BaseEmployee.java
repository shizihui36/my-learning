package com.shizh.study.week4;

/**
 * @ClassName BaseEmployee
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/26
 **/
public abstract class BaseEmployee {
    public void print(){
        System.out.println("This is an abstract class.");
    }

    /**
     * 发工资
     * @param
     * @return int
     */
    public abstract int getSalary();
}
