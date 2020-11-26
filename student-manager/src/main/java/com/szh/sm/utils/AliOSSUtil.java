package com.szh.sm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName AliOSSUtil
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/23
 **/
public class AliOSSUtil {
    public static String ossUpload(File file){
        String bucketDomain = "https://shi-niit.oss-cn-hangzhou.aliyuncs.com";
        //endPoint 是杭州
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        String accessKeyId = "LTAI4G8FSRpNDHMFuZzhWSEi";
        String accessKeySecret = "qELTJlniCOe9T1oFYQOnCF3knCy36X";
        //Bucket名称
        String bucketName = "shi-niit";
        //目录名称
        String fileDir ="image/";
        //获取本地文件的文件名
        String fileName = file.getName();
        //上传后的文件名生成，这里会将客户端的文件保留扩展名，主文件名用UUID生成
        String fileKey = UUID.randomUUID().toString()+fileName.substring(fileName.indexOf("."));
        //创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        //上传file到bucketName的file目录下，用fileKey作为新文件名存储
        ossClient.putObject(bucketName,fileDir+fileKey,file);
        //关闭ossClient实例
        ossClient.shutdown();
        //返回url组成：域名+目录+新文件名
        return bucketDomain+fileDir+fileKey;

    }

    public static void main(String[] args) {
        File file = new File("C:/Users/Lenovo/Desktop/java/me.png");
        String url = ossUpload(file);
        System.out.println(url);
    }
}
