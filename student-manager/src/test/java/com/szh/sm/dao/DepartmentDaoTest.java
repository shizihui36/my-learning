package com.szh.sm.dao;


import com.szh.sm.entity.Department;
import com.szh.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DepartmentDaoTest {
   private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    @Test
    public void getAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDao.getAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        assert  departmentList != null;
        departmentList.forEach(System.out:: println);
    }
    @Test
    public void insert(){
        int n = 0;
        Department department = Department.builder()
                .departmentName("测试院系")
                .logo("me.jpg")
                .build();
        try {
            n = departmentDao.insertDepartment(department);
        }catch (SQLException e){
            e.printStackTrace();
        }
       assertEquals(1,n);
    }
    @Test
    public void delete() {
        int n = 0;
        try {
            n = departmentDao.delete(9);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1, n);
    }
}
