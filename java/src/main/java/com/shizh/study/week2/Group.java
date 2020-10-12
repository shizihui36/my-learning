package com.shizh.study.week2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Group
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private String group;
    private Student groupstudent[];
}
