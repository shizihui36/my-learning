package com.szh.sm.factory;

import com.szh.sm.dao.AdminDao;
import com.szh.sm.dao.ClazzDao;
import com.szh.sm.dao.DepartmentDao;
import com.szh.sm.dao.impl.AdminDaoImpl;
import com.szh.sm.dao.impl.ClassDaoImpl;
import com.szh.sm.dao.impl.DepartmentDaoImpl;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class DaoFactory {
    public static AdminDao getAdminDaoInstance(){

        return new AdminDaoImpl();
    }
    public static DepartmentDao getDepartmentDaoInstance(){
        return new DepartmentDaoImpl();
    }
    public static ClazzDao getClazzDaoInstance(){
        return new ClassDaoImpl();
    }
    
}
