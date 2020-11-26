package com.szh.sm.dao;


import com.szh.sm.entity.Admin;
import com.szh.sm.factory.DaoFactory;
import org.junit.Test;


import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class AdminDaoTest {
    private final AdminDao adminDao = DaoFactory.getAdminDaoInstance();
    @Test
    public void findAdminByAccount() {
        Admin admin;
        try {
            admin = adminDao.findAdminByAccount("shi56535874@163.com");
            assertEquals("石子慧",admin.getAdminName());
            System.out.println(admin);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
