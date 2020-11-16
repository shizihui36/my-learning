package com.shizh.study.week11;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.net.Socket;
import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/16
 **/
public class MapTest {
    public static void main(String[] args) {
//        Map<String, Integer> map = new HashMap<>(8);
//        map.put("apple",6);
//        map.put("pear",2);
//        map.put("banana",4);
//        System.out.println(map);
//        //for循环遍历
//        for (String key:map.keySet()){
//            Integer value = map.get(key);
//            System.out.println(key + "单价为:" + value);
//        }
//        //编写国家和首都
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("中国","北京");
//        map1.put("美国","洛杉矶");
//        map1.put("英国","伦敦");
//        System.out.println(map1);
//        for (String key : map1.keySet()){
//            Object key1;
//            String value1 = (String) map1.get(key);
//            System.out.println(key + "首都为"+value1);
//        }
//        System.out.println("iterator遍历");
//        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Integer> entry = iterator.next();
//            System.out.println(entry.getKey()+"单价为:"+entry.getValue());
//        }
//        System.out.println("通过遍历Map 的value, 只能遍历value，获取不到key");
//        for (Integer value:map.values()){
//            System.out.println(value);
//        }
//        System.out.println("通过遍历Map 的entrySet，遍历Key和Value，***");
//        for (Map.Entry<String, Integer> entry:map.entrySet()){
//            System.out.println(entry.getKey()+ "单价为:"+entry.getValue());
//        }
//        System.out.println("lambda 表达式***");
//        map.forEach((Key, Value)-> System.out.println("key:" + Key +",value:"+Value));



        Map<String,String> map2 = new HashMap<>();
        map2.put("Tom","CoreJava");
        map2.put("John","Oracle");
        map2.put("Susan","Oracle");
        map2.put("Jerry","JDBC");
        map2.put("Jim","Unix");
        map2.put("Lucy","Jsp");

        //添加
        map2.put("Allen","JDBC");


        System.out.println(map2);
        for (String key : map2.keySet()){
            Object key2;
            String value2 = (String) map2.get(key);
            System.out.println(key + "任教科目:"+value2);
        }

        map2.forEach((Key2, Value2)-> System.out.println("key:" + Key2 +"任教科目:"+Value2));

        for (Map.Entry<String, String> entry:map2.entrySet()){
            System.out.println(entry.getKey()+ "任教科目:"+entry.getValue());
            if (map2.equals("JDBC")){
                System.out.println(map2.keySet()+"任教:"+map2.values());
            }
        }
    }




}
