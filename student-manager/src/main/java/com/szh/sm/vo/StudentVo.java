package com.szh.sm.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName StudentVo
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/12/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVo {
    private String id;
    private String departmentName;
    private String className;
    private String studentName;
    private String phone;
    private Short gender;
    private Date birthday;
    private String avatar;
    private String address;
}
