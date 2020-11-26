package com.szh.sm.service;

import com.szh.sm.entity.Department;

import java.awt.*;
import java.util.List;

/**
 * @ClassName DepartmentService
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/17
 **/
public interface DepartmentService {
    List<Department> selectAll();

    int addDepartment(Department department);


    int delDepartment(Department department, Integer id);
}
