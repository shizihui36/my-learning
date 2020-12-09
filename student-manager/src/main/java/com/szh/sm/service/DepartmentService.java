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
    /**
     * 查询所有院系
     *
     * @return List<Department>
     */
    List<Department> selectAll();
    /**
     * 新增院系
     *
     * @param department 入参
     * @return int
     */
    int addDepartment(Department department);

    /**
     * 删除院系
     *
     * @param depId 院系id
     * @return ResultEntity
     */
    int delete(int depId);
}
