package com.resumeims.server.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.resumeims.resume_config.minioconfig.MinioConfig;
import com.resumeims.resume_config.utils.R;
import com.resumeims.server.MinioFilesService;
import com.resumeims.server.feign.FeignByRequestMinioClassService;

import com.resumeims.server.minioconfig.MinioUtil;
import io.minio.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：zjc
 * @ProjectName: ResumeIMS
 * @Package: com.resumeims.server.controller
 * @ClassName: MinioFilesController
 * @date ：Created in 2021/6/24 16:31
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/minio")
@Api(value = "MinioFilesController", tags = "文件上传接口")
public class MinioFilesController {
    @Autowired
    private MinioFilesService minioService;
    @Autowired
    private FeignByRequestMinioClassService feignByRequestMinioClassService;
    @Autowired
    MinioUtil minioUtil;

    @ApiOperation(value = "使用minio文件上传")
    @PostMapping("/uploadFile")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "MultipartFile", name = "file", value = "上传的文件", required = true),
            @ApiImplicitParam(dataType = "String", name = "bucketName", value = "对象存储桶名称", required = false)
    })
    public R uploadFile(MultipartFile file, String bucketName) {
        try {
            JSONObject minioConfig1 = JSONObject.parseObject(feignByRequestMinioClassService.getMinioConfig());
            MinioConfig minioConfig = JSON.toJavaObject(minioConfig1, MinioConfig.class);
            bucketName = StringUtils.isNotBlank(bucketName) ? bucketName : minioConfig.getBucketName();
            if (!feignByRequestMinioClassService.bucketExists(bucketName)) {
                feignByRequestMinioClassService.makeBucket(bucketName);
            }
            String fileName = file.getOriginalFilename();
            String objectName = new SimpleDateFormat("yyyy/MM/dd/").format(new Date()) + UUID.randomUUID().toString().replaceAll("-", "")
                    + fileName.substring(fileName.lastIndexOf("."));
            InputStream inputStream = file.getInputStream();
            minioUtil.putObject(bucketName, objectName, inputStream);
//            minioService.upLoadFile(file);
            return R.success(feignByRequestMinioClassService.getObjectUrl(bucketName, objectName));
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("上传失败");
        }
    }


}




