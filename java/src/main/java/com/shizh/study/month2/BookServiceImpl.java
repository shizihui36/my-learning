package com.shizh.study.month2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @ClassName BookServiceInput  图书接口实现类
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/2
 **/
@NoArgsConstructor

@Data
public class BookServiceImpl implements BookService {
    @Override
    public boolean BookOpen(Book book) throws ISBNException, IBookException,PriceException{
        Pattern pattern = Pattern.compile(("[0-9]*"));
        String isbn = book.getISBN();
        String bookname = book.getBookname();
        int price = book.getPrice();
        if (isbn.length() != 13 || ! pattern.matcher(isbn).matches()){
            throw new IBookException(bookname+"ISBN码位数不正确");
        }else if(bookname.contains("暴力") || bookname.contains("恐怖")){
             throw  new IBookException(bookname+ "书名中含有恐怖或者暴力");
        }else if (price >100){
            throw new PriceException(bookname + "价格超过100");
        }else {
            return true;
        }
    }
}
