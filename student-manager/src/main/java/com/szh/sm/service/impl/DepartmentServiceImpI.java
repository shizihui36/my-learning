package com.szh.sm.service.impl;

import com.szh.sm.dao.DepartmentDao;
import com.szh.sm.entity.Department;
import com.szh.sm.factory.DaoFactory;
import com.szh.sm.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentServiceImpI
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/17
 **/
public class DepartmentServiceImpI implements DepartmentService {
     private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDao.getAll();
        }catch (SQLException e){
            System.err.print("查询院系信息出现异常");
        }
        return departmentList;
    }

    @Override
    public int addDepartment(Department department) {
        int n = 0;
        try {
            n = departmentDao.insertDepartment(department);
        }catch (SQLException e){
            System.err.print("新增院系信息出现异常");
        }
        return n ;
    }

    @Override
    public int delete(int depId) {
        int n = 0;
        try {
            n = departmentDao.delete(depId);
        }catch (SQLException e){
            System.err.print("删除院系信息出现异常");
        }
        return n;
    }

}
