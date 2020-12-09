package com.szh.sm.service.impl;

import com.szh.sm.dao.AdminDao;
import com.szh.sm.entity.Admin;
import com.szh.sm.factory.DaoFactory;
import com.szh.sm.service.AdminService;
import com.szh.sm.utils.ResultEntity;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = DaoFactory.getAdminDaoInstance();

    @Override
    public ResultEntity adminLogin(String account,String password){
        ResultEntity resultEntity;
        Admin admin = null;
        try {
            //根据账号查找管理员信息，捕获SQL异常
            admin = adminDao.findAdminByAccount(account);
        }catch (SQLException e){
            System.err.println("根据账号查找管理员信息出现SQL异常");
        }
        if (admin != null){
            if (DigestUtils.md5Hex(password).equals(admin.getPassword())){
                resultEntity = ResultEntity.builder().code(0).message("登录成功").data(admin).build();
            }else {
                resultEntity = ResultEntity.builder().code(1).message("密码错误").build();
            }
        }else {
            resultEntity = ResultEntity.builder().code(2).message("账号不存在").build();
        }
        return resultEntity;
    }
}
