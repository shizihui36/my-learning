package com.shizh.study.month2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

/**
 * @ClassName StudyTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/7
 **/
public class StudyTest {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.setName("周医生");
        t.setAge(30);
        t.setContent("java面向对象");
        t.eat();
        t.jiangke();
        Student stu = new Student("韩同学",18,"java基础");
        stu.eat();
        stu.study();
 }
}
