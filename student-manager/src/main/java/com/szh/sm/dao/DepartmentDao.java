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
    /**
     * 删除院系
     *
     * @param depId 院系id
     * @return int
     * @throws SQLException 异常
     */
    int delete(int depId)  throws SQLException;
    /**
     * 新增院系
     *
     * @param department 入参
     * @return int
     * @throws SQLException 异常
     */
    int insertDepartment(Department department) throws SQLException;
}
