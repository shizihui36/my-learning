package com.shizh.study.week11;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * @ClassName Student
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/16
 **/

public class Student implements Comparable<Student> {
    private String name;
    private Integer age;

    @Override
    public int compareTo(Student o) {
        if (this.getAge() > o.getAge()){
            return -1;
        }else  if (this.getAge() < o.getAge()){
            return 1;
        }else {
            return 0;
        }

    }
}
