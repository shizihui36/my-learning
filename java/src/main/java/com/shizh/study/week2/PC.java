package com.shizh.study.week2;

/**
 * @ClassName PC
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/
public class PC {
    CPU cpu;
    HardDisk HD;
    public void setCpu(CPU c){
        cpu = c;
    }
    public void setHardDisk(HardDisk h){
        HD = h;
    }
    public void show(){
        System.out.println("cpu的速度:" + cpu.getSpeed() + "硬盘的容量:" + HD.getAmount());
    }
}
