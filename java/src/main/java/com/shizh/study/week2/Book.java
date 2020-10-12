package com.shizh.study.week2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.Date;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private Integer price;
    private Date publishDate;

}