package com.resumeims.server.impl;

import com.resumeims.server.MinioFilesService;
import com.resumeims.server.feign.FeignByRequestMinioClassService;
import io.minio.MinioClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.server.impl
 * @ClassName: MinioFilesServiceImpl
 * @date ：Created in 2021/6/24 15:58
 * @description：文件上传服务实现类
 * @modified By：
 * @version: v1.0.0$
 */
@Slf4j
@Service
public class MinioFilesServiceImpl implements MinioFilesService {
    @Autowired
    FeignByRequestMinioClassService feignByRequestMinioClassService;
//    @Autowired
//    private MinioUtil minioUtil;

 /*   *//**
     * 判断 bucket是否存在
     *
     * @param bucketName
     * @return
     *//*
    @Override
    public boolean bucketExists(String bucketName) {
        return minioUtil.bucketExists(bucketName);
    }

    *//**
     * 创建 bucket
     *
     * @param bucketName
     *//*
    @Override
    public void makeBucket(String bucketName) {
        minioUtil.makeBucket(bucketName);
    }

    /**
     * 文件上传
     *
     * @param bucketName
     * @param objectName
     * @param filename
     */
/*
    @Override
    public void putObject(String bucketName, String objectName, String filename) {
        minioUtil.putObject(bucketName, objectName, filename);
    }
*/


    @Override
    public boolean putObjectUP(String bucketName, String objectName, MultipartFile file) {
       return feignByRequestMinioClassService.putObjectUP(bucketName, objectName, file);
    }

    @Override
    public boolean upLoadFile(MultipartFile file) {
       return feignByRequestMinioClassService.upLoadFile(file);
    }


//    /**
//     * 文件上传
//     *
//     * @param bucketName
//     * @param multipartFile
//     */
//    @Override
//    public void putObject(String bucketName, MultipartFile multipartFile, String filename) {
//        minioUtil.putObject(bucketName, multipartFile, filename);
//    }

/*    *//**
     * 删除文件
     *
     * @param bucketName
     * @param objectName
     *//*
    @Override
    public boolean removeObject(String bucketName, String objectName) {
        return minioUtil.removeObject(bucketName, objectName);
    }

    *//**
     * 下载文件
     *
     * @param fileName
     * @param originalName
     * @param response
     *//*
    @Override
    public void downloadFile(String bucketName, String fileName, String originalName, HttpServletResponse response) {
        minioUtil.downloadFile(bucketName, fileName, originalName, response);
    }

    */
    /**
     * 获取文件路径
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    @Override
    public String getObjectUrl(String bucketName, String objectName) {
        return feignByRequestMinioClassService.getObjectUrl(bucketName, objectName);
    }


}

