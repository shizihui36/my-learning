package com.shizh.study.one;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/9
 **/
public class LoginService {
    public boolean login(String account,String password){
        if ("admin".equals(account) && "123".equals(password)){
            return true;
        }else {
            return false;
        }
    }
}
