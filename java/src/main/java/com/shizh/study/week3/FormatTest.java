package com.shizh.study.week3;

import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName FormatTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/
public class FormatTest {
    public static void main(String[] args) {
     try {
         Date date = new Date();
         Format format = new Format();
         System.out.println("时间格式为yyyy-MM-dd HH:mm:ss:" + Format.format(date) + "\n");
         System.out.println(format.format(555.66667777,".##"));
         System.out.println("***************");
         long start = System.currentTimeMillis();
         System.out.println("现在的时间戳为:" + start);
         Thread.sleep(3000);
         long end = System.currentTimeMillis();
         System.out.println("两个时间戳的差值为:"+ (end - start));
         System.out.println("经过了" +(end - start)/1000 + "秒");
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
         try{
             long unknown = sdf.parse("2020-10-20 22:41:00 + 0000").getTime();
             System.out.println("一个未知的时间戳:" + unknown);
             System.out.println("和我们此刻的时间差:" + Math.abs(unknown - System.currentTimeMillis())/1000/3600 +"个小时");
         }catch (ParseException e){
             e.printStackTrace();
         }
     }catch (InterruptedException e){
         e.printStackTrace();
     }
    }
}
