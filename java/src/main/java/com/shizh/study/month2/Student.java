package com.shizh.study.month2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @ClassName Student
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/7
 **/
public class Student {
    private String name;
    private int age;
    private String content;
    public void study(){
        System.out.println("年龄为"+age+"的"+name+"正在吃饭");
    }
    public void eat(){
        System.out.println("年龄"+age+"的"+name+"正在吃饭...");
    }

}
