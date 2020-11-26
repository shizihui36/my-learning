package com.szh.sm.service;

import com.szh.sm.entity.Department;
import com.szh.sm.factory.ServiceFactory;
import org.junit.Test;

import java.util.List;

public class DepartmentServiceTest {
   private final DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();

    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(System.out::println);
    }
}
