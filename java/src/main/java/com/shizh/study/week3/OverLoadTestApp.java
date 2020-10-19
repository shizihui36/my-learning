package com.shizh.study.week3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName OverloadTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/10/19
 **/
@Data
@Builder
@AllArgsConstructor
public class OverLoadTestApp {
    public static void main(String[] args) {
        int sum1 = Overload.sum(4,5);
        System.out.println(sum1);
        int second=Overload.second(30,90);
        System.out.println(second);
    }
}

