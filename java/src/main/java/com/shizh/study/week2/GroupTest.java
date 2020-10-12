package com.shizh.study.week2;

import java.util.Date;

/**
 * @ClassName GroupTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/12
 **/
public class GroupTest {
    public static void main(String[] args) {
        Book book1 = new Book("java基础",32,new Date());
        Book book2 = new Book("java数据结构",63,new Date());
        Book book3 = new Book("java大神宝典",78,new Date());
        Book book4 = new Book("JavaScipt",89, new Date());
        Book book5 = new Book("java大神速成法",100,new Date());

        Phone phone1 = new Phone("华为6X",3999);
        Phone phone2 = new Phone("华为7X",4999);
        Phone phone3 = new Phone("华为8X",5999);

        Student student1 = new Student("1001","张三","男",phone1, new Book[]{book1,book2,book5} );
        Student student2 = new Student("1002","李四","男",phone2, new Book[]{book1,book5} );
        Student student3 = new Student("1003","李红","女",phone3, new Book[]{book1,book3,book4} );

        Group group1 = new Group("第一组", new Student[]{student1,student2});
        Group group2 = new Group("第二组", new Student[]{student3});

        System.out.println(student1);
        System.out.println(group2);
    }
}
