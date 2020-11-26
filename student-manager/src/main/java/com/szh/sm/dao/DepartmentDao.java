package com.szh.sm.dao;

import com.szh.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentDao
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/17
 **/
public interface DepartmentDao {
    /**
     * 查询所有院系
     * @return
     * @throws SQLException
     */
    List<Department> getAll() throws SQLException;

    int delectDepartment(Department department, Integer id) throws SQLException;
    int insertDepartment(Department department) throws SQLException;
}
