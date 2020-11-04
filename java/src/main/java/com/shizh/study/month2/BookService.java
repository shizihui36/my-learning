package com.shizh.study.month2;

/**
 * @ClassName BookService
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/2
 **/
public interface BookService {
    boolean BookOpen(Book book) throws IBookException, ISBNException, PriceException;
}
