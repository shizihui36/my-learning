package com.szh.sm.dao;

import com.szh.sm.entity.Admin;

import java.sql.SQLException;

/**
 * @ClassName AdminDao
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public interface AdminDao {
    /**
     *
     * @param account:账号入参
     * @return Admin:管理员信息
     * @throws SQLException : 该方法会抛出SQL异常
     */
    Admin findAdminByAccount(String account) throws SQLException;
}
