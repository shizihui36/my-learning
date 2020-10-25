package com.shizh.study.month;

import java.util.ArrayList;
import static sun.nio.cs.Surrogate.MAX;

/**
 * @ClassName ReceptTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/25
 **/
public class ReceptTest {
    private static final int V1 = 10;
    private static final int V2 = 20;
    private static final int V3 = 30;
    private static final int V4 = 50;

    public static void main(String[] args) {
        ArrayList<User> uList = new ArrayList<>();
        for (int i = 1;i <= MAX; i++){
            uList.add(new User(i));
        }
        System.out.println("未分组:");
        System.out.println(uList);
        Reception r1 = new Reception();
        Reception r2 = new Reception();
        Reception r3 = new Reception();
        r1.setF(new Filter(){
            @Override
            public void filterUser(User u){
                if (u.getId() >= V1 && u.getId() < V2){
                    u.setType("V1");
                }
            }
        });
        r2.setF(u -> {
            if(u.getId() >= V2 && u.getId() < V3){
                u.setType("V2");
            }
        });
        for (User user : uList){
            r1.recept(user);
            r2.recept(user);
            r3.recept(user);
        }
        System.out.println("已分组:");
        for (int i = 0;i < uList.size();i++){
            User user = uList.get(i);
            if (i % 9 == 0){
                System.out.println();
            }
            System.out.println(user + " ");
        }
    }
}
class Reception {
    Filter f;
    public Filter getF(){
        return f;
    }
    public void setF(Filter f){
        this.f = f;
    }
    public void recept(User u){
        if (u.getType() != null){
            return;
        }
        if (f != null){
            f.filterUser(u);
        }else {
            u.setType("A");
        }
    }
}
  class  User{
    private String type;
    private final int id;

    public User(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    @Override
      public String toString(){
        return id + "-" + type;
    }
  }
  interface Filter {

    void filterUser(User u);
  }