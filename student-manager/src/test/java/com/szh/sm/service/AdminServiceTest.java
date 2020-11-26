package com.szh.sm.service;


import com.szh.sm.factory.ServiceFactory;
import com.szh.sm.utils.ResultEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceTest {
    private final AdminService adminService = ServiceFactory.getAdminServiceInstance();

    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminService.adminLogin("shi56535874@163.com","123456");
        assertEquals(0,resultEntity.getCode());
        System.out.println(resultEntity);
    }
}
