package com.szh.sm.factory;

import com.szh.sm.service.AdminService;
import com.szh.sm.service.ClazzService;
import com.szh.sm.service.DepartmentService;
import com.szh.sm.service.StudentService;
import com.szh.sm.service.impl.AdminServiceImpl;
import com.szh.sm.service.impl.ClazzServiceImpl;
import com.szh.sm.service.impl.DepartmentServiceImpI;
import com.szh.sm.service.impl.StudentServiceImpl;

import javax.swing.*;

/**
 * @ClassName ServiceFactory
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class ServiceFactory {
    public static AdminService getAdminServiceInstance(){
        return new AdminServiceImpl();
    }

    public  static DepartmentService getDepartmentServiceInstance(){
        return new DepartmentServiceImpI();
    }

    public static ClazzService getClazzServiceInstance(){
        return new ClazzServiceImpl();
    }

    public static StudentService getStudentServiceInstance(){
        return new StudentServiceImpl();
    }
}
