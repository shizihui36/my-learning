package com.shizh.study.month2;

/**
 * @ClassName Test4
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/4
 **/
public class Test4 {
    public static void main(String[] args) {
        int[] salary = {15000,3000};
        Manager m = new Manager("James","9527",salary);
        m.intro();
        m.showSalary();
        m.work();
        System.out.println("=========");
        Coder c = new Coder();
        c.setName("Kobe");
        c.setId("0025");
        c.setSalary(10000);
        c.intro();
        c.showSalary();
        c.work();
    }
}
