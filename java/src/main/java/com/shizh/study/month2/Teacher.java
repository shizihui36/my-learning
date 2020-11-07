package com.shizh.study.month2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @ClassName Teacher
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/7
 **/
public class Teacher {
    private String name;
    private int age;
    private String content;
    public void jiangke() {
        System.out.println("年龄为"+age+"的"+name+"正在激扬的讲着"+content+"的知识...");
    }

    public void eat() {
        System.out.println("年龄为"+age+"的"+name+"正在吃饭...");
    }
}
