package com.shizh.study.week2;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/
public class Test {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        cpu.speed = 2200;
        HardDisk disk = new HardDisk();
        disk.amount = 200;
        PC pc = new PC();
        pc.setCpu(cpu);
        pc.setHardDisk(disk);
        pc.show();
    }
}
