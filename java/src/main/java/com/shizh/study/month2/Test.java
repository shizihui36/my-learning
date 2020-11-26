package com.shizh.study.month2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/2
 **/
@Builder
@AllArgsConstructor

@Data
public class Test {
    public static void main(String[] args) {
        Book[] books = new Book[]{
                Book.builder().ISBN("1563456789513").bookname("Java暴力破解").price(99).build(),
                Book.builder().ISBN("156348268515P").bookname("Java").price(99).build(),
                Book.builder().ISBN("1563456785152").bookname("Java课程").price(166).build(),
                Book.builder().ISBN("156345678").bookname("Java破解").price(99).build()};
               BookService bs = new BookServiceImpl();
               for (Book book:books){
                   try {
                       boolean b = bs.BookOpen(book);
                       if (b){
                           System.out.println(book.getBookname()+"成功上架！");
                       }
                   }catch (ISBNException | IBookException | PriceException e){
                       System.err.println(e.getMessage());
                   }
               }


        }
    }
