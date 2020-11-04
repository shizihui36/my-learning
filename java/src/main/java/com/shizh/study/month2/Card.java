package com.shizh.study.month2;

/**
 * @ClassName Card
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/4
 **/
public class Card {
    private String ds;
    private String hs;
    public Card(String ds,String hs){
        this.ds = ds;
        this.hs = hs;
    }
    public void showCard(){
        System.out.println(ds + hs);
    }

}
