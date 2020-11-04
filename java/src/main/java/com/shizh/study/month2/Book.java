package com.shizh.study.month2;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder

/**
 * @ClassName Book
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/2
 **/

public class Book {
    private String ISBN;
    private String bookname;
    private Integer price;

    public Book(String ISBN, String bookname, Integer price) {
        this.ISBN = ISBN;
        this.bookname = bookname;
        this.price = price;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getBookname() {
        return bookname;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", bookname='" + bookname + '\'' +
                ", price=" + price +
                '}';
    }

}
