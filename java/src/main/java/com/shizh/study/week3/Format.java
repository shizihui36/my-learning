package com.shizh.study.week3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.text.DecimalFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Date;

/**
 * @ClassName Format
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/
@Data
@NoArgsConstructor

public class Format {

    public synchronized  static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
public String fomat(Date date, Locale tz){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zz yyyy",tz);
        sdf.setTimeZone(TimeZone.getTimeZone("GTM+8"));
        return sdf.format(date.getTime());
}
   public String format(double number){
       DecimalFormat decimalFormat = new DecimalFormat("0.00");
       return decimalFormat.format(number);
   }
   public String format(double number,String pattern){
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(number);
   }
}
