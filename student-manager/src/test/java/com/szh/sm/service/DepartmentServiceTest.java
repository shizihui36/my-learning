package com.szh.sm.service;

import com.szh.sm.entity.Department;
import com.szh.sm.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DepartmentServiceTest {
   private final DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(System.out::println);
    }
    @Test
    public void delete() {
        int n = departmentService.delete(9);
        assertEquals(1, n);
    }
}
