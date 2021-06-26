package com.resumeims.resume_config.controller;

import com.alibaba.fastjson.JSONObject;
import com.resumeims.resume_config.minioconfig.MinioConfig;
import com.resumeims.resume_config.minioconfig.MinioUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.resume_config.controller
 * @ClassName: MinioOpController
 * @date ：Created in 2021/6/25 8:22
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
@Api(value = "MinioOpController", tags = "minio对外提供接口")
public class MinioOpController {
    @Autowired
    MinioConfig minioConfig;
    @Autowired
    MinioUtil minioUtil;

    @GetMapping("/getMinioConfig")
    public Object getMinioConfig() {
        JSONObject minioConfig1 = JSONObject.parseObject(JSONObject.toJSONString(minioConfig));
        return minioConfig1;
    }

    @PostMapping(value = "/upLoadFile")
    public boolean upLoadFile(HttpServletRequest request) throws IOException {
        System.out.println(request);
         MultipartFile  file = null;
        InputStream inputStream = file.getInputStream();
        Boolean index=minioUtil.putObject(null,null,inputStream);
        inputStream.close();
        return index;
    }

    @PostMapping(value = "/putObjectUp",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public boolean putObject(@RequestParam(value = "bucketName",required = false) String bucketName, @RequestParam(value = "objectName",required = false) String objectName,@RequestPart("file") MultipartFile  file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Boolean index=minioUtil.putObject(bucketName, objectName, inputStream);
        inputStream.close();
        return index;
    }

    @GetMapping("/putObject")
    public void putObject(@RequestParam(value = "bucketName", required = false) String bucketName, @RequestParam(value = "objectName", required = false) String objectName, @RequestParam(value = "fileName", required = false) String fileName) {
        minioUtil.putObject(bucketName, objectName, fileName);
    }

    @PostMapping("/makeBucket")
    public void makeBucket(@RequestParam(value = "bucketName", required = false) String bucketName) {
        minioUtil.makeBucket(bucketName);
    }

    @PostMapping("/bucketExists")
    public boolean bucketExists(@RequestParam(value = "bucketName", required = false) String bucketName) {
        return minioUtil.bucketExists(bucketName);
    }

    @PostMapping("/removeBucket")
    public void removeBucket(@RequestParam(value = "bucketName", required = false) String bucketName) {
        minioUtil.removeBucket(bucketName);
    }

    @PostMapping("/listObjectNames")
    public void listObjectNames(@RequestParam(value = "bucketName", required = false) String bucketName) {
        minioUtil.listObjectNames(bucketName);
    }

    @PostMapping("/listObjects")
    public void listObjects(@RequestParam(value = "bucketName", required = false) String bucketName) {
        minioUtil.listObjects(bucketName);
    }

    @GetMapping("/getObjectUrl")
    public String getObjectUrl(@RequestParam(value = "bucketName", required = false) String bucketName,@RequestParam(value = "objectName", required = false) String objectName) {
        return minioUtil.getObjectUrl(bucketName,objectName);
    }

    @PostMapping("/presignedPutObject")
    public void presignedPutObject(@RequestParam(value = "bucketName", required = false) String bucketName,@RequestParam(value = "objectName", required = false) String objectName,Integer expires) {
        minioUtil.presignedPutObject(bucketName,objectName,expires);
    }

    @PostMapping("/listBucketNames")
    public void listBucketNames() {
        minioUtil.listBucketNames();
    }

    @PostMapping("/listBuckets")
    public void listBuckets() {
        minioUtil.listBuckets();
    }

    @PostMapping("/downloadFile")
    public void downloadFile(String bucketName, String fileName, String originalName, HttpServletResponse response) {
        minioUtil.downloadFile(bucketName,fileName,originalName,response);
    }

}
