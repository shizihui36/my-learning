package com.szh.sm.service.impl;

import com.szh.sm.dao.ClazzDao;
import com.szh.sm.entity.Clazz;
import com.szh.sm.factory.DaoFactory;
import com.szh.sm.service.ClazzService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/26
 **/
public class ClazzServiceImpl implements ClazzService {
    private static final ClazzDao clazzDao = DaoFactory.getClazzDaoInstance();
    @Override
    public List<Clazz> getClazzByDepId(int department) {

        List<Clazz> clazzList = null;
        try {
            clazzList = clazzDao.selectByDepartmentId(department);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clazzList;
    }


    @Override
    public int addClazz(Clazz clazz) {

        int n=0;
        n=DaoFactory.getClazzDaoInstance().insertClazz(clazz);

        return n;
    }

    @Override
    public int deleteClazz(Integer id) {
        int n=0;
        n = clazzDao.deleteClazz(id);
        return n;
    }
}
