package com.szh.sm.factory;

import com.szh.sm.dao.AdminDao;
import com.szh.sm.dao.ClazzDao;
import com.szh.sm.dao.DepartmentDao;
import com.szh.sm.dao.StudentDao;
import com.szh.sm.dao.impl.AdminDaoImpl;
import com.szh.sm.dao.impl.ClassDaoImpl;
import com.szh.sm.dao.impl.DepartmentDaoImpl;
import com.szh.sm.dao.impl.StudentDaoImpl;

/**
 * @ClassName DaoFactory
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class DaoFactory {
    /**
     * 获得AdminDao实例
     *
     * @return AdminDao实例
     */
    public static AdminDao getAdminDaoInstance(){
        return new AdminDaoImpl();
    }
    /**
     * 获得DepartmentDao实例
     *
     * @return AdminDao实例
     */
    public static DepartmentDao getDepartmentDaoInstance(){
        return new DepartmentDaoImpl();
    }
    /**
     * 获得ClazzDao实例
     *
     * @return ClazzDao实例
     */
    public static ClazzDao getClazzDaoInstance(){
        return new ClassDaoImpl();
    }

    /**
     * 获得StudentDao实例
     *
     * @return StudentDao实例
     */
    public static StudentDao getStudentDaoInstance() {
        return  new StudentDaoImpl();
    }
}
