package com.szh.sm.dao;

import com.szh.sm.entity.Clazz;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ClazzDao
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/24
 **/
public interface ClazzDao {
    /**
     *
     * @param departmentId  院系Id
     * @return  List<Clazz> 院系班级集合
     * @throws SQLException
     */
    List<Clazz> selectByDepartmentId (int departmentId) throws SQLException;

    int insertClazz(Clazz clazz);

    int deleteClazz(Integer id);
}
