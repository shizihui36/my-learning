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
    /**
     * 新增班级
     *
     * @param clazz 入参班级实体
     * @return int
     * @throws SQLException 异常
     */
    int insertClazz(Clazz clazz) throws SQLException;


    /**
     * 删除班级
     *
     * @param clazzId 班级id
     * @return int
     * @throws SQLException 异常
     */

    int deleteClazz(int clazzId) throws SQLException;
    /**
     * 查询所有班级
     *
     * @return List<Clazz>
     * @throws SQLException 异常
     */
    List<Clazz> selectAll() throws SQLException;

}
