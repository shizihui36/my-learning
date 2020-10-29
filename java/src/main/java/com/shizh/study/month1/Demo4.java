package com.shizh.study.month1;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Demo4
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/29
 **/
public class Demo4 {
    static ArrayList<User> list = new ArrayList<>();
    static {
        list.add(new User("jack","1234"));
        list.add(new User("rose","5678"));
        list.add(new User("tom","0000"));
        for (int i = 0;i < list.size();i++){
            list.get(i).show();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        User u = new User(username,password);
        String login = login(u);
        System.out.println("登录结果:" + login);
    }
    public static String login(User user){
        String msg = "";
        String n = user.getUsername();
        String p = user.getPwd();
        for (int i = 0;i<list.size();i++){
            User u = list.get(i);
            String name = u.getUsername();
            String pwd = u.getPwd();
            if(name.equals(n)){
                if(pwd.equals(p)){
                    return "登录成功";
                }else {
                    return "密码错误";
                }
            }else {
                msg = "用户名不存在";
                continue;
            }
        }
        return msg;
    }
}
class User{
    private String username;
    private String pwd;
    public User(){
    }
    public User(String username,String pwd){
        this.username = username;
        this.pwd = pwd;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPwd(){
        return pwd;
    }
    public void setPwd(String pwd){
        this.pwd = pwd;
    }
    public void show(){
        System.out.println(username + "-" + pwd);
    }
}