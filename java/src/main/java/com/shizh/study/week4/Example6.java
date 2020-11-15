package com.shizh.study.week4;

/**
 * @ClassName Example6
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class Example6 {
    public static void main(String[] args) {
        BB b = new BB();
        b.showA();
        b.show10B();
        b.show10C();
    }
}
interface AA{
    public abstract void showA();
    public default void show10B(){
        show10("BBBB");
    }
    public default void show10C(){
        show10("CCCC");
    }
    static void show10(String str){
        for (int i = 0;i<10;i++){
            System.out.println(str+"");
        }
        System.out.println();
    }
}
class BB implements AA{
    @Override
    public void showA(){
        System.out.println("AAAA");
    }
}