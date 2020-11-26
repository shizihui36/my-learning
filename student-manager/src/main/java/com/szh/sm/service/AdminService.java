package com.szh.sm.service;

import com.szh.sm.utils.ResultEntity;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public interface AdminService {
    ResultEntity adminLogin(String account,String password);
}
